package com.adairm.appservicios.mvp.interfaces.presenters

import com.adairm.appservicios.dataBase.entidades.Cliente

interface IClientesPresenter {
    suspend fun getClientes(cliente: ArrayList<Cliente>)
    suspend fun mostrarClientes()
}