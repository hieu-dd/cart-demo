package vn.teko.cart.ui

import vn.teko.cart.bus.CartBus
import vn.teko.terra.core.android.terra.TerraApp

class CartSdk private constructor(private val terraApp: TerraApp) {
    private var cartBus = CartBus.getInstance(terraApp)
    private var cartManager = cartBus.getCartManager()
    private var cartManagerHelper = CartManagerHelper(cartManager, terraApp.getTerraBus())

    internal fun getCartManagerHelper() = cartManagerHelper

    private var navigationDelegate: CartNavigationDelegate? = null

    fun setNavigationDelegate(navigationDelegate: CartNavigationDelegate?) {
        this.navigationDelegate = navigationDelegate
    }

    internal fun getNavigationDelegate() = navigationDelegate

    companion object {
        private val cartSdkMap: MutableMap<String, CartSdk> = mutableMapOf()

        @JvmStatic
        fun getInstance(terraApp: TerraApp): CartSdk {
            val appName = terraApp.appName
            val cartSdk = cartSdkMap[appName]
            if (cartSdk == null) {
                cartSdkMap[appName] = CartSdk(terraApp)
            }

            return cartSdkMap[appName]!!
        }
    }
}