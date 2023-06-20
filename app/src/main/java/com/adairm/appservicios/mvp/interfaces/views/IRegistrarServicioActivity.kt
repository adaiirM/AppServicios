package com.adairm.appservicios.mvp.interfaces.views

import com.adairm.appservicios.dataBase.entidades.Cliente
import com.adairm.appservicios.dataBase.entidades.PagosRegistrados

interface IRegistrarServicioActivity {
    suspend fun devolverClientes(clientes: ArrayList<Cliente>)
    suspend fun insertar(pagosRegistrados: PagosRegistrados)
}