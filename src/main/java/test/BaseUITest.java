package test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseUITest {

    protected static WebDriver driver;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public BaseUITest(WebDriver driver) {
        this.driver = (ChromeDriver) driver;
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

