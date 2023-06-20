package com.adairm.appservicios.mvp.interactor

import android.content.Context
import com.adairm.appservicios.dataBase.entidades.Cliente
import com.adairm.appservicios.dataBase.repository.GestionServiciosRepository
import com.adairm.appservicios.mvp.interfaces.interactors.IRegistrarClienteInteractor
import com.adairm.appservicios.mvp.interfaces.presenters.IRegistrarClientePresenter

class InteractorRegistroClientesImpl(presenter: IRegistrarClientePresenter, context: Context) :
    IRegistrarClienteInteractor {
    private val presenter: IRegistrarClientePresenter
    private var db: GestionServiciosRepository

    init {
        this.presenter = presenter
        GestionServiciosRepository.inicializar(context)
        db = GestionServiciosRepository.get()
    }


    override suspend fun insertar(cliente: Cliente) {
        db.insert(cliente)
    }
}