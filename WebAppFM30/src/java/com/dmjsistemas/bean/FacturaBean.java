package com.dmjsistemas.bean;

import com.dmjsistemas.dao.IConceptoDao;
import com.dmjsistemas.dao.IFacturaDao;
import com.dmjsistemas.impl.ConceptoDaoImp;
import com.dmjsistemas.impl.FacturaDaoImpl;
import com.dmjsistemas.model.Factura;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "factura")
@ViewScoped
public class FacturaBean implements Serializable {

    private Factura factura;
    private List<Factura> listaFactura;

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    //**MÉTODO CONSTRUCTOR**//
    public FacturaBean() {

    }

    @PostConstruct
    public void init() {
        this.factura = new Factura();
        this.listaFactura = new ArrayList<>();
    }

    //**MÉTODO PARA OBTENER LAS FACTURA POR PERFIL DE USUARIO**//
    public List<Factura> getListaFactura() {
        IFacturaDao dao = new FacturaDaoImpl();
        this.listaFactura = dao.listaFacturaPorUsuario();
        return listaFactura;
    }

    //**MÉTODO PARA BORRAR LA FACTURA Y CONCEPTO**//
    public void borrarFacturaYConcepto(Factura factura) {
        IFacturaDao dao = new FacturaDaoImpl();
        dao.borrarFactura(factura);
        IConceptoDao cdao = new ConceptoDaoImp();
        cdao.borrar(factura.getUuid());
    }
}
