package salesforce.gui.page_object.views;

import config.ConfigManager;

/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

public enum Views {
    CREATE_INDIVIDUAL(String.format("%s%s", ConfigManager.getConfiguration().base_url(), "lightning/o/Individual/new?count=1")),
    INDIVIDUAL_RECENT_LIST(String.format("%s%s", ConfigManager.getConfiguration().base_url(), "lightning/o/Individual/list?filterName=Recent"));

    private String view;

    Views(final String view) {
        this.view = view;
    }

    public String get() {
        return view;
    }
}
