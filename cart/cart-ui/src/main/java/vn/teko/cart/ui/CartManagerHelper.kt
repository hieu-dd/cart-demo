package vn.teko.cart.ui

import vn.teko.cart.core.CartManagerInterface
import vn.teko.terra.core.android.bus.TerraBus

class CartManagerHelper
internal constructor(
    private val cartManager: CartManagerInterface,
    private val terraBus: TerraBus
) : CartManagerInterface {
    override fun getCartItemsQuantity(): Int {
        return cartManager.getCartItemsQuantity()
    }

    override fun addItem() {
        cartManager.addItem()
    }
}