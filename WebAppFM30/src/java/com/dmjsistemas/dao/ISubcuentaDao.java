package com.dmjsistemas.dao;

import com.dmjsistemas.model.Subcuenta;
import java.util.List;

public interface ISubcuentaDao {

    public List<Subcuenta> listaSubcuenta();

    public void guardarSubcuenta(Subcuenta subcuenta);

    public void actualizarSubcuenta(Subcuenta subcuenta);

    public void borrarSubcuenta(Subcuenta subcuenta);
    
    public Subcuenta filtroSubcuenta(String companyName);
    
    public List<Subcuenta> listaCuenta();
    
}
