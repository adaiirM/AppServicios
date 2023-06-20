package com.adairm.appservicios.mvp.Interfaces.Interactors

import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados

interface IInicioInteractor {
    suspend fun getPagosPendientes()

    suspend fun buscarPorId(id: Int)

    suspend fun updatePago(pagoRegistrado: PagosRegistrados)
}