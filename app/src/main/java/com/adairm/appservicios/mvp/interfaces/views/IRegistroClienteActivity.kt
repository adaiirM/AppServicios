package com.adairm.appservicios.mvp.interfaces.views

import com.adairm.appservicios.dataBase.entidades.Cliente

interface IRegistroClienteActivity {
    suspend fun insertar(cliente: Cliente)
}