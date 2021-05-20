package DZ3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DZ3Test {
    private static WebDriver driver;
    private static  WebDriverWait webDriverWait;
    private static final String LOGIN_PAGE_URL = "https://www.nn.ru/community/pokupka/glavpristroi/";

    //    public static void main(String[] args) throws InterruptedException {
    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void  setUpBrouser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        driver.get(LOGIN_PAGE_URL);
        webDriverWait = new WebDriverWait(driver, 5);
        login();
    }

    @Test
     void createNewTheme() {

        driver.findElement(By.xpath("//span[text()='Новая тема']")).click();
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        driver.findElement(By.xpath("//input[@name='Theme']")).sendKeys("Новая тема");
        driver.findElement(By.xpath("//textarea")).sendKeys("Новая тема");
        Select expenceSelect = new Select(driver.findElement(By.xpath("//select[@name='Filter']")));
        expenceSelect.selectByVisibleText("Прочее");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[text()='Новая тема успешно добавлена на форум']")).isDisplayed());
    }


    @Test
    void answerInRaz() throws InterruptedException {
        driver.findElement(By.xpath("//span[@class='shopping-ico']")).click();
//        Thread.sleep(3000);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@pur='9068396']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("fedsp-messenger")));
        js.executeScript("document.getElementById('fedsp-messenger').remove()");
        driver.findElement(By.xpath("//a[@pur='9068396']")).click();
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        driver.findElement(By.xpath("//button[@class=\"fedsp table-open-but\"]")).click();
        driver.findElement(By.xpath("//textarea[@id=\"paycomment\"]")).sendKeys("Ответ");
        driver.findElement(By.xpath("//div[@class='control-group' and count(following-sibling::div) > 1]//input[@class='btn asbut']")).click();
//        Assertions.assertTrue(driver.findElement(By.xpath("//form//div[@class='ucom']")).getText().contains("«Ответ»"));
        String answer = String.valueOf(new Random().nextInt(100));
        driver.findElement(By.xpath("//textarea[@id=\"paycomment\"]")).sendKeys(answer);
        driver.findElement(By.xpath("//div[@class='control-group' and count(following-sibling::div) > 1]//input[@class='btn asbut']")).click();
//        WebElement a=driver.findElement(By.xpath("//form //div[@class=\"ucom\"]"));
        webDriverWait.until(driver -> driver.findElement(By.xpath("//form//div[@class='ucom']")).getText().contains(answer));
        Assertions.assertTrue(driver.findElement(By.xpath("//form//div[@class='ucom']")).getText().contains(answer));
        //        WebElement a=driver.findElement(By.xpath("//form //div[@class=\"ucom\"]"));
//
//        Assertions.assertEquals(driver.findElement(By.xpath("//form //div[@class=\"ucom\"]")).getText(),"Ответ");
    }

       @Test
               void addToFavourites() throws InterruptedException {
            driver.findElement(By.xpath("//a[@class='select-button more-ico']")).click();
           JavascriptExecutor js = (JavascriptExecutor) driver;
           webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("fedsp-messenger")));
           js.executeScript("document.getElementById('fedsp-messenger').remove()");
            driver.findElement(By.xpath("//div[@class='forumsList-cont']//a[text()='Совместная покупка: мама и малыш']")).click();
            List<String> windows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windows.get(1));
            driver.findElement(By.xpath("//div[@class='heading-cont']//*[contains(text(),'Сбор-100 до 11.05')]")).click();
            driver.findElement(By.xpath("//div[@class='forumsList-cont']//a[text()='Совместная покупка: мама и малыш']")).click();
            windows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windows.get(2));
            driver.findElement(By.xpath("//span[@class='link-wrap']")).click();
            Alert alert = driver.switchTo().alert();
            alert.accept();
            driver.findElement(By.xpath("//span[text()=\"Эйвори\"]")).click();
            windows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windows.get(3));
            driver.findElement(By.xpath("//div[text()=\"Мне нравится \"]")).click();
            windows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windows.get(4));
            Assertions.assertTrue(driver.findElement(By.xpath("//a[@class='ilike_them_forum_name']//*[contains(text(),'Сбор-100 до 11.05')]")).isDisplayed());

        }



    private static void login() {
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.linkText("Вход")).click();
        driver.findElement(By.name("login")).sendKeys("Эйвори");
        driver.findElement(By.name("password")).sendKeys("280380");
        driver.findElement(By.xpath("//input[@class=\"btn blueBtn\"]")).click();
    }


    @AfterEach
     void closeBrouser() {
        driver.quit();
    }
}