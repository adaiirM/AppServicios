package com.adairm.appservicios.mvp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.adairm.appservicios.DataBase.Entidades.Cliente
import com.adairm.appservicios.DataBase.Repository.GestionServiciosRepository
import com.adairm.appservicios.databinding.ActivityRegistroClienteBinding
import com.adairm.appservicios.mvp.Interfaces.Presenters.IRegistrarClientePresenter
import com.adairm.appservicios.mvp.Interfaces.Views.IRegistroClienteActivity
import com.adairm.appservicios.mvp.Presenter.PresenterRegistroClienteActivity
import kotlinx.coroutines.launch

class RegistroClienteActivity : AppCompatActivity(), IRegistroClienteActivity {
    private lateinit var binding: ActivityRegistroClienteBinding
    private lateinit var presenter: PresenterRegistroClienteActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroClienteBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        presenter = PresenterRegistroClienteActivity(this, applicationContext)
        aceptar()
    }

    private fun aceptar(){
        binding.btnAceptar.setOnClickListener {
            if (validar()){
                lifecycleScope.launch {
                    insertarCliente()
                    limpiarCampos()
                    Toast.makeText(applicationContext,"Elemento insertado", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private suspend fun insertarCliente(){
        val cliente = Cliente(
            binding.edtNombre.text.toString(),
            binding.edtApellidoPaterno.text.toString(),
            binding.edtApellidoMaterno.text.toString(),
            binding.edtEdad.text.toString(),
            binding.edtTelefono.text.toString(),
            binding.edtCorreo.text.toString()
        )
        insertar(cliente)
    }

    private fun tieneEspacios(text: String): Boolean {
        val patron = "\\s".toRegex()
        return patron.containsMatchIn(text)
    }

    private fun validar(): Boolean{
        var flag = true
        if (binding.edtNombre.text.toString() == "" || binding.edtApellidoPaterno.text.toString() == ""
            || binding.edtApellidoMaterno.text.toString() == "" || binding.edtEdad.text.toString() == ""
            || binding.edtTelefono.text.toString() == "" || binding.edtCorreo.text.toString() == ""){
            mostrarText("Rellena todos los campos")
            flag = false
        } else{
            if (tieneEspacios(binding.edtNombre.text.toString()) || tieneEspacios(binding.edtApellidoPaterno.text.toString())
                || tieneEspacios(binding.edtApellidoMaterno.text.toString())){
                mostrarText("No insertes espacios")
                flag = false
            }
        }
        return flag
    }

    private fun limpiarCampos(){
        binding.edtNombre.setText("")
        binding.edtApellidoPaterno.setText("")
        binding.edtApellidoMaterno.setText("")
        binding.edtEdad.setText("")
        binding.edtTelefono.setText("")
        binding.edtCorreo.setText("")
    }

    private fun mostrarText(texto: String){
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()
    }

    override suspend fun insertar(cliente: Cliente) {
        presenter.insertar(cliente)
    }
}