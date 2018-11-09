package com.universal.dao;

import com.universal.entity.Card;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CardStatementDAOTest {

    @Test
    public void testCardStatementDAO(){

        CardDAO cardDAO = new CardStatementDAO();

//        cardDAO.insertCard("2254 5777 3245 3338",(long)14);
//        cardDAO.updateCard("2254 5777 3245 3390",(long)22);
//        cardDAO.deleteCard((long)22);

        List<Card> cards = cardDAO.getAllCards();

        for(Card card:cards){
            System.out.println(card.getIdCard()+" "+card.getNumber()+" "+card.getCardsBankAccounts());
        }


    }
}
