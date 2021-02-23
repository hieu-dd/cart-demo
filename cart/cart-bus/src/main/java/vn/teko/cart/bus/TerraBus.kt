package vn.teko.cart.bus

import vn.teko.terra.core.android.bus.TerraBus
import vn.teko.terra.core.android.bus.subscriber.Subscriber

internal fun TerraBus.subscribeAddItem(subscriber: Subscriber<Int, Unit>) {
    subscribe("add_item", subscriber)
}

internal fun TerraBus.subscribeGetQuantity(subscriber: Subscriber<Unit, Int>) {
    subscribe("get_quantity", subscriber)
}

