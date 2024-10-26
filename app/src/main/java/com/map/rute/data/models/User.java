package com.map.rute.data.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String email;
    private String passwordHash;
    private LocalDateTime createdAt;

    // Constructor
    public User(UUID id, String name, String email, String passwordHash, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.createdAt = createdAt;
    }

    // Getters y Setters
}
