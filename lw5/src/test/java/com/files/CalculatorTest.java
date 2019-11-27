package com.files;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

  private Calculator CreateDefaultCalculator() {
    return new Calculator();
  }

  @Test
  void getSum_TwoPositiveNumbers_ReturnsPositiveResult() {
    final double NUMBER_ONE = 0.25;
    final double NUMBER_TWO = 0.0;
    final double RESULT = 0.25;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getSum(NUMBER_ONE, NUMBER_TWO);
    assertEquals(RESULT, actual, "Positive + Positive = Positive");
  }

  @Test
  void getSum_TwoNegativeNumbers_ReturnsNegativeResult() {
    final double NUMBER_ONE = -3.0;
    final double NUMBER_TWO = -4.0;
    final double RESULT = -7.0;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getSum(NUMBER_ONE, NUMBER_TWO);
    assertEquals(RESULT, actual, "Negative + Negative = Negative");
  }

  @Test
  void getSum_PositiveAndNegativeNumbers_ReturnsPositiveOrNegativeResult() {
    final double NUMBER_ONE = 3.0;
    final double NUMBER_TWO = -4.0;
    final double RESULT = -1.0;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getSum(NUMBER_ONE, NUMBER_TWO);
    assertEquals(RESULT, actual, "Positive + Negative = (Positive) OR (Negative)");
  }

  @Test
  void getSum_NegativeAndPositiveNumbers_ReturnsPositiveOrNegativeResult() {
    final double NUMBER_ONE = -3.0;
    final double NUMBER_TWO = 4.0;
    final double RESULT = 1.0;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getSum(NUMBER_ONE, NUMBER_TWO);
    assertEquals(RESULT, actual, "Negative + Positive = (Positive) OR (Negative)");
  }

  @Test
  void getDifference_TwoPositiveNumbers_ReturnsPositiveOrNegativeResult() {
    final double NUMBER_ONE = 2.0;
    final double NUMBER_TWO = 4.0;
    final double RESULT = -2.0;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getDifference(NUMBER_ONE, NUMBER_TWO);
    assertEquals(RESULT, actual, "Positive - Positive = (Positive) OR (Negative)");
  }

  @Test
  void getDifference_TwoNegativeNumbers_ReturnsPositiveResult() {
    final double NUMBER_ONE = -2.0;
    final double NUMBER_TWO = -4.0;
    final double RESULT = 2.0;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getDifference(NUMBER_ONE, NUMBER_TWO);
    assertEquals(RESULT, actual, "Negative - Negative = Positive");
  }

  @Test
  void getDifference_PositiveAndNegativeNumbers_ReturnsPositiveResult() {
    final double NUMBER_ONE = 2.0;
    final double NUMBER_TWO = -4.0;
    final double RESULT = 6.0;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getDifference(NUMBER_ONE, NUMBER_TWO);
    assertEquals(RESULT, actual, "Positive - Negative = Positive");
  }

  @Test
  void getDifference_NegativeAndPositiveNumbers_ReturnsNegativeResult() {
    final double NUMBER_ONE = -2.0;
    final double NUMBER_TWO = 4.0;
    final double RESULT = -6.0;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getDifference(NUMBER_ONE, NUMBER_TWO);
    assertEquals(RESULT, actual, "Negative - Positive = Negative");
  }

  @Test
  void getDivision_TwoPositiveNumbers_ReturnsPositiveResult() {
    final double NUMBER_ONE = 6.6;
    final double NUMBER_TWO = 3.3;
    final double RESULT = 2.0;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getDivision(NUMBER_ONE, NUMBER_TWO);
    assertEquals(RESULT, actual, "Positive / Positive = Positive");
  }

  @Test
  void getDivision_TwoNegativeNumbers_ReturnsPositiveResult() {
    final double NUMBER_ONE = -6.0;
    final double NUMBER_TWO = -3.0;
    final double RESULT = 2.0;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getDivision(NUMBER_ONE, NUMBER_TWO);
    assertEquals(RESULT, actual, "Negative / Negative = Positive");
  }

  @Test
  void getDivision_PositiveAndNegativeNumbers_ReturnsNegativeResult() {
    final double NUMBER_ONE = 3.0;
    final double NUMBER_TWO = -6.0;
    final double RESULT = -0.5;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getDivision(NUMBER_ONE, NUMBER_TWO);
    assertEquals(RESULT, actual, "(Positive / Negative) OR (Negative / Positive) = Negative");
  }

  @Test
  void getDivision_DivisionByZero_ReturnsThrows() throws IllegalArgumentException {
    final double NUMBER_ONE = 10.0;
    final double NUMBER_TWO = 0.0;

    Calculator calculator = CreateDefaultCalculator();
    assertThrows(IllegalArgumentException.class, () -> {
      calculator.getDivision(NUMBER_ONE, NUMBER_TWO);
    }, "(Positive) OR (Negative) / 0 = throws");
  }

  @Test
  void getMultiplication_TwoPositiveNumbers_ReturnsPositiveResult() {
    final double NUMBER_ONE = 3.1;
    final double NUMBER_TWO = 2.5;
    final double RESULT = 7.75;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getMultiplication(NUMBER_ONE, NUMBER_TWO);
    assertEquals(RESULT, actual, "Positive * Positive = Positive");
  }

  @Test
  void getMultiplication_TwoNegativeNumbers_ReturnsPositiveResult() {
    final double NUMBER_ONE = -3.0;
    final double NUMBER_TWO = -2.0;
    final double RESULT = 6.0;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getMultiplication(NUMBER_ONE, NUMBER_TWO);
    assertEquals(RESULT, actual, "Negative * Negative = Positive");
  }

  @Test
  void getMultiplication_PositiveAndNegativeNumbers_ReturnsNegativeResult() {
    final double NUMBER_ONE = 3.0;
    final double NUMBER_TWO = -2.0;
    final double RESULT = -6.0;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getMultiplication(NUMBER_ONE, NUMBER_TWO);
    assertEquals(RESULT, actual, "(Positive * Negative) OR (Negative * Positive) = Negative");
  }

  @Test
  void getExponentiation_TwoPositiveNumbers_ReturnsPositiveResult() {
    final double BASIS = 5.0;
    final double EXPONENT = 3.0;
    final double RESULT = 125.0;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getExponentiation(BASIS, EXPONENT);
    assertEquals(RESULT, actual, "Positive ^ Positive = Positive");
  }

  @Test
  void getExponentiation_TwoNegativeNumbers_ReturnsNegativeResult() {
    final double BASIS = -2.0;
    final double EXPONENT = -3.0;
    final double RESULT = -0.125;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getExponentiation(BASIS, EXPONENT);
    assertEquals(RESULT, actual, "Negative ^ Negative = Negative");
  }

  @Test
  void getExponentiation_PositiveAndNegativeNumbers_ReturnsPositiveOrNegativeResult() {
    final double BASIS = 5.0;
    final double EXPONENT = -2.0;
    final double RESULT = 0.04;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getExponentiation(BASIS, EXPONENT);
    assertEquals(RESULT, actual, "(Positive ^ Negative) OR (Negative ^ Positive) = (Positive) OR (Negative)");
  }

  @Test
  void getExponentiation_BasisZero_ReturnsZero() {
    final double BASIS = 0.0;
    final double EXPONENT = 3.0;
    final double RESULT = 0.0;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getExponentiation(BASIS, EXPONENT);
    assertEquals(RESULT, actual, "0 ^ (Positive) OR (Negative) = 0");
  }

  @Test
  void getExponentiation_ExponentZero_ReturnsSingle() {
    final double BASIS = 2.0;
    final double EXPONENT = 0.0;
    final double RESULT = 1.0;

    Calculator calculator = CreateDefaultCalculator();
    double actual = calculator.getExponentiation(BASIS, EXPONENT);
    assertEquals(RESULT, actual, "(Positive) OR (Negative) ^ 0 = 1");
  }

  @Test
  void setResult_ChangeFieldResult_ReturnsModifiedDataNotEqualDefault() {
    final double NEW_RESULT = 100.0;

    Calculator calculator = CreateDefaultCalculator();
    double oldActual = calculator.getResult();
    calculator.setResult(NEW_RESULT);
    double actual = calculator.getResult();

    assertNotEquals(
            oldActual,
            actual,
            "Change result field any number except 0.0 = Modified date not equal default(0.0)"
    );
  }
}