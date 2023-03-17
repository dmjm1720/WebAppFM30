package com.dmjsistemas.dao;

import java.util.List;

import com.dmjsistemas.model.Concepto;

public interface IConceptoDao {

    public List<Concepto> listaConcepto();

    public void guardarConcepto(Concepto concepto);

    public void actualizarConcepto(Concepto concepto);

    public void borrarConcepto(Concepto concepto);

    public void borrar(String uuid);

}
