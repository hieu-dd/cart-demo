package vn.teko.cart.core

interface CartManagerInterface {
    fun getCartItemsQuantity(): Int
    fun addItem()
}