package com.example.clubapp.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name="qr_codes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class QrCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="participant_id", nullable = false)
    private Participant participant;

    @Column(name = "qr_uuid", nullable = false, unique = true)
    private UUID qrUuid;
}

