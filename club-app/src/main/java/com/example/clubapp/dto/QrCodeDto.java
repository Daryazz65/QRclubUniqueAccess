package com.example.clubapp.dto;

import java.util.UUID;

public record QrCodeDto(
        Long id,
        Long participantId,
        UUID qrUuid
) {}