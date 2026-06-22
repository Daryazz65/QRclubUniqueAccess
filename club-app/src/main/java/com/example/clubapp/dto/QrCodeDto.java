package com.example.clubapp.dto;

import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QrCodeDto {
    private Long id;
    private Long participantId;
    private UUID qrUuid;
}