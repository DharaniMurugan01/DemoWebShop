package com.tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.base.Basetest;
import com.pages.Homepage;
public class Hometest extends Basetest{
	private Homepage homepage;
    @Test(priority = 1)
    public void verifyHomePageText() {
    	homepage = new Homepage(driver); 
        homepage.check(); 
    }
}
