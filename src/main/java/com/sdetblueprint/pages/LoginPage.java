package com.sdetblueprint.pages;

import com.sdetblueprint.base.BasePage;
import com.sdetblueprint.utils.PropertyReader;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.fail;

public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(ChromeDriver driver){
        super(driver );
        this.driver = driver;
    }
    // Page Locators

    By username = By.className("c-topaccount__label" );
    By inscription = By.className("c-register__link");
    By gender = By.id("dwfrm_profile_customer_civility_customer1");
    By prenom = By.name("dwfrm_profile_customer_firstname");
    By nom = By.name("dwfrm_profile_customer_lastname" );
    By dateNaiss = By.name("dwfrm_profile_customer_birthdate" );
    By email = By.name("dwfrm_profile_customer_email");

    // Page Actions

    public void openVwo(){
        driver.get("https://www.ysl.com/fr-fr");
    }

    public void LoginWithValidCreds() throws Exception {
        try {
            driver.findElement(username).click();
        }catch (Exception e){
            fail("element seconnecter non trouvé");
        }

        try {
            driver.findElement(inscription).click();
        }catch (Exception e){
            fail("element inscription non trouvé");
        }


        try {
            driver.findElement(prenom).sendKeys(PropertyReader.readItem("username"));
        }catch (Exception e){
            fail("element prenom non trouvé");
        }

        try {
            driver.findElement(nom).sendKeys("BELL");
        }catch (Exception e){
            fail("element nom non trouvé");
        }

        try {
            driver.findElement(dateNaiss).sendKeys(PropertyReader.readItem("dateNaiss"));
        }catch (Exception e){
            fail("element date de naissance non trouvé");
        }

        try {
            driver.findElement(email).sendKeys(PropertyReader.readItem("email"));
        }catch (Exception e){
            fail( "element email non trouvé");
        }

        try {
            driver.findElement(gender).click();
        }catch (Exception e){
            fail("element genre non trouvé");
        }
        Thread.sleep(5* 1000);
       // driver.findElement(username).click();
       // driver.findElement(username).sendKeys(PropertyReader.readItem("username"));
       // driver.findElement(password).sendKeys(PropertyReader.readItem("password"));
       // driver.findElement(signButton).click();
    }



    public DashboardPage afterLogin(){
        return new DashboardPage((ChromeDriver) driver);
    }
    @Attachment(value = "Screenshot", type = "image/png")
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
//Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
        File DestFile=new File(fileWithPath);
//Copy file at destination
        //FileUtils.copyFile(SrcFile, DestFile);
    }

}
