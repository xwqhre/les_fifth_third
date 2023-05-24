package com

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.les_fifth_third.databinding.ItemImageBinding

class PixaAdapter (var list: ArrayList<ImageModel>) : Adapter<PixaAdapter.PixaViewHolder>(){

    class PixaViewHolder(var binding: ItemImageBinding) : ViewHolder(binding.root){
        fun onBind(imageModel: ImageModel) {
            binding.iamgePickView.load(imageModel.largeImageUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixaViewHolder {
        return PixaViewHolder(ItemImageBinding.inflate(LayoutInflater.from(
            parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PixaViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}