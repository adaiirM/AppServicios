package com.adairm.appservicios.mvp.Interfaces.Views

import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto

interface IRegistrarServicioActivity {
    suspend fun devolverClientes(clientes: ArrayList<Cliente>)
    suspend fun insertar(pagosRegistrados: PagosRegistrados)
}