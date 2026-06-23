package com.example.clubapp.service;

import com.example.clubapp.dto.QrCodeDto;
import com.example.clubapp.entity.Participant;
import com.example.clubapp.entity.QrCode;
import com.example.clubapp.exception.ResourceNotFoundException;
import com.example.clubapp.mapper.QrCodeMapper;
import com.example.clubapp.repository.ParticipantRepository;
import com.example.clubapp.repository.QrCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QrCodeService {

    private final QrCodeRepository qrCodeRepository;
    private final ParticipantRepository participantRepository;
    private final QrCodeMapper qrCodeMapper;

    public QrCodeDto getById(Long id) {
        QrCode qrCode = qrCodeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QR-код", id));
        return qrCodeMapper.toDto(qrCode);
    }

    public QrCodeDto getByUuid(UUID uuid) {
        QrCode qrCode = qrCodeRepository.findByQrUuid(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("QR-код", uuid.toString()));
        return qrCodeMapper.toDto(qrCode);
    }

    @Transactional
    public QrCodeDto create(Long participantId) {
        Participant participant = participantRepository.findById(participantId)
                .orElseThrow(() -> new ResourceNotFoundException("Участник", participantId));

        QrCode qrCode = QrCode.builder()
                .participant(participant)
                .qrUuid(UUID.randomUUID())
                .build();

        return qrCodeMapper.toDto(qrCodeRepository.save(qrCode));
    }

    @Transactional
    public QrCodeDto regenerate(Long id) {
        QrCode qrCode = qrCodeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QR-код", id));

        qrCode.setQrUuid(UUID.randomUUID());
        return qrCodeMapper.toDto(qrCodeRepository.save(qrCode));
    }
}