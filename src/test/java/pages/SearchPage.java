package pages;

import zagui.apiZagui.Page;
import org.openqa.selenium.By;

public class SearchPage implements Page {

    By product = By.xpath("//div[@class='product-thumb']//img");

    public void chooseProduct() {
        Page.clickOn(product);
    }
}
