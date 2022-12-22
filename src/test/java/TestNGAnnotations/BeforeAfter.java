package TestNGAnnotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BeforeAfter {
    public WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        // setam driverul pentru browser chrome
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        // facem o instanta de chrome
        driver = new ChromeDriver();

        // accesam un anumit URL
        driver.get("https://demo.automationtesting.in/Index.html");

        // facem browser-ul in modul maximized
        driver.manage().window().maximize();

        // asteptam ca pagina sa fie incarcata
        // wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void closeDriver(){
        // driver.close() - inchide doar tabul curent
        // driver.quit() - inchide instanta de browser cu toate taburile
        // driver.quit();
    }
}
