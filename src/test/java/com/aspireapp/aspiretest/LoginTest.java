package com.aspireapp.aspiretest;

import com.aspireapp.aspiretest.common.TestConstants;
import com.aspireapp.aspiretest.pages.HomePage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aspireapp.aspiretest.pages.LoginPage;

import java.util.HashMap;

public class LoginTest extends BaseTest {
    public static final Logger logger = Logger.getLogger(LoginTest.class);


    private HashMap testDataSuccess = new HashMap();
    private String validEmail = "";
    private String validPass = "";

    @BeforeTest(groups = {"Major","Medium", "Minor"})
    public void setUpTestData() {
        testDataSuccess = (HashMap) data.get("testDataSuccess");
        validEmail = testDataSuccess.get("email").toString();
        validPass = testDataSuccess.get("pass").toString();
    }

    @Test(groups = {"Major"})
    public void loginByEmail() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        logger.info("Access Login Page");
        Assert.assertEquals(TestConstants.LOGIN_PAGE_TITLE,loginPage.getPageTitle());
        loginPage.loginByEmail(validEmail,validPass);
        homePage.waitUtilListBoxExisted();
        logger.info("Access to Inventory page");
    }
}
