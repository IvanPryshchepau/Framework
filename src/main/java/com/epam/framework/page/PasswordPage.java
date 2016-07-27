package com.epam.framework.page;

import com.epam.framework.property.PropertyProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ivanpryshchepau on 7/26/16.
 */
public class PasswordPage {

    private WebDriver driver;

    private final String xpathPasswordField = "//input[@id = 'Passwd']";
    private final String xpathSubmitButton = "//input[@id = 'signIn']";
    private final String xpathChangeAccountButton = "//a[@id='account-chooser-link']";


    public PasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void enterPassword(int user) {
        String password = null;
        switch (user){
            case 1: {
                password = PropertyProvider.getProperty("passwordFirstUser");
                break;
            }
            case 2: {
                password = PropertyProvider.getProperty("passwordSecondUser");
                break;
            }
            case 3: {
                password = PropertyProvider.getProperty("passwordThirdUser");
                break;
            }
        }
        driver.findElement(By.xpath(xpathPasswordField)).sendKeys(password);
    }

    public void submitPassword(){
        driver.findElement(By.xpath(xpathSubmitButton)).click();
    }

    public void changeAccount(){
        driver.findElement(By.xpath(xpathChangeAccountButton)).click();
    }
}
