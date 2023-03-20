package tests;

import pageObjectModel.IndexPage;
import pageObjectModel.RegisterPage;
import pageObjectModel.WindowsPage;
import testNGAnnotations.Hooks;
import org.testng.annotations.Test;

public class v2_WindowsTest extends Hooks {

    @Test
    public void methodTest(){

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickSkipSignIn();

        // switch to 'Windows' submenu tab
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.goToWindowsPage();

        WindowsPage windowsPage = new WindowsPage(driver);

        // open a new tab
        windowsPage.openNewTab(0);

        // open a separate window
        windowsPage.openSeparateWindow(1);

        // open several windows
        windowsPage.openMultipleWindows(2);

    }
}
