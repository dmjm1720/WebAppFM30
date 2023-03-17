package com.dmjsistemas.dao;

import java.util.List;

import com.dmjsistemas.model.Captura;
import java.time.LocalDate;

public interface ICapturaDao {

    public List<Captura> listaCaptura();

    public List<Captura> listaCapturaEnviado();

    public void guardar(Captura captura);

    public void actualizar(Captura captura);

    public void borrar(Captura captura);

    public void actualizarEstadoEnviado(String folio);

    public List<Captura> listaReportePorFechas(LocalDate f1, LocalDate f2);
    
    public void actualizarCuenta(String cta, int id);
}
