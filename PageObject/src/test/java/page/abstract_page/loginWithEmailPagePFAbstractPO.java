package page.abstract_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

public class loginWithEmailPagePFAbstractPO extends AbstractPage{
    private static final String LOGIN_WITH_EMAIL_PAGE_URL="https://www.dcrussia.ru/account/";

    @FindBy(xpath = "//*[@id='dwfrm_loyaltyinclude_email']")
    private WebElement loginInput;

    @FindBy(xpath = "//label[@id=\"id_email_status_dwfrm_loyaltyinclude_email\"]")
    private WebElement labelErrMessage;

    @FindBy(xpath="//*[@id=\"cboxClose\"]")
    private WebElement closeBox;

    public loginWithEmailPagePFAbstractPO(WebDriver driver){super(driver);}

    public loginWithEmailPagePFAbstractPO openPage()
    {
        driver.get(LOGIN_WITH_EMAIL_PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }
    public loginWithEmailPagePFAbstractPO inputMail(String mail) throws InterruptedException {
        closeBox.click();
        Thread.sleep(1000);
        loginInput.sendKeys(mail);
        return this;
    }
    public boolean checkLabelErrMessage() throws InterruptedException {
        Thread.sleep(500);
        CustomConditions.waitWebElementLocatedBy(driver, By.xpath("//label[@id=\"id_email_status_dwfrm_loyaltyinclude_email\"]"));

        if(!labelErrMessage.getText().equals("Пожалуйста, введите свой E-mail"))
            return true;
        else
            return false;
    }



}
