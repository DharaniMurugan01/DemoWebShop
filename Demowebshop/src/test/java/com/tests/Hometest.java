package com.tests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.Basetest;
import com.pages.Homepage;

@Listeners(com.listener.Testlistener.class)
public class Hometest extends Basetest{
	private Homepage homepage;
    @Test(priority = 1)
    public void verifyHomePageText() {
    	homepage = new Homepage(driver); 
        homepage.check(); 
    }
}
