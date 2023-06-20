package com.adairm.appservicios.dataBase.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clientes")

data class Cliente(@ColumnInfo(name = "id_cliente") @PrimaryKey(autoGenerate = true) val idCliente: Int){

    @ColumnInfo(name = "nombre_cliente") lateinit var nombreCliente: String
    @ColumnInfo(name = "apellido_paterno") lateinit var apellidoPaterno: String
    @ColumnInfo(name = "apellido_materno") lateinit var apellidoMaterno: String
    @ColumnInfo(name = "nombre_completo") lateinit var nombreCompleto: String
    @ColumnInfo(name = "edad") lateinit var edad: String
    @ColumnInfo(name = "telefono") lateinit var telefono: String
    @ColumnInfo(name = "correo") lateinit var correo: String

    constructor(
        nombreCliente: String,
        apellidoPaterno: String,
        apellidoMaterno: String,
        edad: String,
        telefono: String,
        correo: String

    ) : this(0){
        this.nombreCliente = nombreCliente
        this.apellidoPaterno = apellidoPaterno
        this.apellidoMaterno = apellidoMaterno
        this.nombreCompleto = "$nombreCliente $apellidoPaterno $apellidoMaterno"
        this.edad = edad
        this.telefono = telefono
        this.correo = correo
    }
}
