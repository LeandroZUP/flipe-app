package br.com.zup.flipeapp.data.model.marca

import com.google.gson.annotations.SerializedName

data class MarcaResponse (
    @SerializedName("Marcas")
    val marcas: ArrayList<Marca>
)