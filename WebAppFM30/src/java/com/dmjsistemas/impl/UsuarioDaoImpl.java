package com.dmjsistemas.impl;

import com.dmjsistemas.dao.Password;
import org.hibernate.Session;

import com.dmjsistemas.dao.IUsuarioDao;
import com.dmjsistemas.model.Usuario;
import com.dmjsistemas.util.HibernateUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

import org.hibernate.Transaction;
import org.hibernate.Query;

public class UsuarioDaoImpl implements IUsuarioDao {

    Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");

    @Override
    public Usuario obtenerDatosUsuario(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Usuario WHERE nombre=:nombre AND clave=:clave AND estado=1";
        Query q = session.createQuery(hql).setMaxResults(1);
        q.setParameter("nombre", usuario.getNombre());
        q.setParameter("clave", Password.sha512(usuario.getClave()));
        return (Usuario) q.uniqueResult();
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario user = this.obtenerDatosUsuario(usuario);
        if (user != null) {
            if (!user.getClave().equals(Password.sha512(usuario.getClave()))) {
                user = null;
            }
        }
        return user;
    }

    @Override
    @SuppressWarnings("null")
    public void guardarUsuario(Usuario usuario) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(usuario);
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
    public void actualizarUsuario(Usuario usuario) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(usuario);
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
    public void borrarUsuario(Usuario usuario) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(usuario);
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
    public List<Usuario> listaUsuario() {
        List<Usuario> lista = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Usuario";
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
    public int obtenerFolioUsuario() {
        int folioUsuario = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "SELECT folio+1 FROM Usuario WHERE idusuario=:idusuario";
        try {
            Query q = session.createQuery(hql);
            q.setParameter("idusuario", us.getIdusuario());
            folioUsuario = Integer.parseInt(q.setMaxResults(1).uniqueResult().toString());
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }

        return folioUsuario;
    }

    @Override
    @SuppressWarnings("null")
    public void actualizarFolioUsuario(Usuario usuario, String folio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "UPDATE Usuario SET folio=:folio WHERE idUsuario=:idUsuario";
        Query q = session.createQuery(hql);
        q.setParameter("folio", folio);
        q.setParameter("idUsuario", usuario.getIdusuario());
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        } 
    }

}
