package com.dmjsistemas.dao;

import java.util.List;

import com.dmjsistemas.model.Poliza;

public interface IPolizaDao {

	public List<Poliza> listaPoliza();

	public void guardarPoliza(Poliza poliza);

	public void actualizarPoliza(Poliza poliza);

	public void borrarPoliza(Poliza poliza);

}
