package com.dmjsistemas.gastos.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "concepto", schema = "dbo", catalog = "gastos")
public class ConceptoGastos implements java.io.Serializable {

    private int idConcepto;
    private String nombreConcepto;
    private BigDecimal importe;
    private BigDecimal iva;
    private BigDecimal tua;
    private String factura;
    private String uuid;
    private String rfc;
    private String nombre;
    private String estatus;
    private BigDecimal totalmxn;
    private BigDecimal totalusd;
    private String comentario;
    private String nombreUsuario;
    private String folioUsuario;
    private Date fecha;
    private String tipo;
    private String estado;
    private String rfcreceptor;
    private String nombreReceptor;
    private String tarjeta;
    private String rutaXml;
    private String rutaImagen;
    private String rutaPdf;
    private String modificarArchivo;
    private BigDecimal propina;
    private BigDecimal ish;
    private String tarjetaGasolina;
    private String departamento;
    private String lugarExpedicion;
    private String descripcion;
    private String selloCfd;
    private String selloSat;
    private String fechaTimbrado;
    private String noCertificadoSat;
    private String veruuid;
    private String noCertificado;
    private BigDecimal tipoCambio;
    private String moneda;
    private String tipoComprobante;
    private String metodoPago;
    private String formaPago;
    private BigDecimal impuestoRetenido;
    private byte[] imagen;
    private Date fechaDocumento;

    public ConceptoGastos() {
    }

    public ConceptoGastos(int idConcepto) {
        this.idConcepto = idConcepto;
    }

    public ConceptoGastos(int idConcepto, String nombreConcepto, BigDecimal importe, BigDecimal iva, BigDecimal tua, String factura, String uuid, String rfc, String nombre, String estatus, BigDecimal totalmxn, BigDecimal totalusd, String comentario, String nombreUsuario, String folioUsuario, Date fecha, String tipo, String estado, String rfcreceptor, String nombreReceptor, String tarjeta, String rutaXml, String rutaImagen, String rutaPdf, String modificarArchivo, BigDecimal propina, BigDecimal ish, String tarjetaGasolina, String departamento, String lugarExpedicion, String descripcion, String selloCfd, String selloSat, String fechaTimbrado, String noCertificadoSat, String veruuid, String noCertificado, BigDecimal tipoCambio, String moneda, String tipoComprobante, String metodoPago, String formaPago, BigDecimal impuestoRetenido, byte[] imagen, Date fechaDocumento) {
        this.idConcepto = idConcepto;
        this.nombreConcepto = nombreConcepto;
        this.importe = importe;
        this.iva = iva;
        this.tua = tua;
        this.factura = factura;
        this.uuid = uuid;
        this.rfc = rfc;
        this.nombre = nombre;
        this.estatus = estatus;
        this.totalmxn = totalmxn;
        this.totalusd = totalusd;
        this.comentario = comentario;
        this.nombreUsuario = nombreUsuario;
        this.folioUsuario = folioUsuario;
        this.fecha = fecha;
        this.tipo = tipo;
        this.estado = estado;
        this.rfcreceptor = rfcreceptor;
        this.nombreReceptor = nombreReceptor;
        this.tarjeta = tarjeta;
        this.rutaXml = rutaXml;
        this.rutaImagen = rutaImagen;
        this.rutaPdf = rutaPdf;
        this.modificarArchivo = modificarArchivo;
        this.propina = propina;
        this.ish = ish;
        this.tarjetaGasolina = tarjetaGasolina;
        this.departamento = departamento;
        this.lugarExpedicion = lugarExpedicion;
        this.descripcion = descripcion;
        this.selloCfd = selloCfd;
        this.selloSat = selloSat;
        this.fechaTimbrado = fechaTimbrado;
        this.noCertificadoSat = noCertificadoSat;
        this.veruuid = veruuid;
        this.noCertificado = noCertificado;
        this.tipoCambio = tipoCambio;
        this.moneda = moneda;
        this.tipoComprobante = tipoComprobante;
        this.metodoPago = metodoPago;
        this.formaPago = formaPago;
        this.impuestoRetenido = impuestoRetenido;
        this.imagen = imagen;
        this.fechaDocumento = fechaDocumento;
    }

    @Id

    @Column(name = "idConcepto", unique = true, nullable = false)
    public int getIdConcepto() {
        return this.idConcepto;
    }

    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }

    @Column(name = "nombreConcepto", length = 50)
    public String getNombreConcepto() {
        return this.nombreConcepto;
    }

    public void setNombreConcepto(String nombreConcepto) {
        this.nombreConcepto = nombreConcepto;
    }

    @Column(name = "importe", scale = 4)
    public BigDecimal getImporte() {
        return this.importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    @Column(name = "iva", scale = 4)
    public BigDecimal getIva() {
        return this.iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    @Column(name = "tua", scale = 4)
    public BigDecimal getTua() {
        return this.tua;
    }

    public void setTua(BigDecimal tua) {
        this.tua = tua;
    }

    @Column(name = "factura", length = 50)
    public String getFactura() {
        return this.factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    @Column(name = "uuid", length = 100)
    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Column(name = "rfc", length = 50)
    public String getRfc() {
        return this.rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @Column(name = "nombre", length = 250)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "estatus", length = 50)
    public String getEstatus() {
        return this.estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Column(name = "totalmxn", scale = 4)
    public BigDecimal getTotalmxn() {
        return this.totalmxn;
    }

    public void setTotalmxn(BigDecimal totalmxn) {
        this.totalmxn = totalmxn;
    }

    @Column(name = "totalusd", scale = 4)
    public BigDecimal getTotalusd() {
        return this.totalusd;
    }

    public void setTotalusd(BigDecimal totalusd) {
        this.totalusd = totalusd;
    }

    @Column(name = "comentario", length = 250)
    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Column(name = "nombreUsuario", length = 150)
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Column(name = "folioUsuario", length = 3)
    public String getFolioUsuario() {
        return this.folioUsuario;
    }

    public void setFolioUsuario(String folioUsuario) {
        this.folioUsuario = folioUsuario;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha", length = 10)
    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "tipo", length = 50)
    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Column(name = "estado", length = 30)
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(name = "rfcreceptor", length = 50)
    public String getRfcreceptor() {
        return this.rfcreceptor;
    }

    public void setRfcreceptor(String rfcreceptor) {
        this.rfcreceptor = rfcreceptor;
    }

    @Column(name = "nombreReceptor", length = 250)
    public String getNombreReceptor() {
        return this.nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    @Column(name = "tarjeta", length = 2)
    public String getTarjeta() {
        return this.tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Column(name = "rutaXML", length = 250)
    public String getRutaXml() {
        return this.rutaXml;
    }

    public void setRutaXml(String rutaXml) {
        this.rutaXml = rutaXml;
    }

    @Column(name = "rutaImagen", length = 250)
    public String getRutaImagen() {
        return this.rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Column(name = "rutaPDF", length = 250)
    public String getRutaPdf() {
        return this.rutaPdf;
    }

    public void setRutaPdf(String rutaPdf) {
        this.rutaPdf = rutaPdf;
    }

    @Column(name = "modificarArchivo", length = 2)
    public String getModificarArchivo() {
        return this.modificarArchivo;
    }

    public void setModificarArchivo(String modificarArchivo) {
        this.modificarArchivo = modificarArchivo;
    }

    @Column(name = "propina", scale = 4)
    public BigDecimal getPropina() {
        return this.propina;
    }

    public void setPropina(BigDecimal propina) {
        this.propina = propina;
    }

    @Column(name = "ish", scale = 4)
    public BigDecimal getIsh() {
        return this.ish;
    }

    public void setIsh(BigDecimal ish) {
        this.ish = ish;
    }

    @Column(name = "tarjetaGasolina", length = 2)
    public String getTarjetaGasolina() {
        return this.tarjetaGasolina;
    }

    public void setTarjetaGasolina(String tarjetaGasolina) {
        this.tarjetaGasolina = tarjetaGasolina;
    }

    @Column(name = "departamento", length = 50)
    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Column(name = "lugarExpedicion", length = 250)
    public String getLugarExpedicion() {
        return this.lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    @Column(name = "descripcion", length = 250)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "selloCFD", length = 500)
    public String getSelloCfd() {
        return this.selloCfd;
    }

    public void setSelloCfd(String selloCfd) {
        this.selloCfd = selloCfd;
    }

    @Column(name = "selloSAT", length = 500)
    public String getSelloSat() {
        return this.selloSat;
    }

    public void setSelloSat(String selloSat) {
        this.selloSat = selloSat;
    }

    @Column(name = "fechaTimbrado", length = 50)
    public String getFechaTimbrado() {
        return this.fechaTimbrado;
    }

    public void setFechaTimbrado(String fechaTimbrado) {
        this.fechaTimbrado = fechaTimbrado;
    }

    @Column(name = "noCertificadoSAT", length = 50)
    public String getNoCertificadoSat() {
        return this.noCertificadoSat;
    }

    public void setNoCertificadoSat(String noCertificadoSat) {
        this.noCertificadoSat = noCertificadoSat;
    }

    @Column(name = "veruuid", length = 10)
    public String getVeruuid() {
        return this.veruuid;
    }

    public void setVeruuid(String veruuid) {
        this.veruuid = veruuid;
    }

    @Column(name = "noCertificado", length = 50)
    public String getNoCertificado() {
        return this.noCertificado;
    }

    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    @Column(name = "tipoCambio", scale = 4)
    public BigDecimal getTipoCambio() {
        return this.tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    @Column(name = "moneda", length = 25)
    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @Column(name = "tipoComprobante", length = 50)
    public String getTipoComprobante() {
        return this.tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    @Column(name = "metodoPago", length = 50)
    public String getMetodoPago() {
        return this.metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Column(name = "formaPago", length = 100)
    public String getFormaPago() {
        return this.formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    @Column(name = "impuestoRetenido", scale = 4)
    public BigDecimal getImpuestoRetenido() {
        return this.impuestoRetenido;
    }

    public void setImpuestoRetenido(BigDecimal impuestoRetenido) {
        this.impuestoRetenido = impuestoRetenido;
    }

    @Column(name = "imagen")
    public byte[] getImagen() {
        return this.imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaDocumento", length = 10)
    public Date getFechaDocumento() {
        return this.fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

}
