package com.adairm.appservicios.mvp.interfaces.interactors

import com.adairm.appservicios.dataBase.entidades.PagosRegistrados

interface IInicioInteractor {
    suspend fun getPagosPendientes()

    suspend fun buscarPorId(id: Int)

    suspend fun updatePago(pagoRegistrado: PagosRegistrados)
}