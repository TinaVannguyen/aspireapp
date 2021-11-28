package com.aspireapp.aspiretest;

import com.aspireapp.aspiretest.common.TestConstants;
import com.aspireapp.aspiretest.pages.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ManufacturingTest extends BaseTest {
    public static final Logger logger = Logger.getLogger(ManufacturingTest.class);

    private HashMap testDataSuccess = new HashMap();
    private HashMap addProductSuccess = new HashMap();
    private String validEmail = "";
    private String validPass = "";
    private String validProductName ="";


    @BeforeTest(groups = {"Major", "Medium", "Minor"})
    public void setUpTestData() {
        testDataSuccess = (HashMap) data.get("testDataSuccess");
        addProductSuccess = (HashMap) data.get("addProductSuccess");

        validEmail = testDataSuccess.get("email").toString();
        validPass = testDataSuccess.get("pass").toString();

        validProductName = addProductSuccess.get("productName").toString();
    }

    @Test(groups = {"Major"})
    public void ManufacturingFeature() {
        logger.info("Access Manufacturing Page");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginByEmail(validEmail, validPass);

        HomePage homePage = new HomePage(driver);
        homePage.waitUtilListBoxExisted();
        homePage.clickManufacturing();

        ManufacturingPage manufacturingPage = new ManufacturingPage(driver);
        manufacturingPage.waitUtilManufactureExisted();
        Assert.assertEquals(manufacturingPage.getManufacturingPageName(),TestConstants.MANUFACTURING_NAME_PAGE);
        manufacturingPage.clickManufacturingCreate();
        Assert.assertEquals(manufacturingPage.getManufacturingCreateScreen(),TestConstants.MANUFACTURING_CREATE_PAGE);

        manufacturingPage.clickManufacturingProduct();
        manufacturingPage.inputProductManufacturingSearch(validProductName);
        manufacturingPage.waitUtilManufactureProductExisted();
        manufacturingPage.clickManufacturingSave();
        Assert.assertEquals(manufacturingPage.getManufacturingProductName(),TestConstants.MANUFACTURING_PRODUCT_ADDED);
    }
}
