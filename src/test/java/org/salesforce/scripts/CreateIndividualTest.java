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
import org.testng.Assert;
import org.testng.annotations.Test;
import salesforce.gui.page_object.pages.HomePage;
import salesforce.gui.page_object.pages.IndividualFormPage;
import salesforce.gui.page_object.pages.LoginPage;
import salesforce.gui.page_object.views.Views;

import java.util.Map;

public class CreateIndividualTest extends TestBase {

    private Map<String, Object> vars;
    private PropertiesConfig propertiesConfig;

    public void login() {
        propertiesConfig = ConfigManager.getConfiguration();
        HomePage homePage = new HomePage(driver);
        LoginPage loginpage = new LoginPage(driver);
        loginpage.setUsernameTextbox(propertiesConfig.username());
        loginpage.setPasswordTextbox(propertiesConfig.password());
        homePage = loginpage.login();
        Assert.assertTrue(homePage.labelObjectManageriIsVisible());
    }

    @Test
    public void createIndividualWithLastname() {
        login();
        driver.get(Views.CREATE_INDIVIDUAL.get());
        IndividualFormPage individualFormPage = new IndividualFormPage(driver);
        individualFormPage.setLastnameTextbox("Paul");
        individualFormPage.save();
        Assert.assertTrue(individualFormPage.createdIndividualLabelVisibility());
    }
}
