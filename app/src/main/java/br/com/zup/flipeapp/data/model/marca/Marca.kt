package br.com.zup.flipeapp.data.model.marca

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Marca(
    @SerializedName("codigo")
    val codigo: String,
    @SerializedName("nome")
    val nome: String
): Parcelable