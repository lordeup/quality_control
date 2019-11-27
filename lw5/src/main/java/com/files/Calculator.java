package com.files;

import java.lang.Math;

public class Calculator {
  private double result;

  public Calculator() {
    this.result = 0.0;
  }

  public double getSum(double numberOne, double numberTwo) {
    result = numberOne + numberTwo;
    return result;
  }

  public double getDifference(double numberOne, double numberTwo) {
    result = numberOne - numberTwo;
    return result;
  }

  public double getDivision(double numberOne, double numberTwo) {
    if (numberTwo == 0) {
      throw new IllegalArgumentException("Division by 0");
    }
    result = numberOne / numberTwo;
    return result;
  }

  public double getMultiplication(double numberOne, double numberTwo) {
    result = numberOne * numberTwo;
    return result;
  }

  public double getExponentiation(double basis, double exponent) {
    result = Math.pow(basis, exponent);
    return result;
  }

  public void setResult(double result) {
    this.result = result;
  }

  public double getResult() {
    return result;
  }
}
