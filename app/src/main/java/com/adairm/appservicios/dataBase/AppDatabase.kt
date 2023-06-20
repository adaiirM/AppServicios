package com.adairm.appservicios.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adairm.appservicios.dataBase.daos.ClienteDao
import com.adairm.appservicios.dataBase.daos.PagosRegistradosDao
import com.adairm.appservicios.dataBase.entidades.Cliente
import com.adairm.appservicios.dataBase.entidades.PagosRegistrados

//Referencia de clase

@Database(entities = [Cliente::class, PagosRegistrados::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun pagosRegistradosDao(): PagosRegistradosDao
    abstract fun clienteDao(): ClienteDao
}

