package com.universal.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String name;

    private String surname;

    private String phone;

    private Collection<Card> cards = new ArrayList<>();
}
