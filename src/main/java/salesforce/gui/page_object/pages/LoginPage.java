/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.gui.page_object.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(css = ".username")
    WebElement usernameTextbox;

    @FindBy(css = ".password")
    WebElement passwordTextbox;

    @FindBy(id = "Login")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsernameTextbox(String username) {
        usernameTextbox.sendKeys(username);
    }

    public void setPasswordTextbox(String password) {
        passwordTextbox.sendKeys(password);
    }

    public HomePage login() {
        loginButton.click();
        return new HomePage(driver);
    }
}
