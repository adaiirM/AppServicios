package com.adairm.appservicios.mvp.presenter

import android.content.Context
import com.adairm.appservicios.dataBase.entidades.Cliente
import com.adairm.appservicios.dataBase.entidades.PagosRegistrados
import com.adairm.appservicios.mvp.interactor.InteractorListaServicioImpl
import com.adairm.appservicios.mvp.interfaces.interactors.IListaServiciosInteractor
import com.adairm.appservicios.mvp.interfaces.presenters.IListaServiciosPresenter
import com.adairm.appservicios.mvp.interfaces.views.IListaServiciosActivity

class PresenterListaServicioActivity (view: IListaServiciosActivity, context: Context): IListaServiciosPresenter {
    private val view: IListaServiciosActivity
    private val interactor: IListaServiciosInteractor

    init {
        interactor = InteractorListaServicioImpl(this, context)
        this.view = view
    }

    override suspend fun buscarPorNombre(nombreC: String) {
        interactor.buscarPorNombre(nombreC)
    }

    override suspend fun devolverClientes(clientes: ArrayList<Cliente>) {
        view.devolverClientes(clientes)
    }

    override suspend fun buscarPorId(id: Int) {
        interactor.buscarPorId(id)
    }

    override suspend fun devolverPagos(pagosRegistrados: ArrayList<PagosRegistrados>) {
        view.devolverPagos(pagosRegistrados)
    }


}