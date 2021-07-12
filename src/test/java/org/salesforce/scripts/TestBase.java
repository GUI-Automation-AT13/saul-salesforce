/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.salesforce.scripts;

import config.ConfigManager;
import config.PropertiesConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import salesforce.gui.page_object.pages.IndividualListPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    public void initializeWebDriver() throws IOException {
        PropertiesConfig propertiesConfig = ConfigManager.getConfiguration();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", propertiesConfig.chrome_driver_path());
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(propertiesConfig.base_url());
    }

    @AfterMethod
    public void deleteCreatedIndividual() {
        IndividualListPage individualListPage = new IndividualListPage(driver);
        individualListPage.deleteCreatedIndividual();
        Assert.assertTrue(individualListPage.recentlyViewedSpanVisible());
    }

    @AfterSuite
    public void quitDriver() {
        driver.quit();
    }
}