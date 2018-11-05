package com.universal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    private String account;

    private BigDecimal deposit;

    private BigDecimal credit;

    private Boolean state;
}
