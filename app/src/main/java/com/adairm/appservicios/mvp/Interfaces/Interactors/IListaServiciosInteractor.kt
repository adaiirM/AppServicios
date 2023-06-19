package com.adairm.appservicios.mvp.Interfaces.Interactors

interface IListaServiciosInteractor {
    suspend fun buscarPorNombre(nombreC: String)

    suspend fun buscarPorId(id: Int)
}