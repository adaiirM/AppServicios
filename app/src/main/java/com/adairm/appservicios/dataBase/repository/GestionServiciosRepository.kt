package com.adairm.appservicios.dataBase.repository

import android.content.Context
import androidx.room.Room
import com.adairm.appservicios.dataBase.AppDatabase
import com.adairm.appservicios.dataBase.entidades.Cliente
import com.adairm.appservicios.dataBase.entidades.PagosRegistrados

private const val DATA_BASE_NAME = "gestion-servicios-daabase.db"

class GestionServiciosRepository private constructor(context: Context){

    private val dbRoom: AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase:: class.java,
        DATA_BASE_NAME
    ).build()

    private val clienteDao = dbRoom.clienteDao()
    private val pagosRegistradosDao = dbRoom.pagosRegistradosDao()

    //Metodo del cliente
    suspend fun insert(cliente: Cliente)  = clienteDao.insert(cliente = cliente)
    suspend fun findByName(nombreCompleto: String) = clienteDao.findByName(nombreCompleto)
    suspend fun getAllClientes() = clienteDao.getAll()

    //Metodo de los pagos registrados
    suspend fun insertPago(pagosRegistrados: PagosRegistrados) = pagosRegistradosDao.insert(pagosRegistrados)
    suspend fun findByIdEstado(id: Int, estadoPago: String) = pagosRegistradosDao.findByIdEstado(id, estadoPago)
    suspend fun findByEstado(estadoPago: String) = pagosRegistradosDao.findByEstado(estadoPago)
    suspend fun findById(id: Int) = pagosRegistradosDao.findById(id)
    suspend fun updateEstado(pagoRegistrado: PagosRegistrados) = pagosRegistradosDao.updateEstado(pagoRegistrado)

    companion object{
        private var INSTANCE: GestionServiciosRepository? = null

        fun inicializar(context: Context){
            if(INSTANCE == null){
                INSTANCE = GestionServiciosRepository(context)
            }
        }

        fun get(): GestionServiciosRepository{
            return INSTANCE ?: throw IllegalStateException("GestionServiciosRepository debe ser inicializado")
        }
    }
}