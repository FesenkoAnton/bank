package com.universal.dao;

import com.universal.connection.MainConnect;
import com.universal.entity.Card;
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

    private static final String insertCard = "INSERT INTO cards (number, cards_bank_accounts) VALUES ( ? ,(select id_bank from bank_accounts where bank_accounts.id_bank = ? ))";
    private static final String updateCard = "UPDATE cards SET number = ? WHERE id_card = ?";
    private static final String deleteCard = "DELETE FROM cards WHERE id_card = ?";
    private static final String getAllCards = "SELECT * FROM cards";

    @Override
    public void insertCard(String number, Long bankAccountsID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(PropertFilesData.getQuery("insertCard"));
            if(preparedStatement==null){System.out.println("null");}


            preparedStatement.setString(1, number);
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