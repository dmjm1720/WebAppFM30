package com.dmjsistemas.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONCEPTO", schema = "dbo", catalog = "DBFM30")
public class Concepto implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPARTIDA")
    private int idpartida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDFACTURA")
    private Factura factura;

    @Column(name = "DESCRIPCION", length = 1000)
    private String descripcion;

    @Column(name = "UUID", length = 200)
    private String uuid;

    @Column(name = "PRECIO_UNITARIO", scale = 4)
    private BigDecimal precioUnitario;

    @Column(name = "CANTIDAD", length = 50)
    private String cantidad;

    @Column(name = "UNIDAD", length = 50)
    private String unidad;

    @Column(name = "CLAVE_UNIDAD", length = 50)
    private String claveUnidad;

    @Column(name = "IMPORTE", scale = 4)
    private BigDecimal importe;

    @Column(name = "CLAVE_PROD", length = 100)
    private String claveProd;

    public Concepto() {
    }

    public Concepto(int idpartida) {
        this.idpartida = idpartida;
    }

    public Concepto(int idpartida, Factura factura, String descripcion, String uuid, BigDecimal precioUnitario, String cantidad, String unidad, String claveUnidad, BigDecimal importe, String claveProd) {
        this.idpartida = idpartida;
        this.factura = factura;
        this.descripcion = descripcion;
        this.uuid = uuid;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.claveUnidad = claveUnidad;
        this.importe = importe;
        this.claveProd = claveProd;
    }

    public int getIdpartida() {
        return this.idpartida;
    }

    public void setIdpartida(int idpartida) {
        this.idpartida = idpartida;
    }

    public Factura getFactura() {
        return this.factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public BigDecimal getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return this.unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getClaveUnidad() {
        return this.claveUnidad;
    }

    public void setClaveUnidad(String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    public BigDecimal getImporte() {
        return this.importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getClaveProd() {
        return this.claveProd;
    }

    public void setClaveProd(String claveProd) {
        this.claveProd = claveProd;
    }

}
