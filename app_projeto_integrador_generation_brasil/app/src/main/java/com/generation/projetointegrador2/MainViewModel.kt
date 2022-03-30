package com.generation.projetointegrador2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.projetointegrador2.model.Postagem
import com.generation.projetointegrador2.model.Tema
import com.generation.projetointegrador2.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: Repository): ViewModel() {

        private val _myTemaResponse = MutableLiveData<Response<List<Tema>>>()

        val myTemaResponse: LiveData<Response<List<Tema>>> = _myTemaResponse

        private val _myPostagemResponse = MutableLiveData<Response<List<Postagem>>>()

        val myPostagemResponse: LiveData<Response<List<Postagem>>> = _myPostagemResponse

    val dataSelecionada = MutableLiveData<LocalDate>()
    //val horaSelecionada = MutableLiveData<DateTime>()

    init {
        dataSelecionada.value = LocalDate.now()
        listTema()
    }


    fun listTema(){
        viewModelScope.launch {
            try {
                val response = repository.listTema()
                _myTemaResponse.value = response
            }catch (e: Exception){
                Log.d("Error", e.message.toString())
            }
        }
    }

    fun addPostagem(postagem: Postagem){
        viewModelScope.launch {
            try {
                repository.addPostagem(postagem)
                listTema()
            } catch (e: Exception) {
                Log.d("Error", e.message.toString())
            }

        }
    }

    fun listPostagem(){
        viewModelScope.launch {
            try {
                val response = repository.listPostagem()
                _myPostagemResponse.value = response
            } catch (e: Exception) {
                Log.e("Developer", "error", e)
            }
        }
    }

}