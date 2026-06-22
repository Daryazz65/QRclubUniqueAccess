package com.example.clubapp.controller;

import com.example.clubapp.dto.ParticipantDto;
import com.example.clubapp.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @GetMapping
    public ResponseEntity<List<ParticipantDto>> getAll() {
        return ResponseEntity.ok(participantService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipantDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(participantService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ParticipantDto> create(@RequestBody ParticipantDto dto) {
        return ResponseEntity.ok(participantService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipantDto> update(@PathVariable Long id,
                                                 @RequestBody ParticipantDto dto) {
        return ResponseEntity.ok(participantService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        participantService.delete(id);
        return ResponseEntity.noContent().build();
    }
}