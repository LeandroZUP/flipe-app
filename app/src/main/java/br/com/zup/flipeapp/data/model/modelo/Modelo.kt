package br.com.zup.flipeapp.data.model.modelo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Modelo(
    @SerializedName("codigo")
    val codigo: Int,
    @SerializedName("nome")
    val nome: String
): Parcelable