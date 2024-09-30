import PageObject.AuthPage;
import PageObject.MainPage;
import PageObject.RegistrationPage;
import PageObject.UserAccountPage;
import UserData.DataGenerate;
import UserData.User;
import UserData.UserActions;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static UserData.Constants.MAIN_PAGE;

public class PersonalAccountTests {
    private WebDriver driver;
    private final UserActions userActions = new UserActions();
    private final User user = DataGenerate.makeNewUser();

    MainPage mainPage;
    AuthPage authPage;
    RegistrationPage registrationPage;
    UserAccountPage userAccountPage;

    @Before
    public void setUp() {
        driver = WebDriverFactory.createWebDriver();
        driver.get(MAIN_PAGE);

        mainPage = new MainPage(driver);
        authPage = new AuthPage(driver);
        registrationPage = new RegistrationPage(driver);
        userAccountPage = new UserAccountPage(driver);

        userActions.userCreate(user);
        authPage.openAuthPage();
        authPage.loginInput(user);
    }

    @Test
    @DisplayName("Переход в личный кабинет по клику на «Личный кабинет»")
    public void transitionToAccountClickAccount() {
        mainPage.accountClick();
        Assert.assertTrue(userAccountPage.userMenuIsDisplayedCheck());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void transitionToConstructorClickConstructor() {
        mainPage.accountClick();
        userAccountPage.clickConstructorButton();
        Assert.assertTrue(mainPage.constructorIsDisplayedCheck());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void transitionToConstructorClickStellarBurgers() {
        mainPage.accountClick();
        userAccountPage.clickStellarBurgersLogo();
        Assert.assertTrue(mainPage.constructorIsDisplayedCheck());
    }

    @Test
    @DisplayName("Выход из аккаунта по кнопке «Выйти» в личном кабинете")
    public void logoutClickExit() {
        mainPage.accountClick();
        userAccountPage.logoutAccount();
        mainPage.openMainPage();
        Assert.assertTrue(mainPage.authButtonIsDisplayedCheck());
    }

    @After
    public void tearDown() {
        driver.quit();
        userActions
                .userDelete(userActions.getAccessToken(user));
    }
}