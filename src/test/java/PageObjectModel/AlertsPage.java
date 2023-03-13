package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AlertsPage extends BasePage{

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".nav-stacked>li>a")
    public List<WebElement> alertOptions;

    @FindBy(css = "#OKTab>button")
    public WebElement ok;

    @FindBy(css = "#CancelTab>button")
    public WebElement cancel;

    @FindBy(css = "#CancelTab>#demo")
    public WebElement cancelledAlertMessage;

    @FindBy(css = "#Textbox>button")
    public WebElement textBoxAccept;

    @FindBy(css = "#Textbox>#demo1")
    public WebElement acceptedAlertMessage;


    public void alertAccept(Integer index){
        alertOptions.get(index).click();
        elementMethod.clickElement(ok);
        alertMethod.accept();
    }

    public void alertCancel(Integer index, String expectedMessage){
        alertOptions.get(index).click();
        elementMethod.clickElement(cancel);
        alertMethod.cancel();
        elementMethod.validateElementMessage(cancelledAlertMessage, expectedMessage);
    }

    public void alertTextBoxAccept(Integer index, String value, String expectedMessage1, String expectedMessage2){
        alertOptions.get(index).click();
        elementMethod.clickElement(textBoxAccept);
        alertMethod.acceptText(value);
        elementMethod.validateElementMessage(acceptedAlertMessage, expectedMessage1 + value + expectedMessage2);
    }

}
