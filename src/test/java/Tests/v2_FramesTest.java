package Tests;

import PageObjectModel.FramesPage;
import PageObjectModel.IndexPage;
import PageObjectModel.RegisterPage;
import TestNGAnnotations.BeforeAfter;
import TestNGAnnotations.Hooks;
import org.testng.annotations.Test;

public class v2_FramesTest extends Hooks {

    @Test
    public void frameMethod(){

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickSkipSignIn();

        // switch to 'Frames' submenu tab
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.goToFramesPage();

        FramesPage framesPage = new FramesPage(driver);

        // open a single frame and fill in the input
        framesPage.switchToSingleFrame(0, propertiesFile.getValue("inputTextFrame1"));

        // open the nested frames and fill in the input
        framesPage.switchToMultipleFrames(1, propertiesFile.getValue("inputTextFrame2"));

    }
}
