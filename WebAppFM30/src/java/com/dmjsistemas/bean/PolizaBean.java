package com.dmjsistemas.bean;

import com.dmjsistemas.model.Usuario;
import java.io.Serializable;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Named(value = "poliza")
@RequestScoped
public class PolizaBean extends Conexion implements Serializable {

    private String drcr;
    private String account;
    private String taxCode;
    private String tf;
    private String subAccount;
    private String contractNo;
    private String referenceNo;
    private String dueDate;
    private String amount;
    private String userFolio;
    private String userName;
    private String usrFolio;
    private Date documentDate;
    private String department;
    private double subtotalAll;
    private double ivaAll;
    private double importeRetIva;
    private double totalAll;
    private String conceptAll;
    private String uuidAll;
    private String accountAll;
    private String contractAll;
    private String invoiceAll;
    private double ishAll;
    private String var;
    private String var1;
    private String di;
    private String mes;
    private String año;
    private String dia1;
    private String mes1;
    private String año1;
    private String lugarExp;
    private double propinaAll;
    private String DRCR;

    public String getDrcr() {
        return drcr;
    }

    public void setDrcr(String drcr) {
        this.drcr = drcr;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTf() {
        return tf;
    }

    public void setTf(String tf) {
        this.tf = tf;
    }

    public String getSubAccount() {
        return subAccount;
    }

    public void setSubAccount(String subAccount) {
        this.subAccount = subAccount;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUserFolio() {
        return userFolio;
    }

    public void setUserFolio(String userFolio) {
        this.userFolio = userFolio;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUsrFolio() {
        return usrFolio;
    }

    public void setUsrFolio(String usrFolio) {
        this.usrFolio = usrFolio;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSubtotalAll() {
        return subtotalAll;
    }

    public void setSubtotalAll(double subtotalAll) {
        this.subtotalAll = subtotalAll;
    }

    public double getIvaAll() {
        return ivaAll;
    }

    public void setIvaAll(double ivaAll) {
        this.ivaAll = ivaAll;
    }

    public double getImporteRetIva() {
        return importeRetIva;
    }

    public void setImporteRetIva(double importeRetIva) {
        this.importeRetIva = importeRetIva;
    }

    public double getTotalAll() {
        return totalAll;
    }

    public void setTotalAll(double totalAll) {
        this.totalAll = totalAll;
    }

    public String getConceptAll() {
        return conceptAll;
    }

    public void setConceptAll(String conceptAll) {
        this.conceptAll = conceptAll;
    }

    public String getUuidAll() {
        return uuidAll;
    }

    public void setUuidAll(String uuidAll) {
        this.uuidAll = uuidAll;
    }

    public String getAccountAll() {
        return accountAll;
    }

    public void setAccountAll(String accountAll) {
        this.accountAll = accountAll;
    }

    public String getContractAll() {
        return contractAll;
    }

    public void setContractAll(String contractAll) {
        this.contractAll = contractAll;
    }

    public String getInvoiceAll() {
        return invoiceAll;
    }

    public void setInvoiceAll(String invoiceAll) {
        this.invoiceAll = invoiceAll;
    }

    public double getIshAll() {
        return ishAll;
    }

    public void setIshAll(double ishAll) {
        this.ishAll = ishAll;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getDi() {
        return di;
    }

    public void setDi(String di) {
        this.di = di;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getDia1() {
        return dia1;
    }

    public void setDia1(String dia1) {
        this.dia1 = dia1;
    }

    public String getMes1() {
        return mes1;
    }

    public void setMes1(String mes1) {
        this.mes1 = mes1;
    }

    public String getAño1() {
        return año1;
    }

    public void setAño1(String año1) {
        this.año1 = año1;
    }

    public String getLugarExp() {
        return lugarExp;
    }

    public void setLugarExp(String lugarExp) {
        this.lugarExp = lugarExp;
    }

    public double getPropinaAll() {
        return propinaAll;
    }

    public void setPropinaAll(double propinaAll) {
        this.propinaAll = propinaAll;
    }

    public String getDRCR() {
        return DRCR;
    }

    public void setDRCR(String DRCR) {
        this.DRCR = DRCR;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public PolizaBean() {
    }
    Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");

    public void captura(String nombre, String folio, String concepto, String xml) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery("SELECT FOLIO, FECHA FROM CAPTURA WHERE ESTADO='ENVIADO' AND IDUSUARIO='" + nombre + "' AND FOLIO='" + folio + "'");
            while (rs.next()) {
                this.usrFolio = rs.getString("FOLIO");
                this.documentDate = rs.getDate("FECHA");
                this.department = us.getDepartamento();
                this.var = this.documentDate.toString();
                String[] fecha = this.var.split("-");
                this.año = fecha[0];
                this.mes = fecha[1];
                this.di = fecha[2];
                Date ahora = new Date();
                SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
                this.var1 = formateador.format(ahora);
                String[] mifecha = this.var1.split("-");
                this.dia1 = mifecha[0];
                this.mes1 = mifecha[1];
                this.año1 = mifecha[2];
                this.conceptAll = concepto;
                if (xml.equals("SI")) {
                    insertarDatosPolizaXML();
                } else if (xml.equals("NO")) {
                    insertarDatosPolizaSinXML();
                }

                //reportePolizaBean(nombre, folio);
                actualizarEstado(nombre, folio);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE FM30", "POLIZA GENERADA EXITOSAMENTE");
                FacesContext.getCurrentInstance().addMessage(null, message);

            }

            this.department = "";
            this.usrFolio = "";

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        Cerrar();
    }

    public void insertarDatosPolizaXML() throws SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery("SELECT IMPORTE, IVA, IMPUESTO_RETENIDO, TOTALMXN, FACTURA, UPPER(SUBSTRING(uuid,25,12)) AS uuid, ISH, LIGAR_EXPEDICION, PROPINA FROM FACTURA WHERE FOLIO_USUARIO='" + this.usrFolio + "' AND NOMBRE_USUARIO='" + us.getSubcuenta() + "'");
            while (rs.next()) {
                //DecimalFormat df = new DecimalFormat("#.##");
                //df.setRoundingMode(RoundingMode.CEILING);
                this.subtotalAll = rs.getDouble("IMPORTE");
                //this.subtotalAll = new Double(df.format(this.subtotalAll));
                this.ivaAll = rs.getDouble("IVA");
                //this.ivaAll = new Double(df.format(this.ivaAll));
                this.importeRetIva = rs.getDouble("IMPUESTO_RETENIDO");
                //this.importeRetIva = new Double(df.format(this.importeRetIva));
                this.ivaAll -= this.importeRetIva;
                this.totalAll = rs.getDouble("TOTALMXN");
                //this.totalAll = Double.parseDouble(df.format(this.totalAll));
                this.invoiceAll = rs.getString("FACTURA");
                this.uuidAll = rs.getString("uuid");
                this.ishAll = rs.getDouble("ISH");
                this.lugarExp = rs.getString("LIGAR_EXPEDICION");
                this.propinaAll = rs.getDouble("PROPINA");

                if (this.ivaAll == 0.0D) {
                    this.ivaAll = (this.totalAll - this.subtotalAll);
                }

                this.accountAll = "32242";
                this.contractAll = "CARGOS";
                this.DRCR = "DR";
                InsertImporte();
                this.DRCR = "DR";
                this.accountAll = "14731";
                InsertIva();
                this.contractAll = "V0015";
                this.accountAll = "41210";
                this.DRCR = "CR";
                InsertTotal();

                this.contractAll = "";
                this.accountAll = "";
                this.invoiceAll = "";
                this.uuidAll = "";
                this.subAccount = "";
                this.subtotalAll = 0.0D;
                this.ivaAll = 0.0D;
                this.totalAll = 0.0D;
                this.ishAll = 0.0D;
                this.lugarExp = "";
                this.propinaAll = 0.0D;
                this.DRCR = "DR";

                this.importeRetIva = 0.0D;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Cerrar();
    }

    public void insertarDatosPolizaSinXML() throws SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery("SELECT IMPORTE_TOTAL_MX, UPPER(SUBSTRING(OBSERVACIONES,25,12)) AS OBS FROM CAPTURA WHERE FOLIO='" + this.usrFolio + "' AND IDUSUARIO='" + us.getIdusuario() + "'");
            while (rs.next()) {

                this.subtotalAll = rs.getDouble("IMPORTE_TOTAL_MX");
                this.uuidAll = rs.getString("OBS");
                this.accountAll = "32242";
                this.contractAll = "CARGOS";
                this.DRCR = "DR";
                InsertImporte();
                this.DRCR = "DR";
                this.accountAll = "14731";
                this.contractAll = "V0015";
                this.accountAll = "41210";
                this.DRCR = "CR";
                this.totalAll = subtotalAll;
                InsertTotal();

                this.contractAll = "";
                this.accountAll = "";
                this.invoiceAll = "";
                this.uuidAll = "";
                this.subAccount = "";
                this.subtotalAll = 0.0D;
                this.ivaAll = 0.0D;
                this.totalAll = 0.0D;
                this.ishAll = 0.0D;
                this.lugarExp = "";
                this.propinaAll = 0.0D;
                this.DRCR = "DR";

                this.importeRetIva = 0.0D;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Cerrar();
    }

    public void InsertImporte() throws SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            st.executeUpdate("INSERT INTO POLIZA (VOUCHER_NO, ENTRY_DATE, TRANSACTION_DATE, CURRENCY, RATE, REMARKS, DRCR, UNIT, ACCOUNT, TAX_CODE, TF, SUB_ACCOUNT, CONTRACT_NO, REFERENCE_NO, DUE_DATE, AMOUNT, USER_FOLIO, USER_NAME) VALUES ('1','" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.di + "." + this.mes + "." + this.año + "', 'MXN', '', '" + this.conceptAll + "', '" + this.DRCR + "', '" + this.department + "', '" + this.accountAll + "', '5', '1', '" + us.getSubcuenta() + "', '" + this.invoiceAll + "',  '" + this.uuidAll + "', '" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.subtotalAll + "', '" + this.usrFolio + "', '" + us.getSubcuenta() + "')");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        Cerrar();
    }

    public void InsertIva() throws SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            st.executeUpdate("INSERT INTO POLIZA (VOUCHER_NO, ENTRY_DATE, TRANSACTION_DATE, CURRENCY, RATE, REMARKS, DRCR, UNIT, ACCOUNT, TAX_CODE, TF, SUB_ACCOUNT, CONTRACT_NO, REFERENCE_NO, DUE_DATE, AMOUNT, USER_FOLIO, USER_NAME) VALUES ('1','" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.di + "." + this.mes + "." + this.año + "', 'MXN', '', '" + this.conceptAll + "', '" + this.DRCR + "', '" + this.department + "', '" + this.accountAll + "', '5', '1', '" + us.getSubcuenta() + "', '" + this.invoiceAll + "',  '" + this.uuidAll + "', '" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.ivaAll + "', '" + this.usrFolio + "', '" + us.getSubcuenta() + "')");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        Cerrar();
    }

    public void actualizarEstado(String id, String folio) throws SQLException {
        try {
            Conectar();
            PreparedStatement ps = getCn().prepareStatement("UPDATE CAPTURA SET ESTADO_POLIZA=? WHERE IDUSUARIO=? AND FOLIO=?");
            ps.setString(1, "GENERADA");
            ps.setString(2, id);
            ps.setString(3, folio);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Cerrar();
    }

    public void InsertTotal() throws SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            st.executeUpdate("INSERT INTO POLIZA (VOUCHER_NO, ENTRY_DATE, TRANSACTION_DATE, CURRENCY, RATE, REMARKS, DRCR, UNIT, ACCOUNT, TAX_CODE, TF, SUB_ACCOUNT, CONTRACT_NO, REFERENCE_NO, DUE_DATE, AMOUNT, USER_FOLIO, USER_NAME) VALUES ('1','" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.di + "." + this.mes + "." + this.año + "', 'MXN', '', '" + this.conceptAll + "', '" + this.DRCR + "', '" + this.department + "', '" + this.accountAll + "', '5', '1', '" + us.getSubcuenta() + "', '" + this.invoiceAll + "',  '" + this.uuidAll + "', '" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.totalAll + "', '" + this.usrFolio + "', '" + us.getSubcuenta() + "')");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        Cerrar();
    }

    public void reportePolizaBean(String nombre, String folio) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        reportePoliza rPoliza = new reportePoliza();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/WEB-INF/reporte/text.jasper");
        rPoliza.getReporte(ruta, nombre, folio);
        FacesContext.getCurrentInstance().responseComplete();
    }
    
  
}
