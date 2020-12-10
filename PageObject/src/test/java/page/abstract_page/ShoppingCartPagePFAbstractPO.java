package page.abstract_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

import java.util.List;

public class ShoppingCartPagePFAbstractPO extends  AbstractPage{
    private static final String SHOPPING_CARD_HOMEPAGE_URL="https://www.dcrussia.ru/on/demandware.store/Sites-DC-RU-Site/ru_RU/Cart-Show";

    @FindBy(xpath="//button[@class='cart__button-remove-product btn-remove']")
    private List<WebElement> deleteGoodButtons;

    @FindBy(xpath="//input[@class='cart__button btn-secure-checkout button label-animated']")
    private List<WebElement> acceptOrderButton;

    public ShoppingCartPagePFAbstractPO(WebDriver driver){super(driver);}

    public ShoppingCartPagePFAbstractPO openPage()
    {
        driver.get(SHOPPING_CARD_HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }
    public ShoppingCartPagePFAbstractPO findAndClickDeleteButtons()
    {
        if (deleteGoodButtons != null && deleteGoodButtons.size() != 0) {
            for (WebElement el : deleteGoodButtons) {
                el.click();
            }
        }
        return this;
    }
    public boolean placingOrder()
    {
        try {


            if (acceptOrderButton.size()>0) {
                return false;
            }
        }
        catch (Exception ex){

            return true;
        }
        return true;
    }
}
