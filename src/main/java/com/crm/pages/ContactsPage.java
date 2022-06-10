package com.crm.pages;

import com.crm.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    WebElement contactsLabel;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "middle_initial")
    WebElement middleName;

    @FindBy(id = "surname")
    WebElement surname;

    @FindBy(id = "department")
    WebElement department;

    @FindBy(xpath = "//input[@type='submit' and @value='save']")
    WebElement saveButton;

    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyContactsLabel(){
        return contactsLabel.isDisplayed();
    }

    public void selectContactsByName(String name){
        driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
                + "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
    }



    public void createNewContact(String title, String name, String middlennitials, String lastname, String depart){
        Select select = new Select(driver.findElement(By.name("title")));
        select.selectByValue(title);
        firstName.sendKeys(name);
        middleName.sendKeys(middlennitials);
        surname.sendKeys(lastname);
        department.sendKeys(depart);
        saveButton.submit();
    }


}
