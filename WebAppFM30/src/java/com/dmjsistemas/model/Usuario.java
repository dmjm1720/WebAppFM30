package com.dmjsistemas.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO", schema = "dbo", catalog = "DBFM30")
public class Usuario implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDUSUARIO")
    private int idusuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPERFIL")
    private Perfil perfil;

    @Column(name = "NOMBRE", nullable = false, length = 150)
    private String nombre;

    @Column(name = "CORREO", length = 50)
    private String correo;

    @Column(name = "CLAVE", length = 300)
    private String clave;

    @Column(name = "ESTADO")
    private Integer estado;

    @Column(name = "SUBCUENTA", length = 50)
    private String subcuenta;

    @Column(name = "DEPARTAMENTO", length = 50)
    private String departamento;

    @Column(name = "CLAVE_DEPARTAMENTO", length = 20)
    private String claveDepartamento;

    @Column(name = "FOLIO", length = 10)
    private String folio;

    @Column(name = "CUENTA", length = 50)
    private String cuenta;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private Set<Captura> capturas = new HashSet<Captura>(0);

    public Usuario() {
    }

    public Usuario(int idusuario, String nombre) {
        this.idusuario = idusuario;
        this.nombre = nombre;
    }

    public Usuario(int idusuario, Perfil perfil, String nombre, String correo, String clave, Integer estado, String subcuenta, String departamento, String claveDepartamento, String folio, String cuenta, Set<Captura> capturas) {
        this.idusuario = idusuario;
        this.perfil = perfil;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.estado = estado;
        this.subcuenta = subcuenta;
        this.departamento = departamento;
        this.claveDepartamento = claveDepartamento;
        this.folio = folio;
        this.cuenta = cuenta;
        this.capturas = capturas;
    }

    public int getIdusuario() {
        return this.idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Perfil getPerfil() {
        return this.perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getEstado() {
        return this.estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getSubcuenta() {
        return this.subcuenta;
    }

    public void setSubcuenta(String subcuenta) {
        this.subcuenta = subcuenta;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getClaveDepartamento() {
        return this.claveDepartamento;
    }

    public void setClaveDepartamento(String claveDepartamento) {
        this.claveDepartamento = claveDepartamento;
    }

    public String getFolio() {
        return this.folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Set<Captura> getCapturas() {
        return this.capturas;
    }

    public void setCapturas(Set<Captura> capturas) {
        this.capturas = capturas;
    }

}
