package com.adairm.appservicios.mvp.interfaces.presenters

import com.adairm.appservicios.dataBase.entidades.Cliente

interface IRegistrarClientePresenter {
    suspend fun insertar(cliente: Cliente)
}