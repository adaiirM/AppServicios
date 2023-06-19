package com.adairm.appservicios.mvp.Presenter

import android.content.Context
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
}