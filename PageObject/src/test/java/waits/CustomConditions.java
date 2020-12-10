package waits;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CustomConditions {
    public static ExpectedCondition<Boolean> jQueryAJAXsCompleted(){
        return new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                return (Boolean)((JavascriptExecutor)driver).executeScript("return (window.jQuery != null) && (jQuery.active===0);");
            }
        };
    }
    public static List<WebElement> waitAllWebElementLocatedBy(WebDriver driver, By by)
    {
        return (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public static WebElement waitWebElementLocatedBy(WebDriver driver, By by)
    {
        return (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
