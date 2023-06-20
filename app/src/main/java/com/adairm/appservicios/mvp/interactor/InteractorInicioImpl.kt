package com.adairm.appservicios.mvp.interactor

import android.content.Context
import com.adairm.appservicios.dataBase.entidades.Cliente
import com.adairm.appservicios.dataBase.entidades.PagosRegistrados
import com.adairm.appservicios.dataBase.entidades.ServiciosPendientesDto
import com.adairm.appservicios.dataBase.repository.GestionServiciosRepository
import com.adairm.appservicios.mvp.interfaces.interactors.IInicioInteractor
import com.adairm.appservicios.mvp.interfaces.presenters.IInicioPresenter

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