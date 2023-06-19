package com.adairm.appservicios.DataBase.Entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.jar.Attributes.Name

@Entity(tableName = "admin")

data class Admin(@ColumnInfo(name = "id_admin") @PrimaryKey(autoGenerate = true) val idAdmin: Int){

    @ColumnInfo(name = "nombre_cliente") lateinit var nombreAdmin: String
    @ColumnInfo(name = "apellido_paterno") lateinit var password: String

    constructor(
        nombreAdmin: String,
        password: String,

    ) : this(0){
        this.nombreAdmin = nombreAdmin
        this.password = password
    }
}
