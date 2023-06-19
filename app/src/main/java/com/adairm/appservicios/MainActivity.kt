package com.adairm.appservicios

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.adairm.appservicios.mvp.View.InicioActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.adairm.appservicios.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)



        val sharedPreferences = getSharedPreferences("sesion", Context.MODE_PRIVATE)
        val sesion = sharedPreferences.getBoolean("sesion_activa", false)
        if (sesion){
            intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
        } else{
            binding.btnIngresar.setOnClickListener {
                if (binding.edtNombre.text.toString() == "Adair" && binding.edtPassword.text.toString() == "123"){
                    intent = Intent(this, InicioActivity::class.java)
                    startActivity(intent)
                    val editor = sharedPreferences.edit()
                    editor.putString("clave", binding.edtNombre.text.toString())
                    editor.putBoolean("sesion_activa", true)
                    editor.apply()
                }else{
                    Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    
}