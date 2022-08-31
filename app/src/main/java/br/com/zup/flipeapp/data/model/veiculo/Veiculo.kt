package br.com.zup.flipeapp.data.model.veiculo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Veiculo(
    @SerializedName("AnoModelo")
    val anoModelo: Int,
    @SerializedName("CodigoFipe")
    val codigoFipe: String,
    @SerializedName("Combustivel")
    val combustivel: String,
    @SerializedName("Marca")
    val marca: String,
    @SerializedName("MesReferencia")
    val mesReferencia: String,
    @SerializedName("Modelo")
    val modelo: String,
    @SerializedName("SiglaCombustivel")
    val siglaCombustivel: String,
    @SerializedName("TipoVeiculo")
    val tipoVeiculo: Int,
    @SerializedName("Valor")
    val valor: String,
    var bookmarked: Boolean = false
): Parcelable