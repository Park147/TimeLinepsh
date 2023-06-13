package fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.timelinepsh.databinding.FragmentOneBinding

class FolwFragment : Fragment() {


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
