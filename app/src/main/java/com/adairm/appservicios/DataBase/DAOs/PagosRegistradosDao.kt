package com.adairm.appservicios.DataBase.DAOs

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados

@Dao
interface PagosRegistradosDao {

    @Insert
    suspend fun insert(pagoRegistrado: PagosRegistrados)

    @Query("SELECT * FROM pagos_registrados")
    suspend fun getAll(): List<PagosRegistrados>

    @Query("SELECT * FROM pagos_registrados WHERE estado_pago = :estadoPago")
    suspend fun findByEstado(estadoPago: String): List<PagosRegistrados>

    @Update
    suspend fun updateEstado(pagoRegistrado: PagosRegistrados)

    @Query("SELECT * FROM pagos_registrados WHERE id_cliente = :id")
    suspend fun findById(id: Int): PagosRegistrados

    @Query("SELECT * FROM pagos_registrados WHERE id_cliente = :id and estado_pago = :estadoPago")
    suspend fun findByIdEstado(id: Int, estadoPago: String): List<PagosRegistrados>
}