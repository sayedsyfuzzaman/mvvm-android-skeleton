package com.syfuzzaman.mvvm_android_skeleton.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.syfuzzaman.mvvm_android_skeleton.R
import com.syfuzzaman.mvvm_android_skeleton.data.network.api.User
import com.syfuzzaman.mvvm_android_skeleton.databinding.FragmentUserDetailsBinding
import com.syfuzzaman.mvvm_android_skeleton.ui.common.BaseListItemCallback

class UserDetailsFragment : Fragment(), BaseListItemCallback<User> {
    private lateinit var binding: FragmentUserDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }
}