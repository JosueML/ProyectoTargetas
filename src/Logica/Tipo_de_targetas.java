/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Marquetti
 */
public class Tipo_de_targetas {
    private int id;
    private String nombre;
    private int id_imagen;
    private float valor;
    private boolean cuc;

    public Tipo_de_targetas(int id, String nombre, int id_imagen, float valor, boolean CUC) {
        this.id = id;
        this.nombre = nombre;
        this.id_imagen = id_imagen;
        this.valor = valor;
        this.cuc = CUC;
    }
    public Tipo_de_targetas() {
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean getCuc() {
        return cuc;
    }

    public void setCuc(boolean cuc) {
        this.cuc = cuc;
    }
   
}
