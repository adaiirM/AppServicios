package com.adairm.appservicios.mvp.interfaces.presenters

import com.adairm.appservicios.dataBase.entidades.Cliente
import com.adairm.appservicios.dataBase.entidades.PagosRegistrados

interface IRegistrarServiciosPresenter {
    suspend fun buscarClientes(nombreC: String)
    suspend fun devolverClientes(clientes: ArrayList<Cliente>)

    suspend fun insertar(pagosRegistrados: PagosRegistrados)

}