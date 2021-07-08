package com.example.trans;

import java.sql.SQLException;

import java.util.Scanner;
import java.sql.*;

import com.example.trans.entity.Account;
import com.example.trans.entity.Transaction;
import com.example.trans.p0.JdbcAccountRepository;
import com.example.trans.p0.AccountRepository;
import com.example.trans.p0.TransactionRepository;
import com.example.trans.entity.TransactionCredit;
import com.example.trans.p0.TransactionCreditRepository;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
       AccountRepository accountrepository = new JdbcAccountRepository();
       TransactionRepository transactionRepository = new JdbcAccountRepository();
       TransactionCreditRepository transactionCreditRepository = new JdbcAccountRepository();
       Account account = new Account(123346, 1237788);
       Transaction transaction = new Transaction("2021-07-07",10000.0,10000.0,25);
       TransactionCredit transactionCredit = new TransactionCredit("2021-07-07", 10000.0, 10000.0, 31);
       //transactionRepository.transactionreport();
       char option='\0';
       do {
    	   System.out.println("Enter a Character A/B/C");
    	   Scanner sc = new Scanner(System.in);
    	   option=sc.next().charAt(0);
    	   System.out.println('\n');
    	   
    	  switch(option) {
    	  case 'A': accountrepository.save(account);
    	  			break;
    	  case 'B': accountrepository.transfer(1000);
    				transactionRepository.report(transaction);
    				transactionCreditRepository.creditreport(transactionCredit);
    				break;
    	  case 'C': transactionRepository.transactionreport();
    	  			break;
    	  default :	System.out.println("-------You Entered a Wrong Option!-------");
    				break;
    	  }
       }while(option != 'D');
       
       System.out.println("--------Thank You! For Using Our Services--------");
	//accountrepository.save(account);
	//accountrepository.transfer(10000);
	//transactionRepository.report(transaction);
	//transactionCreditRepository.creditreport(transactionCredit);
    }
}
