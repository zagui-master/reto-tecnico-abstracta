package zagui.driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class Driver {
    private static WebDriver driver;

    public WebDriver browser() {
        return browser("chrome"); // Usa Chrome por defecto si no se pasa parámetro
    }

    public WebDriver browser(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "firefox" -> driver = new FirefoxDriver();
                case "safari" -> driver = new SafariDriver();
                default -> driver = new ChromeDriver();
            }
        }
        return driver;
    }

}
