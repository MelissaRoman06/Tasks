package core.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebDriverConfig {
    private int implicitWaitTime;
    private int explicitWaitTime;
    private int waitSleepTime;
    private static WebDriverConfig configInstance;

    /**
     * Constructor WebDriverConfig.
     */
    protected WebDriverConfig() {
        readProperties();
    }

    /**
     * Gets the configInstance of WebDriverConfig.
     *
     * @return a configInstance.
     */
    public static WebDriverConfig getInstance() {
        if (configInstance == null) {
            configInstance = new WebDriverConfig();
        }
        return configInstance;
    }

    /**
     * Initializes WebDriverConfig.
     */
    public void readProperties() {
        try (InputStream input = new FileInputStream("gradle.properties")) {
            Properties properties = new Properties();
            properties.load(input);
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
     * @return The implicit time.
     */
    public int getImplicitWaitTime() {
        return implicitWaitTime;
    }

    /**
     * Gets the explicit wait time set for the WebDriver.
     *
     * @return The explicit time.
     */
    public int getExplicitWaitTime() {
        return explicitWaitTime;
    }

    /**
     * Gets the sleep time wait set for the WebDriver.
     *
     * @return Sleep time wait.
     */
    public int getWaitSleepTime() {
        return waitSleepTime;
    }
}
