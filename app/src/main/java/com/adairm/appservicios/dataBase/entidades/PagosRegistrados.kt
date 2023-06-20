package com.adairm.appservicios.dataBase.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pagos_registrados")

data class PagosRegistrados(@ColumnInfo(name = "id_pago_registrado") @PrimaryKey(autoGenerate = true) val idPagoRegistrado: Int){

    @ColumnInfo(name = "concepto_pago") lateinit var conceptoPago: String
    @ColumnInfo(name = "monto_pago") var montoPago: Double = 0.0
    @ColumnInfo(name = "fecha_inicio") lateinit var fechaInicio: String
    @ColumnInfo(name = "fecha_fin") lateinit var fechaFin: String
    @ColumnInfo(name = "estado_pago") lateinit var estadoPago: String
    @ColumnInfo(name = "periodo_suscripcion") lateinit var periodoSuscripcion: String
    @ColumnInfo(name = "id_cliente") var idCliente: Int = 0

    constructor(
        conceptoPago: String,
        montoPago: Double,
        periodoSuscripcion: String,
        fechaInicio: String,
        fechaFin: String,
        estadoPago: String,
        idCliente: Int

        ) : this(0) {
        this.conceptoPago = conceptoPago
        this.montoPago = montoPago
        this.periodoSuscripcion = periodoSuscripcion
        this.fechaInicio = fechaInicio
        this.fechaFin = fechaFin
        this.estadoPago = estadoPago
        this.idCliente = idCliente
    }

    constructor() : this(0) {
    }
}
