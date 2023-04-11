import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageOblects.MainPage;

import java.time.Duration;

public class BaseTest {
    WebDriver webDriver;
    MainPage mainPage;
    private final String base_URL = "https://litecart.stqa.ru/en/";

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
        mainPage = new MainPage(webDriver);
    }

    @BeforeMethod
    public void beforeMethod() {
        webDriver.manage().deleteAllCookies();
        webDriver.get(base_URL);
    }

    @AfterTest
    public void afterTest() {
        webDriver.quit();
    }
}