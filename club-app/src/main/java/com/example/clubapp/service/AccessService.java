package com.example.clubapp.service;

import com.example.clubapp.dto.EntryResponse;
import com.example.clubapp.entity.Participant;
import com.example.clubapp.entity.QrCode;
import com.example.clubapp.repository.QrCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccessService {

    private final QrCodeRepository qrCodeRepository;

    @Transactional
    public EntryResponse checkAccess(UUID qrUuid) {
        // Находим QR-код
        QrCode qrCode = qrCodeRepository.findByQrUuid(qrUuid)
                .orElseThrow(() -> new RuntimeException("Неверный QR-код"));

        // Получаем участника
        Participant participant = qrCode.getParticipant();

        // Генерируем новый UUID
        UUID newUuid = UUID.randomUUID();
        qrCode.setQrUuid(newUuid);
        qrCodeRepository.save(qrCode);

        // Возвращаем ответ
        return EntryResponse.builder()
                .fullName(participant.getLastName() + " " +
                        participant.getFirstName() + " " +
                        participant.getMiddleName())
                .newQrUuid(newUuid)
                .build();
    }
}