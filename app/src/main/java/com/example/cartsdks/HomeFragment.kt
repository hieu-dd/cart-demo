package com.example.cartsdks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.cartsdks.databinding.FragmentHomeBinding
import vn.teko.terra.core.android.terra.TerraApp

class HomeFragment : Fragment() {
    private lateinit var dataBinding: FragmentHomeBinding
    private val terraApp = TerraApp.getInstance(DemoApplication.APP_NAME)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.apply {
            next.setOnClickListener {
                AppNavigator.goToCart()
            }
            add.setOnClickListener {
                terraApp.getTerraBus().publish("add_item", 1)
            }
        }
    }
}