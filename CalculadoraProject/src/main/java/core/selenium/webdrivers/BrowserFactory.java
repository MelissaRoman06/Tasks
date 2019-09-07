package core.selenium.webdrivers;

import calculadora.ui.utils.Operations;

import java.util.HashMap;
import java.util.Map;

public abstract class BrowserFactory {
    private static Map <String,IBrowser> browsers = new HashMap<>();
    static {
        browsers.put("chrome", new Chrome());
        browsers.put("firefox", new Firefox());
    }
    public static IBrowser getBrowser(String browserName) {
        return browsers.get(browserName);
    }
}
