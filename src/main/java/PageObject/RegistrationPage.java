package PageObject;

import UserData.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static PageObject.PageObjectConstants.*;
import java.time.Duration;

import static UserData.Constants.REG_PAGE;

public class RegistrationPage {
    private final WebDriver webDriver;

    public RegistrationPage(WebDriver driver) {
        this.webDriver = driver;
    }

    @Step("Открытие страницы регистрации")
    public void openRegistrationPage() {
        webDriver.get(REG_PAGE);
    }

    @Step("Регистрация. Ввод данных. Клик по кнопке Зарегистрироваться")
    public void registrationInput(User user) {
        webDriver.findElement(NameField).sendKeys(user.getName());
        webDriver.findElement(EmailField).sendKeys(user.getEmail());
        webDriver.findElement(PasswordField).sendKeys(user.getPassword());
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(RegistrationButton));
        webDriver.findElement(RegistrationButton).click();
    }

    @Step("")
    public void loginRegistrationClick() {
        webDriver.findElement(AuthButton2).click();
    }

    @Step("Проверка отображения сообщения об ошибке")
    public boolean errorMessageCheck() {
        return webDriver.findElement(IncorrectPasswordMessage).isDisplayed();
    }
}
