package RefactorMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethod {
    WebDriver driver;

    public FrameMethod(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame(String frame){
        driver.switchTo().frame(frame);
    }

    public void switchToFrame(WebElement element){
        driver.switchTo().frame(element);
    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }
}
