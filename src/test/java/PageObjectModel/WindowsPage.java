package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WindowsPage extends BasePage{

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".nav-stacked>li>a")
    public List<WebElement> windowTypes;
    @FindBy(css = "#Tabbed button")
    public WebElement tabOK;
    @FindBy(css = "#Seperate button")
    public WebElement windowOK;
    @FindBy(css = "#Multiple button")
    public WebElement windowsOK;

    public void openNewTab(Integer index){
        windowTypes.get(index).click();
        elementMethod.clickElement(tabOK);
        windowMethod.switchToSpecificWindow(index + 1);
        System.out.println(driver.getTitle());
        windowMethod.closeWindow();
        windowMethod.switchToSpecificWindow(index);
    }
    public void openSeparateWindow(Integer index){
        windowTypes.get(index).click();
        elementMethod.clickElement(windowOK);
        windowMethod.switchToSpecificWindow(index);
        System.out.println(driver.getTitle());
        windowMethod.closeWindow();
        windowMethod.switchToSpecificWindow(index - 1);
    }
    public void openMultipleWindows(Integer index){
        windowTypes.get(index).click();
        elementMethod.clickElement(windowsOK);
        windowMethod.switchToSpecificWindow(index);
        System.out.println(driver.getTitle());
        windowMethod.closeWindow();
        windowMethod.switchToSpecificWindow(index - 1);
        System.out.println(driver.getTitle());
        windowMethod.closeWindow();
        windowMethod.switchToSpecificWindow(index - 2);
    }

}
