package com.adairm.appservicios.DataBase.Entidades

class ServiciosPendientesDto {
    var conceptoPago: String
    var nombreCompleto: String
    var telefono: String
    var montoPago: Double
    var fechaInicio: String
    var fechaFin: String

    constructor(
        conceptoPago: String,
        nombreCompleto: String,
        telefono: String,
        montoPago: Double,
        fechaInicio: String,
        fechaFin: String
    ){
        this.conceptoPago = conceptoPago
        this.nombreCompleto = nombreCompleto
        this.telefono = telefono
        this.montoPago = montoPago
        this.fechaInicio = fechaInicio
        this.fechaFin = fechaFin
    }
}