package core.selenium.webdrivers;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements IBrowser{
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver();
    }
}
