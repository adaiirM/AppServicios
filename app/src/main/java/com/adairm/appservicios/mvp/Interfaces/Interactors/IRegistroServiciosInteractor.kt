package com.adairm.appservicios.mvp.Interfaces.Interactors

import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto

interface IRegistroServiciosInteractor {
    suspend fun buscarCliente(nombreC: String)

    suspend fun insertar(pagosRegistrados: PagosRegistrados)

}