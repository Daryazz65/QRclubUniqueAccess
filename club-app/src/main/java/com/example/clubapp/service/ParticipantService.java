package com.example.clubapp.service;

import com.example.clubapp.dto.ParticipantDto;
import com.example.clubapp.entity.Participant;
import com.example.clubapp.exception.ResourceNotFoundException;
import com.example.clubapp.mapper.ParticipantMapper;
import com.example.clubapp.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ParticipantService {

    private final ParticipantRepository participantRepository;
    private final ParticipantMapper participantMapper;

    public Page<ParticipantDto> getAll(Pageable pageable) {
        return participantRepository.findAll(pageable)
                .map(participantMapper::toDto);
    }

    public ParticipantDto getById(Long id) {
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Участник", id));
        return participantMapper.toDto(participant);
    }

    @Transactional
    public ParticipantDto create(ParticipantDto dto) {
        Participant participant = participantMapper.toEntity(dto);
        return participantMapper.toDto(participantRepository.save(participant));
    }

    @Transactional
    public ParticipantDto update(Long id, ParticipantDto dto) {
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Участник", id));

        participant.setFirstName(dto.firstName());
        participant.setLastName(dto.lastName());
        participant.setMiddleName(dto.middleName());

        return participantMapper.toDto(participantRepository.save(participant));
    }

    @Transactional
    public void delete(Long id) {
        if (!participantRepository.existsById(id)) {
            throw new ResourceNotFoundException("Участник", id);
        }
        participantRepository.deleteById(id);
    }
}