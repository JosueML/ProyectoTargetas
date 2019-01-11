/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Date;

/**
 *
 * @author Josue Marquetti
 */
public class Targeta {
    private String id;
    private String codigo;
    private Date fecha_entrada;
    private Date fecha_salida;
    private int tipo_de_targeta;
    private String vendedor;
    private String cliente;
    private int estado_de_compra;
    private String comentarios;

    public Targeta() {
    
    }
    
    public Targeta(String id, String codigo, Date fecha_entrada, Date fecha_salida, int tipo_de_targeta, String vendedor, String cliente, int estado_de_compra, String comentarios) {
        this.id = id;
        this.codigo = codigo;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.tipo_de_targeta = tipo_de_targeta;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.estado_de_compra = estado_de_compra;
        this.comentarios = comentarios;
    }

    public Targeta(String id, Date fecha_entrada, int tipo_de_targeta, int estado_de_compra, String comentarios) {
        this.id = id;
        this.fecha_entrada = fecha_entrada;
        this.tipo_de_targeta = tipo_de_targeta;
        this.estado_de_compra = estado_de_compra;
        this.comentarios = comentarios;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public int getTipo_de_targeta() {
        return tipo_de_targeta;
    }

    public void setTipo_de_targeta(int tipo_de_targeta) {
        this.tipo_de_targeta = tipo_de_targeta;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getEstado_de_compra() {
        return estado_de_compra;
    }

    public void setEstado_de_compra(int estado_de_compra) {
        this.estado_de_compra = estado_de_compra;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    public void actualiza_comentarios(String comentario){
        String concat = this.comentarios+ " // "+comentario;
        this.comentarios = concat;
    /*concat*/}
    
    
    
    
}
