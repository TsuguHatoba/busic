package com.example.busic.ui.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.busic.databinding.FragmentBookListBinding
import com.example.busic.ui.book.BookViewModel
import com.example.busic.R
import com.example.busic.adapter.BookListAdapter
import com.example.busic.adapter.BookListener
import com.google.android.material.divider.MaterialDividerItemDecoration

class BookListFragment : Fragment(){
    private val viewModel: BookViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val binding = FragmentBookListBinding.inflate(inflater)
        val binding = FragmentBookListBinding.inflate(inflater)
        viewModel.getBookList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = BookListAdapter(BookListener { book ->
            viewModel.onBookClicked(book)
            findNavController()
                .navigate(R.id.action_bookListFragment_to_bookDetailFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "Harry Pottah"
        // menambahkan dekorasi garis bawah
        binding.recyclerView.addItemDecoration(MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        return binding.root
    }
}