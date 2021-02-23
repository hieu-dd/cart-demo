package com.example.cartsdks

import android.app.Application
import vn.teko.cart.ui.CartSdk
import vn.teko.terra.core.android.terra.TerraApp

class DemoApplication : Application() {
    companion object {
        const val APP_NAME = "CartSDKs"
    }

    override fun onCreate() {
        super.onCreate()
        val terraApp = TerraApp.initializeApp(this, APP_NAME)
        CartSdk.getInstance(terraApp)
    }
}