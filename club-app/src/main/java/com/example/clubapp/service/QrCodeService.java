package com.example.clubapp.service;

import com.example.clubapp.dto.QrCodeDto;
import com.example.clubapp.entity.Participant;
import com.example.clubapp.entity.QrCode;
import com.example.clubapp.repository.ParticipantRepository;
import com.example.clubapp.repository.QrCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QrCodeService {

    private final QrCodeRepository qrCodeRepository;
    private final ParticipantRepository participantRepository;

    public List<QrCodeDto> getAll() {
        return qrCodeRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public QrCodeDto getById(Long id) {
        QrCode qrCode = qrCodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("QR-код не найден: " + id));
        return toDto(qrCode);
    }

    public QrCodeDto getByUuid(UUID uuid) {
        QrCode qrCode = qrCodeRepository.findByQrUuid(uuid)
                .orElseThrow(() -> new RuntimeException("QR-код не найден: " + uuid));
        return toDto(qrCode);
    }

    @Transactional
    public QrCodeDto create(Long participantId) {
        Participant participant = participantRepository.findById(participantId)
                .orElseThrow(() -> new RuntimeException("Участник не найден: " + participantId));

        QrCode qrCode = QrCode.builder()
                .participant(participant)
                .qrUuid(UUID.randomUUID())
                .build();

        return toDto(qrCodeRepository.save(qrCode));
    }

    @Transactional
    public QrCodeDto regenerate(Long id) {
        QrCode qrCode = qrCodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("QR-код не найден: " + id));

        qrCode.setQrUuid(UUID.randomUUID());
        return toDto(qrCodeRepository.save(qrCode));
    }

    private QrCodeDto toDto(QrCode qrCode) {
        return QrCodeDto.builder()
                .id(qrCode.getId())
                .participantId(qrCode.getParticipant().getId())
                .qrUuid(qrCode.getQrUuid())
                .build();
    }
}