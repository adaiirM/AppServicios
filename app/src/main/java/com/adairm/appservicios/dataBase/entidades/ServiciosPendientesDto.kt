package com.adairm.appservicios.dataBase.entidades

class ServiciosPendientesDto(
    var idPago: Int,
    var conceptoPago: String,
    var nombreCompleto: String,
    var telefono: String,
    var montoPago: Double,
    var fechaInicio: String,
    var fechaFin: String
)