package br.com.zup.flipeapp.data.model.modelo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ano(
    @SerializedName("codigo")
    val codigo: String,
    @SerializedName("nome")
    val nome: String
): Parcelable