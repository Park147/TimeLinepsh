package fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.timelinepsh.databinding.FragmentTwoReserveBinding
import com.example.timelinepsh.retrofit.MainActivity

class TwoReserveFragment : Fragment() {
    lateinit var binding: FragmentTwoReserveBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoReserveBinding.inflate(inflater, container, false)

        binding.MainMenu.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }
}