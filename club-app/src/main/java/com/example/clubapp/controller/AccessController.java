package com.example.clubapp.controller;

import com.example.clubapp.dto.EntryResponse;
import com.example.clubapp.service.AccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/access")
@RequiredArgsConstructor
public class AccessController {

    private final AccessService accessService;

    @PostMapping("/check/{qrUuid}")
    public ResponseEntity<EntryResponse> checkAccess(@PathVariable UUID qrUuid) {
        return ResponseEntity.ok(accessService.checkAccess(qrUuid));
    }
}