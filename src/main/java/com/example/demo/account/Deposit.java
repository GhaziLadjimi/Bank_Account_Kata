package com.example.demo.account;

import java.util.Date;

public class Deposit extends RegistryRecord {

  private Integer newBalance;

  public Deposit(Integer amount, Date date, Integer balance) {
    super(amount, date, balance);
    newBalance = balance;
  }

  @Override
  public int execute() {
    newBalance = getBalance() + getAmount();
    return newBalance;
  }

}
