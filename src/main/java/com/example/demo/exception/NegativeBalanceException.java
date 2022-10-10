package com.example.demo.exception;

public class NegativeBalanceException extends Exception {

  public NegativeBalanceException(String errorMessage) {
    super(errorMessage);
  }
}