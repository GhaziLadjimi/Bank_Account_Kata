package com.example.demo.account;

import java.util.Date;

import com.example.demo.exception.NegativeBalanceException;

public class Withdrawal extends RegistryRecord {

  private Integer newBalance;

  public Withdrawal(Integer amount, Date date, Integer balance) {
    super(amount, date, balance);
    newBalance = balance;
  }

  @Override
  public int execute() throws NegativeBalanceException {
    if (getBalance() - getAmount() >= 0) {
      newBalance = getBalance() - getAmount();
      return newBalance;
    } else {
      throw new NegativeBalanceException("The amount you want to withdrawal is superior to your balance");
    }
  }

  public Integer getNewBalance() {
    return newBalance;
  }

  public void setNewBalance(Integer newBalance) {
    this.newBalance = newBalance;
  }
}