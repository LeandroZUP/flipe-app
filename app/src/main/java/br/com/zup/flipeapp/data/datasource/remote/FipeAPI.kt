package br.com.zup.flipeapp.data.datasource.remote

import br.com.zup.flipeapp.data.model.ano.AnoResponse
import br.com.zup.flipeapp.data.model.marca.MarcaResponse
import br.com.zup.flipeapp.data.model.modelo.ModeloResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface FipeAPI {

    @GET("/marcas/")
    suspend fun getMarcas(): MarcaResponse

    @GET("marcas/{marcas}/modelos")
    suspend fun getModelos(@Path("marcas") codMarca: Int): ModeloResponse

    @GET("marcas/{marcas}/modelos/{modelos}/anos")
    suspend fun getAnos(@Path("anos") codAno: Int): AnoResponse

    @GET("marcas/{marcas}/modelos/{modelos}/anos/{anos}/")
    suspend fun getVeiculo(codigoFipe: Int)

}