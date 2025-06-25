package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import zagui.apiZagui.Page;


public class CartPage implements Page {

    By imgProduct = By.cssSelector("#content form img");
    By btnRemoveProduct = By.cssSelector("button[data-original-title='Remove']");
    By titleCartEmpty = By.cssSelector("#content p");

    public boolean isElementVisible() {
        WebElement element = driver.browser().findElement(imgProduct);
        return element.isDisplayed();
    }

    public boolean isTitleVisible() {
        WebElement element = driver.browser().findElement(titleCartEmpty);
        return element.isDisplayed();
    }

    public void removeProduct() {
        Page.clickOn(btnRemoveProduct);
    }

}
