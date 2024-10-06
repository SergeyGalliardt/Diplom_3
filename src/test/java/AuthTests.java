import PageObject.*;
import UserData.DataGenerate;
import UserData.User;
import UserData.UserActions;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


import static UserData.Constants.MAIN_PAGE;

public class AuthTests {
    private WebDriver driver;
    private final UserActions userActions = new UserActions();
    private final User user = DataGenerate.makeNewUser();

    MainPage mainPage;
    AuthPage authPage;
    RegistrationPage registrationPage;
    UserAccountPage userAccountPage;
    RecoverPage recoverPage;

    @Before
    public void setUp() {
        driver = WebDriverFactory.createWebDriver();
        driver.get(MAIN_PAGE);

        mainPage = new MainPage(driver);
        authPage = new AuthPage(driver);
        registrationPage = new RegistrationPage(driver);
        userAccountPage = new UserAccountPage(driver);
        recoverPage = new RecoverPage(driver);

        userActions.userCreate(user);

    }


    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void authMainPageAuthButtonCheck() {
        mainPage.loginClick();
        authPage.loginInput(user);
        mainPage.accountClick();
        Assert.assertTrue(userAccountPage.userMenuIsDisplayedCheck());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет» на главной")
    public void authMainAccountButtonCheck() {
        mainPage.accountClick();
        authPage.loginInput(user);
        mainPage.openMainPage();
        Assert.assertTrue(mainPage.createOrderButtonIsDisplayedCheck());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void authRegistrationPageCheck() {
        registrationPage.openRegistrationPage();
        registrationPage.loginRegistrationClick();

        authPage.loginInput(user);
        mainPage.accountClick();
        Assert.assertTrue(userAccountPage.userMenuIsDisplayedCheck());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void authRecoverPageCheck() {

        recoverPage.openRecoverPasswordPage();
        recoverPage.loginRecoverPage();
        authPage.loginInput(user);

        mainPage.accountClick();
        Assert.assertTrue(userAccountPage.userMenuIsDisplayedCheck());
    }

    @After
    public void tearDown() {
        driver.quit();
        userActions
                .userDelete(userActions.getAccessToken(user));
    }

}