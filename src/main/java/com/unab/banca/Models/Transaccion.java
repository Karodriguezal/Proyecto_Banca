package com.unab.banca.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="transaccion")
public class Transaccion implements Serializable{

    @Id
    @Column(name="id_transaccion")
    private Integer id_transaccion;

    @Column(name="fecha_transaccion")
    private Date fecha_transaccion;

    @Column(name="valor_transaccion")
    private Integer valor_transaccion;

    @Column(name="tipo_transaccion")
    private String tipo_transaccion;

    @ManyToOne
    @JoinColumn(name="id_cuenta")
    private Cuenta cuenta;

    public Transaccion(Integer id_transaccion, Date fecha_transaccion, Integer valor_transaccion, String tipo_transaccion, Cuenta cuenta) {
        this.id_transaccion = id_transaccion;
        this.fecha_transaccion = fecha_transaccion;
        this.valor_transaccion = valor_transaccion;
        this.tipo_transaccion = tipo_transaccion;
        this.cuenta = cuenta;
    }

    public Transaccion() {
    }

    public Integer getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(Integer id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Date getFecha_transaccion() {
        return fecha_transaccion;
    }

    public void setFecha_transaccion(Date fecha_transaccion) {
        this.fecha_transaccion = fecha_transaccion;
    }

    public Integer getValor_transaccion() {
        return valor_transaccion;
    }

    public void setValor_transaccion(Integer valor_transaccion) {
        this.valor_transaccion = valor_transaccion;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
