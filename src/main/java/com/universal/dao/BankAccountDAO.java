package com.universal.dao;

import com.universal.entity.BankAccount;

import java.math.BigDecimal;
import java.util.List;

public interface BankAccountDAO {

    void updateBankAccount(String account,
                           BigDecimal deposit,
                           BigDecimal credit,
                           Boolean state,
                           Long idBank);

    void insertBankAccount(String account,
                           BigDecimal deposit,
                           BigDecimal credit,
                           Boolean state,
                           Long customerId);

    void deleteBankAccount(Long idBank);

    List<BankAccount> getAllBankAccounts();

}
