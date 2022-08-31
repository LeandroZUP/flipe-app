package br.com.zup.flipeapp.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zup.flipeapp.data.model.veiculo.VeiculoEntity

@Dao
interface VeiculoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveVeiculoBookmarkDB (veiculo: VeiculoEntity)

    @Query("SELECT * from tabela_fipe")
    fun getAllBookmarkVeiculo(): List <VeiculoEntity>

    @Query("DELETE FROM tabela_fipe WHERE codigoFipe = :codFipe")
    fun deleteVeiculoBookmarkDB(codFipe: String)
}