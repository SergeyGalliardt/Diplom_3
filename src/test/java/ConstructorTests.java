import PageObject.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static UserData.Constants.MAIN_PAGE;

public class ConstructorTests {

        private WebDriver driver;
        MainPage mainPage;

        @Before
        public void setUp() {
        driver = WebDriverFactory.createWebDriver();
        driver.get(MAIN_PAGE);

        mainPage = new MainPage(driver);
        }

        @Test
        @DisplayName("Переход к разделу «Булки»")
        public void transitionToBunsCheck() {
        mainPage.transitionToppingsClick();

        mainPage.transitionBunsClick();
        mainPage.bunsMenuIsVisibleCheck();
    }

        @Test
        @DisplayName("Переход к разделу «Соусы»")
        public void transitionToSaucesCheck() {
        mainPage.transitionToppingsClick();

        mainPage.transitionSaucesClick();
        mainPage.saucesMenuIsVisibleCheck();
    }

        @Test
        @DisplayName("Переход к разделу «Начинки»")
        public void transitionToToppingsCheck() {
        mainPage.transitionToppingsClick();
        mainPage.toppingsMenuIsVisibleCheck();
    }

        @After
        public void tearDown() {
        driver.quit();
    }
}