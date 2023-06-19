package com.adairm.appservicios.mvp.Interfaces.Presenters

import com.adairm.appservicios.DataBase.Entidades.Cliente

interface IRegistrarClientePresenter {
    suspend fun insertar(cliente: Cliente)
}