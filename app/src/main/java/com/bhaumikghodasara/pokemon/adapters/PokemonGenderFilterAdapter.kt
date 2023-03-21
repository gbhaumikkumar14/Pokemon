package com.bhaumikghodasara.pokemon.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bhaumikghodasara.pokemon.R
import com.bhaumikghodasara.pokemon.util.capitalizeFirstCharacter
import java.util.HashSet

class PokemonGenderFilterAdapter(
    private val genderResult: List<String?>,
    private val genderItemClickListener: GenderItemClickListener,
    private val genderSelect: HashSet<String>
) :
    RecyclerView.Adapter<PokemonGenderFilterAdapter.FilterViewHolder>() {

    class FilterViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var filterName: TextView = item.findViewById(R.id.filterName)
        var checkBox: CheckBox = item.findViewById(R.id.checkbox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.filter_item, parent, false)
        return FilterViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.filterName.text = genderResult[position]?.capitalizeFirstCharacter()
        holder.checkBox.isChecked = genderSelect.contains(genderResult[position])
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            genderResult[position]?.let {
                genderItemClickListener.onGenderItemClicked(
                    position,
                    it,
                    isChecked
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return genderResult.size
    }

    interface GenderItemClickListener {
        fun onGenderItemClicked(position: Int, genderName: String, isChecked: Boolean)
    }
}