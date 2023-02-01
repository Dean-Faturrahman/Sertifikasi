package com.example.mydrawer.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mydrawer.ui.pager.DessertFragment
import com.example.mydrawer.ui.pager.DrinkFragment
import com.example.mydrawer.ui.pager.FoodFragment

class SectionPagerAdapter(fragmentManager: FragmentManager) : FragmentStateAdapter(fragmentManager.primaryNavigationFragment!!) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FoodFragment()
            1 -> fragment = DrinkFragment()
            2 -> fragment = DessertFragment()
        }
        return fragment as Fragment
    }

}