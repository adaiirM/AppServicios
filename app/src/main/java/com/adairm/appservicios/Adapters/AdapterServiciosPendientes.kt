package com.adairm.appservicios.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adairm.appservicios.DataBase.Entidades.PagosRegistrados
import com.adairm.appservicios.DataBase.Entidades.ServiciosPendientesDto
import com.adairm.appservicios.databinding.ItemListServiciosPagadosBinding
import com.adairm.appservicios.databinding.ItemListServiciosPendientesBinding

class AdapterServiciosPendientes (private val listServ:List<ServiciosPendientesDto>):
    RecyclerView.Adapter<AdapterServiciosPendientes.ViewHolderServPend>(), View.OnClickListener{

    lateinit var listener: View.OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderServPend {
        val binding = ItemListServiciosPendientesBinding.inflate(LayoutInflater.from(parent.context))
        binding.root.setOnClickListener(this)
        return ViewHolderServPend(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderServPend, position: Int) {
        holder.asignarDatos(listServ.get(position))
    }

    override fun getItemCount(): Int {
        return listServ.size
    }

    class ViewHolderServPend(binding: ItemListServiciosPendientesBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: ItemListServiciosPendientesBinding

        init {
            this.binding = binding
        }

        fun asignarDatos(serviciosPendientesDto: ServiciosPendientesDto) {
            binding.edtConceptoPago.text = serviciosPendientesDto.conceptoPago
            binding.edtNombre.text = serviciosPendientesDto.nombreCompleto
            binding.edtTelefono.text = serviciosPendientesDto.telefono
            binding.edtMontoPago.text = serviciosPendientesDto.montoPago.toString()
            binding.edtFechaInicio.text = serviciosPendientesDto.fechaInicio
            binding.edtFechaFin.text = serviciosPendientesDto.fechaFin
        }
    }

    fun setOnClickListener(listener: View.OnClickListener){
        this.listener = listener
    }

    override fun onClick(v: View?) {
        if (listener != null){
            listener.onClick(v)
        }
    }

}