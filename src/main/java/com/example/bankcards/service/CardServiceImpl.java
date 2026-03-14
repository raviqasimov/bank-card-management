package com.example.bankcards.service;

import com.example.bankcards.dto.TransferRequest;
import com.example.bankcards.entity.Card;
import com.example.bankcards.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCardById(Long id) {
        return cardRepository.findById(id).orElseThrow(() -> new  RuntimeException("Card not found"));
    }

    @Override
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

    @Override
    public Card transfer(TransferRequest request) {
        Card from = cardRepository.findById(request.getFromCardId())
                .orElseThrow(() -> new RuntimeException("Card not found"));
        Card to = cardRepository.findById(request.getToCardId())
                .orElseThrow(() -> new RuntimeException("Card not found"));
        if (from.getBalance().compareTo(request.getAmount()) < 0) {
            throw new RuntimeException("Insufficient balance");
        }
        from.setBalance(from.getBalance().subtract(request.getAmount()));
        to.setBalance(to.getBalance().add(request.getAmount()));
        cardRepository.save(from);
        cardRepository.save(to);
        return from;
    }
}
