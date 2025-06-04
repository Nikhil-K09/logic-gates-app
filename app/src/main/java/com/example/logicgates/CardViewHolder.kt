package com.example.logicgates

import androidx.recyclerview.widget.RecyclerView
import com.example.logicgates.databinding.CardCellBinding

class CardViewHolder(
    private val cardCellBinding: CardCellBinding
) :RecyclerView.ViewHolder(cardCellBinding.root)
{
    fun bindGate(gate : Gate){
        cardCellBinding.cover.setImageResource(gate.cover)
        cardCellBinding.title.text=gate.title
    }
}