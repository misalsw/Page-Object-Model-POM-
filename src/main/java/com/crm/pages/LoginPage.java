package com.crm.pages;

import com.crm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class LoginPage extends TestBase {

            //pageFactory - Object Repository OR:
            @FindBy(xpath = "//input[@placeholder='Username']")
            WebElement username;

            @FindBy(xpath = "//input[@placeholder='Password']")
            WebElement password;

            @FindBy(xpath = "//input[@class='btn btn-small']")
            WebElement loginButton;

            @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
            WebElement signUpButton;

            @FindBy(xpath = "//a[@class='navbar-brand']//img[@class='img-responsive']")
            WebElement crmLogo;

            // Initializing the Page Objects
        public LoginPage() {
                PageFactory.initElements(driver, this);
            }

            // Actions
            public String validateLoginPageTitle () {
                return driver.getTitle();
            }

            public boolean validateCRMImage () {
                return crmLogo.isDisplayed();
            }


        public HomePage login(String un, String pwd){
            username.sendKeys(un);
            password.sendKeys(pwd);
            loginButton.submit();

            return new HomePage();

        }
    }

