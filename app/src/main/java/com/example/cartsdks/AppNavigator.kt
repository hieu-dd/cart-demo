package com.example.cartsdks

import android.annotation.SuppressLint
import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.cartsdks.DemoApplication.Companion.APP_NAME
import vn.teko.cart.ui.CartNavigationDelegate
import vn.teko.cart.ui.CartSdk
import vn.teko.terra.core.android.terra.TerraApp

@SuppressLint("StaticFieldLeak")
internal object AppNavigator {
    fun registerSdkNavigation() {
        val terraApp = TerraApp.getInstance(APP_NAME)
        CartSdk.getInstance(terraApp).setNavigationDelegate(object : CartNavigationDelegate {
            override fun backFromCart() {
                getMainNavigation()?.popBackStack()
            }
        })
    }

    private var activity: Activity? = null

    internal fun setActivity(activity: Activity?) {
        this.activity = activity
    }

    fun goToCart() {
        getMainNavigation()?.navigate(HomeFragmentDirections.actionHomeFragmentToCartFragment())
    }

    fun getMainNavigation(): NavController? =
        activity?.let { Navigation.findNavController(it, R.id.myNavHostFragment) }
}