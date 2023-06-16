package com.sdetblueprint.pages;

import com.sdetblueprint.base.BasePage;
import com.sdetblueprint.utils.DataUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DashboardPage extends BasePage{

    WebDriver driver;

    public DashboardPage(ChromeDriver driver){
        super(driver );
        this.driver = driver;
    }

    By userName  = By.cssSelector("[data-qa='lufexuloga']");

    // Page Action
    public String loggedInUserName(){
        waitForElementToAppear(userName);
        return driver.findElement(userName).getText();
    }
}
