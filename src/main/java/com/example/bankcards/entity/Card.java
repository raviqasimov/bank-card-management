package com.example.bankcards.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNumber;
    private BigDecimal balance;
    private LocalDate expiryDate;
    @Enumerated(EnumType.STRING)
    private CardStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;
}
