package com.universal.dao;

import com.universal.connection.MainConnect;
import com.universal.entity.BankAccount;
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

public class CustomerStatementDAO implements CustomerDAO {

    private static final Logger logger = Logger.getLogger(CustomerStatementDAO.class);

    @Override
    public void insertCustomer(Customer customer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(PropertFilesData.getQuery("insertCustomer"));
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getSurname());
            preparedStatement.setString(3, customer.getName());
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
    public void updateCustomer(Customer customer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(PropertFilesData.getQuery("updateCustomer"));
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getSurname());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setLong(4, customer.getId());
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
    public void deleteCustomer(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(PropertFilesData.getQuery("deleteCustomer"));
            preparedStatement.setLong(1, id);
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
    public List<Customer> getAllCustomers() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(PropertFilesData.getQuery("getAllCustomers"));
            List<Customer> customers = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setPhone(resultSet.getString("phone"));
                customers.add(customer);
            }
            return customers;
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

    @Override
    public Customer getCustomer(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Customer customer = new Customer();
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(PropertFilesData.getQuery("getCustomer"));
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setPhone(resultSet.getString("phone"));
            }
            return customer;
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
        return customer;
    }

    @Override
    public List<Customer> getCustomerAccountCard(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Customer customer = null;
        BankAccount bankAccount = null;
        Card card = null;
        List<Customer> customers = new ArrayList<>();;

        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(PropertFilesData.getQuery("getCustomerAccountCard"));
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                bankAccount = new BankAccount();
                card = new Card();

                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setPhone(resultSet.getString("phone"));

                bankAccount.setIdBank(resultSet.getLong("id_bank"));
                bankAccount.setAccount(resultSet.getString("account"));
                bankAccount.setDeposit(resultSet.getBigDecimal("deposit"));
                bankAccount.setCredit(resultSet.getBigDecimal("credit"));
                bankAccount.setState(resultSet.getBoolean("state"));
                bankAccount.setBankAccountsCustomers(resultSet.getLong("bank_accounts_customers"));
                customer.setBankAccount(bankAccount);

                card.setIdCard(resultSet.getLong("id_card"));
                card.setNumber(resultSet.getString("number"));
                card.setCardsBankAccounts(resultSet.getLong("cards_bank_accounts"));
                customer.setCard(card);

                customers.add(customer);
            }
            return customers;
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


    @Override
    public Customer getCustomerJoinBankAcc(Long id) {
        return null;
    }


}
