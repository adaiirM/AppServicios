package com.adairm.appservicios.DataBase.DAOs

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adairm.appservicios.DataBase.Entidades.Cliente

@Dao
interface ClienteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cliente: Cliente)

    @Query("SELECT * FROM clientes")
    suspend fun getAll(): List<Cliente>

    @Query("SELECT * FROM clientes WHERE nombre_completo LIKE :nombreCompleto")
    suspend fun findByName(nombreCompleto: String): List<Cliente>
}



