package com.adairm.appservicios.mvp.Interfaces.Presenters

import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados

interface IListaServiciosPresenter {
    suspend fun buscarPorNombre(nombreC: String)
    suspend fun devolverClientes(clientes: ArrayList<Cliente>)

    suspend fun buscarPorId(id: Int)
    suspend fun devolverPagos(pagosRegistrados: ArrayList<PagosRegistrados>)
}