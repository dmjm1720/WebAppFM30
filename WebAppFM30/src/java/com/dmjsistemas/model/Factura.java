package com.dmjsistemas.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FACTURA", schema = "dbo", catalog = "DBFM30")
public class Factura implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FACTURA")
    private int idFactura;

    @Column(name = "NOMBRE_FACTURA", length = 150)
    private String nombreFactura;

    @Column(name = "IMPORTE", scale = 4)
    private BigDecimal importe;

    @Column(name = "IVA", scale = 4)
    private BigDecimal iva;

    @Column(name = "TUA", scale = 4)
    private BigDecimal tua;

    @Column(name = "FACTURA", length = 50)
    private String factura;

    @Column(name = "UUID", length = 100)
    private String uuid;

    @Column(name = "RFC", length = 50)
    private String rfc;

    @Column(name = "NOMBRE", length = 250)
    private String nombre;

    @Column(name = "ESTATUS", length = 50)
    private String estatus;

    @Column(name = "TOTALMXN", scale = 4)
    private BigDecimal totalmxn;

    @Column(name = "TOTALUSD", scale = 4)
    private BigDecimal totalusd;

    @Column(name = "COMENTARIO", length = 250)
    private String comentario;

    @Column(name = "NOMBRE_USUARIO", length = 150)
    private String nombreUsuario;

    @Column(name = "FOLIO_USUARIO", length = 3)
    private String folioUsuario;

    @Column(name = "FECHA", length = 20)
    private String fecha;

    @Column(name = "TIPO", length = 50)
    private String tipo;

    @Column(name = "ESTADO", length = 30)
    private String estado;

    @Column(name = "RFC_RECEPTOR", length = 50)
    private String rfcReceptor;

    @Column(name = "NOMBRE_RECEPTOR", length = 250)
    private String nombreReceptor;

    @Column(name = "TARJETA", length = 2)
    private String tarjeta;

    @Column(name = "RUTA_XML", length = 250)
    private String rutaXml;

    @Column(name = "RURA_IMAGEN", length = 250)
    private String ruraImagen;

    @Column(name = "RURA_PDF", length = 250)
    private String ruraPdf;

    @Column(name = "MODIFICAR_ARCHIVO", length = 2)
    private String modificarArchivo;

    @Column(name = "PROPINA", scale = 4)
    private BigDecimal propina;

    @Column(name = "ISH", scale = 4)
    private BigDecimal ish;

    @Column(name = "TARJETA_GASOLINA", length = 2)
    private String tarjetaGasolina;

    @Column(name = "DEPARTAMENTO", length = 50)
    private String departamento;

    @Column(name = "LIGAR_EXPEDICION", length = 250)
    private String ligarExpedicion;

    @Column(name = "DESCRIPCION", length = 250)
    private String descripcion;

    @Column(name = "SELLO_CFD", length = 500)
    private String selloCfd;

    @Column(name = "SELLO_SAT", length = 500)
    private String selloSat;

    @Column(name = "FECHA_TIMBRADO", length = 50)
    private String fechaTimbrado;

    @Column(name = "NO_CERTIFICADO_SAT", length = 50)
    private String noCertificadoSat;

    @Column(name = "VER_UUID", length = 10)
    private String verUuid;

    @Column(name = "NO_CERTIFICADO", length = 50)
    private String noCertificado;

    @Column(name = "TIPO_CAMBIO", scale = 4)
    private BigDecimal tipoCambio;

    @Column(name = "MODENDA", length = 25)
    private String modenda;

    @Column(name = "TIPO_COMPROBANTE", length = 50)
    private String tipoComprobante;

    @Column(name = "METODO_PAGO", length = 50)
    private String metodoPago;

    @Column(name = "FORMA_PAGO", length = 100)
    private String formaPago;

    @Column(name = "IMPUESTO_RETENIDO", scale = 4)
    private BigDecimal impuestoRetenido;

    @Column(name = "IMAGEN")
    private byte[] imagen;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_DOCUMENTO", length = 10)
    private Date fechaDocumento;

    @Column(name = "USO_CFDI", length = 100)
    private String usoCfdi;

    @Column(name = "RFC_PROV_CERTIF", length = 50)
    private String rfcProvCertif;

    @Column(name = "VERSION_SAT", length = 5)
    private String versionSat;

    @Column(name = "NOMBRE_FACTURA_PDF", length = 150)
    private String nombreFacturaPdf;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "factura")
    private Set<Concepto> conceptos = new HashSet<Concepto>(0);

    public Factura() {
    }

    public Factura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Factura(String factura, String uuid, BigDecimal importe, BigDecimal totalmxn) {
        this.factura = factura;
        this.uuid = uuid;
        this.importe = importe;
        this.totalmxn = totalmxn;
    }

    public Factura(int idFactura, String nombreFactura, BigDecimal importe, BigDecimal iva, BigDecimal tua, String factura, String uuid, String rfc, String nombre, String estatus, BigDecimal totalmxn, BigDecimal totalusd, String comentario, String nombreUsuario, String folioUsuario, String fecha, String tipo, String estado, String rfcReceptor, String nombreReceptor, String tarjeta, String rutaXml, String ruraImagen, String ruraPdf, String modificarArchivo, BigDecimal propina, BigDecimal ish, String tarjetaGasolina, String departamento, String ligarExpedicion, String descripcion, String selloCfd, String selloSat, String fechaTimbrado, String noCertificadoSat, String verUuid, String noCertificado, BigDecimal tipoCambio, String modenda, String tipoComprobante, String metodoPago, String formaPago, BigDecimal impuestoRetenido, byte[] imagen, Date fechaDocumento, String usoCfdi, String rfcProvCertif, String versionSat, String nombreFacturaPdf, Set<Concepto> conceptos) {
        this.idFactura = idFactura;
        this.nombreFactura = nombreFactura;
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
        this.rfcReceptor = rfcReceptor;
        this.nombreReceptor = nombreReceptor;
        this.tarjeta = tarjeta;
        this.rutaXml = rutaXml;
        this.ruraImagen = ruraImagen;
        this.ruraPdf = ruraPdf;
        this.modificarArchivo = modificarArchivo;
        this.propina = propina;
        this.ish = ish;
        this.tarjetaGasolina = tarjetaGasolina;
        this.departamento = departamento;
        this.ligarExpedicion = ligarExpedicion;
        this.descripcion = descripcion;
        this.selloCfd = selloCfd;
        this.selloSat = selloSat;
        this.fechaTimbrado = fechaTimbrado;
        this.noCertificadoSat = noCertificadoSat;
        this.verUuid = verUuid;
        this.noCertificado = noCertificado;
        this.tipoCambio = tipoCambio;
        this.modenda = modenda;
        this.tipoComprobante = tipoComprobante;
        this.metodoPago = metodoPago;
        this.formaPago = formaPago;
        this.impuestoRetenido = impuestoRetenido;
        this.imagen = imagen;
        this.fechaDocumento = fechaDocumento;
        this.usoCfdi = usoCfdi;
        this.rfcProvCertif = rfcProvCertif;
        this.versionSat = versionSat;
        this.nombreFacturaPdf = nombreFacturaPdf;
        this.conceptos = conceptos;
    }

    public int getIdFactura() {
        return this.idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getNombreFactura() {
        return this.nombreFactura;
    }

    public void setNombreFactura(String nombreFactura) {
        this.nombreFactura = nombreFactura;
    }

    public BigDecimal getImporte() {
        return this.importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public BigDecimal getIva() {
        return this.iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getTua() {
        return this.tua;
    }

    public void setTua(BigDecimal tua) {
        this.tua = tua;
    }

    public String getFactura() {
        return this.factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRfc() {
        return this.rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstatus() {
        return this.estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public BigDecimal getTotalmxn() {
        return this.totalmxn;
    }

    public void setTotalmxn(BigDecimal totalmxn) {
        this.totalmxn = totalmxn;
    }

    public BigDecimal getTotalusd() {
        return this.totalusd;
    }

    public void setTotalusd(BigDecimal totalusd) {
        this.totalusd = totalusd;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getFolioUsuario() {
        return this.folioUsuario;
    }

    public void setFolioUsuario(String folioUsuario) {
        this.folioUsuario = folioUsuario;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRfcReceptor() {
        return this.rfcReceptor;
    }

    public void setRfcReceptor(String rfcReceptor) {
        this.rfcReceptor = rfcReceptor;
    }

    public String getNombreReceptor() {
        return this.nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    public String getTarjeta() {
        return this.tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getRutaXml() {
        return this.rutaXml;
    }

    public void setRutaXml(String rutaXml) {
        this.rutaXml = rutaXml;
    }

    public String getRuraImagen() {
        return this.ruraImagen;
    }

    public void setRuraImagen(String ruraImagen) {
        this.ruraImagen = ruraImagen;
    }

    public String getRuraPdf() {
        return this.ruraPdf;
    }

    public void setRuraPdf(String ruraPdf) {
        this.ruraPdf = ruraPdf;
    }

    public String getModificarArchivo() {
        return this.modificarArchivo;
    }

    public void setModificarArchivo(String modificarArchivo) {
        this.modificarArchivo = modificarArchivo;
    }

    public BigDecimal getPropina() {
        return this.propina;
    }

    public void setPropina(BigDecimal propina) {
        this.propina = propina;
    }

    public BigDecimal getIsh() {
        return this.ish;
    }

    public void setIsh(BigDecimal ish) {
        this.ish = ish;
    }

    public String getTarjetaGasolina() {
        return this.tarjetaGasolina;
    }

    public void setTarjetaGasolina(String tarjetaGasolina) {
        this.tarjetaGasolina = tarjetaGasolina;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getLigarExpedicion() {
        return this.ligarExpedicion;
    }

    public void setLigarExpedicion(String ligarExpedicion) {
        this.ligarExpedicion = ligarExpedicion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSelloCfd() {
        return this.selloCfd;
    }

    public void setSelloCfd(String selloCfd) {
        this.selloCfd = selloCfd;
    }

    public String getSelloSat() {
        return this.selloSat;
    }

    public void setSelloSat(String selloSat) {
        this.selloSat = selloSat;
    }

    public String getFechaTimbrado() {
        return this.fechaTimbrado;
    }

    public void setFechaTimbrado(String fechaTimbrado) {
        this.fechaTimbrado = fechaTimbrado;
    }

    public String getNoCertificadoSat() {
        return this.noCertificadoSat;
    }

    public void setNoCertificadoSat(String noCertificadoSat) {
        this.noCertificadoSat = noCertificadoSat;
    }

    public String getVerUuid() {
        return this.verUuid;
    }

    public void setVerUuid(String verUuid) {
        this.verUuid = verUuid;
    }

    public String getNoCertificado() {
        return this.noCertificado;
    }

    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    public BigDecimal getTipoCambio() {
        return this.tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getModenda() {
        return this.modenda;
    }

    public void setModenda(String modenda) {
        this.modenda = modenda;
    }

    public String getTipoComprobante() {
        return this.tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getMetodoPago() {
        return this.metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getFormaPago() {
        return this.formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public BigDecimal getImpuestoRetenido() {
        return this.impuestoRetenido;
    }

    public void setImpuestoRetenido(BigDecimal impuestoRetenido) {
        this.impuestoRetenido = impuestoRetenido;
    }

    public byte[] getImagen() {
        return this.imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Date getFechaDocumento() {
        return this.fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public String getUsoCfdi() {
        return this.usoCfdi;
    }

    public void setUsoCfdi(String usoCfdi) {
        this.usoCfdi = usoCfdi;
    }

    public String getRfcProvCertif() {
        return this.rfcProvCertif;
    }

    public void setRfcProvCertif(String rfcProvCertif) {
        this.rfcProvCertif = rfcProvCertif;
    }

    public String getVersionSat() {
        return this.versionSat;
    }

    public void setVersionSat(String versionSat) {
        this.versionSat = versionSat;
    }

    public String getNombreFacturaPdf() {
        return this.nombreFacturaPdf;
    }

    public void setNombreFacturaPdf(String nombreFacturaPdf) {
        this.nombreFacturaPdf = nombreFacturaPdf;
    }

    public Set<Concepto> getConceptos() {
        return this.conceptos;
    }

    public void setConceptos(Set<Concepto> conceptos) {
        this.conceptos = conceptos;
    }

}
