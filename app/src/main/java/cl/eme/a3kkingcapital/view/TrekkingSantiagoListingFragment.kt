package cl.eme.a3kkingcapital.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.eme.a3kkingcapital.R
import cl.eme.a3kkingcapital.databinding.FragmentListingTrekkingsantiagoBinding
import timber.log.Timber

class TrekkingSantiagoListingFragment : Fragment() {

    private lateinit var binding : FragmentListingTrekkingsantiagoBinding
    private val viewModel : TrekkingSantiagoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val adapter = TrekkingSantiagoAdapter()

        binding = FragmentListingTrekkingsantiagoBinding.inflate(layoutInflater)
        binding.rvTrekkingSantiago.layoutManager = LinearLayoutManager(context)
        binding.rvTrekkingSantiago.adapter = adapter

        viewModel.selected().observe(viewLifecycleOwner, {
            Timber.d("Lista de Datos")
            it?.let{
               Timber.d("Tamaño de la lista ${it.size}")
                adapter.update(it)
            }
        })
        adapter.selectedItem().observe(viewLifecycleOwner,{
            viewModel.selectedItem(it)
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.mc, TrekkingSantiagoDetailFragment())?.addToBackStack("Detail")?.commit()
        })

        return binding.root
    }
}