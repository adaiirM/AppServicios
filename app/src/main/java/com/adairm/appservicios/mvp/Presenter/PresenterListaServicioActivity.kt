package com.adairm.appservicios.mvp.Presenter

import android.content.Context
import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados
import com.adairm.appservicios.mvp.Interactor.InteractorListaServicioImpl
import com.adairm.appservicios.mvp.Interfaces.Interactors.IListaServiciosInteractor
import com.adairm.appservicios.mvp.Interfaces.Presenters.IListaServiciosPresenter
import com.adairm.appservicios.mvp.Interfaces.Views.IListaServiciosActivity

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