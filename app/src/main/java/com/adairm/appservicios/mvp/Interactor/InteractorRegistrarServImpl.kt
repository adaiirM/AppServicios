package com.adairm.appservicios.mvp.Interactor

import android.content.Context
import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto
import com.adairm.appservicios.DataBase.Repository.GestionServiciosRepository
import com.adairm.appservicios.mvp.Interfaces.Interactors.IRegistroServiciosInteractor
import com.adairm.appservicios.mvp.Interfaces.Presenters.IRegistrarServiciosPresenter

class InteractorRegistrarServImpl (presenter: IRegistrarServiciosPresenter, context: Context): IRegistroServiciosInteractor {
    private val presenter: IRegistrarServiciosPresenter
    private var db: GestionServiciosRepository

    init {
        this.presenter = presenter
        GestionServiciosRepository.inicializar(context)
        db = GestionServiciosRepository.get()
    }

    override suspend fun buscarCliente(nombreC: String) {
        val clientes = db.findByName(nombreC) as ArrayList<Cliente>
        presenter.devolverClientes(clientes)
    }

    override suspend fun insertar(pagosRegistrados: PagosRegistrados) {
        db.insertPago(pagosRegistrados)
    }


}