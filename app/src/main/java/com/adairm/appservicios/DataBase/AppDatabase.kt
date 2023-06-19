package com.adairm.appservicios.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adairm.appservicios.DataBase.DAOs.AdminDao
import com.adairm.appservicios.DataBase.DAOs.ClienteDao
import com.adairm.appservicios.DataBase.DAOs.PagosRegistradosDao
import com.adairm.appservicios.DataBase.Entidades.Admin
import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados

//Referencia de clase

@Database(entities = [Admin::class, Cliente::class, PagosRegistrados::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun adminDao(): AdminDao
    abstract fun pagosRegistradosDao(): PagosRegistradosDao
    abstract fun clienteDao(): ClienteDao

}