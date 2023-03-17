package com.dmjsistemas.bean;

import com.dmjsistemas.dao.ICapturaDao;
import com.dmjsistemas.impl.CapturaDaoImpl;
import com.dmjsistemas.model.Captura;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "reporte")
@ViewScoped
public class ReporteBean implements Serializable {

    private List<Captura> lista;
    private LocalDate fecha1;
    private LocalDate fecha2;

    public List<Captura> getLista() {
        return lista;
    }

    public LocalDate getFecha1() {
        return fecha1;
    }

    public void setFecha1(LocalDate fecha1) {
        this.fecha1 = fecha1;
    }

    public LocalDate getFecha2() {
        return fecha2;
    }

    public void setFecha2(LocalDate fecha2) {
        this.fecha2 = fecha2;
    }

    public ReporteBean() {
    }

    @PostConstruct
    public void init() {
        this.lista = new ArrayList<>();
    }

    //**MÉTODO PARA LISTAR LOS DATOS DEL REPORTE DE RELACIÓN POR FECHAS**//
    public void datosListaReporte() {
        ICapturaDao cDao = new CapturaDaoImpl();
        this.lista = new ArrayList<>();
        this.lista = cDao.listaReportePorFechas(fecha1, fecha2);
    }

}
