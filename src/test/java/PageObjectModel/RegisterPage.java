package PageObjectModel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='SwitchTo']")
    public WebElement switchTo;
    @FindBy(xpath = "//a[text()='Alerts']")
    public WebElement alerts;
    public String urlAlerts = "https://demo.automationtesting.in/Alerts.html";
    @FindBy(xpath = "//a[text()='Windows']")
    public WebElement windows;
    public String urlWindows = "https://demo.automationtesting.in/Windows.html";
    @FindBy(xpath = "//a[text()='Frames']")
    public WebElement frames;
    public String urlFrames = "https://demo.automationtesting.in/Frames.html";


    @FindBy(css = "input[placeholder='First Name']")
    public WebElement firstNameEl;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastNameEl;
    @FindBy(xpath = "//textarea")
    public WebElement addressEl;
    @FindBy(css = "input[ng-model='EmailAdress']")
    public WebElement emailEl;
    @FindBy(css = "input[ng-model='Phone']")
    public WebElement phoneEl;
    @FindBy(id = "checkbox2")
    public WebElement hobbyEl;
    @FindBy(id = "Skills")
    public WebElement skillsEl;
    @FindBy(id = "yearbox")
    public WebElement yearEl;
    @FindBy(css = "select[placeholder='Month']")
    public WebElement monthEl;
    @FindBy(css = "select[placeholder='Day']")
    public WebElement dayEl;
    @FindBy(id = "msdd")
    public WebElement languageEl;
    @FindBy(css = ".ui-autocomplete>li>a")
    public List<WebElement> languagesListEl;
    @FindBy(css = "input[value='FeMale']")
    public WebElement genderEl;
    @FindBy(css = ".select2-selection--single")
    public WebElement countryEl;
    @FindBy(css = ".select2-search__field")
    public WebElement countryAutocompleteEl;
    @FindBy(id = "imagesrc")
    public WebElement fileEl;
    @FindBy(id = "firstpassword")
    public WebElement passEl;
    @FindBy(id = "secondpassword")
    public WebElement passConfirmEl;
    @FindBy(id = "submitbtn")
    public WebElement submitBtn;


    public void goToAlertsPage(){
        elementMethod.switchToElement(switchTo);
        elementMethod.clickElement(alerts);
        pageMethod.switchToURL(urlAlerts);
    }
    public void goToWindowsPage(){
        elementMethod.switchToElement(switchTo);
        elementMethod.clickElement(windows);
        pageMethod.switchToURL(urlWindows);
    }
    public void goToFramesPage(){
        elementMethod.switchToElement(switchTo);
        elementMethod.clickElement(frames);
        pageMethod.switchToURL(urlFrames);
    }


    public void invalidRegistration(HashMap<String,String> testData){
        elementMethod.fillInputElement(firstNameEl, testData.get("firstName"));
        elementMethod.fillInputElement(lastNameEl, testData.get("lastName"));
        elementMethod.fillInputElement(addressEl, testData.get("address"));
        elementMethod.fillInputElement(emailEl, testData.get("email"));
        elementMethod.fillInputElement(phoneEl, testData.get("phone"));
        elementMethod.clickElement(hobbyEl);
        elementMethod.dropdownOptionText(skillsEl, testData.get("skills"));
        elementMethod.dropdownOptionValue(yearEl, testData.get("year"));
        elementMethod.dropdownOptionText(monthEl, testData.get("month"));
        elementMethod.dropdownOptionValue(dayEl, testData.get("day"));
        elementMethod.clickElement(languageEl);
        elementMethod.dropdownSeveralOptions(languagesListEl, testData.get("language"));
        elementMethod.clickElement(genderEl);
        elementMethod.clickElement(countryEl);
        elementMethod.fillInputElement(countryAutocompleteEl, testData.get("country"));
        countryAutocompleteEl.sendKeys(Keys.ENTER);
        elementMethod.fillInputElement(fileEl, testData.get("url"));
        elementMethod.fillInputElement(passEl, testData.get("password"));
        elementMethod.fillInputElement(passConfirmEl, testData.get("password"));
        elementMethod.clickElement(submitBtn);
    }

}
