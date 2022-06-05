package com.example.busic.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter

import com.example.busic.databinding.ListViewItemBinding
import com.example.busic.data.PotterBukuItem
import com.example.busic.databinding.ListBukuItemBinding

class BukuListAdapter(private val clickListener: BukuListener) :
    ListAdapter<PotterBukuItem, BukuListAdapter.BukuViewHolder>(DiffCallback)
{
    class BukuViewHolder(
        var binding: ListBukuItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: BukuListener, buku: PotterBukuItem){
            binding.buku = buku
            binding.clickListener = clickListener
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PotterBukuItem>(){
        override fun areItemsTheSame(oldItem: PotterBukuItem, newItem: PotterBukuItem): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: PotterBukuItem, newItem: PotterBukuItem): Boolean {
            return oldItem.gender == newItem.gender && oldItem.image == newItem.image
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : BukuViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BukuViewHolder(
            ListBukuItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BukuViewHolder, position: Int){
        val buku = getItem(position)
        holder.bind(clickListener, buku)
    }
}

class BukuListener(val clickListener: (buku: PotterBukuItem ) -> Unit){
    fun onClick(buku: PotterBukuItem) = clickListener(buku)
}