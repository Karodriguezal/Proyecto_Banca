package com.unab.banca.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    @Id
    @Column(name="id_cliente")
    private String id_cliente;
    @Column(name="nombre_cliente")
    private String nombre_cliente;
    @Column(name="clave_cliente")
    private String clave_cliente;

    public Cliente(String id_cliente, String nombre_cliente, String clave_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.clave_cliente = clave_cliente;
    }

    public Cliente() {
    }

    @Override
    public String toString() {
        return "Cliente [id_cliente=" + id_cliente + ", nombre_cliente=" + nombre_cliente + ", clave_cliente="
                + clave_cliente + "]";
    }
}
