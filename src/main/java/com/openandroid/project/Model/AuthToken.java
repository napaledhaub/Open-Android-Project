package com.openandroid.project.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

public class AuthToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="token")
    private String token;

    private LocalDateTime expirationDateTime;

    @OneToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    public AuthToken(String token, LocalDateTime expirationDateTime, Developer developer) {
        this.token = token;
        this.expirationDateTime = expirationDateTime;
        this.developer = developer;
    }
}
