package com.adairm.appservicios.mvp.Presenter

import android.content.Context
import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto
import com.adairm.appservicios.mvp.Interactor.InteractorInicioImpl
import com.adairm.appservicios.mvp.Interfaces.Interactors.IInicioInteractor
import com.adairm.appservicios.mvp.Interfaces.Presenters.IInicioPresenter
import com.adairm.appservicios.mvp.Interfaces.Views.IInicioActivity

class PresenterInicioActivity (view: IInicioActivity, context: Context): IInicioPresenter{
    private val view: IInicioActivity
    private val interactor: IInicioInteractor

    init {
        interactor = InteractorInicioImpl(this, context)
        this.view = view
    }

    override suspend fun mostrarPagos() {
        interactor.getPagosPendientes()
    }

    override suspend fun getPagosPendientes(serviciosPendientes: ArrayList<ServiciosPendientesDto>) {
        view.mostrarPagosR(serviciosPendientes)
    }

    override suspend fun buscarPorId(id: Int) {
        interactor.buscarPorId(id)
    }

    override suspend fun devolverPago(pagoRegistrado: PagosRegistrados) {
        view.devolverPago(pagoRegistrado)
    }

    override suspend fun updatePago(pagoRegistrado: PagosRegistrados) {
        interactor.updatePago(pagoRegistrado)
    }
}