package com.bhaumikghodasara.pokemon.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bhaumikghodasara.data.models.PokemonMasterData
import com.bhaumikghodasara.domain.entities.PokemonDetailData
import com.bhaumikghodasara.domain.entities.Types
import com.bhaumikghodasara.pokemon.R
import com.bhaumikghodasara.pokemon.util.Constants
import com.bhaumikghodasara.pokemon.util.Constants.IMG_ID_FORMAT
import com.bhaumikghodasara.pokemon.util.Utils
import com.bhaumikghodasara.pokemon.util.capitalizeFirstCharacter
import com.bhaumikghodasara.pokemon.util.loadImage

class PokemonListAdapter(
    private val pokemonData: HashMap<String, PokemonMasterData>,
    private val onItemClick: OnItemClick
) :
    RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {
    private lateinit var getContext: Context
    private var dataKey = pokemonData.keys.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        getContext = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataKey = dataKey[position]
        val itemData = pokemonData[dataKey]
        setImageBackground(holder.parentView, itemData?.pokemonDetailData)
        itemData?.pokemonDetailData?.name?.let {
            holder.pokemonName.text = itemData.pokemonDetailData?.name!!.capitalizeFirstCharacter()
        }
        holder.pokemonId.text = String.format(IMG_ID_FORMAT, itemData?.pokemonDetailData?.id)

        holder.pokemonImage.loadImage(
            "${Constants.BASE_IMAGE_URL}${itemData?.pokemonDetailData?.id}${Constants.IMG_EXTENSION}",
            R.drawable.ic_pokemon
        )

        holder.parentView.setOnClickListener {
            onItemClick.onItemClicked(position, itemData?.pokemonDetailData?.name!!)
        }
    }

    private fun setImageBackground(
        gradientView: ConstraintLayout,
        pokemonDetailData: PokemonDetailData?,
    ) {
        val typesList = pokemonDetailData?.types?.map { types: Types -> types.type?.name }
        if (typesList != null) {
            gradientView.background = Utils().getGradientColors(
                getContext,
                typesList.toMutableList()
            )
        }
    }

    override fun getItemCount(): Int {
        return dataKey.size
    }

    interface OnItemClick {
        fun onItemClicked(position: Int, pokemonName: String)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pokemonImage: ImageView = itemView.findViewById(R.id.pokemon_image)
        val pokemonName: TextView = itemView.findViewById(R.id.pokemon_name)
        val pokemonId: TextView = itemView.findViewById(R.id.pokemon_id)
        val parentView: ConstraintLayout = itemView.findViewById(R.id.item_view)
    }
}