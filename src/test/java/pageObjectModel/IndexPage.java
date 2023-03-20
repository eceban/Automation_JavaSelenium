package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage{
    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "btn1")
    public WebElement signIn;

    @FindBy(id = "btn2")
    public WebElement skipSignIn;

    public void clickSignIn(){ elementMethod.clickElement(signIn);}

    public void clickSkipSignIn(){
        elementMethod.clickElement(skipSignIn);
    }

}
