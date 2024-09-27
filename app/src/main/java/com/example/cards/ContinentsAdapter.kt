import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cards.Continent
import com.example.cards.databinding.ItemContinentBinding

class ContinentsAdapter(
    private val continents: List<Continent>,
    private val onClick: (Continent) -> Unit
) : RecyclerView.Adapter<ContinentsAdapter.ContinentViewHolder>() {

    inner class ContinentViewHolder(val binding: ItemContinentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(continent: Continent) {
            binding.textViewContinentName.text = continent.name
            binding.textViewContinentDescription.text = continent.description


            Glide.with(binding.imageViewContinent.context)
                .load(continent.imageUrl)
                .into(binding.imageViewContinent)

            binding.root.setOnClickListener {
                onClick(continent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContinentViewHolder {
        val binding = ItemContinentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContinentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContinentViewHolder, position: Int) {
        holder.bind(continents[position])
    }

    override fun getItemCount(): Int = continents.size
}
