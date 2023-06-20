package com.adairm.appservicios.mvp.presenter

import android.content.Context
import com.adairm.appservicios.dataBase.entidades.PagosRegistrados
import com.adairm.appservicios.dataBase.entidades.ServiciosPendientesDto
import com.adairm.appservicios.mvp.interactor.InteractorInicioImpl
import com.adairm.appservicios.mvp.interfaces.interactors.IInicioInteractor
import com.adairm.appservicios.mvp.interfaces.presenters.IInicioPresenter
import com.adairm.appservicios.mvp.interfaces.views.IInicioActivity

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