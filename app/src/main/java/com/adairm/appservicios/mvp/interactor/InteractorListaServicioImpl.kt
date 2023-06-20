package com.adairm.appservicios.mvp.interactor

import android.content.Context
import com.adairm.appservicios.dataBase.entidades.Cliente
import com.adairm.appservicios.dataBase.entidades.PagosRegistrados
import com.adairm.appservicios.dataBase.repository.GestionServiciosRepository
import com.adairm.appservicios.mvp.interfaces.interactors.IListaServiciosInteractor
import com.adairm.appservicios.mvp.interfaces.presenters.IListaServiciosPresenter

class InteractorListaServicioImpl (presenter: IListaServiciosPresenter, context: Context): IListaServiciosInteractor {
    private val presenter: IListaServiciosPresenter
    private var db: GestionServiciosRepository

    init {
        this.presenter = presenter
        GestionServiciosRepository.inicializar(context)
        db = GestionServiciosRepository.get()
    }

    override suspend fun buscarPorNombre(nombreC: String) {
        val clientes = db.findByName(nombreC) as ArrayList<Cliente>
        presenter.devolverClientes(clientes)
    }

    override suspend fun buscarPorId(id: Int) {
        val pagos = db.findByIdEstado(id, "Pagado")
        presenter.devolverPagos(pagos as ArrayList<PagosRegistrados>)
    }


}