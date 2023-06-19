package com.adairm.appservicios.mvp.Interactor

import android.content.Context
import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto
import com.adairm.appservicios.DataBase.Repository.GestionServiciosRepository
import com.adairm.appservicios.mvp.Interfaces.Interactors.IClienesInteractor
import com.adairm.appservicios.mvp.Interfaces.Interactors.IInicioInteractor
import com.adairm.appservicios.mvp.Interfaces.Presenters.IClientesPresenter
import com.adairm.appservicios.mvp.Interfaces.Presenters.IInicioPresenter

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