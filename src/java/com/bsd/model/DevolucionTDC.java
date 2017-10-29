package com.bsd.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Arturo Cordero
 */
public class DevolucionTDC {
    
    private String numeroTarjeta;
    private String afiliacion;
    private Date fechaTransaccion;
    private String codigoAutorizacion;
    
    private String formaPago;
    private BigDecimal total;
    
    private BigDecimal importeOriginal;
    private BigDecimal importeDevolver;

    public DevolucionTDC() {
        
    }

    public DevolucionTDC(String numeroTarjeta, String afiliacion, Date fechaTransaccion, String codigoAutorizacion, String formaPago, BigDecimal total, BigDecimal importeOriginal, BigDecimal importeDevolver) {
        this.numeroTarjeta = numeroTarjeta;
        this.afiliacion = afiliacion;
        this.fechaTransaccion = fechaTransaccion;
        this.codigoAutorizacion = codigoAutorizacion;
        this.formaPago = formaPago;
        this.total = total;
        this.importeOriginal = importeOriginal;
        this.importeDevolver = importeDevolver;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getAfiliacion() {
        return afiliacion;
    }

    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public String getCodigoAutorizacion() {
        return codigoAutorizacion;
    }

    public void setCodigoAutorizacion(String codigoAutorizacion) {
        this.codigoAutorizacion = codigoAutorizacion;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getImporteOriginal() {
        return importeOriginal;
    }

    public void setImporteOriginal(BigDecimal importeOriginal) {
        this.importeOriginal = importeOriginal;
    }

    public BigDecimal getImporteDevolver() {
        return importeDevolver;
    }

    public void setImporteDevolver(BigDecimal importeDevolver) {
        this.importeDevolver = importeDevolver;
    }

    @Override
    public String toString() {
        return "DevolucionTDC{" + "numeroTarjeta=" + numeroTarjeta + ", afiliacion=" + afiliacion + ", fechaTransaccion=" + fechaTransaccion + ", codigoAutorizacion=" + codigoAutorizacion + ", formaPago=" + formaPago + ", total=" + total + ", importeOriginal=" + importeOriginal + ", importeDevolver=" + importeDevolver + '}';
    }

   
    
    
}