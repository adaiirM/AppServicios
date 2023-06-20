package com.adairm.appservicios.mvp.interfaces.interactors

interface IListaServiciosInteractor {
    suspend fun buscarPorNombre(nombreC: String)

    suspend fun buscarPorId(id: Int)
}