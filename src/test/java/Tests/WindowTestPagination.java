package Tests;

import RefactorMethods.ElementMethod;
import RefactorMethods.PageMethod;
import RefactorMethods.WindowMethod;
import TestNGAnnotations.BeforeAfter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowTestPagination extends BeforeAfter {

    @Test
    public void methodTest(){

        PageMethod pageMethod = new PageMethod(driver);
        ElementMethod elementMethod = new ElementMethod(driver);
        WindowMethod windowMethod = new WindowMethod(driver);

        // facem click pe butonul [Skip Sign In] ca sa omitem pagina de logare
        WebElement skipSignIn = driver.findElement(By.id("btn2"));
        skipSignIn.click();

        // verificam dupa titlu ca pagina 'Register' s-a incarcat
        String expectedPageTitle1 = "Register";
        pageMethod.validatePageTitle(expectedPageTitle1);

        // accesam optiunea Windows din submeniul SwitchTo
        WebElement switchToDropdown = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        /*
        Actions actiuni = new Actions(driver);
        actiuni.moveToElement(switchToDropdown).perform();
        */
        elementMethod.switchToElement(switchToDropdown);

        WebElement windowsOption = driver.findElement(By.xpath("//a[text()='Windows']"));
        windowsOption.click();
        /*
        driver.navigate().to("https://demo.automationtesting.in/Windows.html");
        */
        pageMethod.switchToURL("https://demo.automationtesting.in/Windows.html");

        // verificam dupa titlu ca pagina 'Frames & windows' s-a incarcat
        String expectedPageTitle2 = "Frames & windows";
        pageMethod.validatePageTitle(expectedPageTitle2);

        // 1:OPTION - selectam prima optiune din meniul de categorii de windows
        List<WebElement> windowTypes = driver.findElements(By.cssSelector(".nav-stacked>li>a"));
        windowTypes.get(0).click();

        // submit pe butonul 'click'
        WebElement clickNewTab = driver.findElement(By.cssSelector("#Tabbed button"));
        clickNewTab.click();
        System.out.println(driver.getTitle());

        // deplasare la urmatorul tab nou care s-a deschis
        /*
        ArrayList<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));
        System.out.println(driver.getTitle());
        driver.close();
        */
        windowMethod.switchToSpecificWindow(1);
        windowMethod.closeWindow();

        // revenim la tabul initial
        /* driver.switchTo().window(tabList.get(0)); */
        windowMethod.switchToSpecificWindow(0);

        // 2:OPTION - selectam a doua optiune din meniul de categorii de windows
        windowTypes.get(1).click();
        WebElement clickNewWindow = driver.findElement(By.cssSelector("#Seperate button"));
        clickNewWindow.click();
        System.out.println(driver.getTitle());

        // deplasare la urmatoarea fereastra separata care s-a deschis
        /*
        ArrayList<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        System.out.println(driver.getTitle());
        */
        windowMethod.switchToSpecificWindow(1);
        // inchidem fereastra curenta
        /* driver.close(); */
        windowMethod.closeWindow();

        // revenim la tabul initial
        /* driver.switchTo().window(tabList.get(0)); */
        windowMethod.switchToSpecificWindow(0);

        // 3:OPTION - selectam a treia optiune din meniul de categorii de windows
        windowTypes.get(2).click();
        WebElement clickMultipleTabs = driver.findElement(By.cssSelector("#Multiple button"));
        clickMultipleTabs.click();
        System.out.println(driver.getTitle());


        // deplasare la urmatoarele 2 taburi care s-au deschis
        /*
        ArrayList<String> tabsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(2));
        System.out.println(driver.getTitle());
        driver.close();
        */
        windowMethod.switchToSpecificWindow(2);
        windowMethod.closeWindow();

        // trecem inapoi la tabul 1
        /*
        driver.switchTo().window(tabsList.get(1));
        System.out.println(driver.getTitle());
        driver.close();
        */
        windowMethod.switchToSpecificWindow(1);
        windowMethod.closeWindow();

        // revenim la tabul initial
        /*
        driver.switchTo().window(tabList.get(0));
        System.out.println(driver.getTitle());
        */
        windowMethod.switchToSpecificWindow(0);

    }
}
