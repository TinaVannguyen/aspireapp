package com.aspireapp.aspiretest.pages;

import com.aspireapp.aspiretest.pageobject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends PageObject {
    private static final String INVENTORY_TOGGLE_CSS_SELECTOR = "nav[class='o_main_navbar']>ul>li>a[role='button']";
    private static final String INVENTORY_PRODUCT_LIST_CSS_SELECTOR ="div[class='dropdown-menu show']>a[role='menuitem']";

    @FindBy(css = "div[role='listbox']>a[id='result_app_1']")
    private WebElement btnInventory;

    @FindBy(css ="div[role='listbox']")
    private WebElement getListBox;

    @FindBy(css = "nav[class='o_main_navbar']")
    private  WebElement getMenuBar;

    @FindBy(css = "nav[class='o_main_navbar']>a[class='o_menu_brand']")
    private  WebElement inventoryName;

    @FindBy (css = "div[class='dropdown-menu show']")
    private WebElement getProductList;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getInventoryPageTitle() {
        return driver.getTitle();
    }

    public void clickInventory() {
        elementHelper.click(btnInventory);
    }

    public void clickProductToggle(){
        getMenuBar.findElements(By.cssSelector(INVENTORY_TOGGLE_CSS_SELECTOR)).get(1).click();
    }

    public void clickProductValue(){
        getProductList.findElements(By.cssSelector(INVENTORY_PRODUCT_LIST_CSS_SELECTOR)).get(0).click();
    }

    public String getInventoryName(){
        return elementHelper.getText(inventoryName);
    }

}
