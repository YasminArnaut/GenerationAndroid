package com.example.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.room.adapter.UserAdapter
import com.example.room.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var mainViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(
            layoutInflater, container, false
        )

        val adapter = UserAdapter()

        mainViewModel = UserViewModel(context)
        mainViewModel.lerTodosOsDados.observe(viewLifecycleOwner){
            adapter.setList(it)
        }

        binding.recyclerUser.layoutManager = LinearLayoutManager(context)
        binding.recyclerUser.adapter = adapter
        binding.recyclerUser.setHasFixedSize(true)

        binding.floatingAdd.setOnClickListener{
            findNavController().navigate(R.id.action_list_Fragment_to_add_Fragment2)
        }

        return binding.root
    }

}