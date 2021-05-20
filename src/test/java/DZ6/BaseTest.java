package DZ6;

import DZ6.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    MainPage mainPage;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        mainPage = new MainPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.manage().logs().get(LogType.BROWSER).getAll().forEach(System.out::println);
        driver.quit();
    }
}