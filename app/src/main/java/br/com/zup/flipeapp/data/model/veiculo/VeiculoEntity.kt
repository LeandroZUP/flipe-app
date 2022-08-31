package br.com.zup.flipeapp.data.model.veiculo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_fipe")
class VeiculoEntity(@PrimaryKey var codigoFipe: String)