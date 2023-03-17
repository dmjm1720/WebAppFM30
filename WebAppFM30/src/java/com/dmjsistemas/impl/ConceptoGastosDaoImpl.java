package com.dmjsistemas.impl;

import com.dmjsistemas.dao.IConceptoGastosDao;
import com.dmjsistemas.gastos.model.ConceptoGastos;
import com.dmjsistemas.model.Usuario;
import com.dmjsistemas.util.HibernateUtilGastos;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ConceptoGastosDaoImpl implements IConceptoGastosDao {

    Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");

    @Override
    public List<ConceptoGastos> listaConceptoGastos() {
        List<ConceptoGastos> lista = null;

        Session session = HibernateUtilGastos.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Concepto WHERE nombreUsuario=:nombreUsuario AND totalmxn IS NOT NULL ORDER BY idConcepto DESC";
        try {
            Query q = session.createQuery(hql).setMaxResults(12);
            q.setParameter("nombreUsuario", us.getSubcuenta());
            lista = (List<ConceptoGastos>) q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    @SuppressWarnings("null")
    public void actualizarLista(ConceptoGastos concepto) {
        Session session = null;
        try {
            session = HibernateUtilGastos.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(concepto);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "¡AVISO!", "INFORMACIÓN ACTUALIZADA CORRECTAMENTE"));
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡AVISO!", "ERROR AL ACTUALIZAR"));
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public ConceptoGastos obtenerFactura(Session session, int idConcepto) throws Exception {
         String hql = "FROM Concepto WHERE idConcepto=:idConcepto  ORDER BY idConcepto ASC";
        Query q = session.createQuery(hql).setMaxResults(1);
        q.setParameter("idConcepto", idConcepto);
        return (ConceptoGastos) q.uniqueResult();
    }

    @Override
    public List<ConceptoGastos> listaConceptoGastosUSD() {
         List<ConceptoGastos> lista = null;

        Session session = HibernateUtilGastos.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Concepto WHERE nombreUsuario=:nombreUsuario AND totalusd IS NOT NULL ORDER BY idConcepto DESC";
        try {
            Query q = session.createQuery(hql).setMaxResults(12);
            q.setParameter("nombreUsuario", us.getSubcuenta());
            lista = (List<ConceptoGastos>) q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

}
