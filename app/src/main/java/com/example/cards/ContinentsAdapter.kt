import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cards.Continent
import com.example.cards.databinding.ItemContinentBinding

class ContinentsAdapter(
    private val continents: List<Continent>,
    private val onClick: (Continent) -> Unit
) : RecyclerView.Adapter<ContinentsAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemContinentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(continent: Continent) {
            binding.textViewContinentName.text = continent.name
            binding.textViewContinentDescription.text = continent.description

            Glide.with(binding.imageViewContinent.context)
                .load(continent.imageUrl)
                .into(binding.imageViewContinent)

            binding.root.setOnClickListener { onClick(continent) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContinentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(continents[position])
    }

    override fun getItemCount() = continents.size
}
