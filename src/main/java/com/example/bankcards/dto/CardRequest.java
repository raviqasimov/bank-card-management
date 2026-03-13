package com.example.bankcards.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CardRequest {
    private String cardNumber;
    private LocalDate expiryDate;
    private BigDecimal balance;
}
