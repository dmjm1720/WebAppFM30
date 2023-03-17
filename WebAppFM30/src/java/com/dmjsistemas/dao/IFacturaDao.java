package com.dmjsistemas.dao;

import java.util.List;

import com.dmjsistemas.model.Factura;

public interface IFacturaDao {

    public List<Factura> listaFactura();
    
    public List<Factura> listaFacturaPorUsuario();

    public void guardarFactura(Factura factura);

    public void actualizarFactura(Factura factura);

    public void borrarFactura(Factura factura);

    public String validarUuidExistente(String uuid);
    
    public String sumaTotalFactura();
    
    public String nombresFacturas();
    
    public List<Factura> listaArchivosAdjuntos(String folio);
    
    public String sumaSubTotalFactura();

}
