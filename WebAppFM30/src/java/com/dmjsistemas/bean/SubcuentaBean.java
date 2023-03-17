package com.dmjsistemas.bean;

import com.dmjsistemas.model.Subcuenta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.dmjsistemas.dao.ISubcuentaDao;
import com.dmjsistemas.impl.SubCuentaImpl;

@Named(value = "subcuenta")
@ViewScoped
public class SubcuentaBean implements Serializable {

    private List<Subcuenta> listaSubcuenta;
    private Subcuenta subcuenta;

    public Subcuenta getSubcuenta() {
        return subcuenta;
    }

    public void setSubcuenta(Subcuenta subcuenta) {
        this.subcuenta = subcuenta;
    }

    public SubcuentaBean() {
    }

    @PostConstruct
    public void init() {
        this.listaSubcuenta = new ArrayList<>();
        this.subcuenta = new Subcuenta();
    }

    public List<Subcuenta> getListaSubcuenta() {
        ISubcuentaDao sDao = new SubCuentaImpl();
        this.listaSubcuenta = sDao.listaSubcuenta();
        return listaSubcuenta;
    }

    public void guardar() {
        ISubcuentaDao sDao = new SubCuentaImpl();
        sDao.guardarSubcuenta(subcuenta);
        this.subcuenta = new Subcuenta();
    }

    public void actualizar() {
        ISubcuentaDao sDao = new SubCuentaImpl();
        sDao.actualizarSubcuenta(subcuenta);
        this.subcuenta = new Subcuenta();

    }

    public void borrar() {
        ISubcuentaDao sDao = new SubCuentaImpl();
    }
}
