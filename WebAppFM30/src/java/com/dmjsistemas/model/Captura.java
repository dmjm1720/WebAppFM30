package com.dmjsistemas.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CAPTURA", schema = "dbo", catalog = "DBFM30")
public class Captura implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDGASTO")
    private int idgasto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPROVEEDOR")
    private Subcuenta subcuenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDUSUARIO")
    private Usuario usuario;

    @Column(name = "TIPO_SOLICITUD", length = 100)
    private String tipoSolicitud;

    @Column(name = "REFERENCIA", length = 50)
    private String referencia;

    @Column(name = "AUTORIZACION", length = 50)
    private String autorizacion;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", length = 10)
    private Date fecha;

    @Column(name = "CONCEPTO_GASTO", length = 250)
    private String conceptoGasto;

    @Column(name = "IMPORTE_TOTAL_MX", scale = 4)
    private BigDecimal importeTotalMx;

    @Column(name = "IMPORTE_TOTAL_USD", scale = 4)
    private BigDecimal importeTotalUsd;

    @Column(name = "PAGAR_A", length = 50)
    private String pagarA;

    @Column(name = "GASTOS_A", length = 50)
    private String gastosA;

    @Column(name = "CARGO_DE", length = 50)
    private String cargoDe;

    @Column(name = "SECCION_AUTORIZA", length = 100)
    private String seccionAutoriza;

    @Column(name = "SUBCUENTA", length = 50)
    private String subcuenta_1;

    @Column(name = "CUENTA_GASTO", length = 50)
    private String cuentaGasto;

    @Column(name = "UUID", length = 50)
    private String uuid;

    @Column(name = "IVA", scale = 4)
    private BigDecimal iva;

    @Column(name = "RET_IVA", scale = 4)
    private BigDecimal retIva;

    @Column(name = "RET_ISR", scale = 4)
    private BigDecimal retIsr;

    @Column(name = "CURRENCY", length = 10)
    private String currency;

    @Column(name = "ESTADO", length = 50)
    private String estado;

    @Column(name = "FOLIO", length = 10)
    private String folio;

    @Column(name = "BANCO_BENEFICIARIO", length = 75)
    private String bancoBeneficiario;

    @Column(name = "CUENTA_BENEFICIARIO", length = 75)
    private String cuentaBeneficiario;

    @Column(name = "AUTORIZACION_BENEFICIARIO", length = 75)
    private String autorizacionBeneficiario;

    @Column(name = "OBSERVACIONES", length = 500)
    private String observaciones;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_CAPTURA", length = 10)
    private Date fechaCaptura;

    @Column(name = "ESTADO_POLIZA", length = 50)
    private String estadoPoliza;

    @Column(name = "REFERENCE_NO", length = 500)
    private String referenceNo;

    @Column(name = "PORTAL", length = 20)
    private String portal;

    @Column(name = "XML", length = 5)
    private String xml;

    @Column(name = "SUBTOTAL", scale = 4)
    private BigDecimal subtotal;

    public Captura() {
    }

    public Captura(int idgasto) {
        this.idgasto = idgasto;
    }

    public Captura(int idgasto, Subcuenta subcuenta, Usuario usuario, String tipoSolicitud, String autorizacion, String referencia, Date fecha, String conceptoGasto, BigDecimal importeTotalMx, BigDecimal importeTotalUsd, String pagarA, String gastosA, String cargoDe, String seccionAutoriza, String subcuenta_1, String cuentaGasto, String uuid, BigDecimal iva, BigDecimal retIva, BigDecimal retIsr, String currency, String estado, String folio, String bancoBeneficiario, String cuentaBeneficiario, String autorizacionBeneficiario, String observaciones, Date fechaCaptura, String estadoPoliza, String referenceNo, String portal, String xml, BigDecimal subtotal) {
        this.idgasto = idgasto;
        this.subcuenta = subcuenta;
        this.usuario = usuario;
        this.tipoSolicitud = tipoSolicitud;
        this.autorizacion = autorizacion;
        this.referencia = referencia;
        this.fecha = fecha;
        this.conceptoGasto = conceptoGasto;
        this.importeTotalMx = importeTotalMx;
        this.importeTotalUsd = importeTotalUsd;
        this.pagarA = pagarA;
        this.gastosA = gastosA;
        this.cargoDe = cargoDe;
        this.seccionAutoriza = seccionAutoriza;
        this.subcuenta_1 = subcuenta_1;
        this.cuentaGasto = cuentaGasto;
        this.uuid = uuid;
        this.iva = iva;
        this.retIva = retIva;
        this.retIsr = retIsr;
        this.currency = currency;
        this.estado = estado;
        this.folio = folio;
        this.bancoBeneficiario = bancoBeneficiario;
        this.cuentaBeneficiario = cuentaBeneficiario;
        this.autorizacionBeneficiario = autorizacionBeneficiario;
        this.observaciones = observaciones;
        this.fechaCaptura = fechaCaptura;
        this.estadoPoliza = estadoPoliza;
        this.referenceNo = referenceNo;
        this.portal = portal;
        this.xml = xml;
        this.subtotal = subtotal;
    }

    public int getIdgasto() {
        return this.idgasto;
    }

    public void setIdgasto(int idgasto) {
        this.idgasto = idgasto;
    }

    public Subcuenta getSubcuenta() {
        return this.subcuenta;
    }

    public void setSubcuenta(Subcuenta subcuenta) {
        this.subcuenta = subcuenta;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipoSolicitud() {
        return this.tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getAutorizacion() {
        return this.autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public String getReferencia() {
        return this.referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConceptoGasto() {
        return this.conceptoGasto;
    }

    public void setConceptoGasto(String conceptoGasto) {
        this.conceptoGasto = conceptoGasto;
    }

    public BigDecimal getImporteTotalMx() {
        return this.importeTotalMx;
    }

    public void setImporteTotalMx(BigDecimal importeTotalMx) {
        this.importeTotalMx = importeTotalMx;
    }

    public BigDecimal getImporteTotalUsd() {
        return this.importeTotalUsd;
    }

    public void setImporteTotalUsd(BigDecimal importeTotalUsd) {
        this.importeTotalUsd = importeTotalUsd;
    }

    public String getPagarA() {
        return this.pagarA;
    }

    public void setPagarA(String pagarA) {
        this.pagarA = pagarA;
    }

    public String getGastosA() {
        return this.gastosA;
    }

    public void setGastosA(String gastosA) {
        this.gastosA = gastosA;
    }

    public String getCargoDe() {
        return this.cargoDe;
    }

    public void setCargoDe(String cargoDe) {
        this.cargoDe = cargoDe;
    }

    public String getSeccionAutoriza() {
        return this.seccionAutoriza;
    }

    public void setSeccionAutoriza(String seccionAutoriza) {
        this.seccionAutoriza = seccionAutoriza;
    }

    public String getSubcuenta_1() {
        return this.subcuenta_1;
    }

    public void setSubcuenta_1(String subcuenta_1) {
        this.subcuenta_1 = subcuenta_1;
    }

    public String getCuentaGasto() {
        return this.cuentaGasto;
    }

    public void setCuentaGasto(String cuentaGasto) {
        this.cuentaGasto = cuentaGasto;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public BigDecimal getIva() {
        return this.iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getRetIva() {
        return this.retIva;
    }

    public void setRetIva(BigDecimal retIva) {
        this.retIva = retIva;
    }

    public BigDecimal getRetIsr() {
        return this.retIsr;
    }

    public void setRetIsr(BigDecimal retIsr) {
        this.retIsr = retIsr;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFolio() {
        return this.folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getBancoBeneficiario() {
        return this.bancoBeneficiario;
    }

    public void setBancoBeneficiario(String bancoBeneficiario) {
        this.bancoBeneficiario = bancoBeneficiario;
    }

    public String getCuentaBeneficiario() {
        return this.cuentaBeneficiario;
    }

    public void setCuentaBeneficiario(String cuentaBeneficiario) {
        this.cuentaBeneficiario = cuentaBeneficiario;
    }

    public String getAutorizacionBeneficiario() {
        return this.autorizacionBeneficiario;
    }

    public void setAutorizacionBeneficiario(String autorizacionBeneficiario) {
        this.autorizacionBeneficiario = autorizacionBeneficiario;
    }

    public String getObservaciones() {
        return this.observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaCaptura() {
        return this.fechaCaptura;
    }

    public void setFechaCaptura(Date fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }

    public String getEstadoPoliza() {
        return this.estadoPoliza;
    }

    public void setEstadoPoliza(String estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }

    public String getReferenceNo() {
        return this.referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getPortal() {
        return this.portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public String getXml() {
        return this.xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public BigDecimal getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

}
