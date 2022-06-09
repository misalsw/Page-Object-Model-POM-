package com.crm.testcases;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utilities.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ContactsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public ContactsPageTest() {
        super();
    }
    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        homePage = loginPage.login(props.getProperty("username"), props.getProperty("password"));
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }

    @Test(priority = 1)
    public void verifyContactsLabel() {
        Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is missing on the page");
    }


    @Test(priority = 2)
    public void selectSingleContactsTest() {
        contactsPage.selectContactsByName("Vaibhav Misal");
    }

    @Test(priority = 3)
    public void selectMultipleContactsTest() {
        contactsPage.selectContactsByName("Vaibhav Misal");
        contactsPage.selectContactsByName("Akshay Misal");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}