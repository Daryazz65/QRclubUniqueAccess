package com.example.clubapp.dto;

import java.util.UUID;

public record EntryResponse(
        String fullName,
        UUID newQrUuid
) {}