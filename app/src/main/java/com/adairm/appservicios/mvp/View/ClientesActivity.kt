package com.adairm.appservicios.mvp.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.adairm.appservicios.Adapters.AdapterClientes
import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Repository.GestionServiciosRepository
import com.adairm.appservicios.databinding.ActivityClientesBinding
import com.adairm.appservicios.mvp.Interfaces.Presenters.IClientesPresenter
import com.adairm.appservicios.mvp.Interfaces.Views.IClientesActivity
import com.adairm.appservicios.mvp.Presenter.PresenterClientesActivity
import kotlinx.coroutines.launch

class ClientesActivity : AppCompatActivity(), IClientesActivity{
    private lateinit var binding: ActivityClientesBinding
    private lateinit var adapterClientes: AdapterClientes
    private var clientes = ArrayList<Cliente>()
    private lateinit var presenter: PresenterClientesActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientesBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)
        //Inicialziacion del objeto presenter
        presenter = PresenterClientesActivity(this, applicationContext)

        construirRecycler()
        agregarCliente()
    }

    fun agregarCliente(){
        binding.faAgregar.setOnClickListener{
            intent = Intent(this, RegistroClienteActivity::class.java)
            startActivity(intent)
        }
    }

    fun construirRecycler(){
        //Inicia un corrutina para ejecutar los metodos de la base de datos
        lifecycleScope.launch {
            //Mediante los metodos del presenter se manda un llamada para devolver los clientes
            presenter.mostrarClientes()
            binding.rvClientes.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
            adapterClientes = AdapterClientes(clientes)
            binding.rvClientes.adapter = adapterClientes
            adapterClientes.setOnClickListener{}
        }
    }

    //Recibe el resultado de la consulta del presenter
    override suspend fun mostrarClientes(clientes: ArrayList<Cliente>) {
        this.clientes = clientes
    }
}