package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static PageObject.PageObjectConstants.*;
import java.time.Duration;

public class UserAccountPage {
    private final WebDriver webDriver;

    public UserAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    @Step("Личный кабинет. Проверка отображения меню пользователя")
    public boolean userMenuIsDisplayedCheck() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(ProfileText));
        return webDriver.findElement(ProfileText).isDisplayed();
    }

    @Step("Клик на Конструктор")
    public void clickConstructorButton() {
        webDriver.findElement(ConstructorButton).click();
    }

    @Step("Клик на логотип Stellar Burgers")
    public void clickStellarBurgersLogo() {
        webDriver.findElement(StellarBurgersLogo).click();
    }

    @Step("Выход из аккаунта по кнопке Выйти в личном кабинете")
    public void logoutAccount() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(LogoutButton));
        webDriver.findElement(LogoutButton).click();
    }
}
