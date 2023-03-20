package tests;

import refactorMethods.ElementMethod;
import refactorMethods.FrameMethod;
import refactorMethods.PageMethod;
import testNGAnnotations.BeforeAfter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class v1_FramesTest extends BeforeAfter {

    @Test
    public void metodaTest(){

        PageMethod pageMethod = new PageMethod(driver);
        FrameMethod frameMethod = new FrameMethod(driver);
        ElementMethod elementMethod = new ElementMethod(driver);

        // facem click pe butonul [Skip Sign In] ca sa omitem pagina de logare
        WebElement skipSignIn = driver.findElement(By.id("btn2"));
        elementMethod.clickElement(skipSignIn);

        // din header in meniu identificam elementul dropdown "SwitchTo"
        WebElement switchToDropdown = driver.findElement(By.xpath("//a[text()='SwitchTo']"));

        // deplasare catre elementul identificat "SwitchTo"
        elementMethod.switchToElement(switchToDropdown);

        // identificam elementul optiune "Alerts" din submeniul dropdown-ului "SwitchTo"
        WebElement iframesOption = driver.findElement(By.xpath("//a[text()='Frames']"));
        elementMethod.clickElement(iframesOption);

        // pentru a scapa de pop-up-ul de publicitate -> mergem direct catre pagina frames
        pageMethod.switchToURL("https://demo.automationtesting.in/Frames.html");


        List<WebElement> buttons = driver.findElements(By.cssSelector(".nav-tabs a"));
        buttons.get(0).click();

        frameMethod.switchToFrame("SingleFrame");
        WebElement inputElement = driver.findElement(By.cssSelector("input[type='text']"));
        elementMethod.fillInputElement(inputElement, "Ana are mere");

        frameMethod.switchToDefaultContent();
        buttons.get(1).click();

        frameMethod.switchToFrame(driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        frameMethod.switchToFrame(driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']")));
        WebElement inputElement2 = driver.findElement(By.cssSelector("input[type='text']"));
        elementMethod.fillInputElement(inputElement2, "Ana are mere");

    }
}
