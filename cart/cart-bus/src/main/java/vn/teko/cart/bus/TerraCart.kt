package vn.teko.cart.bus

import vn.teko.cart.core.CartManager
import vn.teko.cart.core.CartManagerInterface
import vn.teko.terra.core.android.terra.BaseTerraServiceManager
import vn.teko.terra.core.android.terra.ITerraServiceManager
import vn.teko.terra.core.android.terra.TerraApp

internal class TerraCartManager : BaseTerraServiceManager<CartManagerInterface>() {
    override fun getServiceName(): String = "cart"

    override fun getServiceDisplayName(): String = "Cart Service"

    override fun createInstance(
        config: String,
        terraApp: TerraApp
    ) = CartManager()
}

object TerraCart : ITerraServiceManager<CartManagerInterface> by TerraCartManager()