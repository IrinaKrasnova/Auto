package DZ3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resourses/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(5000);
        driver.close();
    }
}
