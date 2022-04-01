package com.example.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.room.data.User
import com.example.room.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(
            layoutInflater, container, false
        )
        binding.buttonCadastrar.setOnClickListener {
            addUsuario()

        }
        viewModel = UserViewModel(context)

        return binding.root
    }
    fun addUsuario(){
        val editNome = binding.editNome.text.toString()
        val editSobrenome = binding.editSobreNome.text.toString()
        val editIdade = binding.editTextNumber.text.toString()

        if(validar(editNome, editSobrenome, editIdade)){
            val user = User(
                0, editNome, editSobrenome, editIdade.toInt()
            )
            viewModel.addUser(user)
            Toast.makeText(
                context, "Usuario Salvo",
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_add_Fragment_to_list_Fragment2)
        }else{
            Toast.makeText(
                context, "Preecha os campos corretamente!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    fun validar(nome: String, sobrenome: String, idade: String): Boolean{
    return !(nome.isEmpty() || sobrenome.isEmpty() || idade.isEmpty())
    }
}