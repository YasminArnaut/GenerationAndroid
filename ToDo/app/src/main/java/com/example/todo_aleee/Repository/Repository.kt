package com.example.todo_aleee.Repository

import com.example.todo_aleee.api.RetrofitInstance
import com.example.todo_aleee.model.Categoria
import retrofit2.Response

class Repository {

    suspend fun listCategoria(): Response<List<Categoria>> {
        return RetrofitInstance.api.listCategoria()
    }

}