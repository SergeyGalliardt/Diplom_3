import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    private static final String BROWSER_PROPERTY = "browser";
    private static final String DEFAULT_BROWSER = "chrome";
    private static final String WEBDRIVER_CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public enum Browser {
        CHROME, YANDEX;
    }

    public static WebDriver createWebDriver() {
        Browser browser = getActiveBrowser();

        switch (browser) {
            case CHROME:
                System.setProperty(WEBDRIVER_CHROME_DRIVER_PROPERTY, "C:/Users/PC/WebDriver/bin/chromedriver.exe");
                return new ChromeDriver();
            case YANDEX:
                System.setProperty(WEBDRIVER_CHROME_DRIVER_PROPERTY, "C:/Users/PC/WebDriver/bin/yandexdriver.exe");
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    private static Browser getActiveBrowser() {
        String browserName = System.getProperty(BROWSER_PROPERTY, DEFAULT_BROWSER);
        return Browser.valueOf(browserName.toUpperCase());
    }
}
