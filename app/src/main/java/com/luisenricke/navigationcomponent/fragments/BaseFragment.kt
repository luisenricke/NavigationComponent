package com.luisenricke.navigationcomponent.fragments

import androidx.fragment.app.Fragment
import com.luisenricke.navigationcomponent.MainActivity

@Suppress("unused")
abstract class BaseFragment : Fragment() {

    fun getActivityContext(): MainActivity = (activity as MainActivity)

}
