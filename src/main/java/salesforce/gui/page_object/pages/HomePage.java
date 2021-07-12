package salesforce.gui.page_object.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

public class HomePage {

    WebDriver driver;

    @FindBy(css = ".hasActions .title")
    WebElement labelObjectManager;

    @FindBy(css = "css=div[title=\"Delete\"]")
    WebElement deleteIndividualButton;

    @FindBy(css = "button[title=\"Delete\"] span")
    WebElement confirmDeleteIndividualButton;

    public HomePage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public boolean labelObjectManageriIsVisible() {
        return labelObjectManager.isDisplayed();
    }

    public HomePage deleteCreatedIndividual() {
        deleteIndividualButton.click();
        confirmDeleteIndividualButton.click();
        return new HomePage(driver);
    }
}
