package com.example.clubapp.mapper;

import com.example.clubapp.dto.ParticipantDto;
import com.example.clubapp.entity.Participant;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {

    public ParticipantDto toDto(Participant participant) {
        return new ParticipantDto(
                participant.getId(),
                participant.getFirstName(),
                participant.getLastName(),
                participant.getMiddleName()
        );
    }

    public Participant toEntity(ParticipantDto dto) {
        return Participant.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .middleName(dto.middleName())
                .build();
    }
}