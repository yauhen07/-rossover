package crossovertests;

import core.WebDriverSingleton;
import org.testng.annotations.AfterClass;

public class BaseTest {

    @AfterClass
    public void cleanUp(){
        WebDriverSingleton.kill();
    }
}
