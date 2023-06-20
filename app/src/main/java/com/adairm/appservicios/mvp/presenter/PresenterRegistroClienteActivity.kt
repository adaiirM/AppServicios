package com.adairm.appservicios.mvp.presenter

import android.content.Context
import com.adairm.appservicios.dataBase.entidades.Cliente
import com.adairm.appservicios.mvp.interactor.InteractorRegistroClientesImpl
import com.adairm.appservicios.mvp.interfaces.interactors.IRegistrarClienteInteractor
import com.adairm.appservicios.mvp.interfaces.presenters.IRegistrarClientePresenter
import com.adairm.appservicios.mvp.interfaces.views.IRegistroClienteActivity

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