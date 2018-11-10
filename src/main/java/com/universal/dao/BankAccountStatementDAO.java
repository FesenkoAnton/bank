package com.universal.dao;

import com.universal.connection.MainConnect;
import com.universal.entity.BankAccount;
import com.universal.proper.PropertFilesData;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccountStatementDAO implements BankAccountDAO {

    private static final Logger logger = Logger.getLogger(BankAccountStatementDAO.class);

    @Override
    public void insertBankAccount(BankAccount bankAccount, Long customerId) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(PropertFilesData.getQuery("insertBankAccount"));
            preparedStatement.setString(1, bankAccount.getAccount());
            preparedStatement.setBigDecimal(2, bankAccount.getDeposit());
            preparedStatement.setBigDecimal(3, bankAccount.getCredit());
            preparedStatement.setBoolean(4, bankAccount.getState());
            preparedStatement.setLong(5, customerId);
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
    public void updateBankAccount(BankAccount bankAccoun) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(PropertFilesData.getQuery("updateBankAccount"));
            preparedStatement.setString(1, bankAccoun.getAccount());
            preparedStatement.setBigDecimal(2, bankAccoun.getDeposit());
            preparedStatement.setBigDecimal(3, bankAccoun.getCredit());
            preparedStatement.setBoolean(4, bankAccoun.getState());
            preparedStatement.setLong(5, bankAccoun.getIdBank());

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
    public void deleteBankAccount(Long idBank) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(PropertFilesData.getQuery("deleteBankAccount"));
            preparedStatement.setLong(1, idBank);
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
    public List<BankAccount> getAllBankAccounts() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(PropertFilesData.getQuery("getAllBankAccounts"));
            List<BankAccount> bankAccounts = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BankAccount bankAccount = new BankAccount();
                bankAccount.setIdBank(resultSet.getLong("id_bank"));
                bankAccount.setAccount(resultSet.getString("account"));
                bankAccount.setDeposit(resultSet.getBigDecimal("deposit"));
                bankAccount.setCredit(resultSet.getBigDecimal("credit"));
                bankAccount.setState(resultSet.getBoolean("state"));
                bankAccount.setBankAccountsCustomers(resultSet.getLong("bank_accounts_customers"));

                bankAccounts.add(bankAccount);
            }
            return bankAccounts;
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
