package com.example.timeline

import android.app.TabActivity
import android.os.Bundle
import android.widget.TabHost
import android.widget.TabHost.TabSpec
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.timeline.MyAdapter
import com.example.timeline.R

@Suppress("DEPRECATION")
class MainActivity : TabActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabHost = tabHost

        val tabSpecRecommend = tabHost.newTabSpec("Recommend").setIndicator("추천")
        tabSpecRecommend.setContent(R.id.tabMainActivity)
        tabHost.addTab(tabSpecRecommend)

        val tabSpecFollowing = tabHost.newTabSpec("Following").setIndicator("팔로잉")
        tabSpecFollowing.setContent(R.id.tabFollowing)
        tabHost.addTab(tabSpecFollowing)

        tabHost.currentTab = 0
    }

    class MainActivity : FragmentActivity() {
        lateinit var aPager: ViewPager2
        lateinit var pagerAdapter: FragmentStateAdapter

        lateinit var binding: MainActivityBinding
        val numPage = 4;
        var Toorbarname: TextView? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = MainActivityBinding.inflate(layoutInflater)
            setContentView(binding.root)


            //ViewPager2
            aPager = findViewById<ViewPager2>(R.id.viewpager)
            //Adapter
            pagerAdapter = MyAdapter(this, numPage)
            aPager.setAdapter(pagerAdapter)

            //ViewPager Setting
            aPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL)
            aPager.setCurrentItem(1000)
            aPager.setOffscreenPageLimit(3)
            aPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                    if (positionOffsetPixels == 0) {
                        aPager.setCurrentItem(position)
                    }
                }

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    mIndicator.animatePageSelected(position % numPage)
                }
            })
            val pageMargin = resources.getDimensionPixelOffset(R.dimen.pageMargin).toFloat()
            val pageOffset = resources.getDimensionPixelOffset(R.dimen.offset).toFloat()
            aPager.setPageTransformer(ViewPager2.PageTransformer { page, position ->
                val myOffset = position * -(2 * pageOffset + pageMargin)
                if (aPager.getOrientation() == ViewPager2.ORIENTATION_HORIZONTAL) {
                    if (ViewCompat.getLayoutDirection(aPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                        page.translationX = -myOffset
                    } else {
                        page.translationX = myOffset
                    }
                } else {
                    page.translationY = myOffset
                }
            })
        }
    }
}
