package com.example.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cards.Continent
import com.example.cards.Country
import com.example.cards.DetailFragment
import com.example.cards.R
import com.example.cards.databinding.FragmentCountriesBinding

class CountriesFragment : Fragment() {

    private var _binding: FragmentCountriesBinding? = null
    private val binding get() = _binding!!

    private lateinit var countries: List<Country>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val continent = arguments?.getSerializable("continent_key") as? Continent
        continent?.let {
            countries = it.countries
            setupRecyclerView()
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerViewCountries.layoutManager = LinearLayoutManager(context)
        val adapter = CountriesAdapter(countries) { country ->
            val bundle = Bundle().apply {
                putSerializable("country_key", country)
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, DetailFragment::class.java, bundle)
                .addToBackStack(null)
                .commit()
        }
        binding.recyclerViewCountries.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
