import PageObject.*;
import UserData.*;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


import static UserData.Constants.REG_PAGE;

public class RegistrationTests {
    private WebDriver driver;

    MainPage mainPage;
    AuthPage authPage;
    RegistrationPage registrationPage;
    UserAccountPage userAccountPage;

    private final UserActions userActions = new UserActions();
    private final User user = DataGenerate.makeNewUser();
    private final User userWithShortPassword = DataGenerate.makeUserWithShortPassword();
    private boolean userCreated = false;

    @Before
    public void setUp() {
        driver = WebDriverFactory.createWebDriver();
        driver.get(REG_PAGE);

        mainPage = new MainPage(driver);
        authPage = new AuthPage(driver);
        registrationPage = new RegistrationPage(driver);
        userAccountPage = new UserAccountPage(driver);

        registrationPage.openRegistrationPage();
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void userRegistrationOkCheck() {
        //Регистрация
        registrationPage.registrationInput(user);

        mainPage.openMainPage();
        Assert.assertTrue(mainPage.createOrderButtonIsDisplayedCheck());
        userCreated = true;
    }

    @Test
    @DisplayName("Проверка появления ошибки при вводе пароля менее 6 символов")
    public void registrationWithShortPasswordFailCheck() {
        registrationPage.registrationInput(userWithShortPassword);
        Assert.assertTrue(registrationPage.errorMessageCheck());
    }


   @After
   public void tearDown() {
       driver.quit();
       if (userCreated) {
           userActions
                   .userDelete(userActions.getAccessToken(user));
       }
   }

}