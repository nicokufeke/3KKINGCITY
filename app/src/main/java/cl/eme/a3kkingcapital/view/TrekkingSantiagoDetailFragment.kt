package cl.eme.a3kkingcapital.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.eme.a3kkingcapital.databinding.FragmentDetailTrekkingsantiagoBinding
import coil.load

class TrekkingSantiagoDetailFragment: Fragment() {

    private lateinit var binding: FragmentDetailTrekkingsantiagoBinding
    private val viewModel: TrekkingSantiagoViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentDetailTrekkingsantiagoBinding.inflate(layoutInflater)
        viewModel.selectedItem().observe(viewLifecycleOwner, {
        binding.tvName.text = it.name
        binding.tvLocation.text = it.location
        binding.tvDistance.text = it.distance
        binding.tvDifficulty.text = it.difficulty
        binding.ivTrekkingSantiago.load(it.image)

        })
        return binding.root
    }
}