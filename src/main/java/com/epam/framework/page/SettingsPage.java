package com.epam.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ivanpryshchepau on 7/27/16.
 */
public class SettingsPage {

    private WebDriver driver;

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
