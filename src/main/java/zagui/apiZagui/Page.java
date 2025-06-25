package zagui.apiZagui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import zagui.driverManager.Driver;

import java.time.Duration;
import java.util.List;

public interface Page {

    Driver driver = new Driver();

    /**************************** WAIT EVENTS **********************************************************/
    Logger logger = LogManager.getLogger(Page.class);
    int DEFAULT_TIMEOUT_SECONDS = 5;

    private static WebDriverWait getWait() {
        return new WebDriverWait(driver.browser(), Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
    }

    private static <T> T waitFor(ExpectedCondition<T> condition, By locator) {
        try {
            return getWait().until(condition);
        } catch (TimeoutException error) {
            logger.error("Timeout waiting for element: {}", locator, error);
            throw new TimeoutException("Element not found: " + locator, error);
        }
    }

    private static WebElement waitToVisibilityOfElementLocated(By locator) {
        return waitFor(ExpectedConditions.visibilityOfElementLocated(locator), locator);
    }

    private static WebElement waitToElementToBeClickable(By locator) {
        return waitFor(ExpectedConditions.elementToBeClickable(locator), locator);
    }

    private static Alert waitToAlertIsPresent() {
        return getWait().until(ExpectedConditions.alertIsPresent());
    }
    /************************************************************************************************/
    /************************** CLICK EVENTS *****************************************************/
    static void clickOn(By element) {
        waitToElementToBeClickable(element).click();
    }

    static void doubleClickOn(By element) {
        new Actions(driver.browser()).doubleClick(waitToElementToBeClickable(element)).perform();
    }
    /************************************************************************************************/
    /*********************** INPUT EVENTS ********************************************************/
    static void typeOn(By element, String text) {
        waitToVisibilityOfElementLocated(element).sendKeys(text);
    }

    static void clear(By element, String text) {
        waitToVisibilityOfElementLocated(element).clear();
    }
    /************************************************************************************************/
    /*********************** TEXT EVENTS ********************************************************/
    static String getTextFromElement(By element) {
        return waitToVisibilityOfElementLocated(element).getText();
    }

    static List<String> getTextFromElements(By element) {
        return driver.browser().findElements(element).stream().map(WebElement::getText).toList();
    }
    /************************************************************************************************/
    /*********************** URL EVENTS ********************************************************/
    static String getCurrentUrl() {
        return driver.browser().getCurrentUrl();
    }
    /************************************************************************************************/
    /*********************** DROPDOWN EVENTS ********************************************************/
    static Select select(By element) {
        return new Select(waitToVisibilityOfElementLocated(element));
    }

    static void selectByIndex(By element, int index) {
        select(element).selectByIndex(index);
    }

    static void selectByName(By element, String value) {
        select(element).selectByValue(value);
    }

    static void selectByVisibleText(By element, String text) {
        select(element).selectByVisibleText(text);
    }

    static List<String> getSelectOptions(By element) {
        return select(element).getOptions().stream().map(WebElement::getText).toList();
    }

    static void deselectByIndex(By element, int index) {
        select(element).deselectByIndex(index);
    }

    static void deselectByName(By element, String value) {
        select(element).deselectByValue(value);
    }
    /************************************************************************************************/
    /*********************** DRAG AND DROP EVENTS ********************************************************/
    static void dragAndDropOnElement(By elementDraggable, By elementDroppable) {
        WebElement draggable = waitToVisibilityOfElementLocated(elementDraggable);
        WebElement droppable = waitToVisibilityOfElementLocated(elementDroppable);
        new Actions(driver.browser()).dragAndDrop(draggable, droppable).perform();
    }
    /************************************************************************************************/
    /*********************** ALERT EVENTS ********************************************************/
    static void alertAccept() {
        waitToAlertIsPresent().accept();
    }

    static void alertDismiss() {
        waitToAlertIsPresent().dismiss();
    }

    static void alertPrompt(String prompt) {
        Alert alert = waitToAlertIsPresent();
        alert.sendKeys(prompt);
        alert.accept();
    }
    /************************************************************************************************/

}
