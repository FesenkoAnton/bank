package com.universal.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {

    private Long idBank;

    private String account;

    private BigDecimal deposit;

    private BigDecimal credit;

    private Boolean state;

    private Long bankAccountsCustomers;

    private List<Card> cards = new ArrayList<>();

    public Long getIdBank() {
        return idBank;
    }

    public void setIdBank(Long idBank) {
        this.idBank = idBank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Long getBankAccountsCustomers() {
        return bankAccountsCustomers;
    }

    public void setBankAccountsCustomers(Long bankAccountsCustomers) {
        this.bankAccountsCustomers = bankAccountsCustomers;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
