package test;

import driver.DriverSingleton;
import util.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
