package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homepage {
 private WebDriver driver;
 public Homepage(WebDriver driver) {
     this.driver = driver;
     PageFactory.initElements(driver, this);
 }
 @FindBy(xpath = "//a[text()='Register']")
 private WebElement reglink;
 @FindBy(xpath="(//h2)[1]")
 private WebElement word;
 public void check() {
	 String x=word.getText().trim();
	 String y="Welcome to our store";
	 Assert.assertEquals(x,y);
	 System.out.println("Assertion success in home page");
	 reglink.click();
	 }
}
