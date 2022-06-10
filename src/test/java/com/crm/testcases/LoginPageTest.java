package com.crm.testcases;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
    String title = loginPage.validateLoginPageTitle();
    Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
    }

    @Test(priority = 2)
    public void crmLogoImageTest(){
        boolean flag = loginPage.validateCRMImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest(){
        homePage = loginPage.login(props.getProperty("username"), props.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
