package Tests;

import PageObjectModel.IndexPage;
import PageObjectModel.RegisterPage;
import PageObjectModel.WindowsPage;
import TestNGAnnotations.BeforeAfter;
import TestNGAnnotations.Hooks;
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
