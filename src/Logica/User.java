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
public class User {
    private int id;
    private String nombre;
    private String pass;
    private int tipo_de_user;
    private int id_imagen;

    public User(int id, String nombre, String pass, int tipo_de_user, int id_imagen) {
        this.id = id;
        this.nombre = nombre;
        this.pass = pass;
        this.tipo_de_user = tipo_de_user;
        this.id_imagen = id_imagen;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getTipo_de_user() {
        return tipo_de_user;
    }

    public void setTipo_de_user(int tipo_de_user) {
        this.tipo_de_user = tipo_de_user;
    }

    public int getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
    }
    
    
    
    public boolean coincide_user_pass(String user, String pass){
        return this.nombre.equals(user)&&this.pass.equals(pass);
    }
    
    public boolean cambiar_pass(String viejo, String nuevo){
        if(this.pass.equals(viejo))
            setPass(nuevo);
        return this.pass.equals(nuevo);
    }
}
