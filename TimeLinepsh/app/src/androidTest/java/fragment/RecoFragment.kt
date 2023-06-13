package fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.timelinepsh.databinding.FragmentOneBinding
import com.google.android.material.tabs.TabLayoutMediator

class RecoFragment : Fragment() {

    lateinit var binding: FragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater, container, false)

        val tabLayout = binding.ReserveTabs

        val viewPager = binding.ReserveViewpager

        viewPager.adapter = OneFragment.MyReserveFragmentPagerAdapter(this)

        return binding.root
    }
}
