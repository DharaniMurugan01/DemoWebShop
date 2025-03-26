package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Datapro.ExcelDataProvider;
import com.base.Basetest;
import com.pages.Homepage;
import com.pages.Registerpage;

public class Registertest extends Basetest {
    private Registerpage registerPage;
    private Homepage hp;

    @Test(dataProvider = "exceldata", dataProviderClass = com.Datapro.ExcelDataProvider.class)
    public void register(String gen, String fname, String lname, String email, String pass, String status) {
        System.out.println("Register test started");
        
        Homepage hp = new Homepage(driver);
        hp.check();
        
        registerPage = new Registerpage(driver);
        String actualText = registerPage.getpagetext();
        String expectedText = "Register";
        Assert.assertEquals(actualText, expectedText, "Register page text mismatch");
        System.out.println("Asserted the register page");
        
        registerPage.register(gen, fname, lname, email, pass);
        System.out.println("Registration process completed");
        if (status.equalsIgnoreCase("pass")) {
            String ex= "Your registration completed";
            String ac = registerPage.Status1();
            Assert.assertEquals(ac, ex);
            System.out.println("Registration completed successfully");
        } 
        else if(status.equalsIgnoreCase("duplicate")) {
        	String ex="Wrong email";
        	String ac=registerPage.Status3();
        	Assert.assertEquals(ex,ac);
        	System.out.print("duplicate value entered");
        }
        else if(status.equalsIgnoreCase("already")){
        	String ex="The specified email already exists";
        	String ac=registerPage.Status();
        	Assert.assertEquals(ex,ac);
        	System.out.print("already exists");
        }
        else if(status.equalsIgnoreCase("required")) {
        	String ex="Email is required.";
        	String ac=registerPage.Status2();
        	Assert.assertEquals(ex,ac);
        	System.out.print("enter the required field");
        }
     }
}
