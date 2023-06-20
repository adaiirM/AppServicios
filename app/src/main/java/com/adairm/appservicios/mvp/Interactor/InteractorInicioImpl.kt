package com.adairm.appservicios.mvp.Interactor

import android.content.Context
import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto
import com.adairm.appservicios.DataBase.Repository.GestionServiciosRepository
import com.adairm.appservicios.mvp.Interfaces.Interactors.IInicioInteractor
import com.adairm.appservicios.mvp.Interfaces.Presenters.IInicioPresenter

class InteractorInicioImpl (presenter: IInicioPresenter, context: Context) : IInicioInteractor {
    private val presenter: IInicioPresenter
    private var db: GestionServiciosRepository

    init {
        this.presenter = presenter
        GestionServiciosRepository.inicializar(context)
        db = GestionServiciosRepository.get()
    }

    override suspend fun getPagosPendientes(){
        val listServiciosPendientes = ArrayList<ServiciosPendientesDto>()
            val clientes = db.getAllClientes() as ArrayList<Cliente>
            val servicios = db.findByEstado("No pagado")
            for (i in servicios) {
                for (j in clientes) {
                    if (i.idCliente == j.idCliente) {
                        val serv = ServiciosPendientesDto(
                            i.idPagoRegistrado,
                            i.conceptoPago,
                            j.nombreCompleto,
                            j.telefono,
                            i.montoPago,
                            i.fechaInicio,
                            i.fechaFin,
                        )
                        listServiciosPendientes.add(serv)
                    }
                }
            }
        presenter.getPagosPendientes(listServiciosPendientes)
    }

    override suspend fun buscarPorId(id: Int) {
        val pagoRegistrado: PagosRegistrados = db.findById(id)
        presenter.devolverPago(pagoRegistrado)
    }

    override suspend fun updatePago(pagoRegistrado: PagosRegistrados) {
        db.updateEstado(pagoRegistrado)
    }
}