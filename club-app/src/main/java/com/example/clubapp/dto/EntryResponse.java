package com.example.clubapp.dto;

import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntryResponse {
    private String fullName;
    private UUID newQrUuid;
}