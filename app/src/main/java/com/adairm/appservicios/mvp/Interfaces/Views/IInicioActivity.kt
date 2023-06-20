package com.adairm.appservicios.mvp.Interfaces.Views

import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto

interface IInicioActivity {
    fun mostrarPagosR(pagosRegistrados: ArrayList<ServiciosPendientesDto>)

    suspend fun devolverPago(pagos: PagosRegistrados)

}