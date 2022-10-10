package com.example.demo.account;

import java.util.Date;
import java.util.Objects;

import com.example.demo.exception.NegativeBalanceException;

public abstract class RegistryRecord {

  private Integer amount;
  private Date date;
  private Integer balance;

  protected RegistryRecord(Integer balance, Date date, Integer amount) {
    this.amount = amount;
    this.date = date;
    this.balance = balance;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Integer getBalance() {
    return balance;
  }

  public void setBalance(Integer balance) {
    this.balance = balance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistryRecord that = (RegistryRecord) o;
    return Objects.equals(amount, that.amount) && Objects.equals(date, that.date) && Objects.equals(balance,
        that.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, date, balance);
  }

  public abstract int execute() throws NegativeBalanceException;
}
