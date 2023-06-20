package com.adairm.appservicios.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.adairm.appservicios.dataBase.entidades.PagosRegistrados
import com.adairm.appservicios.databinding.ItemListServiciosPagadosBinding

class AdapterServiciosPagados(private val listServ:List<PagosRegistrados>):
    RecyclerView.Adapter<AdapterServiciosPagados.ViewHolderServ>(), View.OnClickListener{

    lateinit var listener: View.OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderServ {
        val binding = ItemListServiciosPagadosBinding.inflate(LayoutInflater.from(parent.context))
        binding.root.setOnClickListener(this)
        return ViewHolderServ(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderServ, position: Int) {
        holder.asignarDatos(listServ.get(position))
    }

    override fun getItemCount(): Int {
        return listServ.size
    }

    class ViewHolderServ(binding: ItemListServiciosPagadosBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: ItemListServiciosPagadosBinding

        init {
            this.binding = binding
        }

        fun asignarDatos(pagosRegistrados: PagosRegistrados) {
            binding.edtConceptoPago.text = pagosRegistrados.conceptoPago
            binding.edtMontoPago.text = pagosRegistrados.montoPago.toString()
            binding.edtFechaInicio.text = pagosRegistrados.fechaInicio
            binding.edtFechaFin.text = pagosRegistrados.fechaFin
            binding.edtPeriodo.text = pagosRegistrados.periodoSuscripcion
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