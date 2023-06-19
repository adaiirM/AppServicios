package com.adairm.appservicios.mvp.Presenter

import android.content.Context
import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto
import com.adairm.appservicios.mvp.Interactor.InteractorClientesImpl
import com.adairm.appservicios.mvp.Interactor.InteractorInicioImpl
import com.adairm.appservicios.mvp.Interfaces.Interactors.IClienesInteractor
import com.adairm.appservicios.mvp.Interfaces.Interactors.IInicioInteractor
import com.adairm.appservicios.mvp.Interfaces.Presenters.IClientesPresenter
import com.adairm.appservicios.mvp.Interfaces.Presenters.IInicioPresenter
import com.adairm.appservicios.mvp.Interfaces.Views.IClientesActivity
import com.adairm.appservicios.mvp.Interfaces.Views.IInicioActivity

class PresenterClientesActivity (view: IClientesActivity, context: Context): IClientesPresenter {
    private val view: IClientesActivity
    private val interactor: IClienesInteractor

    init {
        interactor = InteractorClientesImpl(this, context)
        this.view = view
    }

    override suspend fun getClientes(cliente: ArrayList<Cliente>) {
        view.mostrarClientes(cliente)
    }

    override suspend fun mostrarClientes() {
        interactor.getClientes()
    }
}