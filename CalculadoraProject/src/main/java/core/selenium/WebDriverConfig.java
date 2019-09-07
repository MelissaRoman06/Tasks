package core.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * WebDriverConfig reads properties file to set waits' time to be used by the web driver.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class WebDriverConfig {
    private int implicitWaitTime;
    private int explicitWaitTime;
    private int waitSleepTime;
    private String browserName;
    private static WebDriverConfig configInstance;

    /**
     * Constructor WebDriverConfig.
     */
    protected WebDriverConfig() {
        readProperties();
    }

    /**
     * Gets the instance of WebDriverConfig.
     *
     * @return configInstance.
     */
    public static WebDriverConfig getInstance() {
        if (configInstance == null) {
            configInstance = new WebDriverConfig();
        }
        return configInstance;
    }

    /**
     * Reads properties file for Web Driver waits' config.
     */
    public void readProperties() {
        try (InputStream input = new FileInputStream("gradle.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            browserName = properties.getProperty("browserName");
            implicitWaitTime = Integer.parseInt(properties.getProperty("implicitWaitTime"));
            explicitWaitTime = Integer.parseInt(properties.getProperty("explicitWaitTime"));
            waitSleepTime = Integer.parseInt(properties.getProperty("waitSleepTime"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Gets the implicit wait time set for the WebDriver.
     *
     * @return Implicit wait time.
     */
    public String getBrowserName() {
        return browserName;
    }

    /**
     * Gets the implicit wait time set for the WebDriver.
     *
     * @return Implicit wait time.
     */
    public int getImplicitWaitTime() {
        return implicitWaitTime;
    }

    /**
     * Gets the explicit wait time set for the WebDriver.
     *
     * @return Explicit wait time.
     */
    public int getExplicitWaitTime() {
        return explicitWaitTime;
    }

    /**
     * Gets the sleep time wait set for the WebDriver.
     *
     * @return Sleep wait time.
     */
    public int getWaitSleepTime() {
        return waitSleepTime;
    }
}
