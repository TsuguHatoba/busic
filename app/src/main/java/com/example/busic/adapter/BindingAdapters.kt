package com.example.busic.adapter

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.busic.R
import com.example.busic.data.PotterBookItem
import com.example.busic.data.PotterBukuItem
import com.example.busic.ui.book.BookApiStatus
import com.example.busic.ui.buku.BukuApiStatus


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<PotterBookItem>?){
    val adapter = recyclerView.adapter as BookListAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDatas")
fun bindRecyclerViews(recyclerView: RecyclerView, data: List<PotterBukuItem>?){
    val adapter = recyclerView.adapter as BukuListAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: BookApiStatus?) {
    when(status) {
        BookApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        BookApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        BookApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}

@BindingAdapter("apiStatuses")
fun bindStatus(statusImageView: ImageView, status: BukuApiStatus?) {
    when(status) {
        BukuApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        BukuApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        BukuApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}