package cl.eme.a3kkingcapital.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.eme.a3kkingcapital.databinding.ItemListTrekkingBinding
import cl.eme.a3kkingcapital.model.TrekkingSantiago
import coil.load

class TrekkingSantiagoAdapter : RecyclerView.Adapter<TrekkingSantiagoAdapter.TrekkingSantiagoVH>() {

    private var trekkingList = listOf<TrekkingSantiago>()
    private val selectedItem = MutableLiveData<TrekkingSantiago>()

    fun selectedItem() : LiveData<TrekkingSantiago> = selectedItem
    fun update (getTrekking: List<TrekkingSantiago>) {
        trekkingList =getTrekking
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrekkingSantiagoVH {
        val binding = ItemListTrekkingBinding.inflate(LayoutInflater.from(parent.context))
        return TrekkingSantiagoVH(binding)
    }

    override fun onBindViewHolder(holder: TrekkingSantiagoVH, position: Int) {
        val trekking = trekkingList[position]
        holder.bind(trekking)
        holder.itemView.setOnClickListener{
            selectedItem.value = trekking
        }
    }

    override fun getItemCount(): Int {
        return trekkingList.size


    }
    class TrekkingSantiagoVH(val binding: ItemListTrekkingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(trekking: TrekkingSantiago) {
        binding.rvName.text = trekking.name
        binding.rvimage.load(trekking.image)

        }

    }



}



