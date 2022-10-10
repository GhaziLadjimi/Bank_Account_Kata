package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.account.Account;
import com.example.demo.exception.NegativeBalanceException;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) throws NegativeBalanceException {
    SpringApplication.run(DemoApplication.class, args);

    Account account = new Account(500);

    account.deposit(100);
    account.withdraw(400);

    System.out.println(account.printStatement());
  }

}
