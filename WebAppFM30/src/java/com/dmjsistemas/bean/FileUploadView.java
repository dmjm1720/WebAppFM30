package com.dmjsistemas.bean;

import com.dmjsistemas.util.Configuracion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import org.jdom2.JDOMException;
import org.primefaces.PrimeFaces;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

@Named
@RequestScoped
public class FileUploadView extends XmlBean {

    private UploadedFile file;
    ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    private String path = Configuracion.getPathXML();
    private String path2 = Configuracion.getPathPDF();

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public FileUploadView() {

    }

    @PostConstruct
    public void init() {

    }

    public void handleFileUploadOtros(FileUploadEvent event) throws IOException, SQLException, MessagingException, FileNotFoundException, JDOMException {
        copyFileOtros(event.getFile().getFileName(), event.getFile().getInputStream());
    }

    public void copyFileOtros(String fileName, InputStream in) throws SQLException, MessagingException, FileNotFoundException, IOException, JDOMException {
        try {

            File directorio = new File(path2);
            if (!directorio.exists()) {
                directorio.mkdir();
            }

            path = "";
            path = path2;

            try (OutputStream dir = new FileOutputStream(new File(path + fileName))) {
                int read = 0;
                byte[] bytes = new byte[51200];
                while ((read = in.read(bytes)) != -1) {
                    dir.write(bytes, 0, read);
                }

                insertarConcepto2(fileName);

                in.close();
                dir.flush();
            }

        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Sistema de Gastos Marubeni", "El XML tiene problemas que impiden procesarlo. Error: " + e.getMessage() + " Por favor revisa tu XML"));
        }

    }

    public void handleFileUpload(FileUploadEvent event) throws IOException, SQLException, MessagingException, FileNotFoundException, JDOMException {
        copyFile(event.getFile().getFileName(), event.getFile().getInputStream());
    }

    public void copyFile(String fileName, InputStream in) throws SQLException, MessagingException, FileNotFoundException, IOException, JDOMException {
        try {

            File directorio = new File(path);
            if (!directorio.exists()) {
                directorio.mkdir();
            }

            try (OutputStream dir = new FileOutputStream(new File(path + fileName))) {
                int read = 0;
                byte[] bytes = new byte[51200];
                while ((read = in.read(bytes)) != -1) {
                    dir.write(bytes, 0, read);
                }

                leerCFDI(path + fileName);
                String valida = validacion(); //Validación en el WebService del SAT
                String uuidExistente = validarUUID(); //Validación de CFDI existente en la BD
                if (valida.equals("Vigente") && uuidExistente.equals("NO EXISTE")) {
                    String dato = "El Archivo XML: " + fileName + " se ha validado correctamente, estus: " + valida;
                    PrimeFaces.current().executeScript("Swal.fire({\n"
                            + "  position: 'top-center',\n"
                            + "  icon: 'success',\n"
                            + "  title: 'Web Service SAT',\n"
                            + "  text: '" + dato + "',\n"
                            + "  showConfirmButton: false,\n"
                            + "  timer: 8000\n"
                            + "})");
                    insertarConcepto(fileName);
                } else if (!valida.equals("Vigente")) {
                    String dato = "El Archivo XML: " + fileName + " No se puede procesar con el estatus: " + " " + valida;
                    PrimeFaces.current().executeScript("Swal.fire({\n"
                            + "  position: 'top-center',\n"
                            + "  icon: 'error',\n"
                            + "  title: 'Web Service SAT',\n"
                            + "  text: '" + dato + "',\n"
                            + "  showConfirmButton: false,\n"
                            + "  timer: 8000\n"
                            + "})");
                } else if (!uuidExistente.equals("NO EXISTE")) {
                    String dato = "Archivo XML: " + fileName + " ya existe en el sistema ";
                    PrimeFaces.current().executeScript("Swal.fire({\n"
                            + "  position: 'top-center',\n"
                            + "  icon: 'error',\n"
                            + "  title: 'Archivo duplicado',\n"
                            + "  text: '" + dato + "',\n"
                            + "  showConfirmButton: false,\n"
                            + "  timer: 8000\n"
                            + "})");
                }

                in.close();
                dir.flush();
            }

        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Sistema de Gastos Marubeni", "El XML tiene problemas que impiden procesarlo. Error: " + e.getMessage() + " Por favor revisa tu XML"));
        }

    }

}
