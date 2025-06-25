@Test01
Feature: Carrito de compras en OpenCart

  Scenario Outline: Agregar y eliminar producto del carrito
    Given que el usuario abre la web de OpenCart
    When busca el producto "<producto>"
    And selecciona el primer producto en los resultados
    And agrega el producto al carrito
    And ingresa al carrito de compras
    And presiona el botón "View Cart"
    Then verifica que el producto "<producto>" esté en el carrito
    When elimina el producto del carrito
    Then verifica que el producto "<producto>" ya no esté en el carrito

    Examples:
      | producto |
      | iPhone   |
