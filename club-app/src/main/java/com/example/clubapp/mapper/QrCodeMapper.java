package com.example.clubapp.mapper;

import com.example.clubapp.dto.QrCodeDto;
import com.example.clubapp.entity.QrCode;
import org.springframework.stereotype.Component;

@Component
public class QrCodeMapper {

    public QrCodeDto toDto(QrCode qrCode) {
        return new QrCodeDto(
                qrCode.getId(),
                qrCode.getParticipant().getId(),
                qrCode.getQrUuid()
        );
    }
}