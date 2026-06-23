package com.example.clubapp.dto;

public record ParticipantDto(
        Long id,
        String firstName,
        String lastName,
        String middleName
) {}