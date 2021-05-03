package DZ3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DZ3Test {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://www.nn.ru/community/pokupka/glavpristroi/";
    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//
//        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/main/resourses/chromedriver_win32/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        login();

        driver.findElement(By.xpath("//span[text()='Новая тема']")).click();
        driver.findElement(By.xpath("//input[@name='Theme']")).sendKeys("Новая тема");
        driver.findElement(By.xpath("//textarea")).sendKeys("Новая тема");
        Select expenceSelect = new Select(driver.findElement(By.xpath("//select[@name='Filter']")));
        expenceSelect.selectByVisibleText("Прочее");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//input[@type='submit']"));
        driver.findElement(By.xpath("//*[text()='Новая тема успешно добавлена на форум']"));


        Thread.sleep(3000);
        driver.quit();
    }
    private static void login() {
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.linkText("Вход")).click();
        driver.findElement(By.name("login")).sendKeys("Эйвори");
        driver.findElement(By.name("password")).sendKeys("280380");
        driver.findElement(By.xpath("//input[@class=\"btn blueBtn\"]")).click();
    }
}
