package com.example.logicgates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.logicgates.databinding.CardCellBinding

class CardAdapter(private val gates:List<Gate>)
    : RecyclerView.Adapter<CardViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val from =LayoutInflater.from(parent.context)
        val binding=CardCellBinding.inflate(from,parent,false)
        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int =gates.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindGate(gates[position])
    }
}