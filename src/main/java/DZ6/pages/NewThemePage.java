package DZ6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewThemePage extends BaseView{
    public NewThemePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//textarea")
    public WebElement fillNameTheme;

    @FindBy(xpath = "//textarea")
    public WebElement squareNameTheme;

    @FindBy(xpath = "//select[@name='Filter']")
    public WebElement selectNameTheme;

    @FindBy(xpath ="//input[@type='submit']")
    public WebElement buttonCreateTheme;

    @Step("Ввести название темы")
    public NewThemePage fillNameTheme(String nametheme) {
        fillNameTheme.sendKeys(nametheme);
        return this;
    }

    @Step("Ввести текст ")
    public NewThemePage fillTextTheme(String textTheme) {
        squareNameTheme.sendKeys(textTheme);
        return this;
    }

    @Step("Выбрать рубрику темы")
    public NewThemePage selectRubricTheme(String rubric){
        new  Select(selectNameTheme).selectByVisibleText(rubric);
        return this;
     }

    @Step("Нажать кнопку Создать тему")
    public MainPage clickButtonCreateTheme(){
        buttonCreateTheme.click();
        return new MainPage(driver);
     }


}
