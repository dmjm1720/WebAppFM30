package com.dmjsistemas.bean;

import com.dmjsistemas.dao.IConceptoDao;
import com.dmjsistemas.dao.IFacturaDao;
import com.dmjsistemas.dao.IUsuarioDao;
import com.dmjsistemas.impl.ConceptoDaoImp;
import com.dmjsistemas.impl.FacturaDaoImpl;
import com.dmjsistemas.impl.UsuarioDaoImpl;
import com.dmjsistemas.model.Concepto;
import com.dmjsistemas.model.Factura;
import com.dmjsistemas.model.Usuario;
import com.dmjsistemas.util.Configuracion;
import dmjmsistemas.sat.Acuse;
import dmjmsistemas.sat.ConsultaCFDIService;
import dmjmsistemas.sat.IConsultaCFDIService;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XmlBean extends Conexion {

    Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
    private Connection cn;
    private Connection cnSAE;

    private String ruta = "";

    private final List<String> lista;

    private Concepto part;

    private Factura concepto;

    private BigDecimal miprop;
    private String rutaPDF;
    private String rutaIMG;
    private String validarFactura;
    private String validarUUID;
    private String folioAbierto;
    private String uuidConcepto;
    private String recuperarUUID;
    private String nUsario;
    private String fUsuario;
    private String serie;
    private String folio;
    private String fecha;
    private String sello;
    private String formaDePago;
    private String noCertificado;
    private String certificado;
    private String subTotal;
    private String TipoCambio;
    private String moneda;
    private String total;
    private String tipoDeComprobante;
    private String metodoDePago;
    private String LugarExpedicion;
    private String rfcE;
    private String nombreE;
    private String rfcR;
    private String nombreR;
    private String cantidad;
    private String unidad;
    private String descripcion;
    private String valorUnitario;
    private String importe;
    private String RegimenFiscal;
    private String Regimen;
    private String UsoCFDI;
    private String BaseTraslado;
    private String Impuesto;
    private String TipoFactor;
    private String TasaOCuota;
    private String ImporteTraslado;
    private String Version;
    private String FechaTimbrado;
    private String RfcProvCertif;
    private String SelloCFD;
    private String NoCertificadoSAT;
    private String SelloSAT;
    private String UUIDTF;
    private String VersionSAT;
    private String nombreCFDI;
    private String calleDF;
    private String noExteriorDF;
    private String noInteriorDF;
    private String coloniaDF;
    private String municipioDF;
    private String estadoDF;
    private String paisDF;
    private String codigoPostalDF;
    private String calle;
    private String noExterior;
    private String noInterior;
    private String colonia;
    private String municipio;
    private String estado;
    private String pais;
    private String codigoPostal;
    private String impuestoRet;
    private String importeRet;
    private String TotalCargos;
    private String CodigoCargoOC;
    private String importeOC;
    private String ClaveProdServ;
    private String ClaveUnidad;
    private String facturaSAE;
    private String TUA;
    private String tipoViaje;
    private String nombreDepto;
    private String card;
    private String cardGas;
    private String conceptName;
    private String impuestoISH;
    private String importeISH;
    private String dirXML;
    private String dirPDF;
    private String miPDF;
    private String RFCEmisor;
    private String RFCReceptor;
    private String TotalCfdi;
    private String UuidCfdi;
    private String respuestaSAT;

    private ConsultaCFDIService consulta;
    private IConsultaCFDIService respuesta;
    private Acuse acuse;

    public BigDecimal getMiprop() {
        return this.miprop;
    }

    public void setMiprop(BigDecimal miprop) {
        this.miprop = miprop;
    }

    public String getMiPDF() {
        return this.miPDF;
    }

    public String getRutaPDF() {
        return this.rutaPDF;
    }

    public void setRutaPDF(String rutaPDF) {
        this.rutaPDF = rutaPDF;
    }

    public String getRutaIMG() {
        return this.rutaIMG;
    }

    public void setRutaIMG(String rutaIMG) {
        this.rutaIMG = rutaIMG;
    }

    public void setMiPDF(String miPDF) {
        this.miPDF = miPDF;
    }

    public String getRuta() {
        return this.ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getnUsario() {
        return this.nUsario;
    }

    public void setnUsario(String nUsario) {
        this.nUsario = nUsario;
    }

    public String getfUsuario() {
        return this.fUsuario;
    }

    public void setfUsuario(String fUsuario) {
        this.fUsuario = fUsuario;
    }

    public String getImpuestoISH() {
        return this.impuestoISH;
    }

    public void setImpuestoISH(String impuestoISH) {
        this.impuestoISH = impuestoISH;
    }

    public String getImporteISH() {
        return this.importeISH;
    }

    public void setImporteISH(String importeISH) {
        this.importeISH = importeISH;
    }

    public String getConceptName() {
        return this.conceptName;
    }

    public void setConceptName(String conceptName) {
        this.conceptName = conceptName;
    }

    public String getCardGas() {
        return this.cardGas;
    }

    public void setCardGas(String cardGas) {
        this.cardGas = cardGas;
    }

    public String getCard() {
        return this.card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getNombreDepto() {
        return this.nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    public String getTipoViaje() {
        return this.tipoViaje;
    }

    public void setTipoViaje(String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

    public String getTUA() {
        return this.TUA;
    }

    public void setTUA(String TUA) {
        this.TUA = TUA;
    }

    public String getFolioAbierto() {
        return this.folioAbierto;
    }

    public void setFolioAbierto(String folioAbierto) {
        this.folioAbierto = folioAbierto;
    }

    public String getUuidConcepto() {
        return this.uuidConcepto;
    }

    public void setUuidConcepto(String uuidConcepto) {
        this.uuidConcepto = uuidConcepto;
    }

    public String getRecuperarUUID() {
        return this.recuperarUUID;
    }

    public void setRecuperarUUID(String recuperarUUID) {
        this.recuperarUUID = recuperarUUID;
    }

    public XmlBean() {
        this.lista = new ArrayList();
        this.part = new Concepto();
        this.concepto = new Factura();
    }

    public Concepto getPart() {
        return this.part;
    }

    public void setPart(Concepto part) {
        this.part = part;
    }

    public String getValidarFactura() {
        return this.validarFactura;
    }

    public void setValidarFactura(String validarFactura) {
        this.validarFactura = validarFactura;
    }

    public String getValidarUUID() {
        return this.validarUUID;
    }

    public void setValidarUUID(String validarUUID) {
        this.validarUUID = validarUUID;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFolio() {
        return this.folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSello() {
        return this.sello;
    }

    public void setSello(String sello) {
        this.sello = sello;
    }

    public String getFormaDePago() {
        return this.formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public String getNoCertificado() {
        return this.noCertificado;
    }

    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    public String getCertificado() {
        return this.certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getSubTotal() {
        return this.subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getTipoCambio() {
        return this.TipoCambio;
    }

    public void setTipoCambio(String TipoCambio) {
        this.TipoCambio = TipoCambio;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTotal() {
        return this.total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTipoDeComprobante() {
        return this.tipoDeComprobante;
    }

    public void setTipoDeComprobante(String tipoDeComprobante) {
        this.tipoDeComprobante = tipoDeComprobante;
    }

    public String getMetodoDePago() {
        return this.metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public String getLugarExpedicion() {
        return this.LugarExpedicion;
    }

    public void setLugarExpedicion(String LugarExpedicion) {
        this.LugarExpedicion = LugarExpedicion;
    }

    public String getRfcE() {
        return this.rfcE;
    }

    public void setRfcE(String rfcE) {
        this.rfcE = rfcE;
    }

    public String getNombreE() {
        return this.nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getRfcR() {
        return this.rfcR;
    }

    public void setRfcR(String rfcR) {
        this.rfcR = rfcR;
    }

    public String getNombreR() {
        return this.nombreR;
    }

    public void setNombreR(String nombreR) {
        this.nombreR = nombreR;
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

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValorUnitario() {
        return this.valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getImporte() {
        return this.importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getRegimenFiscal() {
        return this.RegimenFiscal;
    }

    public void setRegimenFiscal(String RegimenFiscal) {
        this.RegimenFiscal = RegimenFiscal;
    }

    public String getRegimen() {
        return this.Regimen;
    }

    public void setRegimen(String Regimen) {
        this.Regimen = Regimen;
    }

    public String getUsoCFDI() {
        return this.UsoCFDI;
    }

    public void setUsoCFDI(String UsoCFDI) {
        this.UsoCFDI = UsoCFDI;
    }

    public String getBaseTraslado() {
        return this.BaseTraslado;
    }

    public void setBaseTraslado(String BaseTraslado) {
        this.BaseTraslado = BaseTraslado;
    }

    public String getImpuesto() {
        return this.Impuesto;
    }

    public void setImpuesto(String Impuesto) {
        this.Impuesto = Impuesto;
    }

    public String getTipoFactor() {
        return this.TipoFactor;
    }

    public void setTipoFactor(String TipoFactor) {
        this.TipoFactor = TipoFactor;
    }

    public String getTasaOCuota() {
        return this.TasaOCuota;
    }

    public void setTasaOCuota(String TasaOCuota) {
        this.TasaOCuota = TasaOCuota;
    }

    public String getImporteTraslado() {
        return this.ImporteTraslado;
    }

    public void setImporteTraslado(String ImporteTraslado) {
        this.ImporteTraslado = ImporteTraslado;
    }

    public String getVersion() {
        return this.Version;
    }

    public void setVersion(String Version) {
        this.Version = Version;
    }

    public String getFechaTimbrado() {
        return this.FechaTimbrado;
    }

    public void setFechaTimbrado(String FechaTimbrado) {
        this.FechaTimbrado = FechaTimbrado;
    }

    public String getRfcProvCertif() {
        return this.RfcProvCertif;
    }

    public void setRfcProvCertif(String RfcProvCertif) {
        this.RfcProvCertif = RfcProvCertif;
    }

    public String getSelloCFD() {
        return this.SelloCFD;
    }

    public void setSelloCFD(String SelloCFD) {
        this.SelloCFD = SelloCFD;
    }

    public String getNoCertificadoSAT() {
        return this.NoCertificadoSAT;
    }

    public void setNoCertificadoSAT(String NoCertificadoSAT) {
        this.NoCertificadoSAT = NoCertificadoSAT;
    }

    public String getSelloSAT() {
        return this.SelloSAT;
    }

    public void setSelloSAT(String SelloSAT) {
        this.SelloSAT = SelloSAT;
    }

    public String getUUIDTF() {
        return this.UUIDTF;
    }

    public void setUUIDTF(String UUIDTF) {
        this.UUIDTF = UUIDTF;
    }

    public String getVersionSAT() {
        return this.VersionSAT;
    }

    public void setVersionSAT(String VersionSAT) {
        this.VersionSAT = VersionSAT;
    }

    public String getNombreCFDI() {
        return this.nombreCFDI;
    }

    public void setNombreCFDI(String nombreCFDI) {
        this.nombreCFDI = nombreCFDI;
    }

    public String getCalleDF() {
        return this.calleDF;
    }

    public void setCalleDF(String calleDF) {
        this.calleDF = calleDF;
    }

    public String getNoExteriorDF() {
        return this.noExteriorDF;
    }

    public void setNoExteriorDF(String noExteriorDF) {
        this.noExteriorDF = noExteriorDF;
    }

    public String getNoInteriorDF() {
        return this.noInteriorDF;
    }

    public void setNoInteriorDF(String noInteriorDF) {
        this.noInteriorDF = noInteriorDF;
    }

    public String getColoniaDF() {
        return this.coloniaDF;
    }

    public void setColoniaDF(String coloniaDF) {
        this.coloniaDF = coloniaDF;
    }

    public String getMunicipioDF() {
        return this.municipioDF;
    }

    public void setMunicipioDF(String municipioDF) {
        this.municipioDF = municipioDF;
    }

    public String getEstadoDF() {
        return this.estadoDF;
    }

    public void setEstadoDF(String estadoDF) {
        this.estadoDF = estadoDF;
    }

    public String getPaisDF() {
        return this.paisDF;
    }

    public void setPaisDF(String paisDF) {
        this.paisDF = paisDF;
    }

    public String getCodigoPostalDF() {
        return this.codigoPostalDF;
    }

    public void setCodigoPostalDF(String codigoPostalDF) {
        this.codigoPostalDF = codigoPostalDF;
    }

    public String getCalle() {
        return this.calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNoExterior() {
        return this.noExterior;
    }

    public void setNoExterior(String noExterior) {
        this.noExterior = noExterior;
    }

    public String getNoInterior() {
        return this.noInterior;
    }

    public void setNoInterior(String noInterior) {
        this.noInterior = noInterior;
    }

    public String getColonia() {
        return this.colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getImpuestoRet() {
        return this.impuestoRet;
    }

    public void setImpuestoRet(String impuestoRet) {
        this.impuestoRet = impuestoRet;
    }

    public String getImporteRet() {
        return this.importeRet;
    }

    public void setImporteRet(String importeRet) {
        this.importeRet = importeRet;
    }

    public String getTotalCargos() {
        return this.TotalCargos;
    }

    public void setTotalCargos(String TotalCargos) {
        this.TotalCargos = TotalCargos;
    }

    public String getCodigoCargoOC() {
        return this.CodigoCargoOC;
    }

    public void setCodigoCargoOC(String CodigoCargoOC) {
        this.CodigoCargoOC = CodigoCargoOC;
    }

    public String getImporteOC() {
        return this.importeOC;
    }

    public void setImporteOC(String importeOC) {
        this.importeOC = importeOC;
    }

    public String getClaveProdServ() {
        return this.ClaveProdServ;
    }

    public void setClaveProdServ(String ClaveProdServ) {
        this.ClaveProdServ = ClaveProdServ;
    }

    public String getClaveUnidad() {
        return this.ClaveUnidad;
    }

    public void setClaveUnidad(String ClaveUnidad) {
        this.ClaveUnidad = ClaveUnidad;
    }

    public String getFacturaSAE() {
        return this.facturaSAE;
    }

    public void setFacturaSAE(String facturaSAE) {
        this.facturaSAE = facturaSAE;
    }

    public Connection getCn() {
        return this.cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public Connection getCnSAE() {
        return this.cnSAE;
    }

    public void setCnSAE(Connection cnSAE) {
        this.cnSAE = cnSAE;
    }

    public String getDirXML() {
        return this.dirXML;
    }

    public void setDirXML(String dirXML) {
        this.dirXML = dirXML;
    }

    public String getDirPDF() {
        return this.dirPDF;
    }

    public void setDirPDF(String dirPDF) {
        this.dirPDF = dirPDF;
    }

    public String getRFCEmisor() {
        return this.RFCEmisor;
    }

    public void setRFCEmisor(String RFCEmisor) {
        this.RFCEmisor = RFCEmisor;
    }

    public String getRFCReceptor() {
        return this.RFCReceptor;
    }

    public void setRFCReceptor(String RFCReceptor) {
        this.RFCReceptor = RFCReceptor;
    }

    public String getTotalCfdi() {
        return this.TotalCfdi;
    }

    public void setTotalCfdi(String TotalCfdi) {
        this.TotalCfdi = TotalCfdi;
    }

    public String getUuidCfdi() {
        return this.UuidCfdi;
    }

    public void setUuidCfdi(String UuidCfdi) {
        this.UuidCfdi = UuidCfdi;
    }

    public ConsultaCFDIService getConsulta() {
        return this.consulta;
    }

    public void setConsulta(ConsultaCFDIService consulta) {
        this.consulta = consulta;
    }

    public IConsultaCFDIService getRespuesta() {
        return this.respuesta;
    }

    public void setRespuesta(IConsultaCFDIService respuesta) {
        this.respuesta = respuesta;
    }

    public Acuse getAcuse() {
        return this.acuse;
    }

    public void setAcuse(Acuse acuse) {
        this.acuse = acuse;
    }

    public String getRespuestaSAT() {
        return this.respuestaSAT;
    }

    public void setRespuestaSAT(String respuestaSAT) {
        this.respuestaSAT = respuestaSAT;
    }

    public void leerCFDI(String rutaXML) throws JDOMException, IOException {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        SAXBuilder builder = new SAXBuilder();

        this.ruta = rutaXML;
        File xmlFile = new File(this.ruta);
        Document document = builder.build(xmlFile);
        Element rootNode = document.getRootElement();
        this.serie = rootNode.getAttributeValue("serie");
        if (this.serie == null) {
            this.serie = rootNode.getAttributeValue("Serie");
        }
        this.folio = rootNode.getAttributeValue("folio");
        if (this.folio == null) {
            this.folio = rootNode.getAttributeValue("Folio");
        }
        this.fecha = rootNode.getAttributeValue("fecha");
        if (this.fecha == null) {
            this.fecha = rootNode.getAttributeValue("Fecha");
        }
        this.sello = rootNode.getAttributeValue("sello");
        if (this.sello == null) {
            this.sello = rootNode.getAttributeValue("Sello");
        }
        this.formaDePago = rootNode.getAttributeValue("formaDePago");
        if (this.formaDePago == null) {
            this.formaDePago = rootNode.getAttributeValue("FormaPago");
        }
        this.noCertificado = rootNode.getAttributeValue("noCertificado");
        if (this.noCertificado == null) {
            this.noCertificado = rootNode.getAttributeValue("NoCertificado");
        }
        this.certificado = rootNode.getAttributeValue("certificado");
        if (this.certificado == null) {
            this.certificado = rootNode.getAttributeValue("Certificado");
        }
        this.subTotal = rootNode.getAttributeValue("subTotal");
        if (this.subTotal == null) {
            this.subTotal = rootNode.getAttributeValue("SubTotal");
        }
        this.TipoCambio = rootNode.getAttributeValue("tipoCambio");
        if (this.TipoCambio == null) {
            this.TipoCambio = rootNode.getAttributeValue("TipoCambio");
        }
        this.moneda = rootNode.getAttributeValue("moneda");
        if (this.moneda == null) {
            this.moneda = rootNode.getAttributeValue("Moneda");
        }
        this.total = rootNode.getAttributeValue("total");
        if (this.total == null) {
            this.total = rootNode.getAttributeValue("Total");
        }
        this.TotalCfdi = this.total;
        this.tipoDeComprobante = rootNode.getAttributeValue("tipoDeComprobante");
        if (this.tipoDeComprobante == null) {
            this.tipoDeComprobante = rootNode.getAttributeValue("TipoDeComprobante");
        }
        this.metodoDePago = rootNode.getAttributeValue("metodoDePago");
        if (this.metodoDePago == null) {
            this.metodoDePago = rootNode.getAttributeValue("MetodoPago");
        }
        this.LugarExpedicion = rootNode.getAttributeValue("LugarExpedicion");
        if (this.LugarExpedicion == null) {
            this.LugarExpedicion = rootNode.getAttributeValue("LugarExpedicion");
        }
        this.VersionSAT = rootNode.getAttributeValue("version");
        if (this.VersionSAT == null) {
            this.VersionSAT = rootNode.getAttributeValue("Version");
        }
        List list = rootNode.getChildren();
        for (int i = 0; i < list.size(); i++) {
            Element elementoCFDI = (Element) list.get(i);
            String valor = elementoCFDI.getName();
            if (valor.equals("Emisor")) {
                this.rfcE = elementoCFDI.getAttributeValue("rfc");
                if (this.rfcE == null) {
                    this.rfcE = elementoCFDI.getAttributeValue("Rfc");
                }
                this.RFCEmisor = this.rfcE;
                this.nombreE = elementoCFDI.getAttributeValue("nombre");
                if (this.nombreE == null) {
                    this.nombreE = elementoCFDI.getAttributeValue("Nombre");
                }
                this.RegimenFiscal = elementoCFDI.getAttributeValue("RegimenFiscal");
            }

            if (valor.equals("Receptor")) {
                this.rfcR = elementoCFDI.getAttributeValue("rfc");
                if (this.rfcR == null) {
                    this.rfcR = elementoCFDI.getAttributeValue("Rfc");
                }
                this.RFCReceptor = this.rfcR;
                this.nombreR = elementoCFDI.getAttributeValue("nombre");
                if (this.nombreR == null) {
                    this.nombreR = elementoCFDI.getAttributeValue("Nombre");
                }
                this.UsoCFDI = elementoCFDI.getAttributeValue("UsoCFDI");
            }
            List listaCampos = elementoCFDI.getChildren();
            for (int j = 0; j < listaCampos.size(); j++) {
                Element campo = (Element) listaCampos.get(j);
                String valor2 = campo.getName();

                if (valor2.equals("DomicilioFiscal")) {
                    this.calleDF = campo.getAttributeValue("calle");
                    this.noExteriorDF = campo.getAttributeValue("noExterior");
                    this.noInteriorDF = campo.getAttributeValue("noInterior");
                    this.coloniaDF = campo.getAttributeValue("colonia");
                    this.municipioDF = campo.getAttributeValue("municipio");
                    this.estadoDF = campo.getAttributeValue("estado");
                    this.paisDF = campo.getAttributeValue("pais");
                    this.codigoPostalDF = campo.getAttributeValue("codigoPostal");
                }
                if (valor2.equals("RegimenFiscal")) {
                    this.RegimenFiscal = campo.getAttributeValue("Regimen");
                }
                if (valor2.equals("Domicilio")) {
                    this.calle = campo.getAttributeValue("calle");
                    this.noExterior = campo.getAttributeValue("noExterior");
                    this.noInterior = campo.getAttributeValue("noInterior");
                    this.colonia = campo.getAttributeValue("colonia");
                    this.municipio = campo.getAttributeValue("municipio");
                    this.estado = campo.getAttributeValue("estado");
                    this.pais = campo.getAttributeValue("pais");
                    this.codigoPostal = campo.getAttributeValue("codigoPostal");
                }

                if (valor2.equals("TimbreFiscalDigital")) {
                    this.RfcProvCertif = campo.getAttributeValue("RfcProvCertif");
                    this.Version = campo.getAttributeValue("version");
                    if (this.Version == null) {
                        this.Version = campo.getAttributeValue("Version");
                    }
                    this.UUIDTF = campo.getAttributeValue("uuid");
                    if (this.UUIDTF == null) {
                        this.UUIDTF = campo.getAttributeValue("UUID");
                    }
                    this.UuidCfdi = this.UUIDTF;
                    this.FechaTimbrado = campo.getAttributeValue("fechaTimbrado");
                    if (this.FechaTimbrado == null) {
                        this.FechaTimbrado = campo.getAttributeValue("FechaTimbrado");
                    }
                    this.SelloCFD = campo.getAttributeValue("selloCFD");
                    if (this.SelloCFD == null) {
                        this.SelloCFD = campo.getAttributeValue("SelloCFD");
                    }
                    this.NoCertificadoSAT = campo.getAttributeValue("noCertificadoSAT");
                    if (this.NoCertificadoSAT == null) {
                        this.NoCertificadoSAT = campo.getAttributeValue("NoCertificadoSAT");
                    }
                    this.SelloSAT = campo.getAttributeValue("selloSAT");
                    if (this.SelloSAT == null) {
                        this.SelloSAT = campo.getAttributeValue("SelloSAT");
                    }
                }
                if (valor2.equals("Concepto")) {
                    this.cantidad = campo.getAttributeValue("cantidad");
                    if (this.cantidad == null) {
                        this.cantidad = campo.getAttributeValue("Cantidad");
                    }
                    this.unidad = campo.getAttributeValue("unidad");
                    if (this.unidad == null) {
                        this.unidad = campo.getAttributeValue("Unidad");
                    }

                    this.ClaveUnidad = campo.getAttributeValue("ClaveUnidad");

                    this.descripcion = campo.getAttributeValue("descripcion");
                    if (this.descripcion == null) {
                        this.descripcion = campo.getAttributeValue("Descripcion");
                    }
                    this.valorUnitario = campo.getAttributeValue("valorUnitario");
                    if (this.valorUnitario == null) {
                        this.valorUnitario = campo.getAttributeValue("ValorUnitario");
                    }
                    this.importe = campo.getAttributeValue("importe");
                    if (this.importe == null) {
                        this.importe = campo.getAttributeValue("Importe");
                    }
                    this.ClaveProdServ = campo.getAttributeValue("ClaveProdServ");
                    this.lista.add(this.cantidad);
                    this.lista.add(this.unidad);
                    this.lista.add(this.ClaveUnidad);
                    this.lista.add(this.descripcion);
                    this.lista.add(this.valorUnitario);
                    this.lista.add(this.importe);
                }

                List otros = campo.getChildren();
                for (int k = 0; k < otros.size(); k++) {
                    Element campo2 = (Element) otros.get(k);
                    String valor3 = campo.getName();
                    if (valor3.equals("Aerolineas")) {
                        Double valTUA = Double.valueOf(campo.getAttributeValue("TUA"));
                        if (valTUA > 0.00) {
                            this.TUA = campo.getAttributeValue("TUA");
                        }
                    }
                    if (valor3.equals("Traslados")) {
                        this.Impuesto = campo2.getAttributeValue("impuesto");
                        if (this.Impuesto == null) {
                            this.Impuesto = campo2.getAttributeValue("Impuesto");
                        }
                        this.TasaOCuota = campo2.getAttributeValue("tasa");
                        if (this.TasaOCuota == null) {
                            this.TasaOCuota = campo2.getAttributeValue("TasaOCuota");
                        }

                        Double valIVa = Double.valueOf(campo2.getAttributeValue("Importe"));
                        if (valIVa > 0.0) {
                            this.ImporteTraslado = campo2.getAttributeValue("Importe");
                        }

                        this.BaseTraslado = campo2.getAttributeValue("Base");

                    }

                    if (valor3.equals("ImpuestosLocales")) {
                        this.impuestoISH = campo2.getAttributeValue("ImpLocTrasladado");
                        this.importeISH = campo2.getAttributeValue("Importe");
                    }
                    if (valor3.equals("Retenciones")) {
                        this.impuestoRet = campo2.getAttributeValue("impuesto");
                        if (this.impuestoRet == null) {
                            this.impuestoRet = campo2.getAttributeValue("Impuesto");
                        }
                        this.importeRet = campo2.getAttributeValue("importe");
                        if (this.importeRet == null) {
                            this.importeRet = campo2.getAttributeValue("Importe");
                        }
                    }
                    if (valor3.equals("Aerolineas")) {
                        this.TotalCargos = campo2.getAttributeValue("TotalCargos");

                        List otros2 = campo2.getChildren();
                        for (int l = 0; l < otros2.size(); l++) {
                            Element campo3 = (Element) otros2.get(l);
                            String valor4 = campo2.getName();
                            if (valor4.equals("OtrosCargos")) {
                                this.CodigoCargoOC = campo3.getAttributeValue("CodigoCargo");
                                this.importeOC = campo3.getAttributeValue("Importe");
                            }
                        }
                    }
                }
            }
        }

    }

    public void insertarPartidas() {
        IConceptoDao cDao = new ConceptoDaoImp();
        int a = 0;
        int b = 1;
        int c = 2;
        int d = 3;
        int e = 4;
        int f = 5;

        int tamaño = this.lista.size() / 6;
        for (String ap : this.lista) {
            while (tamaño > 0) {
                this.part.setCantidad((String) this.lista.get(a));
                this.part.setUnidad((String) this.lista.get(b));
                this.part.setClaveUnidad((String) this.lista.get(c));
                this.part.setDescripcion((String) this.lista.get(d));
                this.part.setPrecioUnitario(new BigDecimal((String) this.lista.get(e)));
                this.part.setUuid(this.UUIDTF);
                this.part.setImporte(new BigDecimal((String) this.lista.get(f)));
                cDao.guardarConcepto(this.part);
                this.part = new Concepto();
                a += 6;
                b += 6;
                c += 6;
                d += 6;
                e += 6;
                f += 6;
                tamaño -= 1;
            }
        }
        this.lista.clear();
    }

    public void limpiarLista() {
        this.lista.clear();
    }

    public void insertarConcepto(String filename) throws MalformedURLException {
        IFacturaDao cDao = new FacturaDaoImpl();
        this.concepto.setNombreFactura(filename);
        String pdf = filename.replace("xml", "").replace("XML", "");
        this.concepto.setNombreFacturaPdf(pdf + "pdf");
        this.concepto.setNombre(getConceptName());
        if (this.subTotal != null) {
            this.concepto.setImporte(new BigDecimal(getSubTotal()));
        }
        if (this.ImporteTraslado != null) {
            this.concepto.setIva(new BigDecimal(getImporteTraslado()));
        }

        if (this.TUA != null) {
            this.concepto.setTua(new BigDecimal(getTUA()));
        }
        if (this.serie == null) {
            this.serie = "";
        }
        if (this.folio == null) {
            this.serie = "";
        }
        String no_factura = this.serie + " " + this.folio;
        if (" null".contains(no_factura)) {
            no_factura = null;
        }
        Optional<String> op = Optional.ofNullable(no_factura);
        String no_factura_op = op.orElse(this.UUIDTF);
        this.concepto.setFactura(no_factura_op);
        this.concepto.setUuid(this.UUIDTF);
        this.concepto.setRfc(this.rfcE);
        this.concepto.setNombre(this.nombreE);
        this.concepto.setTotalmxn(new BigDecimal(this.total));
        this.concepto.setNombreUsuario(this.usuario.getSubcuenta());
        IUsuarioDao dao = new UsuarioDaoImpl();
        this.concepto.setFolioUsuario(String.valueOf(dao.obtenerFolioUsuario()));
        this.concepto.setTipo(getTipoViaje());
        this.concepto.setEstado("Agregar");
        this.concepto.setRfcReceptor(getRfcR());
        this.concepto.setNombreReceptor(getNombreR());
        this.concepto.setModificarArchivo("No");
        this.concepto.setPropina(getMiprop());
        if (this.importeISH != null) {
            this.concepto.setIsh(new BigDecimal(getImporteISH()));
        }
        this.concepto.setTarjeta(getCard());
        this.concepto.setRutaXml(getDirXML());
        this.concepto.setRuraPdf(getDirPDF());
        this.concepto.setTarjetaGasolina(getCardGas());
        this.concepto.setDepartamento(getNombreDepto());
        this.concepto.setLigarExpedicion(getLugarExpedicion());
        this.concepto.setSelloCfd(getSelloCFD());
        this.concepto.setSelloSat(getSelloSAT());
        this.concepto.setFechaTimbrado(getFechaTimbrado());
        this.concepto.setFecha(getFecha());
        this.concepto.setUsoCfdi(getUsoCFDI());
        this.concepto.setRfcProvCertif(getRfcProvCertif());
        this.concepto.setVersionSat(getVersionSAT());
        this.concepto.setNoCertificadoSat(getNoCertificadoSAT());
        this.concepto.setVerUuid(getVersion());
        this.concepto.setNoCertificado(getNoCertificado());
        if (this.TipoCambio != null) {
            this.concepto.setTipoCambio(new BigDecimal(getTipoCambio()));
        }
        this.concepto.setModenda(getMoneda());
        this.concepto.setTipoComprobante(getTipoDeComprobante());
        this.concepto.setMetodoPago(getMetodoDePago());
        this.concepto.setFormaPago(getFormaDePago());
        if (this.impuestoRet != null) {
            this.concepto.setImpuestoRetenido(new BigDecimal(getImporteRet()));
        }

        cDao.guardarFactura(this.concepto);
        insertarPartidas();
        generarFacturaPdf(UUIDTF, this.concepto.getNombreFactura());
        this.concepto = new Factura();
    }

    public void insertarConcepto2(String filename) throws MalformedURLException {
        IFacturaDao cDao = new FacturaDaoImpl();
        this.concepto.setNombreFactura(filename);
        this.concepto.setNombreFacturaPdf(filename);
        this.concepto.setNombreUsuario(this.usuario.getSubcuenta());
        IUsuarioDao dao = new UsuarioDaoImpl();
        this.concepto.setFolioUsuario(String.valueOf(dao.obtenerFolioUsuario()));
        cDao.guardarFactura(this.concepto);
        this.concepto = new Factura();
    }

    public void limpiarVariables() {
        this.validarFactura = null;
        this.validarUUID = null;
        this.folioAbierto = null;
        this.uuidConcepto = null;
        this.recuperarUUID = null;
        this.nUsario = null;
        this.fUsuario = null;
        this.serie = null;
        this.folio = null;
        this.fecha = null;
        this.sello = null;
        this.formaDePago = null;
        this.noCertificado = null;
        this.certificado = null;
        this.subTotal = null;
        this.TipoCambio = null;
        this.moneda = null;
        this.total = null;
        this.tipoDeComprobante = null;
        this.metodoDePago = null;
        this.LugarExpedicion = null;
        this.rfcE = null;
        this.nombreE = null;
        this.rfcR = null;
        this.nombreR = null;
        this.cantidad = null;
        this.unidad = null;
        this.descripcion = null;
        this.valorUnitario = null;
        this.importe = null;
        this.RegimenFiscal = null;
        this.Regimen = null;
        this.UsoCFDI = null;
        this.BaseTraslado = null;
        this.Impuesto = null;
        this.TipoFactor = null;
        this.TasaOCuota = null;
        this.ImporteTraslado = null;
        this.Version = null;
        this.FechaTimbrado = null;
        this.RfcProvCertif = null;
        this.SelloCFD = null;
        this.NoCertificadoSAT = null;
        this.SelloSAT = null;
        this.UUIDTF = null;
        this.VersionSAT = null;
        this.nombreCFDI = null;
        this.calleDF = null;
        this.noExteriorDF = null;
        this.noInteriorDF = null;
        this.coloniaDF = null;
        this.municipioDF = null;
        this.estadoDF = null;
        this.paisDF = null;
        this.codigoPostalDF = null;
        this.calle = null;
        this.noExterior = null;
        this.noInterior = null;
        this.colonia = null;
        this.municipio = null;
        this.estado = null;
        this.pais = null;
        this.codigoPostal = null;
        this.impuestoRet = null;
        this.importeRet = null;
        this.TotalCargos = null;
        this.CodigoCargoOC = null;
        this.importeOC = null;
        this.ClaveProdServ = null;
        this.ClaveUnidad = null;
        this.facturaSAE = null;
        this.TUA = null;
        this.tipoViaje = null;
        this.nombreDepto = null;
        this.card = null;
        this.cardGas = null;
        this.conceptName = null;
        this.impuestoISH = null;
        this.importeISH = null;
        this.dirXML = null;
        this.dirPDF = null;
        this.miPDF = null;
        this.miprop = null;
        this.importeRet = null;
        this.impuestoRet = null;
    }

    public String validarUUID() {
        IFacturaDao ifd = new FacturaDaoImpl();
        Optional<String> op = Optional.ofNullable(ifd.validarUuidExistente(UUIDTF));
        String validacion = op.orElse("NO EXISTE");
        return validacion;
    }

    public String validacion() {
        String resultado = "";
        if (usuario.getPerfil().getWs().equals("SI")) {
            this.consulta = new ConsultaCFDIService();
            this.respuesta = consulta.getBasicHttpBindingIConsultaCFDIService();
            //System.out.println("?re=" + this.rfcE + "&rr=" + this.rfcR + "&tt=" + this.total + "&id=" + this.UUIDTF);

            this.acuse = respuesta.consulta("?re=" + this.rfcE + "&rr=" + this.rfcR + "&tt=" + this.total + "&id=" + this.UUIDTF);
            Logger logger = Logger.getLogger("Validación CFDI");
            logger.log(Level.INFO, "ESTADO CFDI:{0} UUID:{1}", new Object[]{acuse.getEstado().getValue(), this.UUIDTF});

            resultado = acuse.getEstado().getValue();
        } else if (usuario.getPerfil().getWs().equals("NO")) {
            resultado = "Vigente";
        }
        return resultado;
    }

    public void generarFacturaPdf(String uuid, String fileName) throws MalformedURLException {
        Connection conn = null;
        try {
            try {

                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");       
                conn = DriverManager.getConnection(Configuracion.getConexDB(), Configuracion.getConexUser(), Configuracion.getConexPwd());
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }

            fileName = fileName.replace("xml", "").replace("XML", "");
            Map parameter = new HashMap();
            parameter.put("uuid", uuid);
            URL in = getClass().getResource("/com/dmjsistemas/reporte/facturaPDF.jasper");
            JasperReport jr = (JasperReport) JRLoader.loadObject(in);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, conn);
            JasperExportManager.exportReportToPdfFile(jp, Configuracion.getPathPDF() + fileName + "pdf");

        } catch (JRException ex) {
            Logger.getLogger(XmlBean.class.getName()).log(Level.SEVERE, null, "ERROR AL GENERAR EL REPORTE: " + ex);
        }
    }

}
