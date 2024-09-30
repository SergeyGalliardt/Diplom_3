package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static PageObject.PageObjectConstants.*;
import java.time.Duration;

import static UserData.Constants.*;

public class MainPage {
    private final WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открытие главной страницы")
    public void openMainPage() {
        webDriver.get(MAIN_PAGE);
    }

    @Step("Клик по кнопке «Войти в аккаунт»")
    public void loginClick() {
        webDriver.findElement(AuthButton).click();
    }

    @Step("Клик по кнопке «Личный кабинет»")
    public void accountClick() {
        webDriver.findElement(AccountButton).click();
    }

    @Step("Главная страница. Проверка отображения меню конструктора")
    public boolean constructorIsDisplayedCheck() {
        return webDriver.findElement(ConstructorMenu).isDisplayed();
    }

    @Step("Главная страница. Проверка отображения кнопки Войти в аккаунт")
    public boolean authButtonIsDisplayedCheck() {
        return webDriver.findElement(AuthButton).isDisplayed();
    }

    @Step
    public boolean createOrderButtonIsDisplayedCheck() {
        return webDriver.findElement(CreateOrderButton).isDisplayed();
    }

    @Step("Переход к разделу «Булки»")
    public void transitionBunsClick() {
        webDriver.findElement(BunsButton).click();
    }

    @Step("Проверка отображения раздела «Булки»")
    public boolean bunsMenuIsVisibleCheck() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(BunsMenu));
        return webDriver.findElement(BunsMenu).isDisplayed();
    }

    @Step("Переход к разделу «Соусы»")
    public void transitionSaucesClick() {
        webDriver.findElement(SaucesButton).click();
    }

    @Step("Проверка отображения раздела «Соусы»")
    public boolean saucesMenuIsVisibleCheck() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(SaucesMenu));
        return webDriver.findElement(SaucesMenu).isDisplayed();
    }

    @Step("Переход к разделу «Начинки»")
    public void transitionToppingsClick() {
        webDriver.findElement(ToppingsButton).click();
    }

    @Step("Проверка отображения раздела «Начинки»")
    public boolean toppingsMenuIsVisibleCheck() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(ToppingsMenu));
        return webDriver.findElement(ToppingsMenu).isDisplayed();
    }
}
