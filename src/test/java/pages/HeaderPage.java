package pages;

import zagui.apiZagui.Page;
import org.openqa.selenium.By;;

public class HeaderPage implements Page {

    By inputSearchProduct = By.cssSelector("div#search input");
    By btnSearchProduct = By.cssSelector("div#search button");
    By btnCart = By.id("cart");
    By linkViewCart = By.xpath("//p[@class='text-right']/a[1]");

    public void searchProduct(String value) {
        Page.typeOn(inputSearchProduct, value);
        Page.clickOn(btnSearchProduct);
    }

    public void showCart() {
        Page.clickOn(btnCart);
    }

    public void clickViewCart() {
        Page.clickOn(linkViewCart);
    }

}
