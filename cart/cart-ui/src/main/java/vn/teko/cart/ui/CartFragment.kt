package vn.teko.cart.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import vn.teko.cart.ui.databinding.FragmentCartBinding
import vn.teko.terra.core.android.terra.TerraApp

class CartFragment : Fragment() {
    private lateinit var dataBinding: FragmentCartBinding
    private val terra = TerraApp.getInstance("CartSDKs")
    private lateinit var cartSdk: CartSdk
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_cart, container, false
        )
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cartSdk = CartSdk.getInstance(terra)
        dataBinding.text.text = cartSdk.getCartManagerHelper().getCartItemsQuantity().toString()
        dataBinding.back.setOnClickListener {
            cartSdk.getNavigationDelegate()?.backFromCart()
        }
    }
}