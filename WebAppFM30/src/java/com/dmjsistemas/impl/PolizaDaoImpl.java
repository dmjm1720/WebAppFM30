package com.dmjsistemas.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dmjsistemas.dao.IPolizaDao;
import com.dmjsistemas.model.Poliza;
import com.dmjsistemas.util.HibernateUtil;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class PolizaDaoImpl implements IPolizaDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Poliza> listaPoliza() {
        List<Poliza> lista = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Poliza";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    @SuppressWarnings("null")
    public void guardarPoliza(Poliza poliza) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(poliza);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "¡AVISO!", "INFORMACIÓN GUARDADA CORRECTAMENTE"));
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡AVISO!", "ERROR AL GUARDAR"));
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    @SuppressWarnings("null")
    public void actualizarPoliza(Poliza poliza) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(poliza);
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
    @SuppressWarnings("null")
    public void borrarPoliza(Poliza poliza) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(poliza);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "¡AVISO!", "INFORMACIÓN BORRADA CORRECTAMENTE"));
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡AVISO!", "ERROR AL BORRAR"));
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

}
