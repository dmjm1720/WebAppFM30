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
@Table(name = "SUBCUENTA", schema = "dbo", catalog = "DBFM30")
public class Subcuenta implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDSUBCUENTA")
    private int idsubcuenta;

    @Column(name = "CO", length = 100)
    private String co;

    @Column(name = "COMPANY_NAME", length = 100)
    private String companyName;

    @Column(name = "CTR", length = 10)
    private String ctr;

    @Column(name = "CUENTA", length = 50)
    private String cuenta;

    @Column(name = "SUBCUENTA", length = 50)
    private String subcuenta;

    @Column(name = "BANCO", length = 50)
    private String banco;

    @Column(name = "CUENTA_GASTOS", length = 50)
    private String cuentaGastos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subcuenta")
    private Set<Captura> capturas = new HashSet<Captura>(0);

    public Subcuenta() {
    }

    public Subcuenta(int idsubcuenta) {
        this.idsubcuenta = idsubcuenta;
    }

    public Subcuenta(int idsubcuenta, String co, String companyName, String ctr, String cuenta, String subcuenta, String banco, String cuentaGastos, Set<Captura> capturas) {
        this.idsubcuenta = idsubcuenta;
        this.co = co;
        this.companyName = companyName;
        this.ctr = ctr;
        this.cuenta = cuenta;
        this.subcuenta = subcuenta;
        this.banco = banco;
        this.cuentaGastos = cuentaGastos;
        this.capturas = capturas;
    }

    public int getIdsubcuenta() {
        return this.idsubcuenta;
    }

    public void setIdsubcuenta(int idsubcuenta) {
        this.idsubcuenta = idsubcuenta;
    }

    public String getCo() {
        return this.co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCtr() {
        return this.ctr;
    }

    public void setCtr(String ctr) {
        this.ctr = ctr;
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getSubcuenta() {
        return this.subcuenta;
    }

    public void setSubcuenta(String subcuenta) {
        this.subcuenta = subcuenta;
    }

    public String getBanco() {
        return this.banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCuentaGastos() {
        return this.cuentaGastos;
    }

    public void setCuentaGastos(String cuentaGastos) {
        this.cuentaGastos = cuentaGastos;
    }

    public Set<Captura> getCapturas() {
        return this.capturas;
    }

    public void setCapturas(Set<Captura> capturas) {
        this.capturas = capturas;
    }

}
