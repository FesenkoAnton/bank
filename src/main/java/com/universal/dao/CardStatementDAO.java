package com.universal.dao;

import com.universal.connection.MainConnect;
import com.universal.entity.Card;
import com.universal.entity.Customer;
import com.universal.proper.PropertFilesData;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardStatementDAO implements CardDAO {

    private static final Logger logger = Logger.getLogger(CustomerStatementDAO.class);


    @Override
    public void insertCard(Card card, Long bankAccountsID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(PropertFilesData.getQuery("insertCard"));
            preparedStatement.setString(1, card.getNumber());
            preparedStatement.setLong(2, bankAccountsID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
            MainConnect.putConn(connection);
        }
    }

    @Override
    public void updateCard(String number, Long idCard) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(PropertFilesData.getQuery("updateCard"));
            preparedStatement.setString(1, number);
            preparedStatement.setLong(2, idCard);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
            MainConnect.putConn(connection);
        }
    }

    @Override
    public void deleteCard(Long idCard) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(PropertFilesData.getQuery("deleteCard"));
            preparedStatement.setLong(1, idCard);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
            MainConnect.putConn(connection);
        }
    }

    @Override
    public Card getCardByNumber(String number) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Card card = new Card();
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(PropertFilesData.getQuery("getCardByNumber"));
            preparedStatement.setString(1, number);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                card.setIdCard(resultSet.getLong("id_card"));
                card.setNumber(resultSet.getString("number"));
                card.setCardsBankAccounts(resultSet.getLong("cards_bank_accounts"));
            }
            return card;
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
            MainConnect.putConn(connection);
        }
        return card;
    }



    @Override
    public List<Card> getAllCards() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(PropertFilesData.getQuery("getAllCards"));
            List<Card> cards = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Card card = new Card();
                card.setIdCard(resultSet.getLong("id_card"));
                card.setNumber(resultSet.getString("number"));
                card.setCardsBankAccounts(resultSet.getLong("cards_bank_accounts"));
                cards.add(card);
            }
            return cards;
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
            MainConnect.putConn(connection);
        }
        return Collections.emptyList();
    }
}