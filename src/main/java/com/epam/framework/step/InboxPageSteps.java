package com.epam.framework.step;

import com.epam.framework.page.InboxPage;
import com.epam.framework.page.PasswordPage;
import org.openqa.selenium.*;

/**
 * Created by ivanpryshchepau on 7/27/16.
 */
public class InboxPageSteps {

    private WebDriver driver;

    public InboxPageSteps(WebDriver driver) {
        this.driver = driver;
    }

    public InboxPageSteps moveMessageToSpam(InboxPage inboxPage){
        inboxPage.markLetterSpam();
        return this;
    }

    public InboxPageSteps checkSpam(InboxPage inboxPage, String subject){
        inboxPage.goToSpam();
        inboxPage.checkLetter(subject);
        return this;
    }

    public LoginPageSteps logOut(InboxPage inboxPage){

        inboxPage.logOut();

        try{
            Alert alert = driver.switchTo().alert();
            alert.accept();
            inboxPage.logOut();
        } catch (NoAlertPresentException e) {

        } catch (NoSuchElementException e) {

        }
        return new LoginPageSteps(driver);
    }

    public InboxPageSteps sendMessage(InboxPage inboxPage, String to, String subject, String text){
        inboxPage.clickCompose();
        inboxPage.writeMessage(to, subject, text);
        inboxPage.clickSend();
        return this;
    }

}
