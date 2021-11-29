package com.aspireapp.aspiretest.pages;

import com.aspireapp.aspiretest.pageobject.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManufacturingPage extends PageObject {

    @FindBy(css = "li[class='breadcrumb-item active']")
    private WebElement productPageName;

    @FindBy(css = "a[class='o_menu_brand']")
    private WebElement namePageManufacturing;

    @FindBy(css = "button[accesskey='c']")
    private WebElement createManufacturing;

    @FindBy(css = "div[name='product_id']")
    private WebElement manufacturingProductTxt;

    @FindBy(css = "div[name='product_id']>div[class='o_input_dropdown']>input[class='o_input ui-autocomplete-input']")
    private WebElement inputManufacturingProduct;

    @FindBy(css = "span[name='name']")
    private WebElement nameCreateManufacturing;

    @FindBy(css = "button[accesskey='s']")
    private WebElement bntManufacturingSave;

    @FindBy(css = "a[name='product_id']")
    private WebElement manufacturingNameAdded;

    public ManufacturingPage(WebDriver driver) {
        super(driver);
    }

    public String getManufacturingPageName() {
        return elementHelper.getText(namePageManufacturing);
    }

    public void waitUtilManufactureExisted() {
        waitHelper.waitUtilTextToBeByCssSelector("a[class='o_menu_brand']", "Manufacturing");
    }

    public void clickManufacturingCreate() {
        elementHelper.click(createManufacturing);
    }

    public void clickManufacturingProduct() {
        elementHelper.click(manufacturingProductTxt);
    }

    public void clickManufacturingSave() {
        elementHelper.click(bntManufacturingSave);
    }

    public String getManufacturingCreateScreen() {
        return elementHelper.getText(nameCreateManufacturing);
    }

    public void inputProductManufacturingSearch(String ManufacturingProductName) {
        elementHelper.inputText(inputManufacturingProduct, ManufacturingProductName);
    }

}

