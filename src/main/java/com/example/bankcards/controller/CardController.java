package com.example.bankcards.controller;

import com.example.bankcards.dto.TransferRequest;
import com.example.bankcards.entity.Card;
import com.example.bankcards.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public Card getCardById(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    @PostMapping
    public Card saveCard(@RequestBody Card card) {
        return cardService.saveCard(card);
    }
    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id){
        cardService.deleteCard(id);
    }
    @PostMapping("/transfer")
    public Card transfer(@RequestBody TransferRequest request){
        return cardService.transfer(request);
    }
}
