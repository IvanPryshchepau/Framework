package com.epam.framework.runner;

import com.epam.framework.driver.FactoryDriver;
import com.epam.framework.page.InboxPage;
import com.epam.framework.property.PropertyProvider;
import com.epam.framework.step.InboxPageSteps;
import com.epam.framework.step.LoginPageSteps;
import org.openqa.selenium.WebDriver;

/**
 * Created by ivanpryshchepau on 7/27/16.
 */
public class Main {

    public static void main(String[] args) {
        WebDriver driver = FactoryDriver.getInstance();
        LoginPageSteps loginPageSteps = new LoginPageSteps(driver);
        loginPageSteps.openHomePage();
        InboxPage inboxPage = loginPageSteps.logIn(1);
        inboxPage.goToSettings();
    }

    public void firstTest(){
        WebDriver driver = FactoryDriver.getInstance();
        LoginPageSteps loginPageSteps = new LoginPageSteps(driver);
        loginPageSteps.openHomePage();
        InboxPage inboxPage = loginPageSteps.logIn(1);
        InboxPageSteps inboxPageSteps = new InboxPageSteps(driver);

        inboxPageSteps.sendMessage(inboxPage,
                PropertyProvider.getProperty("loginSecondUser") + "@gmail.com", "Test", "Test");

        inboxPageSteps.logOut(inboxPage);
        loginPageSteps.changeAccount();
        loginPageSteps.logIn(2);

        inboxPageSteps.moveMessageToSpam(inboxPage);

        inboxPageSteps.logOut(inboxPage);
        loginPageSteps.exitChooseAccount();
        loginPageSteps.logIn(1);

        inboxPageSteps.sendMessage(inboxPage,
                PropertyProvider.getProperty("loginSecondUser") + "@gmail.com",
                "Test1", "Test1");

        inboxPageSteps.logOut(inboxPage);
        loginPageSteps.exitChooseAccount();
        loginPageSteps.logIn(2);

        inboxPageSteps.checkSpam(inboxPage, "Test1");
    }
}
