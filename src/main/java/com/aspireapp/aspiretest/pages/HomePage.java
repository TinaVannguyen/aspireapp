package com.aspireapp.aspiretest.pages;

import com.aspireapp.aspiretest.pageobject.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(css = "div[role='listbox']>a[id='result_app_1']")
    private WebElement btnInventory;

    @FindBy(css ="div[role='listbox']")
    private WebElement getListBox;

    @FindBy(css ="div[role='listbox']>a[id='result_app_2']")
    private WebElement bntManufacturing;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void waitUtilListBoxExisted() {
        waitHelper.waitUntilElementDisplayed(getListBox);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickInventory() {
        elementHelper.click(btnInventory);
    }
    public void clickManufacturing(){
        elementHelper.click(bntManufacturing);
    }
}
