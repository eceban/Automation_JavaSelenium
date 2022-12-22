package RefactorMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PageMethod {
    public WebDriver driver;

    public PageMethod(WebDriver driver) {
        this.driver = driver;
    }

    public void waitVisiblePage(String value){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.titleIs(value));
    }

    public void validatePageTitle(String value){
        waitVisiblePage(value);
        Assert.assertEquals(value, driver.getTitle());
    }

    public void switchToURL(String url){
        driver.navigate().to(url);
    }

}
