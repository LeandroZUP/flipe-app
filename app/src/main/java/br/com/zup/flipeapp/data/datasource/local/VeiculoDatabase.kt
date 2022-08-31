package br.com.zup.flipeapp.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.zup.flipeapp.data.datasource.local.dao.VeiculoDao
import br.com.zup.flipeapp.data.model.veiculo.VeiculoEntity

@Database(entities = [VeiculoEntity::class], version = 1)
abstract class VeiculoDatabase : RoomDatabase() {
    abstract fun veiculoDao(): VeiculoDao

    companion object {
        @Volatile
        private var INSTANCE: VeiculoDatabase? = null

        fun getDatabase(context: Context): VeiculoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VeiculoDatabase::class.java,
                    "veiculo_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}