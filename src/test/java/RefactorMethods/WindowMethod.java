package RefactorMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class WindowMethod {
    public WebDriver driver;

    public WindowMethod(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToSpecificWindow(Integer index){
        ArrayList<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(index));
        System.out.println(driver.getTitle());
    }

    public void closeWindow(){
        driver.close();
    }
}
