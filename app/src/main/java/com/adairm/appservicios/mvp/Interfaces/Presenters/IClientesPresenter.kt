package com.adairm.appservicios.mvp.Interfaces.Presenters

import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto

interface IClientesPresenter {
    suspend fun getClientes(cliente: ArrayList<Cliente>)
    suspend fun mostrarClientes()
}