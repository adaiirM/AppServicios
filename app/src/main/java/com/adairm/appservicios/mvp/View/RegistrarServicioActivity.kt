package com.adairm.appservicios.mvp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.adairm.appservicios.Adapters.AdapterClientes
import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto
import com.adairm.appservicios.DataBase.Repository.GestionServiciosRepository
import com.adairm.appservicios.R
import com.adairm.appservicios.databinding.ActivityRegistrarServicioBinding
import com.adairm.appservicios.mvp.Interfaces.Views.IRegistrarServicioActivity
import com.adairm.appservicios.mvp.Presenter.PresenterRegistrarSevActivity
import kotlinx.coroutines.launch

class RegistrarServicioActivity : AppCompatActivity(), IRegistrarServicioActivity{
    private lateinit var binding: ActivityRegistrarServicioBinding
    private  var listCliente = ArrayList<Cliente>()
    private lateinit var nombre: String
    private lateinit var adapterClientes: AdapterClientes
    private lateinit var presenter: PresenterRegistrarSevActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarServicioBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)
        presenter = PresenterRegistrarSevActivity(this, applicationContext)
        GestionServiciosRepository.inicializar(this)
        val db = GestionServiciosRepository.get()

        llenarSpinners()
        construirR()
        agregar()
    }

    fun construirR(){
        binding.btnBuscar.setOnClickListener {
            nombre = binding.edtNombre.text.toString()
            lifecycleScope.launch {
                presenter.buscarClientes(nombre)
                construirRecyclerUser()
            }
        }
    }

    fun agregar(){
        binding.btnAceptar.setOnClickListener {
            if(validar()){
                lifecycleScope.launch {
                    insertarPago()
                    Toast.makeText(applicationContext, "Servicio agregado", Toast.LENGTH_SHORT).show()
                    limpiarCampos()
                }
            }
        }
    }


    private suspend fun insertarPago(){
        val pago = PagosRegistrados(
            binding.edtConceptoPago.text.toString(),
            binding.edtMontoPago.text.toString().toDouble(),
            binding.spinnerPeriodo.selectedItem.toString(),
            binding.edtFechaInicio.text.toString(),
            binding.edtFechaFin.text.toString(),
            binding.spinnerEstadoPago.selectedItem.toString(),
            binding.edtId.text.toString().toInt()
        )
        insertar(pago)
    }

    private fun construirRecyclerUser(){
        binding.rvClientes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        adapterClientes = AdapterClientes(listCliente)
        binding.rvClientes.adapter = adapterClientes

        adapterClientes.setOnClickListener{
            val p = binding.rvClientes.getChildAdapterPosition(it)
            binding.edtId.setText(listCliente[p].idCliente.toString())
        }
    }

    private fun llenarSpinners(){
        val miArreglo = resources.getStringArray(R.array.periodo_suscripcion)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, miArreglo)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPeriodo.adapter = adapter

        val miArreglo2 = resources.getStringArray(R.array.estado_pago)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, miArreglo2)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerEstadoPago.adapter = adapter2
    }

    private fun validar(): Boolean{
        var flag = true
        if (binding.edtId.text.toString() == "" || binding.edtConceptoPago.text.toString() == ""
            || binding.edtMontoPago.text.toString() == "" || binding.edtFechaInicio.text.toString() == ""
            || binding.edtFechaFin.text.toString() == ""){
            mostrarText("Rellena todos los campos")
            flag = false
        } else{

        }
        return flag
    }

    private fun limpiarCampos(){
        binding.edtConceptoPago.setText("")
        binding.edtMontoPago.setText("")
        binding.spinnerPeriodo.setSelection(0)
        binding.edtFechaInicio.setText("")
        binding.edtFechaFin.setText("")
        binding.spinnerEstadoPago.setSelection(0)
    }

    private fun mostrarText(texto: String){
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()
    }

    override suspend fun devolverClientes(clientes: ArrayList<Cliente>) {
        this.listCliente = clientes
    }

    override suspend fun insertar(pagosRegistrados: PagosRegistrados) {
        presenter.insertar(pagosRegistrados)
    }
}