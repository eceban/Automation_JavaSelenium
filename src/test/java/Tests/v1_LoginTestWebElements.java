package Tests;

import RefactorMethods.ElementMethod;
import RefactorMethods.PageMethod;
import TestNGAnnotations.BeforeAfter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class v1_LoginTestWebElements extends BeforeAfter {

    @Test
    public void loginMethod(){

        PageMethod pageMethod = new PageMethod(driver);
        ElementMethod elementMethod = new ElementMethod(driver);

        // identificam un anumit element dupa ID
        WebElement signInelement = driver.findElement(By.id("btn1"));
        signInelement.click();


        // validam o noua pagina deschisa
        String expectedSignIn = "SignIn";
        /*
        String actualSignIn = driver.getTitle();
        Assert.assertEquals(actualSignIn, expectedSignIn);
         */
        pageMethod.validatePageTitle(expectedSignIn);


        // identificam un anumit element dupa CSS
        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue = "test@test.com";
        emailElement.sendKeys(emailValue);


        // identificam un anumit element dupa XPATH
        WebElement passwordElement = driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
        String passwordValue = "pass";
        passwordElement.sendKeys(passwordValue);

        WebElement enterButtonElement = driver.findElement(By.id("enterbtn"));
        enterButtonElement.click();


        // validam mesajul de alerta daca este prezent pe pagina
        WebElement errorAlertElement = driver.findElement(By.id("errormsg"));
        String expectedMessage = "Invalid User Name or PassWord";
        /*
        String actualMessage = errorAlertElement.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Textul din alerta nu este corect");
        */
        elementMethod.validateElementMessage(errorAlertElement, expectedMessage);

    }
}
