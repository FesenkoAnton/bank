package com.universal.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Card {

    private Long idCard;

    private String number;

    private Long cardsBankAccounts;

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getCardsBankAccounts() {
        return cardsBankAccounts;
    }

    public void setCardsBankAccounts(Long cardsBankAccounts) {
        this.cardsBankAccounts = cardsBankAccounts;
    }
}
