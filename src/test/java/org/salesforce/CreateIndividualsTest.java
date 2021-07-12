/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.salesforce;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
public class CreateIndividualsTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        deleteCreatedIndividual();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    public void login() {
        driver.get("https://fundacion-jala4-dev-ed.my.salesforce.com/");
        driver.manage().window().setSize(new Dimension(976, 1040));
        driver.findElement(By.id("username")).sendKeys("scaspam@freeorg01.com");
        driver.findElement(By.id("password")).sendKeys("1234qwer");
        driver.findElement(By.id("Login")).click();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object obj = "Object Manager";
        assertEquals(driver.findElement(By.cssSelector(".hasActions .title")).getText(), obj);
    }

    public void individualForm() {
        driver.get("https://fundacion-jala4-dev-ed.lightning.force.com/lightning/o/Individual/new?count=1");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (vars.get("salutation") != null) {
            driver.findElement(By.cssSelector(".salutation a")).click();
            if (vars.get("salutation") .equals("Mr.")) {
                driver.findElement(By.cssSelector("[title=\"Mr.\"]")).click();
            }
            if ((Boolean) js.executeScript("return (arguments[0] === \'Ms.\')", vars.get("salutation"))) {
                driver.findElement(By.cssSelector("[title=\"Ms.\"]")).click();
            }
            if ((Boolean) js.executeScript("return (arguments[0] === \'Mrs.\')", vars.get("salutation"))) {
                driver.findElement(By.cssSelector("[title=\"Mrs.\"]")).click();
            }
            if ((Boolean) js.executeScript("return (arguments[0] === \'Dr.\')", vars.get("salutation"))) {
                driver.findElement(By.cssSelector("[title=\"Dr.\"]")).click();
            }
            if ((Boolean) js.executeScript("return (arguments[0] === \'Prof.\')", vars.get("salutation"))) {
                driver.findElement(By.cssSelector("[title=\""+ vars.get("salutaion")+ "\"]")).click();
            }
        }
        if (vars.get("firstname") != null) {
            driver.findElement(By.cssSelector(".firstName")).sendKeys(vars.get("firstname").toString());
        }
        if (vars.get("lastname") != null) {
            driver.findElement(By.cssSelector(".lastName")).sendKeys(vars.get("lastname").toString());
        }
        if (vars.get("date") != null) {
            driver.findElement(By.cssSelector("input[class=\' input\']")).sendKeys(vars.get("date").toString());
        }
        if (vars.get("dontProcess") != null) {
            driver.findElement(By.xpath("//div[label[contains(.,\"Process\")]]/input")).click();
        }
        if (vars.get("dontMarket") != null) {
            driver.findElement(By.xpath("//div[label[contains(.,\"Don\'t Market\")]]/input")).click();
        }
        if (vars.get("exportIndividualsData") != null) {
            driver.findElement(By.xpath("//div[label[contains(.,\"Export Individual\'s Data\")]]/input")).click();
        }
        if (vars.get("okToStorePiiData") != null) {
            driver.findElement(By.xpath("//div[label[contains(.,\"OK to Store PII Data Elsewhere\")]]/input")).click();
        }
        if (vars.get("blockGeolocationTracking") != null) {
            driver.findElement(By.xpath("//div[label[contains(.,\"Block Geolocation Tracking\")]]/input")).click();
        }
        if (vars.get("dontProfile") != null) {
            driver.findElement(By.xpath("//div[label[contains(.,\"Don\'t Profile\")]]/input")).click();
        }
        if (vars.get("dontTrack") != null) {
            driver.findElement(By.xpath("//div[label[contains(.,\"Don\'t Track\")]]/input")).click();
        }
        if (vars.get("forgetThisIndividual") != null) {
            driver.findElement(By.xpath("//div[label[contains(.,\"Forget this Individual\")]]/input")).click();
        }
        driver.findElement(By.xpath("//div[span[span[contains(text(),\'Age\')]]]/div//a")).click();
        if (vars.get("age") != null && vars.get("age").equals("13")) {
            driver.findElement(By.xpath("//a[contains(text(),\'13 or Older\')]")).click();
        } else if (vars.get("age") != null && vars.get("age").equals("16")) {
            driver.findElement(By.xpath("//a[contains(text(),\'16 or Older\')]")).click();
        }
        driver.findElement(By.cssSelector(".uiButton--brand > .label")).click();
    }
    public void deleteCreatedIndividual() {
        driver.findElement(By.cssSelector("div[title=\"Delete\"]")).click();
        driver.findElement(By.cssSelector("button[title=\"Delete\"] span")).click();
    }
    @Test
    public void createindividualwithdate() {
        login();
        vars.put("lastname", "Gonzales");
        vars.put("firstname", " Mario");
        vars.put("salutation", "Mr.");
        vars.put("date", "2/2/2000");
        vars.put("dontProcess", "yes");
        vars.put("dontMarket", "yes");
        vars.put("exportIndividualsData", "yes");
        vars.put("okToStorePiiData", "yes");
        vars.put("blockGeolocationTracking", "yes");
        vars.put("dontProfile", "yes");
        vars.put("dontTrack", "yes");
        vars.put("forgetThisIndividual", "yes");
        vars.put("age", "13");
        individualForm();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(driver.findElement(By.cssSelector(".slds-page-header__title > .uiOutputText")).getText(), "Mr. Mario Gonzales");
    }
}
