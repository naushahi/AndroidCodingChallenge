package com.example.otchallenge.ui.bookslisting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.otchallenge.data.model.Book
import com.example.otchallenge.databinding.ItemBookBinding

class BooksListingAdapter: RecyclerView.Adapter<BooksListingAdapter.BooksAdapterViewHolder>() {
    class BooksAdapterViewHolder(var binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    private val diffUtil = object : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book):
                Boolean {
            return oldItem.bookUri == newItem.bookUri
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book):
                Boolean {
            return oldItem == newItem
        }
    }

    private val asyncListDiffer = AsyncListDiffer(this, diffUtil)

    fun saveData( dataResponse: List<Book>?){
        asyncListDiffer.submitList(dataResponse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            BooksAdapterViewHolder{
        val binding =
            ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BooksAdapterViewHolder(binding)}

    override fun onBindViewHolder(holder: BooksAdapterViewHolder, position: Int) {
        val data = asyncListDiffer.currentList[position]
        holder.binding.book = data
        holder.binding.apply {
            Glide
                .with(holder.itemView.context)
                .load(data.bookImage)
                .centerCrop()
                .into(img)
        }
    }

    override fun getItemCount(): Int {
        return asyncListDiffer.currentList.size
    }
}