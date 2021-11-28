package com.aspireapp.aspiretest;

import com.aspireapp.aspiretest.common.Constants;
import com.aspireapp.aspiretest.utils.ConvertUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Map;

public class BaseTest {
    private static final Logger logger = Logger.getLogger(BaseTest.class);
    protected static Map<Object, Object> data;
    protected WebDriver driver;

    @BeforeSuite(groups = {"Major", "Medium", "Minor"})
    public void setupTestData() {
        logger.info("Initializing Staging env");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver96");
        data = ConvertUtil.convertJsonFileToMap(Constants.STAGE_TEST_DATA_NAME);
    }

    @BeforeMethod(alwaysRun = true)
    public void accessPage() {
        driver = new ChromeDriver();
        driver.get("https://aspireapp.odoo.com/web/login");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Fail to wait for page load.");
        }
    }

    @AfterMethod(groups = {"Major", "Medium", "Minor"})
    public void afterFinishTest() {
        driver.quit();
    }
}