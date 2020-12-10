package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.abstract_page.ShoppingCartPagePFAbstractPO;
import page.abstract_page.loginWithEmailPagePFAbstractPO;

import java.util.List;

public class WebDriverSeleniumTest {

    private WebDriver driver;
    private boolean isPlacingAnOrderButtonAvailable=false;
    private boolean isMailValid=false;
    private String mail="maxim03nock@mail.ru";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver","C:/Drivers/chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    public void placingAnOrderWithAnEmptyShoppingCart() throws InterruptedException {

        isPlacingAnOrderButtonAvailable=new ShoppingCartPagePFAbstractPO(driver)
                .openPage()
                .findAndClickDeleteButtons()
                .placingOrder();

        Assert.assertTrue(isPlacingAnOrderButtonAvailable,"Button place order not missing!!!!!!!!!");
    }
    @Test
    public void inputWrongEmail() throws InterruptedException {
        isMailValid=new loginWithEmailPagePFAbstractPO(driver)
                .openPage()
                .inputMail(mail)
                .checkLabelErrMessage();


        Assert.assertTrue(isMailValid,"Mail is not valid");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown()
    {
        driver.quit();
        driver=null;
    }




}
