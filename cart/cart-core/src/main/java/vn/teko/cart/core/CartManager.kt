package vn.teko.cart.core

class CartManager : CartManagerInterface {
    var items = intArrayOf()

    override fun getCartItemsQuantity(): Int {
        return items.size
    }

    override fun addItem() {
        items = items.plus(1)
    }
}