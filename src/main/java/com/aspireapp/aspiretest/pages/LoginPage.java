package com.aspireapp.aspiretest.pages;

import com.aspireapp.aspiretest.common.TestConstants;
import com.aspireapp.aspiretest.pageobject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name='login']")
    private WebElement inputEmail;

    @FindBy(css = "input[name='password']")
    private WebElement inputPass;

    @FindBy(css = "button[class*='btn-primary']")
    private WebElement btnLogin;

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void loginByEmail(String email, String passWord) {
        elementHelper.inputText(inputEmail, email);
        elementHelper.inputText(inputPass, passWord);
        elementHelper.click(btnLogin);
    }
}
