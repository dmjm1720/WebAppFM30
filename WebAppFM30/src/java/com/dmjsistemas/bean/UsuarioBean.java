package com.dmjsistemas.bean;

import com.dmjsistemas.dao.Password;
import com.dmjsistemas.dao.IUsuarioDao;
import com.dmjsistemas.impl.UsuarioDaoImpl;
import com.dmjsistemas.model.Perfil;
import com.dmjsistemas.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "usuario")
@ViewScoped
public class UsuarioBean implements Serializable {

    private Usuario usuario;
    private List<Usuario> listarUsuario;
    private Perfil perfilUsuario;
    private boolean bandera;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Perfil getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(Perfil perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public List<Usuario> getListarUsuario() {
        IUsuarioDao usuarioDao = new UsuarioDaoImpl();
        this.listarUsuario = usuarioDao.listaUsuario();
        return listarUsuario;
    }

    public UsuarioBean() {

    }

    @PostConstruct
    public void init() {
        this.listarUsuario = new ArrayList<>();
        this.usuario = new Usuario();
        this.perfilUsuario = new Perfil();
        this.bandera = false;
    }

    @SuppressWarnings("null")
    public void guardar() {
        IUsuarioDao usuarioDao = new UsuarioDaoImpl();

        if (!usuario.getNombre().isEmpty()
                && !usuario.getCorreo().isEmpty()
                && !usuario.getClave().isEmpty()
                && !usuario.getSubcuenta().isEmpty()
                && !usuario.getDepartamento().isEmpty()
                && !usuario.getClaveDepartamento().isEmpty()
                && perfilUsuario.getIdperfil() != 0) {

            this.usuario.setClave(Password.sha512(this.usuario.getClave()));

            this.usuario.setPerfil(perfilUsuario);
            usuarioDao.guardarUsuario(usuario);
            this.usuario = new Usuario();
            this.perfilUsuario = new Perfil();
        } else {
            if (usuario.getNombre().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡CAMPO REQUERIDO!",
                        "NOMBRE DE USUARIO"));
            }
            if (usuario.getCorreo().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡CAMPO REQUERIDO!",
                        "CORREO"));
            }
            if (usuario.getSubcuenta().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡CAMPO REQUERIDO!",
                        "SUBCUENTA"));
            }
            if (usuario.getDepartamento().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡CAMPO REQUERIDO!",
                        "DEPARTAMENTO"));
            }
            if (usuario.getClaveDepartamento().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡CAMPO REQUERIDO!",
                        "CLAVE DEPARTAMENTO"));
            }
            if (usuario.getClave().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡CAMPO REQUERIDO!",
                        "CONTRASEÑA"));
            }
            if (perfilUsuario.getIdperfil() == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡CAMPO REQUERIDO!",
                        "PERFIL DE USUARIO"));
            }

        }

    }

    public void actualizar() {
        IUsuarioDao usuarioDao = new UsuarioDaoImpl();
        if (bandera == true) {
            this.usuario.setPerfil(perfilUsuario);
            this.usuario.setClave(Password.sha512(this.usuario.getClave()));
            this.usuario.setEstado(1);
            this.usuario.setFolio("0");
            usuarioDao.actualizarUsuario(usuario);
            this.usuario = new Usuario();
            this.perfilUsuario = new Perfil();
        } else if (bandera == false) {
            this.usuario.setPerfil(perfilUsuario);
            usuarioDao.actualizarUsuario(usuario);
            this.usuario = new Usuario();
            this.perfilUsuario = new Perfil();
        }

    }

    public void borrar() {
        IUsuarioDao usuarioDao = new UsuarioDaoImpl();
        usuarioDao.borrarUsuario(usuario);
    }

}
