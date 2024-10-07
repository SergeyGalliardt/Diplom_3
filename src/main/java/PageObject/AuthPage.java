package PageObject;

import UserData.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static PageObject.PageObjectConstants.*;
import static UserData.Constants.AUTH_PAGE;

public class AuthPage {
    private final WebDriver webDriver;

    public AuthPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открытие страницы авторизации")
    public void openAuthPage() {
        webDriver.get(AUTH_PAGE);
    }

    @Step("Заполнение данных для входа. Клик по кнопке Войти")
    public void loginInput(User user) {
        webDriver.findElement(PasswordField2).sendKeys(user.getEmail());
        webDriver.findElement(EmailField2).sendKeys(user.getPassword());
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(AuthButton3));
        webDriver.findElement(AuthButton3).click();
    }
}
