package com.adairm.appservicios.mvp.View

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.adairm.appservicios.Adapters.AdapterServiciosPendientes
import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto
import com.adairm.appservicios.DataBase.Repository.GestionServiciosRepository
import com.adairm.appservicios.MainActivity
import com.adairm.appservicios.databinding.ActivityInicioBinding
import com.adairm.appservicios.mvp.Interfaces.Presenters.IInicioPresenter
import com.adairm.appservicios.mvp.Interfaces.Views.IInicioActivity
import com.adairm.appservicios.mvp.Presenter.PresenterInicioActivity
import kotlinx.coroutines.launch


class InicioActivity : AppCompatActivity(), IInicioActivity {
    private lateinit var binding: ActivityInicioBinding
    private var listServiciosPendientes = ArrayList<ServiciosPendientesDto>()
    private lateinit var presenter: PresenterInicioActivity

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

            adapterServicios.setOnClickListener {/*
                lifecycleScope.launch {
                    val p = binding.recyclerView.getChildAdapterPosition(it)
                    val pagoUpdate = findById(db, listServiciosPendientes[p].)
                    Toast.makeText(applicationContext, p.toString(), Toast.LENGTH_SHORT).show()
                    updateEstado(db, )
                }*/
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

    override fun mostrarPagosR(pagosRegistrados: ArrayList<ServiciosPendientesDto>) {
        this.listServiciosPendientes = pagosRegistrados
    }

}