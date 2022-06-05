package com.example.busic.ui.buku

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.busic.databinding.FragmentBukuListBinding
import com.example.busic.ui.buku.BukuViewModel
import com.example.busic.R
import com.example.busic.adapter.BukuListAdapter
import com.example.busic.adapter.BukuListener
import com.google.android.material.divider.MaterialDividerItemDecoration

class BukuListFragment : Fragment(){
    private val viewModel: BukuViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val binding = FragmentBukuListBinding.inflate(inflater)
        val binding = FragmentBukuListBinding.inflate(inflater)
        viewModel.getBukuList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = BukuListAdapter(BukuListener { buku ->
            viewModel.onBukuClicked(buku)
            findNavController()
                .navigate(R.id.action_bukuListFragment_to_bukuDetailFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "Character"
        // menambahkan dekorasi garis bawah
        binding.recyclerView.addItemDecoration(MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        return binding.root
    }
}