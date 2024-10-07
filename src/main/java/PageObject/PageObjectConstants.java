package PageObject;

import org.openqa.selenium.By;

public class PageObjectConstants {
    //Главная страница. Локатор кнопки "Личный кабинет":
    public static final By AccountButton = By.xpath("//p[contains(text(),'Личный Кабинет')]");
    //Главная страница. Локатор кнопки "Войти в аккаунт":
    public static final By AuthButton = By.xpath("//button[text()='Войти в аккаунт']");
    //Главная страница. Локатор кнопки "Оформить заказ":
    public static final By CreateOrderButton = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    //Главная страница. Локатор кнопки "Булки":
    public static final By BunsButton = By.xpath("//span[contains(text(),'Булки')]");
    //Главная страница. Локатор меню "Булки":
    public static final By BunsMenu = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Булки']");
    //Главная страница. Локатор кнопки "Соусы":
    public static final By SaucesButton = By.xpath("//span[contains(text(),'Соусы')]");
    //Главная страница. Локатор меню "Соусы":
    public static final By SaucesMenu = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Соусы']");
    //Главная страница. Локатор кнопки "Начинки":
    public static final By ToppingsButton = By.xpath("//span[contains(text(),'Начинки')]");
    //Главная страница. Локатор меню "Начинки":
    public static final By ToppingsMenu = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Начинки']");
    //Главная страница. Локатор меню конструктора
    public static final By ConstructorMenu = By.xpath("//*[@id=\"root\"]/div/main/section[1]");
    //Локатор поля "Имя":
    public static final By NameField = By.xpath("//label[text()='Имя']/following-sibling::input");
    //Локатор поля "Email":
    public static final By EmailField = By.xpath("//label[text()='Email']/following-sibling::input");
    //Локатор поля "Пароль":
    public static final By PasswordField = By.xpath("//label[text()='Пароль']/following-sibling::input");
    //Локатор кнопки "Зарегистрироваться":
    public static final By RegistrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    //Локатор кнопки "Войти":
    public static final By AuthButton2 = By.xpath("//a[@class='Auth_link__1fOlj' and contains(@href, '/login')]");
    //Локатор сообщения об ошибке:
    public static final By IncorrectPasswordMessage= By.xpath("//div[@class='input__container']//p[text() = 'Некорректный пароль']");
    //Страница входа в аккаунт. Локатор кнопки "Войти":
    public static final By AuthButton3 = By.xpath("//div[@class='Auth_login__3hAey']//button[text()='Войти']");
    //Страница входа в аккаунт. Локатор поля "Email":
    public static final By PasswordField2 = By.xpath(".//label[contains(text(),'Email')]/../input");
    //Страница входа в аккаунт. Локатор поля "Пароль":
    public static final By EmailField2 = By.xpath(".//label[contains(text(),'Пароль')]/../input");
    //Страница "Личный кабинет". Локатор кнопки "Выйти":
    public static final By LogoutButton = By.xpath("//button[contains(text(),'Выход')]");
    //Страница личного кабинета. Локатор кнопки "Конструктор":
    public static final By ConstructorButton = By.xpath("//p[contains(text(),'Конструктор')]");
    //Страница личного кабинета. Локатор логотипа "Stellar Burgers":
    public static final By StellarBurgersLogo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']//a//*[name()='svg']");
    //Страница личного кабинета. Локатор меню пользователя
    public static final By ProfileText = By.xpath("//p[@class='Account_text__fZAIn text text_type_main-default' and contains(text(), 'В этом разделе')]");
    //Страница восстановления пароля. Локатор кнопки "Войти":
    public static final By AuthButton4 = By.xpath("//a[@class='Auth_link__1fOlj']");
}
