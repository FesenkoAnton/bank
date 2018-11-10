package com.universal.dao;

import com.universal.entity.Customer;

import java.util.List;

interface CustomerDAO {

//    void insertCustomer(String name, String surname, String phone);
    void insertCustomer(Customer customer);

//    void updateCustomer(String name, String surname, String phone, Long id);

    void updateCustomer(Customer customer);

    void deleteCustomer(Long id);

    List<Customer>getAllCustomers();

    Customer getCustomer(Long id);

    List<Customer> getCustomerAccountCard(Long id);

    Customer getCustomerJoinBankAcc(Long id);



}
