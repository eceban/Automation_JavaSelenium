package Tests;

import RefactorMethods.ElementMethod;
import RefactorMethods.PageMethod;
import TestNGAnnotations.BeforeAfter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class v1_RegisterTestDropDowns extends BeforeAfter {

    @Test
    public void registerMethod() {

        ElementMethod elementMethod = new ElementMethod(driver);
        PageMethod pageMethod = new PageMethod(driver);


        // facem click pe butonul [Skip Sign In]
        WebElement skipSignIn = driver.findElement(By.id("btn2"));
        /* skipSignIn.click(); */
        elementMethod.clickElement(skipSignIn);

        // verificam dupa titlu ca pagina corespunzatoare s-a incarcat
        String expectedPageTitle = "Register";
        pageMethod.validatePageTitle(expectedPageTitle);


        // completam campul "First Name"
        WebElement firstName = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstNameValue = "Eugenia";
        /* firstName.sendKeys(firstNameValue); */
        elementMethod.fillInputElement(firstName, firstNameValue);


        // completam campul "Last Name"
        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue = "Ceban";
        /* lastName.sendKeys(lastNameValue); */
        elementMethod.fillInputElement(lastName, lastNameValue);


        // completam campul "Address"
        WebElement addressElement = driver.findElement(By.xpath("//textarea"));
        String addressValue = "Chisinau, Stefan cel Mare 202";
        /* addressElement.sendKeys(addressValue); */
        elementMethod.fillInputElement(addressElement, addressValue);


        // completam campul "Email Address"
        WebElement emailElement = driver.findElement(By.cssSelector("input[ng-model='EmailAdress']"));
        String emailValue = "test@test.com";
        /* emailElement.sendKeys(emailValue); */
        elementMethod.fillInputElement(emailElement, emailValue);


        // completam campul "Phone"
        WebElement phoneElement = driver.findElement(By.cssSelector("input[ng-model='Phone']"));
        String phoneValue = "079111111";
        /* phoneElement.sendKeys(phoneValue); */
        elementMethod.fillInputElement(phoneElement, phoneValue);


        // bifam un hobby
        WebElement hobbyElement = driver.findElement(By.id("checkbox2"));
        /* hobbyElement.click(); */
        elementMethod.clickElement(hobbyElement);


        // selectam un skill
        WebElement skillsSelector = driver.findElement(By.id("Skills"));
        String skillsValue = "Java";
        /* new Select(skillsSelector).selectByVisibleText(skillsValue); */
        elementMethod.dropdownOptionText(skillsSelector, skillsValue);


        // selectam anul
        WebElement yearSelector = driver.findElement(By.id("yearbox"));
        String yearValue = "1998";
        /*
        Select yearSelect = new Select(yearSelector);
        yearSelect.selectByValue(yearValue);
         */
        elementMethod.dropdownOptionValue(yearSelector, yearValue);


        // selectam luna
        WebElement monthSelector = driver.findElement(By.cssSelector("select[placeholder='Month']"));
        String monthValue = "November";
        /*
        Select monthSelect = new Select(monthSelector);
        monthSelect.selectByVisibleText(monthValue);
         */
        elementMethod.dropdownOptionText(monthSelector, monthValue);


        // selectam ziua
        WebElement daySelector = driver.findElement(By.cssSelector("select[placeholder='Day']"));
        String dayValue = "2";
        /*
        Select daySelect = new Select(daySelector);
        daySelect.selectByValue(dayValue);
         */
        elementMethod.dropdownOptionValue(daySelector, dayValue);


        // lista languages unde pot fi selectate mai multe optiuni - trebuie identificata toata lista de optiuni
        WebElement languageSelectBox = driver.findElement(By.id("msdd"));
        /* languageSelectBox.click(); */
        elementMethod.clickElement(languageSelectBox);
        List <WebElement> languagesList = driver.findElements(By.cssSelector(".ui-autocomplete>li>a"));
        /*
        for (Integer index = 0; index < languagesList.size(); index++){
            if (languagesList.get(index).getText().equals("Italian")){
                languagesList.get(index).click();
                break;
            }
         */
        String languageOption1 = "Russian";
        String languageOption2 = "English";
        elementMethod.dropdownSeveralOptions(languagesList, languageOption1);
        elementMethod.dropdownSeveralOptions(languagesList, languageOption2);


        // trebuie de dat un click pe langa pentru a inchide drop-down Languages -> mergem pe Gender
        WebElement genderElement = driver.findElement(By.cssSelector("input[value='FeMale']"));
        /* genderElement.click(); */
        elementMethod.clickElement(genderElement);


        // select country - lista unde cauti si selectezi cu click si enter
        WebElement selectCountryElement = driver.findElement(By.cssSelector(".select2-selection--single"));
        /* selectCountryElement.click(); */
        elementMethod.clickElement(selectCountryElement);
        WebElement selectCountryAutocomplete = driver.findElement(By.cssSelector(".select2-search__field"));
        /* selectCountryAutocomplete.sendKeys("Denma"); */
        elementMethod.fillInputElement(selectCountryAutocomplete, "Denma");
        selectCountryAutocomplete.sendKeys(Keys.ENTER);


        // incarcam poza - sa fie input si sa fie type file!! a vrut path absolut; nu a mers cu Path from content root
        WebElement fileDownloadElement = driver.findElement(By.id("imagesrc"));
        /* fileDownloadElement.sendKeys("C:\\Users\\eceban\\IdeaProjects\\AutomationFramework\\src\\test\\resources\\image.jfif"); */
        elementMethod.fillInputElement(fileDownloadElement, "C:\\Users\\eceban\\IdeaProjects\\AutomationFramework\\src\\test\\resources\\avatar.png");


        // completam parola
        WebElement passElement = driver.findElement(By.id("firstpassword"));
        String passValue = "password1234";
        /* passElement.sendKeys(passValue); */
        elementMethod.fillInputElement(passElement, passValue);


        // confirmam parola
        WebElement passConfirmElement = driver.findElement(By.id("firstpassword"));
        String passConfirmValue = "password1234";
        /* passConfirmElement.sendKeys(passConfirmValue); */
        elementMethod.fillInputElement(passConfirmElement, passConfirmValue);


        // click pe butonul [Submit]
        WebElement submitElement = driver.findElement(By.id("submitbtn"));
        /* submitElement.click(); */
        elementMethod.clickElement(submitElement);

    }

}
