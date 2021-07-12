package config;

/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

import org.aeonbits.owner.Config;

/**
 * Represents an Owner Config class that retrieves the values of the defined property files.
 */
@Config.Sources({
        "classpath:general.properties"
})
public interface PropertiesConfig extends Config{

    @Config.Key("base_url")
    String base_url();

    @Config.Key("username")
    String username();

    @Config.Key("password")
    String password();

    @Config.Key("chrome_driver_path")
    String chrome_driver_path();
}