package com.dmjsistemas.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dmjsistemas.dao.IFacturaDao;
import com.dmjsistemas.dao.IUsuarioDao;
import com.dmjsistemas.model.Factura;
import com.dmjsistemas.model.Usuario;
import com.dmjsistemas.util.HibernateUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Query;

public class FacturaDaoImpl implements IFacturaDao {

    Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");

    @SuppressWarnings("unchecked")
    @Override
    public List<Factura> listaFactura() {
        List<Factura> lista = null;
        IUsuarioDao dao = new UsuarioDaoImpl();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Factura WHERE folioUsuario=:folioUsuario AND nombreUsuario=:nombreUsuario";
        try {
            Query q = session.createQuery(hql);
            q.setParameter("folioUsuario", String.valueOf(dao.obtenerFolioUsuario()));
            q.setParameter("nombreUsuario", usuario.getSubcuenta());
            lista = (List<Factura>) q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    @SuppressWarnings({"null", "ConvertToTryWithResources"})
    public void guardarFactura(Factura factura) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(factura);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "¡AVISO!", "INFORMACIÓN GUARDADA CORRECTAMENTE"));
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡AVISO!", "ERROR AL GUARDAR " + e.getMessage()));
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    @SuppressWarnings("null")
    public void actualizarFactura(Factura factura) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(factura);
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
    public void borrarFactura(Factura factura) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(factura);
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
    public String validarUuidExistente(String uuid) {
        String valorUuid = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "SELECT uuid FROM Factura WHERE uuid=:uuid";
        try {
            Query q = session.createQuery(hql);
            q.setParameter("uuid", uuid);
            valorUuid = (String) q.setMaxResults(1).uniqueResult();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return valorUuid;
    }

    @Override
    @SuppressWarnings("null")
    public String sumaTotalFactura() {
        String total = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "SELECT SUM(totalmxn) FROM Factura WHERE nombreUsuario=:nombreUsuario AND folioUsuario=:folioUsuario";
        IUsuarioDao dao = new UsuarioDaoImpl();
        try {
            Query q = session.createQuery(hql);
            q.setParameter("nombreUsuario", usuario.getSubcuenta());
            q.setParameter("folioUsuario", String.valueOf(dao.obtenerFolioUsuario()));
            try {
                total = q.setMaxResults(1).uniqueResult().toString();
                t.commit();
            } catch (Exception e) {
                Logger logger = Logger.getLogger("SUMA >> SIN DATOS");
                logger.log(Level.INFO, ">>{0}", e.getMessage());
            }

            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return total;
    }

    @Override
    @SuppressWarnings("null")
    public String nombresFacturas() {
        String facturas = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "SELECT factura FROM Factura WHERE nombreUsuario=:nombreUsuario AND folioUsuario=:folioUsuario AND nombreFactura IS NOT NULL";
        IUsuarioDao dao = new UsuarioDaoImpl();
        try {
            Query q = session.createQuery(hql);
            q.setParameter("nombreUsuario", usuario.getSubcuenta());
            q.setParameter("folioUsuario", String.valueOf(dao.obtenerFolioUsuario()));
            try {
                facturas = q.list().toString();
                t.commit();
                session.close();
            } catch (HibernateException e) {
                Logger logger = Logger.getLogger("FACTURA >> SIN DATOS");
                logger.log(Level.INFO, ">>{0}", e.getMessage());
            }

        } catch (HibernateException e) {
            t.rollback();
        }
        return facturas;
    }

    @Override
    public List<Factura> listaFacturaPorUsuario() {
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Factura WHERE uuid IS NOT NULL ORDER BY idFactura DESC";
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
    public List<Factura> listaArchivosAdjuntos(String folio) {
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Factura WHERE folioUsuario=:folioUsuario AND nombreUsuario=:nombreUsuario";
        try {
            Query q = session.createQuery(hql);
            q.setParameter("folioUsuario", folio);
            q.setParameter("nombreUsuario", usuario.getSubcuenta());
            lista = (List<Factura>) q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public String sumaSubTotalFactura() {
        String subtotal = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "SELECT SUM(importe) FROM Factura WHERE nombreUsuario=:nombreUsuario AND folioUsuario=:folioUsuario";
        IUsuarioDao dao = new UsuarioDaoImpl();
        try {
            Query q = session.createQuery(hql);
            q.setParameter("nombreUsuario", usuario.getSubcuenta());
            q.setParameter("folioUsuario", String.valueOf(dao.obtenerFolioUsuario()));
            try {
                subtotal = q.setMaxResults(1).uniqueResult().toString();
                t.commit();
            } catch (Exception e) {
                Logger logger = Logger.getLogger("SUBTOTAL >> SIN DATOS");
                logger.log(Level.INFO, ">>{0}", e.getMessage());
            }

            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return subtotal;
    }

}
