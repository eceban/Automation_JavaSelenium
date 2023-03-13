package RefactorMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AlertMethod {
    WebDriver driver;
    public AlertMethod(WebDriver driver) {
        this.driver = driver;
    }


    public void accept(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void cancel(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void acceptText(String value){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
        alert.accept();
    }

}
