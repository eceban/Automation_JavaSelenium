package RefactorMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementMethod {
    public WebDriver driver;

    public ElementMethod(WebDriver driver){
        this.driver = driver;
    }

    // WAIT - 2 feluri de wait-uri sunt implicit si explicit
    // Wait implicit avem in clasa BeforeAfter
    // Wait explicit avem mai jos
    public void waitVisibleElement(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElement(WebElement element){
        waitVisibleElement(element);
        element.click();
    }

        public void fillInputElement(WebElement element, String value){
        waitVisibleElement(element);
        element.sendKeys(value);
    }

    public void dropdownOptionText(WebElement element, String value){
        waitVisibleElement(element);
        Select elementSelect = new Select(element);
        elementSelect.selectByVisibleText(value);
    }

    public void dropdownOptionValue(WebElement element, String value){
        waitVisibleElement(element);
        new Select(element).selectByValue(value);
    }

    public void dropdownSeveralOptions(List element, String value){
        List<WebElement> optionSelect = element;
        for (Integer index = 0; index < optionSelect.size(); index++) {
            if (optionSelect.get(index).getText().equals(value)) {
                optionSelect.get(index).click();
                break;
            }
        }
    }

    public void validateElementMessage(WebElement element, String expectedMessage){
        waitVisibleElement(element);
        String actualMessage = element.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Textul din alerta nu este corect");
    }

    public void switchToElement(WebElement element){
        waitVisibleElement(element);
        Actions actiuni = new Actions(driver);
        actiuni.moveToElement(element).perform();
    }

}
