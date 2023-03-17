package com.dmjsistemas.impl;

import java.util.List;

import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dmjsistemas.model.Captura;
import com.dmjsistemas.model.Usuario;
import com.dmjsistemas.util.HibernateUtil;
import com.dmjsistemas.dao.ICapturaDao;
import java.time.LocalDate;
import javax.faces.application.FacesMessage;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

public class CapturaDaoImpl implements ICapturaDao {

    Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");

    @SuppressWarnings("unchecked")
    @Override
    public List<Captura> listaCaptura() {
        List<Captura> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM Captura WHERE estado='CAPTURADO' AND idusuario="+ usuario.getIdusuario()+"";
        try {
            lista = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            transaction.rollback();
        }
        return lista;
    }

    @Override
    @SuppressWarnings({"null", "ConvertToTryWithResources"})
    public void guardar(Captura captura) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(captura);
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
    @SuppressWarnings({"null", "ConvertToTryWithResources"})
    public void actualizar(Captura captura) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(captura);
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
    @SuppressWarnings({"null", "ConvertToTryWithResources"})
    public void borrar(Captura captura) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(captura);
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
    @SuppressWarnings("null")
    public void actualizarEstadoEnviado(String folio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "UPDATE Captura SET estado='ENVIADO' WHERE idUsuario=:idUsuario AND folio=:folio";
        Query q = session.createQuery(hql);
        q.setParameter("idUsuario", usuario.getIdusuario());
        q.setParameter("folio", folio);
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
    }

    @Override
    public List<Captura> listaCapturaEnviado() {
        List<Captura> lista = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM Captura WHERE estado='ENVIADO'";
        try {
            lista = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            transaction.rollback();
        }
        return lista;
    }

    @Override
    public List<Captura> listaReportePorFechas(LocalDate f1, LocalDate f2) {
        List<Captura> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM Captura  WHERE Fecha  BETWEEN  '" + f1 + "'  AND  '" + f2 + "'";
        try {
            lista = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            transaction.rollback();
        }
        return lista;
    }

    @Override
    public void actualizarCuenta(String cta, int id) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "UPDATE Captura SET cuentaBeneficiario=:cuentaBeneficiario WHERE idgasto=:idgasto";
        Query q = session.createQuery(hql);
        q.setParameter("cuentaBeneficiario", cta);
        q.setParameter("idgasto", id);
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
    }

}
