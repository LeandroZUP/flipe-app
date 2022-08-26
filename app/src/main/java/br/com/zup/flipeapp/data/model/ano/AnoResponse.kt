package br.com.zup.flipeapp.data.model.ano

import com.google.gson.annotations.SerializedName

class AnoResponse(
    @SerializedName("Anos")
    val anos: ArrayList<Ano>
)