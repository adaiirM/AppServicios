package com.adairm.appservicios.mvp.interfaces.views

import com.adairm.appservicios.dataBase.entidades.Cliente

interface IClientesActivity {
    suspend fun mostrarClientes(clientes: ArrayList<Cliente>)
}