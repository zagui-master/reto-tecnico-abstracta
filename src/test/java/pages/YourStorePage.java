package pages;

import zagui.apiZagui.Page;
import org.openqa.selenium.By;

public class YourStorePage implements Page {

    By btnAddProduct = By.id("button-cart");

    public void addProduct() {
        Page.clickOn(btnAddProduct);
    }
}
