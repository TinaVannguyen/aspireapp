package com.aspireapp.aspiretest;

import com.aspireapp.aspiretest.common.TestConstants;
import com.aspireapp.aspiretest.pages.HomePage;
import com.aspireapp.aspiretest.pages.InventoryPage;
import com.aspireapp.aspiretest.pages.LoginPage;
import com.aspireapp.aspiretest.pages.ProductPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

public class InventoryTest extends BaseTest {
    public static final Logger logger = Logger.getLogger(InventoryTest.class);

    private HashMap testDataSuccess = new HashMap();
    private HashMap addProductSuccess = new HashMap();
    private String validEmail = "";
    private String validPass = "";
    private String validProductName = "";
    private String validProductReference = "";
    private String validProductBarcode = "";
    private String validProductPrice = "";
    private String validProductCost = "";


    @BeforeTest(groups = {"Major", "Medium", "Minor"})
    public void setUpTestData() {
        testDataSuccess = (HashMap) data.get("testDataSuccess");
        addProductSuccess = (HashMap) data.get("addProductSuccess");

        validEmail = testDataSuccess.get("email").toString();
        validPass = testDataSuccess.get("pass").toString();

        validProductName = addProductSuccess.get("productName").toString();
        validProductReference = addProductSuccess.get("productReference").toString();
        validProductBarcode = addProductSuccess.get("productBarcode").toString();
        validProductPrice = addProductSuccess.get("productPrice").toString();
        validProductCost = addProductSuccess.get("productCost").toString();
    }

    public String expectedProductName() {
        String addedProductName = validProductName;
        return addedProductName;
    }

    @Test(groups = {"Major"})
    public void clickInventoryBnt() {
        logger.info("Access Login Page");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginByEmail(validEmail, validPass);

        HomePage homePage = new HomePage(driver);
        homePage.waitUtilListBoxExisted();
        homePage.clickInventory();

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(TestConstants.INVENTORY_NAME_PAGE, inventoryPage.getInventoryName());
        inventoryPage.clickProductToggle();
        inventoryPage.clickProductValue();

        ProductPage productPage = new ProductPage(driver);
        productPage.waitUtilProductNameExisted();
        Assert.assertEquals(TestConstants.PRODUCT_NAME_PAGE, productPage.getProductName());
        productPage.clickProductCreateBnd();
        productPage.waitUtilProductNewExisted();
        Assert.assertEquals(TestConstants.PRODUCT_CREATE_NEW_PAGE, productPage.getProductNewPage());

        productPage.createNewProduct(validProductName, validProductReference, validProductBarcode);
        productPage.clickProductSaveBnd();
        productPage.getAddedProductName();
        Assert.assertEquals(TestConstants.PRODUCT_ADDED_NEW_PAGE, expectedProductName());
        productPage.clickMenuApplication();
    }
}
