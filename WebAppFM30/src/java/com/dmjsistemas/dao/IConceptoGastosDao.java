package com.dmjsistemas.dao;

import com.dmjsistemas.gastos.model.ConceptoGastos;
import java.util.List;
import org.hibernate.Session;

public interface IConceptoGastosDao {

    public List<ConceptoGastos> listaConceptoGastos();

    public void actualizarLista(ConceptoGastos concepto);

    public ConceptoGastos obtenerFactura(Session session, int idConcepto) throws Exception;
    
    public List<ConceptoGastos> listaConceptoGastosUSD();
}
