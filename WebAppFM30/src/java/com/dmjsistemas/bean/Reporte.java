package com.dmjsistemas.bean;

import java.io.File;
import java.sql.SQLException;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class Reporte extends Conexion {

    @SuppressWarnings({"null", "UnnecessaryReturnStatement"})
    public void getReporte(String ruta, String FOLIO, String IDUSUARIO) throws ClassNotFoundException, InstantiationException, IllegalAccessException, JRException {

        this.Conectar();
        Map parameter = new java.util.HashMap();
        parameter.put("FOLIO", FOLIO);
        parameter.put("IDUSUARIO", IDUSUARIO);

        try {
            File file = new File(ruta);

            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            httpServletResponse.setDateHeader("Expires", 0L);
            httpServletResponse.setContentType("application/PDF");

            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());

            net.sf.jasperreports.engine.JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(jasperReport, parameter, this.getCn());

            JRExporter jrExporter = null;
            jrExporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
            jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());

            if (jrExporter != null) {
                try {
                    jrExporter.exportReport();
                } catch (JRException localJRException) {
                    System.out.println(localJRException.getMessage());
                }
            }
            return;
        } catch (JRException | java.io.IOException localJRException1) {
            System.out.println(localJRException1.getMessage());
        } finally {
            if (getCn() != null) {
                try {
                    Cerrar();
                } catch (SQLException localException2) {
                    System.out.println(localException2.getMessage());
                }
            }
        }
    }
}
