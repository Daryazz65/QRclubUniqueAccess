package com.example.clubapp.controller;

import com.example.clubapp.dto.QrCodeDto;
import com.example.clubapp.service.QrCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/qrcodes")
@RequiredArgsConstructor
public class QrCodeController {

    private final QrCodeService qrCodeService;

    @GetMapping("/{id}")
    public ResponseEntity<QrCodeDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(qrCodeService.getById(id));
    }

    @GetMapping("/uuid/{uuid}")
    public ResponseEntity<QrCodeDto> getByUuid(@PathVariable UUID uuid) {
        return ResponseEntity.ok(qrCodeService.getByUuid(uuid));
    }

    @PostMapping("/{participantId}")
    public ResponseEntity<QrCodeDto> create(@PathVariable Long participantId) {
        return ResponseEntity.ok(qrCodeService.create(participantId));
    }

    @PostMapping("/{id}/regenerate")
    public ResponseEntity<QrCodeDto> regenerate(@PathVariable Long id) {
        return ResponseEntity.ok(qrCodeService.regenerate(id));
    }
}