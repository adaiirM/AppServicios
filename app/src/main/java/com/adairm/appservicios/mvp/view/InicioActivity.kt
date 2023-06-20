package com.adairm.appservicios.mvp.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.adairm.appservicios.adapters.AdapterServiciosPendientes
import com.adairm.appservicios.dataBase.entidades.PagosRegistrados
import com.adairm.appservicios.dataBase.entidades.ServiciosPendientesDto
import com.adairm.appservicios.MainActivity
import com.adairm.appservicios.databinding.ActivityInicioBinding
import com.adairm.appservicios.mvp.interfaces.views.IInicioActivity
import com.adairm.appservicios.mvp.presenter.PresenterInicioActivity
import kotlinx.coroutines.launch


class InicioActivity : AppCompatActivity(), IInicioActivity {
    private lateinit var binding: ActivityInicioBinding
    private var listServiciosPendientes = ArrayList<ServiciosPendientesDto>()
    private lateinit var presenter: PresenterInicioActivity
    private var pagoRegistrado = PagosRegistrados()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        presenter = PresenterInicioActivity(this, applicationContext)
        btnServiciosPagado()
        clientes()
        agregarServicio()
        construirRecycler()
        salir()
    }

    fun btnServiciosPagado(){
        binding.btnServiciosPagados.setOnClickListener {
            intent = Intent(applicationContext, ListaServiciosActivity::class.java)
            startActivity(intent)
        }
    }

    fun clientes(){
        binding.btnCliente.setOnClickListener {
            intent = Intent(applicationContext, ClientesActivity::class.java)
            startActivity(intent)
        }
    }

    fun agregarServicio(){
        binding.fbAgregar.setOnClickListener {
            intent = Intent(applicationContext, RegistrarServicioActivity::class.java)
            startActivity(intent)
        }
    }

    fun construirRecycler(){
        lifecycleScope.launch {
            presenter.mostrarPagos()
            binding.recyclerView.layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            val adapterServicios = AdapterServiciosPendientes(listServiciosPendientes)
            binding.recyclerView.adapter = adapterServicios

            //Llama al metodo setOnClickListener para actualizar el estado de pago al tocar algun servicio pendiente
            adapterServicios.setOnClickListener {
                lifecycleScope.launch{
                    //Recupera la posicion y obtiene el id del servicio pendiente para buscar a que
                    //servicio pertence
                    val p = binding.recyclerView.getChildAdapterPosition(it)
                    val id = listServiciosPendientes[p].idPago
                    presenter.buscarPorId(id)

                    val pagoAct = pagoRegistrado
                    pagoAct.estadoPago = "Pagado"
                    pagar(pagoAct)
                }
                adapterServicios.notifyDataSetChanged()
            }
        }
    }

    private fun salir(){
        binding.btnSalir.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Confirmación")
            builder.setMessage("¿Estás seguro de que deseas salir?")

            builder.setPositiveButton("Sí") { dialog, which ->

                val sharedPreferences = getSharedPreferences("sesion", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putBoolean("sesion_activa", false)
                editor.apply()
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            builder.setNegativeButton("No") { dialog, which ->
                dialog.cancel()
            }

            val dialog = builder.create()
            dialog.show()
        }
    }


    private fun pagar(pagoRegistrado: PagosRegistrados){
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Confirmación")
            builder.setMessage("¿Estás seguro que marcar marcar como pagado?")

            builder.setPositiveButton("Sí") { dialog, which ->
                lifecycleScope.launch {
                    //Llama al metodo updadate de presenter para actualizar el registro
                    presenter.updatePago(pagoRegistrado)
                    Toast.makeText(applicationContext, "Servicio pagado", Toast.LENGTH_SHORT).show()
                    intent = Intent(applicationContext, InicioActivity::class.java)
                    startActivity(intent)
                }
            }
            builder.setNegativeButton("No") { dialog, which ->
                dialog.cancel()
            }

            val dialog = builder.create()
            dialog.show()
    }

    override fun mostrarPagosR(pagosRegistrados: ArrayList<ServiciosPendientesDto>) {
        this.listServiciosPendientes = pagosRegistrados
    }

    override suspend fun devolverPago(pagos: PagosRegistrados) {
        this.pagoRegistrado = pagos
    }

}