package com.example.clubapp.service;

import com.example.clubapp.dto.ParticipantDto;
import com.example.clubapp.entity.Participant;
import com.example.clubapp.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    public List<ParticipantDto> getAll(){
        return participantRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public ParticipantDto getById(Long id){
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Участник не найден:" + id));
        return toDto(participant);
    }

    @Transactional
    public ParticipantDto create(ParticipantDto dto) {
        Participant participant = Participant.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .middleName(dto.getMiddleName())
                .build();
        return toDto(participantRepository.save(participant));
    }

    @Transactional
    public ParticipantDto update(Long id, ParticipantDto dto) {
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Участник не найден: " + id));

        participant.setFirstName(dto.getFirstName());
        participant.setLastName(dto.getLastName());
        participant.setMiddleName(dto.getMiddleName());

        return toDto(participantRepository.save(participant));
    }

    @Transactional
    public void delete(Long id) {
        participantRepository.deleteById(id);
    }

    private ParticipantDto toDto(Participant participant) {
        return ParticipantDto.builder()
                .id(participant.getId())
                .firstName(participant.getFirstName())
                .lastName(participant.getLastName())
                .middleName(participant.getMiddleName())
                .build();
    }
}