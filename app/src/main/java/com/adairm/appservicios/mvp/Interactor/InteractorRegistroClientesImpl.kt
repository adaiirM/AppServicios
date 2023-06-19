package com.adairm.appservicios.mvp.Interactor

import android.content.Context
import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Repository.GestionServiciosRepository
import com.adairm.appservicios.mvp.Interfaces.Interactors.IClienesInteractor
import com.adairm.appservicios.mvp.Interfaces.Interactors.IRegistrarClienteInteractor
import com.adairm.appservicios.mvp.Interfaces.Presenters.IClientesPresenter
import com.adairm.appservicios.mvp.Interfaces.Presenters.IRegistrarClientePresenter

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