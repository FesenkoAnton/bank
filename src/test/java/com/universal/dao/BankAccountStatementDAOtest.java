package com.universal.dao;

import com.universal.entity.BankAccount;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BankAccountStatementDAOtest {

    @Test
    public void testCardStatementDAO(){
        BankAccountDAO bankAccountDAO = new BankAccountStatementDAO();

//        bankAccountDAO.updateBankAccount("1234567557",
//                                          BigDecimal.valueOf(150.0),
//                                          BigDecimal.valueOf(150.0),
//                                          false,
//                                          (long) 8);

//        bankAccountDAO.insertBankAccount("1234567445",
//                                          BigDecimal.valueOf(150.0),
//                                          BigDecimal.valueOf(150.0),
//                                          false,
//                                          (long) 3);

//        bankAccountDAO.deleteBankAccount((long)17);
//
//
//        List<BankAccount>bankAccounts = bankAccountDAO.getAllBankAccounts();
//
//        for (BankAccount bankAccount :bankAccounts
//                ) {
//            System.out.println(bankAccount.getIdBank()+" "+bankAccount.getAccount()+" " +bankAccount.getDeposit()+" "+
//                    bankAccount.getCredit()+" "+bankAccount.getState()+" "+bankAccount.getBankAccountsCustomers());
//        }

    }
}
