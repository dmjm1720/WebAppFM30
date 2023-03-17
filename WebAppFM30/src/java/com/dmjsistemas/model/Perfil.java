package com.dmjsistemas.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERFIL", schema = "dbo", catalog = "DBFM30")
public class Perfil implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPERFIL")
    private int idperfil;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "WS", length = 2)
    private String ws;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
    private Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public Perfil() {
    }

    public Perfil(int idperfil, String nombre) {
        this.idperfil = idperfil;
        this.nombre = nombre;
    }

    public Perfil(int idperfil, String nombre, String ws, Set<Usuario> usuarios) {
        this.idperfil = idperfil;
        this.nombre = nombre;
        this.ws = ws;
        this.usuarios = usuarios;
    }

    public int getIdperfil() {
        return this.idperfil;
    }

    public void setIdperfil(int idperfil) {
        this.idperfil = idperfil;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getWs() {
        return this.ws;
    }

    public void setWs(String ws) {
        this.ws = ws;
    }

    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
