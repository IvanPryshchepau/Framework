package com.epam.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ivanpryshchepau on 7/26/16.
 */
public class InboxPage {

    private WebDriver driver;

    private final String xpathMessageToField = "//textarea[@name = 'to']";
    private final String xpathMessageSubjectField = "//input[@placeholder='Subject']";
    private final String xpathMessageTextField = "//div[@aria-label='Message Body']";
    private final String xpathMessage = "//table/colgroup/../tbody";
    private final String xpathReportSpam = "//div[@gh='mtb']//div[@act='9']";

    private final String xpathAccount = "//span[@class='gb_3a gbii']";
    private final String xpathLogOut = "//a[@class='gb_Fa gb_De gb_Le gb_rb']";

    private final String xpathCompose = "//div[@class='T-I J-J5-Ji T-I-KE L3']";
    private final String xpathSend = "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']";


    public InboxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickCompose() {
        driver.findElement(By.xpath(xpathCompose)).click();
    }

    public void writeMessage(String to, String subject, String text){
        driver.findElement(By.xpath(xpathMessageToField)).clear();
        driver.findElement(By.xpath(xpathMessageToField)).sendKeys(to);
        driver.findElement(By.xpath(xpathMessageSubjectField)).clear();
        driver.findElement(By.xpath(xpathMessageSubjectField)).sendKeys(subject);
        driver.findElement(By.xpath(xpathMessageTextField)).clear();
        driver.findElement(By.xpath(xpathMessageTextField)).sendKeys(text);
    }

    public void clickSend(){
        driver.findElement(By.xpath(xpathSend)).click();
    }

    public void markLetterSpam(){
        driver.findElement(By.xpath(xpathMessage)).click();
        driver.findElement(By.xpath(xpathReportSpam)).click();
    }

    public void goToSpam(){
        driver.navigate().to("https://mail.google.com/mail/#spam");
    }

    public void checkLetter(String subject){
        try {
            driver.findElement(By.xpath(xpathMessage + "//span[text()='" + subject + "']"));
        } catch (NoSuchElementException e){
            System.out.println("Test failed");
        }

    }

    public void logOut(){
        driver.findElement(By.xpath(xpathAccount)).click();
        driver.findElement(By.xpath(xpathLogOut)).click();
    }
}
