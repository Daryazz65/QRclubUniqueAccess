package com.example.clubapp.exception;

public class InvalidQrCodeException extends RuntimeException {

    public InvalidQrCodeException(String message) {
        super(message);
    }

    public InvalidQrCodeException() {
        super("Неверный QR-код");
    }
}