package com.universal.dao;

import com.universal.entity.BankAccount;
import org.junit.Test;
import org.omg.CORBA.BAD_CONTEXT;

import java.math.BigDecimal;
import java.util.List;

public class BankAccountStatementDAOtest {

    @Test
    public void testCardStatementDAO(){

        BankAccount bankAccount = new BankAccount();

        bankAccount.setAccount("1234567810");
        bankAccount.setDeposit(BigDecimal.valueOf(133.0));
        bankAccount.setCredit(BigDecimal.valueOf(134.0));
        bankAccount.setState(true);
        bankAccount.setBankAccountsCustomers((long)3);

        BankAccountDAO bankAccountDAO = new BankAccountStatementDAO();

//        bankAccountDAO.insertBankAccount(bankAccount,(long)3);

//        bankAccount.setIdBank((long)19);
//        bankAccountDAO.updateBankAccount(bankAccount);
//        bankAccountDAO.deleteBankAccount((long)18);
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
