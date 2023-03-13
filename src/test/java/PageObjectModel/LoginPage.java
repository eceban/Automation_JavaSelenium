package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[placeholder='E mail']")
    public WebElement emailEl;

    @FindBy(xpath = "//input[@placeholder=\"Password\"]")
    public WebElement passEl;

    @FindBy(id = "enterbtn")
    public WebElement submitBtn;

    @FindBy(id = "errormsg")
    public WebElement errorMessageEl;

    public void invalidLogging(String email, String password, String expectedMessage){
        elementMethod.fillInputElement(emailEl, email);
        elementMethod.fillInputElement(passEl, password);
        elementMethod.clickElement(submitBtn);
        elementMethod.validateElementMessage(errorMessageEl, expectedMessage);
    }

}
