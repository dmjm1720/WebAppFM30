package com.dmjsistemas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.dmjsistemas.impl.CapturaDaoImpl;
import com.dmjsistemas.model.Captura;
import com.dmjsistemas.dao.ICapturaDao;
import com.dmjsistemas.dao.IConceptoGastosDao;
import com.dmjsistemas.dao.IFacturaDao;
import com.dmjsistemas.dao.ISubcuentaDao;
import com.dmjsistemas.dao.IUsuarioDao;
import com.dmjsistemas.gastos.model.ConceptoGastos;
import com.dmjsistemas.impl.ConceptoGastosDaoImpl;
import com.dmjsistemas.impl.FacturaDaoImpl;
import com.dmjsistemas.impl.SubCuentaImpl;
import com.dmjsistemas.impl.UsuarioDaoImpl;
import com.dmjsistemas.model.Factura;
import com.dmjsistemas.model.Subcuenta;
import com.dmjsistemas.model.Usuario;
import com.dmjsistemas.util.Configuracion;
import com.dmjsistemas.util.HibernateUtilGastos;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;
import net.sf.jasperreports.engine.JRException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.PrimeFaces;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

@Named("captura")
@ViewScoped
public class CapturaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Captura> listaCaptura;
    private List<Captura> listaCapturaEnviado;
    private Captura captura;
    private Captura cap;
    private Subcuenta cta;
    private Tipo tipo;
    private String beneficiario;
    private String banco;
    private Subcuenta subcuenta;
    private List<ConceptoGastos> listaConceptoGastos;
    private ConceptoGastos conceptoGastos;
    Session session = null;
    Transaction transaction = null;
    private List<Factura> listaFactura;
    private List<Factura> listaFactura2;
    private Double mxn = 0.0;
    private Double usd = 0.0;
    Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
    private Usuario usuario;
    private Pregunta pregunta;
    private String granTotal;
    private Double granTotal2 = 0.0;
    private String reference_no;
    private String granSubtotal;
    private String nuevaCuenta;

    private List<String> listaCuenta;

    //FECHA DE PAGO
    private int dia;
    private int año;
    private Calendar hoy;
    private String fecPago;

    public Captura getCaptura() {
        return captura;
    }

    public void setCaptura(Captura captura) {
        this.captura = captura;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Subcuenta getSubcuenta() {
        return subcuenta;
    }

    public void setSubcuenta(Subcuenta subcuenta) {
        this.subcuenta = subcuenta;
    }

    public List<ConceptoGastos> getListaConceptoGastos() {
        return listaConceptoGastos;
    }

    public ConceptoGastos getConceptoGastos() {
        return conceptoGastos;
    }

    public void setConceptoGastos(ConceptoGastos conceptoGastos) {
        this.conceptoGastos = conceptoGastos;
    }

    public List<Factura> getListaFactura() {
        IFacturaDao dao = new FacturaDaoImpl();
        this.listaFactura = dao.listaFactura();
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public List<Factura> getListaFactura2() {
        return listaFactura2;
    }

    public void setListaFactura2(List<Factura> listaFactura2) {
        this.listaFactura2 = listaFactura2;
    }

    public Double getMxn() {
        return mxn;
    }

    public void setMxn(Double mxn) {
        this.mxn = mxn;
    }

    public Double getUsd() {
        return usd;
    }

    public void setUsd(Double usd) {
        this.usd = usd;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public CapturaBean() {

    }

    public String getGranTotal() {
        return granTotal;
    }

    public void setGranTotal(String granTotal) {
        this.granTotal = granTotal;
    }

    public String getReference_no() {
        return reference_no;
    }

    public void setReference_no(String reference_no) {
        this.reference_no = reference_no;
    }

    public Double getGranTotal2() {
        return granTotal2;
    }

    public void setGranTotal2(Double granTotal2) {
        this.granTotal2 = granTotal2;
    }

    public String getGranSubtotal() {
        return granSubtotal;
    }

    public void setGranSubtotal(String granSubtotal) {
        this.granSubtotal = granSubtotal;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Calendar getHoy() {
        return hoy;
    }

    public void setHoy(Calendar hoy) {
        this.hoy = hoy;
    }

    public String getFecPago() {
        return fecPago;
    }

    public void setFecPago(String fecPago) {
        this.fecPago = fecPago;
    }

    public Subcuenta getCta() {
        return cta;
    }

    public void setCta(Subcuenta cta) {
        this.cta = cta;
    }

    public Captura getCap() {
        return cap;
    }

    public void setCap(Captura cap) {
        this.cap = cap;
    }

    public String getNuevaCuenta() {
        return nuevaCuenta;
    }

    public void setNuevaCuenta(String nuevaCuenta) {
        this.nuevaCuenta = nuevaCuenta;
    }

    @PostConstruct
    public void init() {
        this.listaCaptura = new ArrayList<>();
        this.listaCapturaEnviado = new ArrayList<>();
        this.captura = new Captura();
        this.cap = new Captura();
        this.cta = new Subcuenta();
        this.tipo = new Tipo();
        this.subcuenta = new Subcuenta();
        this.listaConceptoGastos = new ArrayList<>();
        this.conceptoGastos = new ConceptoGastos();
        this.listaFactura = new ArrayList<>();
        this.listaFactura2 = new ArrayList<>();
        this.usuario = new Usuario();
        this.pregunta = new Pregunta();
        this.listaCuenta = new ArrayList<>();
        //getListaCuenta();
    }

    ///**MÉTODO PARA COLOCAR LA FECHA DE PAGO**//
    public void fechaPago() throws ParseException {
        this.hoy = Calendar.getInstance();
        this.dia = this.hoy.get(7);
        switch (this.dia) {
            case 1:
                this.hoy.add(5, 5);
                break;
            case 2:
                this.hoy.add(5, 4);
                break;
            case 3:
                this.hoy.add(5, 3);
                break;
            case 4:
                this.hoy.add(5, 2);
                break;
            case 5:
                this.hoy.add(5, 8);
                break;
            case 6:
                this.hoy.add(5, 7);
                break;
            default:
                this.hoy.add(5, 6);
        }
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MMMM-yyyy");
        this.fecPago = formateador.format(this.hoy.getTime());
        System.out.println("Fecha de pago" + fecPago);
        Date date1 = new SimpleDateFormat("dd-MMMM-yyyy").parse(fecPago);
        System.out.println("Fecha dos" + date1);
        this.captura.setFecha(date1);
    }

    //**MÉTODO PARA LAS PREGUNTAS**//
    public void tienesXML() {
        PrimeFaces.current().executeScript("PF('dlgDecision').show(),PF('dialogPInicial').hide()");
        PrimeFaces.current().ajax().update("frmDec");
        this.pregunta.setTipoPregunta("¿Tienes XML?");
    }

    public void tipoDeMoneda() {
        this.pregunta.setTipoPregunta("¿Cuál es el tipo de moneda?");
    }

    public void tipoSolicitud() {
        this.pregunta.setTipoPregunta("Selecciona el tipo de solicitud a capturar");
    }

    public void actualizarSiguiente() {
        PrimeFaces.current().executeScript("PF('dlgConXML').show(), PF('dlgDecision').hide()");
        PrimeFaces.current().ajax().update("frmDec");
    }

    public void portalGastos() {
        this.pregunta.setTipoPregunta("Desde el portal de gastos");
    }

    public List<String> completeBanco(String query) {
        String queryLowerCase = query.toLowerCase();
        ISubcuentaDao lista = new SubCuentaImpl();
        List<String> listaSubcuenta = new ArrayList<>();
        List<Subcuenta> listaSub = lista.listaSubcuenta();
        listaSub.forEach((pro) -> {
            listaSubcuenta.add(pro.getBanco());
        });

        return listaSubcuenta.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }

    public List<String> getListaCuenta() {
        ISubcuentaDao lista = new SubCuentaImpl();
        List<Subcuenta> listaSub = lista.listaCuenta();
        listaCuenta.clear();
        listaSub.forEach((subcuenta1) -> {
            listaCuenta.add(subcuenta1.getCuenta());
        });

        return listaCuenta;
    }

    //**MÉTODO PARA LISTAR LA CAPTURA**//
    public List<Captura> getListaCaptura() {
        ICapturaDao lDao = new CapturaDaoImpl();
        this.listaCaptura = lDao.listaCaptura();
        return listaCaptura;
    }

    //**MÉTODO PARA LISTAR LA CAPTURA**//
    public List<Captura> getListaCapturaEnviado() {
        ICapturaDao lDao = new CapturaDaoImpl();
        this.listaCapturaEnviado = lDao.listaCapturaEnviado();
        return listaCapturaEnviado;
    }

    //**MÉTODO PARA LLENAR LOS CAMPOS FALTANTES DEL BENEFICIARIO Y DEPARTAMENTO**//
    public void llenarCamposFaltantes(String beneficiario) {
        @SuppressWarnings("UnusedAssignment")
        Subcuenta s;
        ISubcuentaDao dao = new SubCuentaImpl();
        s = dao.filtroSubcuenta(beneficiario);
        String sinInfo = "NO HAY INFORMACIÓN EN SISTEMA";

        Optional<String> opBanco = Optional.ofNullable(s.getBanco());
        this.captura.setBancoBeneficiario(opBanco.orElse(sinInfo));

        Optional<String> opCuenta = Optional.ofNullable(s.getCuenta());
        this.captura.setCuentaBeneficiario(opCuenta.orElse(sinInfo));

        Optional<String> opSubcuenta = Optional.ofNullable(s.getSubcuenta());
        this.captura.setAutorizacionBeneficiario(opSubcuenta.orElse(sinInfo));

        Optional<String> opAutoriza = Optional.ofNullable(s.getCuentaGastos());
        this.captura.setSeccionAutoriza(opAutoriza.orElse(sinInfo));

        if (captura.getBancoBeneficiario().equals(sinInfo)
                || captura.getCuentaBeneficiario().equals(sinInfo)
                || captura.getAutorizacionBeneficiario().equals(sinInfo)
                || captura.getSeccionAutoriza().equals(sinInfo)) {
            PrimeFaces.current().executeScript("Swal.fire({\n"
                            + "  position: 'top-center',\n"
                            + "  icon: 'error',\n"
                            + "  title: '¡Algo salió mal!',\n"
                            + "  text: 'Validar con el área contable, falta información en sistema del proveedor que intentas procesar',\n"
                            + "  showConfirmButton: true,\n"
                            + "})");
        }

        this.captura.setPagarA(s.getCompanyName());
        this.usuario.setDepartamento(us.getDepartamento());
    }

//**MÉTODO PARA FILTRAR LOS DATOS DEL BENEFICIARIO**//
    public List<String> completeBeneficiario(String query) {
        String queryLowerCase = query.toLowerCase();
        ISubcuentaDao lista = new SubCuentaImpl();
        List<String> listaSubcuenta = new ArrayList<>();
        List<Subcuenta> listaSub = lista.listaSubcuenta();
        listaSub.forEach((pro) -> {
            listaSubcuenta.add(pro.getCompanyName());
        });
        return listaSubcuenta.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }

    //**MÉTODO PARA GUARDAR CAPTURA CON DATOS PORTAL GASTOS MN**//
    public void guardarPago() {
        ICapturaDao iCapturaDao = new CapturaDaoImpl();
        this.captura.setEstado("CAPTURADO");
        this.captura.setXml(getPregunta().getXmlSiNo());
        this.captura.setFechaCaptura(new Date());
        this.captura.setFolio(String.valueOf(folioUsuario()));
        this.captura.setReferencia(String.valueOf(folioUsuario()));
        obtenerNombresFacturas();
        this.captura.setReferenceNo(reference_no);
        actualizarFolioUsuario(us, String.valueOf(folioUsuario()));
        if (pregunta.getTipoMoneda().equals("MONEDA NACIONAL")) {
            this.captura.setCurrency("MXN");
            if (pregunta.getXmlSiNo().equals("NO")) {
                if (captura.getPortal().equals("SI")) {
                    this.captura.setImporteTotalMx(round(String.valueOf(this.granTotal2), 4));
                } else {
                    this.captura.setImporteTotalMx(round(String.valueOf(captura.getImporteTotalMx()), 4));
                }
            } else if (pregunta.getXmlSiNo().equals("SI")) {
                this.captura.setImporteTotalMx(round(this.granTotal, 4));
                this.captura.setSubtotal(round(this.granSubtotal, 4));
            }

        } else if (pregunta.getTipoMoneda().equals("DÓLARES")) {
            this.captura.setCurrency("USD");
            if (pregunta.getXmlSiNo().equals("NO")) {
                if (captura.getPortal().equals("SI")) {
                    this.captura.setImporteTotalMx(round(String.valueOf(this.granTotal2), 4));
                } else {
                    this.captura.setImporteTotalMx(round(String.valueOf(captura.getImporteTotalUsd()), 4));
                }

            } else if (pregunta.getXmlSiNo().equals("SI")) {
                this.captura.setImporteTotalMx(round(this.granTotal, 4));
                this.captura.setSubtotal(round(this.granSubtotal, 4));
            }

        }

        if (this.captura.getTipoSolicitud().equals("TRANSFERENCIA")) {
            Subcuenta sub;
            ISubcuentaDao dao = new SubCuentaImpl();
            String[] nombre = this.subcuenta.getCompanyName().split(" ");
            sub = dao.filtroSubcuenta(nombre[0] + " " + nombre[1]);

            this.captura.setSubcuenta(sub);
            this.captura.setUsuario(us);
            iCapturaDao.guardar(captura);
            this.captura = new Captura();
            this.subcuenta = new Subcuenta();
        } else {
            this.captura.setUsuario(us);
            iCapturaDao.guardar(captura);
            this.captura = new Captura();
            this.subcuenta = new Subcuenta();

        }
        this.listaFactura.clear();
        //this.mxn = 0.0;

    }

    ///**MÉTODO PARA FINALIZAR Y ENVIAR LA CAPTURA**//
    public void procesar(String folio, String fecha, String pagarA, String tipoSol, String concepto, String total, String moneda) {
        try {
            enviarCorreo(folio, fecha, pagarA, tipoSol, concepto, total, moneda);
        } catch (MessagingException ex) {
            Logger.getLogger(CapturaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizarEstadoEnviado(folio);
        String info = "La solicitud de pago FM30 con Folio: " + folio + " y Fecha de pago: " + fecha + " se ha envido para su proceso de revisión";
        PrimeFaces.current().executeScript("Swal.fire({\n"
                + "  position: 'top-center',\n"
                + "  icon: 'success',\n"
                + "  title: 'Envío exitoso',\n"
                + "  text: '" + info + "',\n"
                + "  showConfirmButton: false,\n"
                + "  timer: 8000\n"
                + "})");
    }

    //**MÉTODO PARA ENVIAR CORREO DE ENVIAR CAPTURA**//
    public void enviarCorreo(String folio, String fecha, String pagar, String tipoSol, String concepto, String total, String moneda) throws MessagingException {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.office365.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "portal@marubeni.com.mx");
        props.setProperty("mail.smtp.auth", "true");
        javax.mail.Session sess = javax.mail.Session.getDefaultInstance(props, null);
        sess.setDebug(true);
        BodyPart texto = new MimeBodyPart();
        texto.setContent("<html>"
                + "<head>"
                + "<title></title>"
                + "</head>"
                + "<body>"
                + "<table width='678' height='315' border='0' bordercolor='#0000FF' bgcolor='#FFFFFF'>"
                + "<tr>"
                + "<td height='50' colspan='3' bordercolor='#FFFFFF'><br><br></td></tr><tr><td colspan='3' bordercolor='#FFFFFF'>"
                + "<p align='left' style='font-family:calibri; font-size:17px'>"
                + "<font color='#086A87'>Se solicita el pago del siguiente proveedor, la autorizaci&oacute;n se encuentra anexo al mismo: </font><br><br>"
                + "<font color='#17202a'><b>Proveedor: </b></font>"
                + "<font color='#086A87'> " + pagar + "</font><br>"
                + "<font color='black'><b>Fecha de pago: </b></font>"
                + "<font color='#086A87'>" + fecha + "</font><br> "
                + "<font color='black'><b>Relaci&oacute;n de facturas: </b></font>"
                + "<font color='#086A87'>" + concepto + "</font><br>"
                + "<font color='black'><b>Monto: </b></font>"
                + "<font color='#086A87'>$" + total + "</font><br> "
                + "<font color='black'><b>Moneda: </b></font>"
                + "<font color='#086A87'>" + moneda + "</font><br><br>"
                + "<font color='black'><b>Total: </b></font>"
                + "<font color='#086A87'>" + total + "</font><br>"
                + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td width='425' bordercolor='#FFFFFF'>"
                + "<p align='left' style='font-family:calibri; font-size:17px'><br>"
                + "<font color='#17202a'>Solicitud de gastos FM30 | </font>"
                + "<font color='#E60013'>Marubeni M&eacute;xico, S.A. de C.V.</font><br>"
                + "<a href='https://fm30.marubeni.com.mx' target='_blank'><img src='cid:image' width='45%'/></a>"
                + "</td>"
                + "<td width='122' bordercolor='#FFFFFF'></td>"
                + "<td width='222' rowspan='2' bordercolor='#FFFFFF'></td>"
                + "</tr>"
                + "<tr>"
                + "<td colspan='2' bordercolor='#17202a'><br><br>"
                + "<p align='center' style='font-family:calibri; font-size:20px'>"
                + "<font color='#086A87'><br>MENSAJE ENVIADO DESDE EL SISTEMA DE SOLICITUD DE GASTOS FM30.</font></p>"
                + "</td>"
                + "</tr>"
                + "</table>"
                + "</body>"
                + "</html>", "text/html");

        MimeMultipart multiParte = new MimeMultipart();
        BodyPart imagen = new MimeBodyPart();
        DataSource fds = new FileDataSource(Configuracion.getPathImagenCorreo());
        imagen.setDataHandler(new DataHandler(fds));
        imagen.setHeader("Content-ID", "<image>");

        //BUSCAR LOS XML A ENVIAR
        IFacturaDao dao = new FacturaDaoImpl();
        @SuppressWarnings("UnusedAssignment")
        List<Factura> listaAdjuntos = new ArrayList<>();
        listaAdjuntos = dao.listaArchivosAdjuntos(folio);
        List<File> f = new ArrayList<>();
        for (int i = 0; i < listaAdjuntos.size(); i++) {
            String path = Configuracion.getPathPDF() + listaAdjuntos.get(i).getNombreFacturaPdf();
            File fi = new File(path);
            f.add(fi);
        }
        BodyPart adjuntos;
        for (int i = 0; i < f.size(); i++) {
            adjuntos = new MimeBodyPart();
            FileDataSource fileDataSource = new FileDataSource(f.get(i));
            adjuntos.setDataHandler(new DataHandler(fileDataSource));
            adjuntos.setFileName(f.get(i).getName());
            adjuntos.setDisposition(MimeBodyPart.INLINE);
            multiParte.addBodyPart(adjuntos);

        }

        multiParte.addBodyPart(texto);

        multiParte.addBodyPart(imagen);

        MimeMessage message = new MimeMessage(sess);

        message.setFrom(new InternetAddress("portal@marubeni.com.mx"));

        message.addRecipients(Message.RecipientType.TO, us.getCorreo());
        if (moneda.equals("USD")) {
            message.addRecipient(Message.RecipientType.CC, new InternetAddress("Balderas-F@marubeni.com"));
        }
        message.addRecipient(Message.RecipientType.CC, new InternetAddress("Solano-H@marubeni.com"));
        message.addRecipient(Message.RecipientType.CC, new InternetAddress("Martinez-R@marubeni.com"));
        message.addRecipient(Message.RecipientType.CC, new InternetAddress("Nakasone-A@marubeni.com"));
        message.addRecipient(Message.RecipientType.CC, new InternetAddress("Namikawa-C@marubeni.com"));
        message.addRecipient(Message.RecipientType.BCC, new InternetAddress("marduk25@gmail.com"));

        message.setSubject("SOLICITUD DE PAGO DE GASTOS FM30");

        message.setContent(multiParte);

        Transport t = sess.getTransport("smtp");
        t.connect("portal@marubeni.com.mx", "Gastos$0914");
        t.sendMessage(message, message.getAllRecipients());
        // aviso();
        t.close();
    }

    //**MÉTODO PARA ACTUALIZAR EL ESTADO DE ENVIADO **//
    public void actualizarEstadoEnviado(String folio) {
        ICapturaDao dao = new CapturaDaoImpl();
        dao.actualizarEstadoEnviado(folio);
    }

    //**MÉTODO PARA GUARDAR CAPTURA CON DATOS PORTAL GASTOS USD**//
    public void guardarPGUSD() {
        ICapturaDao iCapturaDao = new CapturaDaoImpl();
        this.captura.setEstado("CAPTURADO");
        this.captura.setFechaCaptura(new Date());
        this.captura.setFolio(String.valueOf(folioUsuario()));
        this.captura.setReferencia(String.valueOf(folioUsuario()));
        actualizarFolioUsuario(us, String.valueOf(folioUsuario()));
        if (this.captura.getTipoSolicitud().equals("TRANSFERENCIA")) {
            Subcuenta sub;
            ISubcuentaDao dao = new SubCuentaImpl();
            sub = dao.filtroSubcuenta(this.subcuenta.getCompanyName());
            String total = this.captura.getImporteTotalUsd().toString();
            this.captura.setImporteTotalUsd(round(total, 4));
            this.captura.setSubcuenta(sub);
            this.captura.setUsuario(us);
            iCapturaDao.guardar(captura);
            this.captura = new Captura();
            this.subcuenta = new Subcuenta();
        } else {
            String total = this.captura.getImporteTotalUsd().toString();
            this.captura.setImporteTotalUsd(round(total, 4));
            this.captura.setUsuario(us);
            iCapturaDao.guardar(captura);
            this.captura = new Captura();
            this.subcuenta = new Subcuenta();

        }
        this.listaFactura.clear();
        //this.usd = 0.0;

    }

    //**MÉTODO PARA OBTENER EL FOLIO DE USUARIO**//
    public int folioUsuario() {
        IUsuarioDao dao = new UsuarioDaoImpl();
        return dao.obtenerFolioUsuario();
    }

    //**MÉTODO PARA ACTUALIZAR EL FOLIO DE USUARIO**//
    public void actualizarFolioUsuario(Usuario usuario, String fSig) {
        IUsuarioDao dao = new UsuarioDaoImpl();
        dao.actualizarFolioUsuario(usuario, fSig);
    }

    //**MÉTODO PARA LISTAR FACTURAS DEL PORTAL DE GASTOS EN M.N.**//
    public void listarConceptoGastos() {
        IConceptoGastosDao iDao = new ConceptoGastosDaoImpl();
        this.listaConceptoGastos = iDao.listaConceptoGastos();
    }

    //**MÉTODO PARA LISTAR FACTURAS DEL PORTAL DE GASTOS EN USD**//
    public void listarConceptoGastosUSD() {
        IConceptoGastosDao iDao = new ConceptoGastosDaoImpl();
        this.listaConceptoGastos = iDao.listaConceptoGastosUSD();
    }

    //**MÉTODO PARA AGREGAR FACTURAS DEL PORTAL DE GASTOS**//
    public void agregarPartida(int idFactura) {
        // Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        this.session = null;
        this.transaction = null;

        try {

            this.session = HibernateUtilGastos.getSessionFactory().openSession();
            IConceptoGastosDao pDao = new ConceptoGastosDaoImpl();
            this.transaction = this.session.beginTransaction();
            this.conceptoGastos = pDao.obtenerFactura(session, idFactura);

            this.listaFactura2.add(new Factura(conceptoGastos.getFactura(), conceptoGastos.getUuid(), conceptoGastos.getImporte(), conceptoGastos.getTotalmxn()));
            try {
                this.granTotal2 = this.granTotal2 + (Double.valueOf(this.conceptoGastos.getTotalmxn().toString()));
            } catch (NumberFormatException e) {
            }
            try {
                this.granTotal2 = this.granTotal2 + (Double.valueOf(this.conceptoGastos.getTotalusd().toString()));
            } catch (NumberFormatException e) {
            }

            this.captura.setImporteTotalMx(new BigDecimal(this.mxn));
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO", "FACTURA AGREGADA AL REPORTE"));

        } catch (Exception e) {
            if (this.transaction != null) {
                System.out.println(e.getMessage());
                transaction.rollback();
            }
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }

    }

    //**MÉTODO PARA QUITAR UNA FACTURA AGREGADA DEL PORTAL DE GASTOS**//
    @SuppressWarnings("IncompatibleEquals")
    public void quitarFactura(String fac, Double importe) {
        try {
            int i = 0;
            for (Factura f : listaFactura2) {
                if (f.getFactura().equals(fac)) {
                    this.listaFactura2.remove(i);
                    break;
                }
                i++;
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "FACTURA QUITADA DEL REPORTE"));
            this.mxn = this.mxn - importe;
            //getListaFactura();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "AVISO", "ERROR AL QUITAR LA FACTURA DEL REPORTE"));
        }
    }

    //**MÉTODO PARA BORRAR LA CAPTURA**//
    public void borrar(Captura captura) {
        ICapturaDao dao = new CapturaDaoImpl();
        dao.borrar(captura);
    }

    //**MÉTODO PARA BORRAR LA FACTURA Y CONCEPTO**//
    public void borrarFacturaConcepto(String uuid) {

    }

    //**MÉTODO PARA REDONDEAR EL TOTAL**//
    public static BigDecimal round(String numberStr, int scale) {
        BigDecimal value = new BigDecimal(numberStr);
        return value.setScale(scale, RoundingMode.HALF_UP);
    }

    //**MÉTODO PARA OBTENER EL TOTAL XML SUBIDOS**//
    public String obtenerTotal() {
        IFacturaDao dao = new FacturaDaoImpl();
        Optional<String> op = Optional.ofNullable(dao.sumaTotalFactura());
        this.granTotal = op.orElse("0.0000");
        return this.granTotal;
    }

    //**MÉTODO PARA OBTENER EL SUBTOTAL XML SUBIDOS**//
    public String obtenerSubTotal() {
        IFacturaDao dao = new FacturaDaoImpl();
        Optional<String> op = Optional.ofNullable(dao.sumaSubTotalFactura());
        this.granSubtotal = op.orElse("0.0000");
        return this.granSubtotal;
    }

    //**MÉTODO PARA OBTENER EL NOMBRE DE LOS ARCHIVOS XML SUBIDOS**//
    public String obtenerNombresFacturas() {
        IFacturaDao dao = new FacturaDaoImpl();
        Optional<String> op = Optional.ofNullable(dao.nombresFacturas());
        this.reference_no = op.orElse("0");
        return this.reference_no;
    }

    public void listarFacturaXML() throws ParseException {
        //falta colocar el WHERE en la consulta
        fechaPago();
        IFacturaDao ifd = new FacturaDaoImpl();
        this.listaFactura = ifd.listaFactura();
        obtenerTotal();
        obtenerSubTotal();
        listaFactura.forEach((l) -> {
            String[] nombre = l.getNombre().split(" ");
            this.subcuenta.setCompanyName(l.getNombre());
            llenarCamposFaltantes(nombre[0] + " " + nombre[1]);
        });

    }

    //**MÉTODO PARA IMPRIMIR EL REPORTE FM30**//
    public void imprimirReporte(String folio, String tipo) {
        try {
            Reporte reporte = new Reporte();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
            String ruta = null;
            if (tipo.equals("TRANSFERENCIA")) {
                ruta = servletContext.getRealPath("/WEB-INF/reporte/reporteFM30.jasper");
            } else {
                ruta = servletContext.getRealPath("/WEB-INF/reporte/reporteFM30_2.jasper");
            }
            reporte.getReporte(ruta, folio, String.valueOf(us.getIdusuario()));
            FacesContext.getCurrentInstance().responseComplete();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | JRException ex) {
            Logger.getLogger(CapturaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void preparaCuenta(String cta, int id) {
        ICapturaDao cDao = new CapturaDaoImpl();
        cDao.actualizarCuenta(cta, id);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO", "CUENTA ACTUALIZADA CORRECTAMENTE"));
    }

}
