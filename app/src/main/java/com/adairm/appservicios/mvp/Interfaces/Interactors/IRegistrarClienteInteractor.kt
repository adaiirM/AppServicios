package com.adairm.appservicios.mvp.Interfaces.Interactors

import com.adairm.appservicios.DataBase.Entidades.Cliente

interface IRegistrarClienteInteractor {
    suspend fun insertar(cliente: Cliente)
}