package com.files;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductTest {
  private static ChromeDriver driver = Utils.getDriver();

  @Test
  public void test_01_FailLogin() {
    Utils.goMainPage(driver);
    Utils.login(driver, TestData.LOGIN, TestData.INVALID_PASSWORD);

    WebElement result = Utils.findElementByClassName(driver, "alert-danger");
    assertTrue(result.isDisplayed(), "Fail login");
  }

  @Test
  public void test_02_SuccessLogin() {
    Utils.goMainPage(driver);
    Utils.login(driver, TestData.LOGIN, TestData.PASSWORD);

    WebElement result = Utils.findElementByClassName(driver, "alert-success");
    assertTrue(result.isDisplayed(), "Success login");
  }

  @Test
  public void test_03_FindProduct() {
    Utils.goMainPage(driver);
    Utils.findTextInput(driver, TestData.SEARCH_EXPRESSION);

    WebElement result = Utils.findElementByXpath(driver, "//h3[contains(text(), 'CASIO MRP-700-1AVEF')]");
    assertTrue(result.isDisplayed(), "Found " + TestData.SEARCH_EXPRESSION);
  }

  @Test
  public void test_04_OrderRegistration() {
    Utils.goMainPage(driver);

    Utils.addProductToBasket(driver);
    Utils.orderRegistration(driver);

    WebElement result = Utils.findElementByClassName(driver, "alert-success");
    assertTrue(result.isDisplayed(), "Order registration");
  }

  @Test
  public void test_05_AddProductToBasket() {
    Utils.goMainPage(driver);
    Utils.addProductToBasket(driver);

    String result = Utils.getTextElementByClassName(driver, "simpleCart_total");
    assertNotEquals("Empty Cart", result, "Product add to basket");
  }
}
