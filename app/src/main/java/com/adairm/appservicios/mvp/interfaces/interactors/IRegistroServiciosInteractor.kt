package com.adairm.appservicios.mvp.interfaces.interactors

import com.adairm.appservicios.dataBase.entidades.PagosRegistrados

interface IRegistroServiciosInteractor {
    suspend fun buscarCliente(nombreC: String)

    suspend fun insertar(pagosRegistrados: PagosRegistrados)

}