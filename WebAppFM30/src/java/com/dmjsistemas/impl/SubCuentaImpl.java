package com.dmjsistemas.impl;

import com.dmjsistemas.model.Subcuenta;
import com.dmjsistemas.util.HibernateUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.dmjsistemas.dao.ISubcuentaDao;
import org.hibernate.Query;

public class SubCuentaImpl implements ISubcuentaDao {

    @Override
    public List<Subcuenta> listaSubcuenta() {
        List<Subcuenta> lista = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Subcuenta";
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
    public void guardarSubcuenta(Subcuenta subcuenta) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(subcuenta);
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
    public void actualizarSubcuenta(Subcuenta subcuenta) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(subcuenta);
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
    public void borrarSubcuenta(Subcuenta subcuenta) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(subcuenta);
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

    @Override
    public Subcuenta filtroSubcuenta(String companyName) {
        Subcuenta subcuenta = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Subcuenta WHERE companyName LIKE :companyName";
        try {
            Query q = session.createQuery(hql);
            q.setParameter("companyName", "%" + companyName + "%");
            subcuenta = (Subcuenta) q.setMaxResults(1).uniqueResult();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return subcuenta;
    }

    @Override
    public List<Subcuenta> listaCuenta() {
        List<Subcuenta> lista = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Subcuenta WHERE cuenta IS NOT NULL";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

}
