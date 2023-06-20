package com.adairm.appservicios.mvp.interactor

import android.content.Context
import com.adairm.appservicios.dataBase.entidades.Cliente
import com.adairm.appservicios.dataBase.repository.GestionServiciosRepository
import com.adairm.appservicios.mvp.interfaces.interactors.IClienesInteractor
import com.adairm.appservicios.mvp.interfaces.presenters.IClientesPresenter

class InteractorClientesImpl (presenter: IClientesPresenter, context: Context) : IClienesInteractor {
    private val presenter: IClientesPresenter
    private var db: GestionServiciosRepository

    init {
        this.presenter = presenter
        GestionServiciosRepository.inicializar(context)
        db = GestionServiciosRepository.get()
    }


    override suspend fun getClientes() {
        val clientes = db.getAllClientes() as ArrayList<Cliente>
        presenter.getClientes(clientes)
    }
}