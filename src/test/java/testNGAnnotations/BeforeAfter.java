package testNGAnnotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BeforeAfter {
    public WebDriver driver;

    public void setDriver() {

/*
        Boolean cicd = Boolean.parseBoolean(System.getProperty("cicd"));
        ChromeOptions options = new ChromeOptions();
        if (cicd){
            options.addArguments("--headless");
        }
*/
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

    public void closeDriver(){
        // driver.close() - inchide doar tabul curent
        // driver.quit() - inchide instanta de browser cu toate taburile
        driver.quit();
    }
}
