package com.universal.dao;

import com.universal.entity.BankAccount;

import java.math.BigDecimal;
import java.util.List;

public interface BankAccountDAO {

//    void insertBankAccount(String account,
//                           BigDecimal deposit,
//                           BigDecimal credit,
//                           Boolean state,
//                           Long customerId);

    void insertBankAccount(BankAccount bankAccount, Long customerId);

//    void updateBankAccount(String account,
//                           BigDecimal deposit,
//                           BigDecimal credit,
//                           Boolean state,
//                           Long idBank);

    void updateBankAccount(BankAccount bankAccoun);

    void deleteBankAccount(Long idBank);

    List<BankAccount> getAllBankAccounts();

}
