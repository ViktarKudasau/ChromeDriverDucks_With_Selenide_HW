import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageOblects.MainPage;
import pageOblects.RubberDucksPage;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected String base_URL = "https://litecart.stqa.ru/en/";
    protected WebDriver webDriver;
    protected MainPage mainPage;
    protected RubberDucksPage rubberDucksPage;

    @BeforeClass
    public void beforeClass() {
        mainPage = new MainPage(webDriver);
        rubberDucksPage = new RubberDucksPage(webDriver);
    }

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
        WebDriverRunner.setWebDriver(webDriver);
    }

    @BeforeMethod
    public void beforeMethod() {
        webDriver.manage().deleteAllCookies();
        open(base_URL);
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Be Happy :) ");
        webDriver.quit();
    }
}
