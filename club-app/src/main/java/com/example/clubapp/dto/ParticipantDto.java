package com.example.clubapp.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipantDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
}