package Tests;

import DataDriven.PropertiesFile;
import PageObjectModel.IndexPage;
import PageObjectModel.LoginPage;
import TestNGAnnotations.BeforeAfter;
import TestNGAnnotations.Hooks;
import org.testng.annotations.Test;

public class v2_LoginTest extends Hooks {

    @Test
    public void loginMethod(){

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickSignIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.invalidLogging(
                propertiesFile.getValue("email"),
                propertiesFile.getValue("password"),
                propertiesFile.getValue("expectedMessageInvalidLogin")
                );

    }
}
