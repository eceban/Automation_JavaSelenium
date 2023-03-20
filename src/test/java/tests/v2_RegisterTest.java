package tests;

import pageObjectModel.IndexPage;
import pageObjectModel.RegisterPage;
import testNGAnnotations.Hooks;
import org.testng.annotations.Test;

import java.util.HashMap;

public class v2_RegisterTest extends Hooks {

    @Test
    public void registerMethod() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickSkipSignIn();

        HashMap<String, String> testData = propertiesFile.getAllData();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.invalidRegistration(testData);

    }

}
