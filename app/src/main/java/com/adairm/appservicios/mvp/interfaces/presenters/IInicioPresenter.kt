package com.adairm.appservicios.mvp.interfaces.presenters

import com.adairm.appservicios.dataBase.entidades.PagosRegistrados
import com.adairm.appservicios.dataBase.entidades.ServiciosPendientesDto

interface IInicioPresenter {
    suspend fun getPagosPendientes(serviciosPendientes: ArrayList<ServiciosPendientesDto>)
    suspend fun mostrarPagos()

    suspend fun buscarPorId(id: Int)
    suspend fun devolverPago(pagoRegistrado: PagosRegistrados)

    suspend fun updatePago(pagoRegistrado: PagosRegistrados)
}