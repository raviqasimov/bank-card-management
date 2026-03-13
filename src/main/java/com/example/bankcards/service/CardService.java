package com.example.bankcards.service;

import com.example.bankcards.dto.TransferRequest;
import com.example.bankcards.entity.Card;

import java.util.List;

public interface CardService {
    List<Card>getAllCards();
    Card getCardById(Long id);
    Card saveCard(Card card);
    void deleteCard(Long id);
    Card transfer(TransferRequest request);
}
