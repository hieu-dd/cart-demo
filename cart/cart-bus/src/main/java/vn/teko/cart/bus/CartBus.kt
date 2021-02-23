package vn.teko.cart.bus

import vn.teko.android.core.util.Result
import vn.teko.cart.core.CartManagerInterface
import vn.teko.terra.core.android.bus.TerraBus
import vn.teko.terra.core.android.bus.subscriber.Subscriber
import vn.teko.terra.core.android.terra.TerraApp

class CartBus(private val cartManager: CartManagerInterface, terraBus: TerraBus) {
    private var subscriberAddItem = object : Subscriber<Int, Unit>() {
        override suspend fun handle(event: Int): Result<Unit, Throwable> {
            return Result.success(cartManager.addItem())
        }
    }
    private var subscriberGetQuantity = object : Subscriber<Unit, Int>() {
        override suspend fun handle(event: Unit): Result<Int, Throwable> {
            return Result.success(cartManager.getCartItemsQuantity())
        }
    }

    init {
        terraBus.subscribeAddItem(subscriberAddItem)
        terraBus.subscribeGetQuantity(subscriberGetQuantity)
    }

    fun getCartManager() = cartManager

    companion object {
        private val cartWithBusMap: MutableMap<String, CartBus> = mutableMapOf()

        @JvmStatic
        fun getInstance(terraApp: TerraApp): CartBus {
            val appName = terraApp.appName
            val cartManager = TerraCart.getInstance(terraApp)
            val cartWithBus = cartWithBusMap[appName]
            if (cartWithBus == null) {
                cartWithBusMap[appName] = CartBus(cartManager, terraApp.getTerraBus())
            }

            return cartWithBusMap[appName]!!
        }
    }
}