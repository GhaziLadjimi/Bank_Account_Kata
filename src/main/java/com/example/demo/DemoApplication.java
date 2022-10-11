package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.account.Account;
import com.example.demo.exception.NegativeBalanceException;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) throws NegativeBalanceException {
    SpringApplication.run(DemoApplication.class, args);

    // create an Account
    Account account = new Account(500);

    // Deposit 100 to the account
    account.deposit(100);

    //Withdraw 400 from the account
    account.withdraw(400);

    // Print the history of my operations
    System.out.println(account.printStatement());
  }

}
