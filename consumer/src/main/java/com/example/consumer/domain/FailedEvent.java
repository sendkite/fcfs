package com.example.consumer.domain;

import jakarta.persistence.*;

@Entity
public class FailedEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long userId;

    public FailedEvent() {
    }

    public FailedEvent(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
