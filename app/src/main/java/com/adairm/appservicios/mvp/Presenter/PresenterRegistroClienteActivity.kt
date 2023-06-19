package com.adairm.appservicios.mvp.Presenter

import android.content.Context
import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto
import com.adairm.appservicios.mvp.Interactor.InteractorInicioImpl
import com.adairm.appservicios.mvp.Interactor.InteractorRegistroClientesImpl
import com.adairm.appservicios.mvp.Interfaces.Interactors.IInicioInteractor
import com.adairm.appservicios.mvp.Interfaces.Interactors.IRegistrarClienteInteractor
import com.adairm.appservicios.mvp.Interfaces.Presenters.IInicioPresenter
import com.adairm.appservicios.mvp.Interfaces.Presenters.IRegistrarClientePresenter
import com.adairm.appservicios.mvp.Interfaces.Views.IInicioActivity
import com.adairm.appservicios.mvp.Interfaces.Views.IRegistroClienteActivity

class PresenterRegistroClienteActivity (view: IRegistroClienteActivity, context: Context): IRegistrarClientePresenter {
    private val view: IRegistroClienteActivity
    private val interactor: IRegistrarClienteInteractor

    init {
        interactor = InteractorRegistroClientesImpl(this, context)
        this.view = view
    }

    override suspend fun insertar(cliente: Cliente) {
        interactor.insertar(cliente)
    }
}