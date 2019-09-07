package core.selenium.webdrivers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.util.HashMap;

/**
 * Chrome class sets the browser.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class Chrome implements IBrowser{
    /**
     * Initializes Chrome driver.
     *
     * @return New ChromeDriver.
     */
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance().version("76.0.3809.126").setup();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("profile.default_content_setting_values.notifications", 2);
        // By setting download prompt to false, all downloads will start automatically.
        chromePrefs.put("download.prompt_for_download", "false");
        // Download files will be put into this path by default.
        String path = "C:\\Users\\Admin\\Downloads";
        File file = new File(path);
        // By setting download default directory, downloaded files will bu put into the specified path.
        chromePrefs.put("download.default_directory", file.getAbsolutePath());
        // By setting safe browsing enabled to true, there won't be alert messages when download XML Files.
        chromePrefs.put("safebrowsing.enabled", "true");
        ChromeOptions chromeOptions = new ChromeOptions();
        // Setting driver to ignore SSL errors.
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        return new ChromeDriver(chromeOptions);
    }
}
