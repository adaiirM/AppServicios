package com.adairm.appservicios.mvp.interactor

import android.content.Context
import com.adairm.appservicios.dataBase.entidades.Cliente
import com.adairm.appservicios.dataBase.entidades.PagosRegistrados
import com.adairm.appservicios.dataBase.repository.GestionServiciosRepository
import com.adairm.appservicios.mvp.interfaces.interactors.IRegistroServiciosInteractor
import com.adairm.appservicios.mvp.interfaces.presenters.IRegistrarServiciosPresenter

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