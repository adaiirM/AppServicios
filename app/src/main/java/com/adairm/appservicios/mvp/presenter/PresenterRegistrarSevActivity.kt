package com.adairm.appservicios.mvp.presenter

import android.content.Context
import com.adairm.appservicios.dataBase.entidades.Cliente
import com.adairm.appservicios.dataBase.entidades.PagosRegistrados
import com.adairm.appservicios.mvp.interactor.InteractorRegistrarServImpl
import com.adairm.appservicios.mvp.interfaces.interactors.IRegistroServiciosInteractor
import com.adairm.appservicios.mvp.interfaces.presenters.IRegistrarServiciosPresenter
import com.adairm.appservicios.mvp.interfaces.views.IRegistrarServicioActivity

class PresenterRegistrarSevActivity (view: IRegistrarServicioActivity, context: Context): IRegistrarServiciosPresenter {
    private val view: IRegistrarServicioActivity
    private val interactor: IRegistroServiciosInteractor

    init {
        interactor = InteractorRegistrarServImpl(this, context)
        this.view = view
    }

    override suspend fun buscarClientes(nombreC: String) {
        interactor.buscarCliente(nombreC)
    }

    override suspend fun devolverClientes(clientes: ArrayList<Cliente>) {
        view.devolverClientes(clientes)
    }

    override suspend fun insertar(pagosRegistrados: PagosRegistrados) {
        interactor.insertar(pagosRegistrados)
    }
}