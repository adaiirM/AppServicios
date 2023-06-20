package com.adairm.appservicios.mvp.presenter

import android.content.Context
import com.adairm.appservicios.dataBase.entidades.Cliente
import com.adairm.appservicios.mvp.interactor.InteractorClientesImpl
import com.adairm.appservicios.mvp.interfaces.interactors.IClienesInteractor
import com.adairm.appservicios.mvp.interfaces.presenters.IClientesPresenter
import com.adairm.appservicios.mvp.interfaces.views.IClientesActivity

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