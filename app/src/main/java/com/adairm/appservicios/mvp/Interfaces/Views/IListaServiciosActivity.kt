package com.adairm.appservicios.mvp.Interfaces.Views

import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados

interface IListaServiciosActivity {
    suspend fun devolverClientes(clientes: ArrayList<Cliente>)

    suspend fun devolverPagos(pagos: ArrayList<PagosRegistrados>)
}