package com.epam.framework.step;

import com.epam.framework.page.InboxPage;
import com.epam.framework.page.LoginPage;
import com.epam.framework.page.PasswordPage;
import com.epam.framework.property.PropertyProvider;
import org.openqa.selenium.WebDriver;

/**
 * Created by ivanpryshchepau on 7/27/16.
 */
public class LoginPageSteps {

    private WebDriver driver;

    private String URL;

    public LoginPageSteps(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageSteps openHomePage() {
        URL = PropertyProvider.getProperty("url");
        driver.navigate().to(URL);
        return this;
    }

    public InboxPage logIn(int user){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUser(user);
        loginPage.submitLogin();
        PasswordPage passwordPage = new PasswordPage(driver);
        passwordPage.enterPassword(user);
        passwordPage.submitPassword();
        return new InboxPage(driver);
    }

    public LoginPage changeAccount(){
        PasswordPage passwordPage = new PasswordPage(driver);
        passwordPage.changeAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.addAccount();
        return new LoginPage(driver);
    }

    public LoginPage exitChooseAccount(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.addAccount();
        return new LoginPage(driver);
    }



}
