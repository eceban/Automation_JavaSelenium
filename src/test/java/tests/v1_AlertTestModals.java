package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testNGAnnotations.Hooks;

import java.util.List;

public class v1_AlertTestModals extends Hooks {

    @Test
    public void metodaTest(){

        // facem click pe butonul [Skip Sign In] ca sa omitem pagina de logare
        WebElement skipSignIn = driver.findElement(By.id("btn2"));
        skipSignIn.click();

        // identificam elementul dropdown "SwitchTo"
        WebElement switchToDropdown = driver.findElement(By.xpath("//a[text()='SwitchTo']"));

        // deplasare catre elementul identificat "SwitchTo"
        Actions actiuni = new Actions(driver);
        actiuni.moveToElement(switchToDropdown).perform();

        // identificam elementul optiune "Alerts" din submeniul dropdown-ului "SwitchTo"
        WebElement alertsOption = driver.findElement(By.xpath("//a[text()='Alerts']"));
        alertsOption.click();

        // pentru a scapa de pop-up-ul de publicitate -> mergem direct catre pagina alerts
        driver.navigate().to("https://demo.automationtesting.in/Alerts.html");

        // identificam si selectam primul tip de alerta din lista de alerte
        List <WebElement> alertTypes = driver.findElements(By.cssSelector(".nav-stacked>li>a"));
        alertTypes.get(0).click();

        // click pe submit button
        WebElement submitButtonAlertOK = driver.findElement(By.cssSelector("#OKTab>button"));
        submitButtonAlertOK.click();

        // deplasare catre alerta si dam confirmare
        Alert alertOK = driver.switchTo().alert();
        alertOK.accept();

        // identificam si selectam al doilea tip de alerta din lista de alerte
        alertTypes.get(1).click();

        // click pe submit button
        WebElement submitButtonAlertOkCancel = driver.findElement(By.cssSelector("#CancelTab>button"));
        submitButtonAlertOkCancel.click();

        // deplasare catre alerta si dam cancel
        Alert alertOkCancel = driver.switchTo().alert();
        alertOkCancel.dismiss();

        // verificam mesajul afisat pentru actiunea cancel
        WebElement checkCanceledAlert = driver.findElement(By.cssSelector("#CancelTab>#demo"));
        String actualMessageCancelalert = checkCanceledAlert.getText();
        System.out.println(actualMessageCancelalert);
        String expectedMessageCancelalert = "You Pressed Cancel";
        Assert.assertEquals(actualMessageCancelalert, expectedMessageCancelalert, "Mesajul nu este corect");

        // identificam si selectam al treilea tip de alerta din lista de alerte
        alertTypes.get(2).click();

        // click pe submit button
        WebElement submitButtonAlertTextbox = driver.findElement(By.cssSelector("#Textbox>button"));
        submitButtonAlertTextbox.click();

        // deplasare catre alerta, completam campul si confirmam
        Alert alertTextbox = driver.switchTo().alert();
        String textBoxValue = "Eugenia";
        alertTextbox.sendKeys(textBoxValue);
        alertTextbox.accept();

        // verificam mesajul afisat pentru actiunea de alerta completata si confirmata
        WebElement checkTextboxAlert = driver.findElement(By.cssSelector("#Textbox>#demo1"));
        String actualMessageTextboxAlert = checkTextboxAlert.getText();
        System.out.println(actualMessageTextboxAlert);
        String expectedMessageTextboxAlert = "Hello " + textBoxValue + " How are you today";
        Assert.assertEquals(actualMessageTextboxAlert, expectedMessageTextboxAlert, "Mesajul nu este corect");

    }
}
