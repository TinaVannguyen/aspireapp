package com.aspireapp.aspiretest.pages;

import com.aspireapp.aspiretest.pageobject.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageObject {


    @FindBy(css = "li[class='breadcrumb-item active']")
    private WebElement productPageName;

    @FindBy(css = "h1 [name='name']")
    private WebElement productPageNameAdd;


    @FindBy(css = "div[class='o_cp_buttons']")
    private WebElement productCreateBnt;

    @FindBy(css = "div>button[accesskey='s']")
    private WebElement productSaveBnt;

    @FindBy(css = "li[class='breadcrumb-item active']")
    private WebElement productNewName;

    @FindBy(css = "h1 [name='name']")
    private WebElement inputProductName;

    @FindBy(css = "td [name='default_code']")
    private WebElement inputReference;

    @FindBy(css = "td [name='barcode']")
    private WebElement inputBarcode;

    @FindBy(css = "div [name='list_price']")
    private WebElement inputPrice;

    @FindBy(css = "div [name='standard_price']")
    private WebElement inputCost;

    @FindBy(css = "li[class='breadcrumb-item active']")
    private WebElement addedProductName;

    @FindBy(css = "a[class='fa o_menu_toggle fa-th']")
    private WebElement menuApplication;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void waitUtilProductNameExisted() {
        waitHelper.waitUtilTextToBeByCssSelector("li[class='breadcrumb-item active']", "Products");
    }

    public void waitUtilProductNewExisted() {
        waitHelper.waitUtilTextToBeByCssSelector("li[class='breadcrumb-item active']", "New");
    }

    public String getProductName() {
        return elementHelper.getText(productPageName);
    }

    public String getProductNewPage() {
        return elementHelper.getText(productNewName);
    }

    public String getAddedProductName() {
        return elementHelper.getText(addedProductName);
    }

    public void clickProductCreateBnd() {
        elementHelper.click(productCreateBnt);
    }

    public void clickProductSaveBnd() {
        elementHelper.click(productSaveBnt);
    }

    public void clickMenuApplication() {
        elementHelper.click(menuApplication);
    }

    public void createNewProduct(String productName, String productReference, String productBarcode) {
        elementHelper.inputText(inputProductName, productName);
        elementHelper.inputText(inputReference, productReference);
        elementHelper.inputText(inputBarcode, productBarcode);
    }
}

