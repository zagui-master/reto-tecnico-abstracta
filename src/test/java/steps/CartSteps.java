package steps;

import browserManager.BrowserManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;


public class CartSteps {

    HeaderPage headerPage = new HeaderPage();
    SearchPage searchPage = new SearchPage();
    YourStorePage yourStorePage = new YourStorePage();
    CartPage cartPage = new CartPage();
    BrowserManager browserManager = new BrowserManager();

    @Given("que el usuario abre la web de OpenCart")
    public void abrirWeb() {
        browserManager.navigateTo();
    }

    @When("busca el producto {string}")
    public void buscarProducto(String producto) {
        headerPage.searchProduct(producto);
    }

    @And("selecciona el primer producto en los resultados")
    public void seleccionarProducto() {
        searchPage.chooseProduct();
    }

    @And("agrega el producto al carrito")
    public void agregarAlCarrito() {
        yourStorePage.addProduct();
    }

    @And("ingresa al carrito de compras")
    public void ingresarCarrito() {
        headerPage.showCart();
    }

    @And("presiona el botón {string}")
    public void presionarBoton(String boton) {
        headerPage.clickViewCart();
    }

    @Then("verifica que el producto {string} esté en el carrito")
    public void verificarProductoEnCarrito(String producto) {
        Assert.assertTrue(cartPage.isElementVisible());
    }

    @When("elimina el producto del carrito")
    public void eliminarProducto() {
        cartPage.removeProduct();
    }

    @Then("verifica que el producto {string} ya no esté en el carrito")
    public void verificarProductoEliminado(String producto) {
        Assert.assertTrue(cartPage.isTitleVisible());
    }
}
