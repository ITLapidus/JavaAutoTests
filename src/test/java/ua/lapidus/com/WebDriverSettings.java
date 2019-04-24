package ua.lapidus.com;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Logger;

public class WebDriverSettings {

    public static Logger log = Logger.getLogger(testProm.class.getName());
    public ChromeDriver chromeDriver;

    @Before
    public void setup() {
        final String pathToChromeDriver = "lib/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        chromeDriver = new ChromeDriver();
    }


    @After
    public void tearDown() {
        //chromeDriver.close();
    }
}