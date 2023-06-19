package com.adairm.appservicios.mvp.Interfaces.Views

import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto

interface IClientesActivity {
    suspend fun mostrarClientes(clientes: ArrayList<Cliente>)
}