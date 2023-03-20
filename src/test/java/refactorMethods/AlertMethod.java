package refactorMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

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
