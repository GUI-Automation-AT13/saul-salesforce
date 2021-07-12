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

public class IndividualFormPage {

    WebDriver driver;

    @FindBy(css = ".salutation a")
    WebElement salutationSelector;

    @FindBy(xpath = "[title=\"Mr.\"]")
    WebElement mrOption;

    @FindBy(xpath = "[title=\"Ms.\"]")
    WebElement msOption;

    @FindBy(xpath = "[title=\"Mrs.\"]")
    WebElement mrsOption;

    @FindBy(xpath = "[title=\"Dr.\"]")
    WebElement drOption;

    @FindBy(xpath = "[title=\"Prof.\"]")
    WebElement profOption;

    @FindBy(css = ".firstName")
    WebElement firstnameTextbox;

    @FindBy(css = ".lastName")
    WebElement lastnameTextbox;

    @FindBy(css = "input[class=' input']")
    WebElement birthdateDateField;

    @FindBy(xpath = "//div[label[contains(.,\"Don't Process\")]]/input")
    WebElement dontProcessCheckbox;

    @FindBy(xpath = "//div[label[contains(.,\"Don't Market\")]]/input")
    WebElement dontMarketCheckbox;

    @FindBy(xpath = "//div[label[contains(.,\"Export Individual's Data\")]]/input")
    WebElement exportIndividualDataCheckbox;

    @FindBy(xpath = "//div[label[contains(.,\"OK to Store PII Data Elsewhere\")]]/input")
    WebElement okToStorePiiDataCheckbox;

    @FindBy(xpath = "//div[label[contains(.,\"Block Geolocation Tracking\")]]/input")
    WebElement blockGeolocationCheckbox;

    @FindBy(xpath = "//div[label[contains(.,\"Don't Profile\")]]/input")
    WebElement dontProfileCheckbox;

    @FindBy(xpath = "//div[label[contains(.,\"Don't Track\")]]/input")
    WebElement dontTrackCheckbox;

    @FindBy(xpath = "//div[label[contains(.,\"Forget this Individual\")]]/input")
    WebElement forgetThisIndividualCheckbox;

    @FindBy(xpath = "//div[span[span[contains(text(),'Age')]]]/div//a")
    WebElement individualAgeSelector;

    @FindBy(xpath = "//a[contains(text(),\'13 or Older\')]")
    WebElement age13Option;

    @FindBy(xpath = "//a[contains(text(),\'16 or Older\')]")
    WebElement age16Option;

    @FindBy(css = "button[title=\"Save\"]")
    WebElement saveButton;

    @FindBy(css = ".slds-page-header__title > .uiOutputText")
    WebElement createdIndividualLabel;

    public IndividualFormPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public void selectSalutation() {
        salutationSelector.click();
    }

    public void selectMrOption() {
        mrOption.click();
    }

    public void selectMrsOption() {
        mrsOption.click();
    }

    public void selectMsOption() {
        msOption.click();
    }

    public void selectDrOption() {
        drOption.click();
    }

    public void selectProfOption() {
        profOption.click();
    }

    public void setFirstnameTextbox(String firstname) {
        firstnameTextbox.sendKeys(firstname);
    }

    public void setLastnameTextbox(String lastname) {
        lastnameTextbox.sendKeys(lastname);
    }

    public void setBirthdateDateField(String date) {
        birthdateDateField.sendKeys(date);
    }

    public void checkDontProcessCheckbox() {
        dontProcessCheckbox.click();
    }

    public void checkDontMarketCheckbox() {
        dontMarketCheckbox.click();
    }

    public void checkExportIndividualDataCheckbox() {
        exportIndividualDataCheckbox.click();
    }

    public void checkOkToStorePiiDataCheckbox() {
        okToStorePiiDataCheckbox.click();
    }

    public void checkBlockGeolocationCheckbox() {
        blockGeolocationCheckbox.click();
    }

    public void checkDontProfileCheckbox() {
        dontProfileCheckbox.click();
    }

    public void checkDontTrackCheckbox() {
        dontTrackCheckbox.click();
    }

    public void checkForgetThisIndividualCheckbox() {
        forgetThisIndividualCheckbox.click();
    }

    public void selectIndividualAgeSelector() {
        individualAgeSelector.click();
    }

    public void selectAge13Option() {
        age13Option.click();
    }

    public void selectAge16Option() {
        age16Option.click();
    }

    public void save() {
        saveButton.click();
    }

    public Boolean createdIndividualLabelVisibility() {
        return createdIndividualLabel.isDisplayed();
    }
}
