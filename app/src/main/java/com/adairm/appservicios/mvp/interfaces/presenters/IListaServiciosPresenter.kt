package com.adairm.appservicios.mvp.interfaces.presenters

import com.adairm.appservicios.dataBase.entidades.Cliente
import com.adairm.appservicios.dataBase.entidades.PagosRegistrados

interface IListaServiciosPresenter {
    suspend fun buscarPorNombre(nombreC: String)
    suspend fun devolverClientes(clientes: ArrayList<Cliente>)

    suspend fun buscarPorId(id: Int)
    suspend fun devolverPagos(pagosRegistrados: ArrayList<PagosRegistrados>)
}