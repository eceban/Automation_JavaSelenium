package TestNGAnnotations;

import DataDriven.PropertiesFile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends BeforeAfter{

    public PropertiesFile propertiesFile;

    @BeforeMethod
    public void prepareEnvironment(){
        setDriver();
        propertiesFile = new PropertiesFile();
    }

    @AfterMethod
    public void clearEnvironment(){
        closeDriver();
    }
}
