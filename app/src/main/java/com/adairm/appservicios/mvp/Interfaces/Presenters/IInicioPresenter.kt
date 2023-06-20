package com.adairm.appservicios.mvp.Interfaces.Presenters

import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto

interface IInicioPresenter {
    suspend fun getPagosPendientes(serviciosPendientes: ArrayList<ServiciosPendientesDto>)
    suspend fun mostrarPagos()

    suspend fun buscarPorId(id: Int)
    suspend fun devolverPago(pagoRegistrado: PagosRegistrados)

    suspend fun updatePago(pagoRegistrado: PagosRegistrados)
}