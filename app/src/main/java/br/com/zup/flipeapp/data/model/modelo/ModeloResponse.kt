package br.com.zup.flipeapp.data.model.modelo

import com.google.gson.annotations.SerializedName

data class ModeloResponse(
    @SerializedName("Modelos")
    val modelos: ArrayList<Modelo>
)