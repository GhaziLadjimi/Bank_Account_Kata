package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.account.Account;
import com.example.demo.exception.NegativeBalanceException;

@SpringBootTest
class DemoApplicationTests {

  public static final Integer initialBalance = 500;
  public static final String expectedPrint =
      "Date              Amount  Balance\n" + new SimpleDateFormat("MM-dd-yyyy HH:mm").format(new Date()) + "\t+100\t600\n" + new SimpleDateFormat(
          "MM-dd-yyyy HH:mm").format(new Date()) + "\t-400\t200\n";
  Account account;

  @BeforeEach
  public void init() {
    account = new Account(initialBalance);
  }


  @Test
  void Deposit_Balance_Increases_When_Making_A_Deposit() throws NegativeBalanceException {

    account.deposit(100);

    assertThat(account.getBalance()).isEqualTo(600);
  }

  @Test
  void Withdraw_Balance_Decreases_When_Making_A_WWithdrawal() throws NegativeBalanceException {

    account.withdraw(100);

    assertThat(account.getBalance()).isEqualTo(400);
  }

  @Test
  void Withdraw_Amount_IS_Superior_To_Balance_When_Making_A_WWWithdrawal() {
    assertThatExceptionOfType(NegativeBalanceException.class).isThrownBy(() -> account.withdraw(600))
        .withMessage("The amount you want to withdrawal is superior to your balance");
  }

  @Test
  void PrintStatement_StatementShouldIncludeHeaderAndRegistryOperationsTable() throws NegativeBalanceException {
    account.deposit(100);
    account.withdraw(400);

    assertThat(account.printStatement()).isEqualTo(expectedPrint);

  }

}
