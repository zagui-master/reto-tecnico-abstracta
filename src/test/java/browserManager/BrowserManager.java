package browserManager;

import zagui.driverManager.Driver;
import io.github.cdimascio.dotenv.Dotenv;

public class BrowserManager {
    Driver driver = new Driver();
    private final Dotenv dotenv = Dotenv.load();
    private final String BROWSER = dotenv.get("BROWSER");

    public void navigateTo() {
        navigateTo(dotenv.get("BASE_URL"));
    }

    public void navigateTo(String url) {
        driver.browser(BROWSER).manage().window().maximize();
        driver.browser(BROWSER).get(url);
    }

    public void quitBrowser() {
        driver.browser().quit();
    }

    public void closeBrowser() {
        driver.browser().close();
    }
}
