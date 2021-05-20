package DZ6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BaseView {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Вход")
    public WebElement buttonEntrance;

    @FindBy(name = "login")
    public WebElement inputLogin;

    @FindBy(name = "password")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@class='btn blueBtn']")
    public WebElement btnblueBtn;

    @FindBy(xpath = "//input[@name='Theme']")
    public WebElement buttonNewTheme;

    @FindBy(xpath = "//span[text()=\"Эйвори\"]")
    public WebElement buttonPersonalArea;
    public By buttonPersonalArealocator=By.xpath("//span[text()=\"Эйвори\"]");

    @FindBy(xpath ="//*[text()='Новая тема успешно добавлена на форум']")
    public WebElement successfully;

@Step("Нажать кнопку Вход")
    public MainPage submitEntrance() {
        buttonEntrance.click();
        return this;
    }

//    public MainPage fillInputLogin(String login) {
//        inputLogin.sendKeys(login);
//        return this;
//    }
@Step("Заполнить поле логина")
    public MainPage fillInputLogin(String login1) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("login")));
        inputLogin.sendKeys(login1);
        return this;
    }
    @Step("Заполнить поле пароля")
    public MainPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }
    @Step("Нажать кнопку авторизации")
    public MainPage submitLogin() {
        btnblueBtn.click();
        return this;
    }
    @Step("Нажать кнопку Новая тема")
    public NewThemePage clickNewTheme() {
        buttonNewTheme.click();
      return  new NewThemePage(driver);
    }



    public MainPage loginArea(String login, String password){
//        buttonEntrance.click();
//        inputLogin.sendKeys(login);
//        inputPassword.sendKeys(password);
//        btnblueBtn.click();
        submitEntrance();
        fillInputLogin(login);
        fillInputPassword(password);
        submitLogin();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new MainPage(driver)
                .buttonPersonalArealocator));
        return new MainPage(driver);
    }

}
//        Assertions.assertTrue(driver.findElement(By.xpath("//*[text()='Новая тема успешно добавлена на форум']")).isDisplayed());