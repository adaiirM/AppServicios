package com.adairm.appservicios.mvp.Interfaces.Presenters

import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto

interface IRegistrarServiciosPresenter {
    suspend fun buscarClientes(nombreC: String)
    suspend fun devolverClientes(clientes: ArrayList<Cliente>)

    suspend fun insertar(pagosRegistrados: PagosRegistrados)

}