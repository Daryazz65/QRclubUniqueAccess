package com.example.clubapp.controller;

import com.example.clubapp.dto.ParticipantDto;
import com.example.clubapp.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/participants")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @GetMapping
    public ResponseEntity<Page<ParticipantDto>> getAll(
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(participantService.getAll(pageable));
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