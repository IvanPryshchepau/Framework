package com.epam.framework.page;

import com.epam.framework.property.PropertyProvider;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ivanpryshchepau on 7/26/16.
 */
public class LoginPage {

    private WebDriver driver;

    private final String xpathFirstUser = "//button[@data-value=\"" +
            PropertyProvider.getProperty("loginFirstUser") + "@gmail.com\"]";
    private final String xpathSecondUser = "//button[@data-value=\"" +
            PropertyProvider.getProperty("loginSecondUser") + "@gmail.com\"]";
    private final String xpathThirdUser = "//button[@data-value=\"" +
            PropertyProvider.getProperty("loginThirdUser") + "@gmail.com\"]";
    private final String xpathLoginField = "//input[@id='Email']";
    private final String xpathSubmitButton = "//input[@id='next']";
    private final String xpathAddAccount = "//a[@id='account-chooser-add-account']";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickUser(int user){
        switch (user){
            case 1:{
                driver.findElement(By.xpath(xpathFirstUser)).click();
                break;
            }
            case 2:{
                driver.findElement(By.xpath(xpathSecondUser)).click();
                break;
            }
            case 3:{
                driver.findElement(By.xpath(xpathThirdUser)).click();
                break;
            }
        }
    }

    public void enterUser(int user){
        String login = null;
        switch (user){
            case 1: {
                login = PropertyProvider.getProperty("loginFirstUser");
                break;
            }
            case 2: {
                login = PropertyProvider.getProperty("loginSecondUser");
                break;
            }
            case 3: {
                login = PropertyProvider.getProperty("loginThirdUser");
                break;
            }
        }
        try{
            driver.findElement(By.xpath(xpathLoginField)).sendKeys(login);
        } catch (UnhandledAlertException e) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }

    }

    public void submitLogin(){
        driver.findElement(By.xpath(xpathSubmitButton)).click();
    }

    public void addAccount(){
        driver.findElement(By.xpath(xpathAddAccount)).click();
    }
}
