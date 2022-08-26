package br.com.zup.flipeapp.domain.repository

import br.com.zup.flipeapp.data.datasource.remote.RetrofitService
import br.com.zup.flipeapp.data.model.marca.MarcaResponse
import br.com.zup.flipeapp.data.model.modelo.ModeloResponse

class FipeRepository {
    suspend fun getMarcas(): MarcaResponse = RetrofitService.apiService.getMarcas()
}