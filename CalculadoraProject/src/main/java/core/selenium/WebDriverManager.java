package core.selenium;

import java.util.concurrent.TimeUnit;

import core.selenium.webdrivers.Chrome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private static WebDriverManager driverManagerInstance;

    /**
     * Constructor WebDriverConfig.
     */
    private WebDriverManager() {
        initialize();
    }

    /**
     * Gets Instance of a WebElement.
     *
     * @return Instance of WebElement.
     */
    public static WebDriverManager getInstance() {
        if (driverManagerInstance == null) {
            driverManagerInstance = new WebDriverManager();
        }
        return driverManagerInstance;
    }

    /**
     * Initializes the settings for the driver.
     */
    private void initialize() {
        this.webDriver = Chrome.initDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage()
                .timeouts()
                .implicitlyWait(WebDriverConfig.getInstance().getImplicitWaitTime(), TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, WebDriverConfig.getInstance().getExplicitWaitTime(),
                WebDriverConfig.getInstance().getWaitSleepTime());
    }

    /**
     * Gets the WebDriver.
     *
     * @return WebDriver.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Gets the WebDriver Wait.
     *
     * @return WebDriverWait.
     */
    public WebDriverWait getWait() {
        return webDriverWait;
    }
}
