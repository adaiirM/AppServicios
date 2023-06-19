package com.adairm.appservicios.mvp.Presenter

import android.content.Context
import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto
import com.adairm.appservicios.mvp.Interactor.InteractorRegistrarServImpl
import com.adairm.appservicios.mvp.Interfaces.Interactors.IRegistroServiciosInteractor
import com.adairm.appservicios.mvp.Interfaces.Presenters.IRegistrarServiciosPresenter
import com.adairm.appservicios.mvp.Interfaces.Views.IRegistrarServicioActivity

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