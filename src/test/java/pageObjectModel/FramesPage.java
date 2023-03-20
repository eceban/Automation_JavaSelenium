package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramesPage extends BasePage{

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".nav-tabs a")
    public List <WebElement> framesOptions;

    private String singleFrame = "SingleFrame";

    @FindBy(css = "input[type='text']")
    public WebElement inputField;


    public void switchToSingleFrame(Integer index, String inputMessage){
        framesOptions.get(index).click();
        frameMethod.switchToFrame(singleFrame);
        elementMethod.fillInputElement(inputField, inputMessage);
        frameMethod.switchToDefaultContent();
    }

    public void switchToMultipleFrames(Integer index, String inputMessage){
        framesOptions.get(index).click();
        frameMethod.switchToFrame(driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        frameMethod.switchToFrame(driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']")));
        elementMethod.fillInputElement(inputField, inputMessage);
    }

}
