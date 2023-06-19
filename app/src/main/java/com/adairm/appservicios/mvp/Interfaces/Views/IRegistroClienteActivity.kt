package com.adairm.appservicios.mvp.Interfaces.Views

import com.adairm.appservicios.DataBase.Entidades.Cliente

interface IRegistroClienteActivity {
    suspend fun insertar(cliente: Cliente)
}