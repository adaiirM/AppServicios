package com.adairm.appservicios.mvp.interfaces.interactors

import com.adairm.appservicios.dataBase.entidades.Cliente

interface IRegistrarClienteInteractor {
    suspend fun insertar(cliente: Cliente)
}