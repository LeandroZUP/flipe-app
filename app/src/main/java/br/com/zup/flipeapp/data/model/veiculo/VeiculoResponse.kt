package br.com.zup.flipeapp.data.model.veiculo

import com.google.gson.annotations.SerializedName

data class VeiculoResponse(
    @SerializedName("Veículo")
    val veiculo: ArrayList<Veiculo>
)
