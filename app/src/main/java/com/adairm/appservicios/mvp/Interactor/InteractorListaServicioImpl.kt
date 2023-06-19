package com.adairm.appservicios.mvp.Interactor

import android.content.Context
import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados
import com.adairm.appservicios.DataBase.Repository.GestionServiciosRepository
import com.adairm.appservicios.mvp.Interfaces.Interactors.IListaServiciosInteractor
import com.adairm.appservicios.mvp.Interfaces.Presenters.IClientesPresenter
import com.adairm.appservicios.mvp.Interfaces.Presenters.IListaServiciosPresenter

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