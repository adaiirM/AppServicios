package com.adairm.appservicios.mvp.interfaces.views

import com.adairm.appservicios.dataBase.entidades.PagosRegistrados
import com.adairm.appservicios.dataBase.entidades.ServiciosPendientesDto

interface IInicioActivity {
    fun mostrarPagosR(pagosRegistrados: ArrayList<ServiciosPendientesDto>)

    suspend fun devolverPago(pagos: PagosRegistrados)

}