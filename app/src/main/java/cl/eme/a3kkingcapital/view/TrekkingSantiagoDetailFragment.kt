package cl.eme.a3kkingcapital.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.eme.a3kkingcapital.databinding.FragmentDetailTrekkingsantiagoBinding
import coil.load
import com.google.android.material.snackbar.Snackbar

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


            fun email() {

                val intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("consultas@easytrek.cl"))
                intent.putExtra(Intent.EXTRA_SUBJECT, "Consulta por tu Trekking ${it.name} , ID : ${it.id} ")
                intent.putExtra(
                        Intent.EXTRA_TEXT, " “Hola\n" +
                        "Vi el Trekking ${it.name} de código ${it.id} y me gustaría que me contactaran a este correo o al\n" +
                        "siguiente número para conocer más detalles ___________")
                intent.type = "message/rfc822"
                startActivity(Intent.createChooser(intent, "Escoja el mail del cliente"))
            }

            binding.floatingActionButton3.setOnClickListener { view ->
                Snackbar.make(view, "Email", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show()
                email()
            }


        })
        return binding.root
    }
}