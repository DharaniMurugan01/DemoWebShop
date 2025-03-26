package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Registerpage {
	 private WebDriver driver;
	 public Registerpage(WebDriver driver) {
	     this.driver = driver;
	     PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath="//input[@id='gender-male']") 
	    private WebElement Male; 
	 @FindBy(xpath="//input[@id='gender-female']") 
	    private WebElement FeMale; 
	 @FindBy(xpath="//input[@id='FirstName']") 
	    private WebElement fn;
	 @FindBy(xpath="//input[@id='LastName']") 
	    private WebElement ln;
	 @FindBy(xpath="//input[@id='Email']") 
	    private WebElement email;
	 @FindBy(xpath="//input[@id='Password']")
	  private WebElement passs;
	 @FindBy(xpath="//input[@id='ConfirmPassword']")
	  private WebElement conpass;
	 @FindBy(xpath="//input[@id='register-button']")
	  private WebElement regclick;
	@FindBy(xpath="//h1[text()='Register']")
	private WebElement text;
	@FindBy(xpath="//li[text()='The specified email already exists']")
	private WebElement already;
	@FindBy(xpath="//div[@class='result']")
	private WebElement complete;
	@FindBy(xpath="//span[@for='Email']")
	private WebElement required;
	@FindBy(xpath="//span[text()='Wrong email']")
	private WebElement dup;
	public String getpagetext() {
		return text.getText();
	}
	 public void register(String gen,String fname, String lname, String emailVal, String pass) {
		 if(gen.equals("Male")) {
			 Male.click();
		 }
		 else {
			 FeMale.click();
		 }
		    fn.sendKeys(fname);
	        ln.sendKeys(lname);
	        email.sendKeys(emailVal);
	        passs.sendKeys(pass);
	        conpass.sendKeys(pass);
	        regclick.click();
	 }
	 public String Status() {
		 return already.getText();
	 }
	 public String Status1() {
		 return complete.getText();
	 }
	 public String Status2() {
		 return required.getText();
	 }
	 public String Status3() {
		 return dup.getText();
	 }
}
