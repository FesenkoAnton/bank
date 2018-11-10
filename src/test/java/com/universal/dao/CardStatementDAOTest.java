package com.universal.dao;

import com.universal.entity.Card;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CardStatementDAOTest {

    @Test
    public void testCardStatementDAO(){

        Card card = new Card();
        card.setNumber("1223 4567 4567 4449");
        card.setCardsBankAccounts((long)5);

        CardDAO cardDAO = new CardStatementDAO();

        cardDAO.insertCard(card,(long)8);

        Card card1 =cardDAO.getCardByNumber("1223 4567 4567 4444");
        assertEquals(card1.getNumber(),"1223 4567 4567 4444");

//        cardDAO.deleteCard((long)25);


//        List<Card> cards = cardDAO.getAllCards();
//
//        for(Card card:cards){
//            System.out.println(card.getIdCard()+" "+card.getNumber()+" "+card.getCardsBankAccounts());
//        }


    }
}
