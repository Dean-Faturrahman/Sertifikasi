package com.example.mydrawer.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.mydrawer.R
import com.example.mydrawer.adapter.SectionPagerAdapter
import com.example.mydrawer.databinding.FragmentMenuBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pagerSetup()
    }

    private fun pagerSetup() {
        val sectionPagerAdapter = SectionPagerAdapter(parentFragmentManager)
        val viewPager: ViewPager2? = view?.findViewById(R.id.view_pager)
        viewPager?.adapter = sectionPagerAdapter
        val tabs: TabLayout? = view?.findViewById(R.id.tabs)
        if (tabs != null && viewPager != null) {
            TabLayoutMediator(tabs, viewPager) { tab, position ->
                tab.text = resources.getString(TAB_TITTLES[position])
            }.attach()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private val TAB_TITTLES = intArrayOf(
            R.string.tab_name_1,
            R.string.tab_name_2,
            R.string.tab_name_3
        )
    }
}