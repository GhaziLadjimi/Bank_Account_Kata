package com.example.demo.account;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.exception.NegativeBalanceException;

public class Account {

  private Integer balance;
  private List<RegistryRecord> registry;

  public Account(Integer initialBalance) {
    balance = initialBalance;
    registry = new ArrayList<>();
  }

  public void deposit(Integer amount) throws NegativeBalanceException {
    RegistryRecord deposit = new Deposit(balance, new Date(), amount);
    balance = deposit.execute();
    registry.add(deposit);
  }

  public void withdraw(Integer amount) throws NegativeBalanceException {
    RegistryRecord withdrawal = new Withdrawal(balance, new Date(), amount);
    balance = withdrawal.execute();
    registry.add(withdrawal);
  }

  public String printStatement() throws NegativeBalanceException {
    StringBuilder statement = new StringBuilder();
    String headings = "Date              Amount  Balance\n";

    for (RegistryRecord registryRecord : registry) {
      statement.append(new SimpleDateFormat("MM-dd-yyyy HH:mm").format(registryRecord.getDate()));

      statement.append("\t");

      if (registryRecord instanceof Deposit) {
        statement.append("+");
      }

      if (registryRecord instanceof Withdrawal) {
        statement.append("-");
      }

      statement.append(registryRecord.getAmount());
      statement.append("\t");
      statement.append(registryRecord.execute());
      statement.append("\n");
    }

    return headings + statement;

  }

  public Integer getBalance() {
    return balance;
  }

}
