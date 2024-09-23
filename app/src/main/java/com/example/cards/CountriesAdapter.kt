package com.example.cards


import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cards.databinding.ItemCountryBinding

class CountriesAdapter(
    private val countries: List<Country>,
    private val onClick: (Country) -> Unit
) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.textViewCountryName.text = country.name
            binding.textViewCountryDescription.text = country.description
            Glide.with(binding.root.context).load(country.imageUrl).into(binding.imageViewCountry)
            binding.root.setOnClickListener { onClick(country) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount() = countries.size
}
