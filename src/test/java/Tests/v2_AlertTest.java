package Tests;

import PageObjectModel.AlertsPage;
import PageObjectModel.IndexPage;
import PageObjectModel.RegisterPage;
import TestNGAnnotations.BeforeAfter;
import TestNGAnnotations.Hooks;
import org.testng.annotations.Test;

public class v2_AlertTest extends Hooks {

    @Test
    public void alertMethod(){

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickSkipSignIn();

        // switch to 'Alerts' submenu tab
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.goToAlertsPage();

        AlertsPage alertsPage = new AlertsPage(driver);

        // open the first type of alert and accept
        alertsPage.alertAccept(0);

        // open the second type of alert and cancel
        alertsPage.alertCancel(1, propertiesFile.getValue("expectedMessageCancelAlert"));

        // open the third type of alert, fill in the input and accept the alert
        alertsPage.alertTextBoxAccept(2, propertiesFile.getValue("inputTextAlert"),
                                              propertiesFile.getValue("expectedMessageTextAlert1"),
                                              propertiesFile.getValue("expectedMessageTextAlert2")
                                    );

    }
}
