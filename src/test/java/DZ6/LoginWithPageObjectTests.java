package DZ6;

import DZ6.pages.MainPage;
import DZ6.pages.NewThemePage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static DZ6.pages.Configuration.BASE_URL;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Feature("Тестирование создания новой темы")
public class LoginWithPageObjectTests extends BaseTest {

    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL);
    }
    @Test
    void loginTest(){
        new MainPage(driver)
                .submitEntrance()
                .fillInputLogin("Эйвори")
                .fillInputPassword("280380")
                .submitLogin();
    }



    @Test
    void CreateNewTheme() throws InterruptedException {
        new MainPage(driver).loginArea("Эйвори","280380")

                .buttonNewTheme.click();
        new NewThemePage(driver).fillNameTheme("Тема")
                                .fillTextTheme("Новая тема")
                                .selectRubricTheme("Прочее")
                                .clickButtonCreateTheme();

        assertThat(new MainPage(driver).successfully.isDisplayed());
    }
}
