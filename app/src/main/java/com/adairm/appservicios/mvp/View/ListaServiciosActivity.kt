package com.adairm.appservicios.mvp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.adairm.appservicios.Adapters.AdapterClientes
import com.adairm.appservicios.Adapters.AdapterServiciosPagados
import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados
import com.adairm.appservicios.DataBase.Repository.GestionServiciosRepository
import com.adairm.appservicios.databinding.ActivityListaServiciosBinding
import com.adairm.appservicios.mvp.Interfaces.Views.IListaServiciosActivity
import kotlinx.coroutines.launch

class ListaServiciosActivity : AppCompatActivity(), IListaServiciosActivity {
    private lateinit var binding: ActivityListaServiciosBinding
    private lateinit var adapterRecycler: AdapterClientes
    private lateinit var adapterRecycler2: AdapterServiciosPagados
    private lateinit var listCliente: List<Cliente>
    private lateinit var listPagos: List<PagosRegistrados>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaServiciosBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        GestionServiciosRepository.inicializar(this)
        val db = GestionServiciosRepository.get()

        buscar(db)
    }

    private fun buscar(db: GestionServiciosRepository){
        binding.btnBuscar.setOnClickListener {
            val nombre = binding.edtNombre.text.toString()
            var byId = 0

            lifecycleScope.launch {
                listCliente = findByName(db, nombre)
                binding.rvClientes.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
                adapterRecycler = AdapterClientes(listCliente)
                binding.rvClientes.adapter = adapterRecycler

                adapterRecycler.setOnClickListener{
                    val id = binding.rvClientes.getChildAdapterPosition(it)
                    byId = listCliente[id].idCliente

                    lifecycleScope.launch {
                        listPagos = findById(db, byId, "Pagado")
                        binding.rcServiciosPagados.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
                        adapterRecycler2 = AdapterServiciosPagados(listPagos)
                        binding.rcServiciosPagados.adapter = adapterRecycler2

                        adapterRecycler2.setOnClickListener{

                        }
                    }
                }
            }
        }
    }

    private suspend fun findByName(db: GestionServiciosRepository, nombreC: String): List<Cliente>{
        return db.findByName(nombreC)
    }

    private suspend fun findById(db: GestionServiciosRepository, id: Int, estadoPago: String): List<PagosRegistrados>{
        return db.findByIdEstado(id, estadoPago)
    }

    override suspend fun devolverClientes(clientes: ArrayList<Cliente>) {
        this.listCliente = clientes
    }

    override suspend fun devolverPagos(pagos: ArrayList<PagosRegistrados>) {
        this.listPagos = pagos
    }


}