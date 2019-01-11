/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Marquetti
 */
public class Controladora {
    private LinkedList<Targeta> targetas;
    private LinkedList<Tipo_de_targetas> tipo_de_targetas;
    private LinkedList<User> users;
    private LinkedList<Imagen> imagenes;
    private Connection con;
    private ConexionBD conexion;
    
    private static Controladora controladora = null;

    public Controladora() {
        this.targetas = new LinkedList<>();
        this.tipo_de_targetas = new LinkedList<>();
        this.users = new LinkedList<>();
        this.con = null;   
        this.conexion = null;
    }
    
    public static Controladora getInstance(){
        if(controladora==null)
            controladora = new Controladora();
        return controladora;
    }

    public LinkedList<Targeta> getTargetas() {
        return targetas;
    }

    public void setTargetas(LinkedList<Targeta> targetas) {
        this.targetas = targetas;
    }

    public LinkedList<Tipo_de_targetas> getTipo_de_targetas() {
        return tipo_de_targetas;
    }

    public void setTipo_de_targetas(LinkedList<Tipo_de_targetas> tipo_de_targetas) {
        this.tipo_de_targetas = tipo_de_targetas;
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    public void setUsers(LinkedList<User> users) {
        this.users = users;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public ConexionBD getConexion() {
        return conexion;
    }

    public void setConexion(ConexionBD conexion) {
        this.conexion = conexion;
    }

    public LinkedList<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(LinkedList<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public static Controladora getControladora() {
        return controladora;
    }

    public static void setControladora(Controladora controladora) {
        Controladora.controladora = controladora;
    }
    
    
    
    
    public void recibirDatos() throws SQLException{
        targetas.clear();
        tipo_de_targetas.clear();
        users.clear();
       
        conexion = new ConexionBD();
        con = conexion.getConnection();
        
        
        PreparedStatement preparar_consulta = null;
        ResultSet rs = null;

        String sql = "SELECT id, codigo, fecha_entrada, fecha_salida, tipo_targeta, vendedor, cliente, estado_de_compra, comentarios FROM targetas";

        preparar_consulta = con.prepareStatement(sql);
        rs = preparar_consulta.executeQuery();
        
        while (rs.next()) {            
            String id = (String) rs.getObject(1);
            String codigo = (String) rs.getObject(2);
            Date fecha_entrada = (Date) rs.getObject(3);
            Date fecha_salida = (Date) rs.getObject(4);
            int tipo_de_targeta = (int) rs.getObject(5);
            String vendedor = (String) rs.getObject(6);
            String cliente = (String) rs.getObject(7);
            int estado_de_compra = (int) rs.getObject(8);
            String comentarios = (String) rs.getObject(9);
            
            Targeta targeta = new Targeta(id, codigo, fecha_entrada, fecha_salida, tipo_de_targeta, vendedor, cliente, estado_de_compra, comentarios);
            
            this.targetas.add(targeta);

        }
        
        sql = "SELECT * FROM tipos_de_targetas";

        preparar_consulta = con.prepareStatement(sql);
        rs = preparar_consulta.executeQuery();
        
        while (rs.next()){
            int id = (int) rs.getObject(1);
            String nombre = (String) rs.getObject(2);
            int id_imagen = (int) rs.getObject(3);
            float valor = (float) rs.getObject(4);
            boolean cuc = (boolean) rs.getObject(5);
            Tipo_de_targetas tipo = new Tipo_de_targetas(id, nombre, id_imagen, valor, cuc);
            this.tipo_de_targetas.add(tipo);
        }
        
        sql = "SELECT * FROM user";

        preparar_consulta = con.prepareStatement(sql);
        rs = preparar_consulta.executeQuery();
        
        while (rs.next()){
            int id = (int) rs.getObject(1);
            String nombre = (String) rs.getObject(2);
            String pass = (String) rs.getObject(3);
            int tipo_de_user = (int) rs.getObject(4);
            int id_imagen = (int) rs.getObject(5);
            User user = new User(id, nombre, pass, tipo_de_user, id_imagen);
            this.users.add(user);
        }
        
        
    }
    
    
    
    public Object[][] tabla_general(){
        Object tabla[][] = null;
        
        int cant = targetas.size();
        tabla = new Object [cant][4];
        
        for(int i = 0; i < cant;i++){
            tabla[i][0] = targetas.get(i).getId();
            tabla[i][1] = targetas.get(i).getFecha_entrada();
            
            for(int z = 0;z<tipo_de_targetas.size();z++){
                if(tipo_de_targetas.get(z).getId()==targetas.get(i).getTipo_de_targeta()){
                    tabla[i][2] = tipo_de_targetas.get(z).getNombre();
                    z = tipo_de_targetas.size()+1;
                }
            }
            
            String estado_de_targeta;
            switch(targetas.get(i).getEstado_de_compra()){
                case 1: 
                    estado_de_targeta = "No vendida";
                    break;
                case 2: 
                    estado_de_targeta = "Vendida";
                    break;
                default: 
                    estado_de_targeta = "En deuda";
            }
            tabla[i][3] = estado_de_targeta;
            
        }
        
        return tabla;
    }
    
    public Object[][] tabla_resumen(){
        Object [][] tabla = null;
        
        tabla = new Object[tipo_de_targetas.size()][5];
        for(int i = 0;i<tipo_de_targetas.size();i++)
            tabla[tipo_de_targetas.get(i).getId()-1][0] = tipo_de_targetas.get(i).getNombre();
        
        int cant [][] = new int [tipo_de_targetas.size()][4];

        for(int i =0;i<targetas.size();i++){
            cant[targetas.get(i).getTipo_de_targeta()-1][targetas.get(i).getEstado_de_compra()-1]++;
            cant[targetas.get(i).getTipo_de_targeta()-1][3]++;
        }
        
        for(int i = 0;i<tipo_de_targetas.size();i++){
            tabla[i][1] = cant[i][0];
            tabla[i][2] = cant[i][1];
            tabla[i][3] = cant[i][2];
            tabla[i][4] = cant[i][3];
        }
           
        return tabla;
    }
    
    public Object[][] tabla_deudas(){
        Object tabla[][] = null;
        
        LinkedList<Targeta> deudas = new LinkedList<>();
        
        for(int i = 0;i<targetas.size();i++)
            if(targetas.get(i).getEstado_de_compra()==3)
                deudas.add(targetas.get(i));
        
        tabla = new Object[deudas.size()][5];
        
        for(int i = 0;i<deudas.size();i++){
            tabla[i][0] = deudas.get(i).getId();
            tabla[i][1] = deudas.get(i).getCodigo();
            int tipo = deudas.get(i).getTipo_de_targeta();
            tabla[i][2] = tipo_de_targetas.get(tipo).getNombre();
            tabla[i][3] = deudas.get(i).getVendedor();
            tabla[i][4] = deudas.get(i).getCliente();
            
        }
        
        return tabla;
    }
    
    public int subir_imagen(byte [] img) throws SQLException{
        PreparedStatement preparar_consulta = null;
        ResultSet rs = null;

        String sql = "SELECT id comentarios FROM imagen";

        preparar_consulta = con.prepareStatement(sql);
        rs = preparar_consulta.executeQuery();
        
        int valor = 0;
        int comprueba = 0;
        while(rs.next()){
            if((int)rs.getObject(1)>valor){
                valor = (int)rs.getObject(1);
                if(valor==comprueba+1)
                    comprueba=valor;
                else{
                    valor-=2;
                    break;
                }
            }
        }
        
        valor++;
        
        preparar_consulta = con.prepareStatement("INSERT INTO imagen (id, imagen) VALUES (?, ?)");
        preparar_consulta.setInt(1, valor);
        preparar_consulta.setBytes(2, img);       
        
        preparar_consulta.executeUpdate();
        
        return valor;
    }
    
    public byte [] descargar_imagen(int id) throws SQLException{
        PreparedStatement preparar_consulta = null;
        ResultSet rs = null;

        String sql = "SELECT imagen comentarios FROM imagen WHERE id = "+id;

        preparar_consulta = con.prepareStatement(sql);
        rs = preparar_consulta.executeQuery();
        
        byte [] imagen = null;
        while(rs.next())
            imagen = rs.getBytes(1);
        
        return imagen;
    }    
    
    public int devolver_id_imagen(int tipo){
        int id = 0;
           
        int i = 0;
        while(i<tipo_de_targetas.size()){
            if(tipo_de_targetas.get(i).getId()==tipo){
                id = tipo_de_targetas.get(i).getId_imagen();
                i = tipo_de_targetas.size();
            }
            i++;
        }
        
        
        return id;
    }
    
    public LinkedList<String> venderTargeta(int tipo_de_targeta){
        LinkedList<String> id = new LinkedList<>();
        
        for(int i =0;i< targetas.size();i++)
            if(targetas.get(i).getTipo_de_targeta() == tipo_de_targeta)
                id.add(targetas.get(i).getId());        
        
        return id;
    }
    
    public void insertar_tipo_de_targeta(Tipo_de_targetas nuevo) throws SQLException{
        if(!tipo_de_targetas.isEmpty()){
            for(int i = 1;i<tipo_de_targetas.size();i++){
                if(tipo_de_targetas.get(i-1).getId()!=(tipo_de_targetas.get(i).getId()-1)){
                    nuevo.setId(tipo_de_targetas.get(i-1).getId()+1);
                    break;
                }else if(i==tipo_de_targetas.size())
                    nuevo.setId(tipo_de_targetas.get(i).getId()+1);
            }

            tipo_de_targetas.add(nuevo.getId()-1, nuevo);

            PreparedStatement preparar_consulta = null;
            ResultSet rs = null;


            preparar_consulta = con.prepareStatement("INSERT INTO tipos_de_targetas (id, nombre, id_imagen, valor, cuc) VALUES (?, ?, ?, ?, ?)");
            preparar_consulta.setInt(1, nuevo.getId());
            preparar_consulta.setString(2, nuevo.getNombre());
            preparar_consulta.setInt(3, nuevo.getId_imagen());
            preparar_consulta.setFloat(4, nuevo.getValor());
            preparar_consulta.setBoolean(5, nuevo.getCuc());

            preparar_consulta.executeUpdate();
        }
        else{
            PreparedStatement preparar_consulta = null;
            ResultSet rs = null;


            preparar_consulta = con.prepareStatement("INSERT INTO tipos_de_targetas (id, nombre, id_imagen, valor, cuc) VALUES (?, ?, ?, ?, ?)");
            preparar_consulta.setInt(1, 1);
            preparar_consulta.setString(2, nuevo.getNombre());
            preparar_consulta.setInt(3, nuevo.getId_imagen());
            preparar_consulta.setFloat(4, nuevo.getValor());
            preparar_consulta.setBoolean(5, nuevo.getCuc());

            preparar_consulta.executeUpdate();
        }
    }
    
    
    //Recibe el nombre del tipo de targeta y devuelve el Tipo de Targeta
    public Tipo_de_targetas buscar_targeta_vender_1(String nombre){
        Tipo_de_targetas tipo = new Tipo_de_targetas();
        int cant = tipo_de_targetas.size();
        for(int i = 0;i<cant;i++){
            if(tipo_de_targetas.get(i).getNombre().equalsIgnoreCase(nombre)){
                tipo = tipo_de_targetas.get(i);
                i=cant;
            }
            else
                tipo = null;
        }
        return tipo;
    }
    
    public LinkedList<Targeta> buscar_targeta_vender_2(Tipo_de_targetas tipo){
        LinkedList<Targeta> targetas1;
        targetas1 = new LinkedList<>();
        
        for(int i = 0;i<this.targetas.size();i++){
            if(tipo.getId()==this.targetas.get(i).getTipo_de_targeta() && this.targetas.get(i).getEstado_de_compra()==1)
                targetas1.add(this.targetas.get(i));
        }
                
        return targetas1;
    }
    
    public Targeta busca_targeta_vender_3(String id, int tipo){
        Targeta targeta = new Targeta();
        
        boolean encontrado = false;
        int i = 0;
        while (!encontrado) {
            if(targetas.get(i).getId().equalsIgnoreCase(id)&&targetas.get(i).getTipo_de_targeta()==tipo){
                targeta = targetas.get(i);
                //Para facilitar la modificacion el codigo va a pasar la posicion de la targeta
                targeta.setCodigo(String.valueOf(i));
                encontrado = true;
            }                
        }
        
        
        return targeta;
    }

    //Update nombre_de_la_tabla SET variable = cambio WHERE variable = condicion
    public void buscar_targeta_vender_4(Targeta targeta, int posicion) throws SQLException{
        this.targetas.set(posicion, targeta);
          
        PreparedStatement preparar_consulta = null;
        ResultSet rs = null;
        String id = targeta.getId();
        String codigo = targeta.getCodigo();
        String comentarios = targeta.getComentarios();
        int estado = targeta.getEstado_de_compra();
        String vendedor = targeta.getVendedor();
        String cliente = targeta.getCliente();
        int tipo = targeta.getTipo_de_targeta();

        
        preparar_consulta = con.prepareStatement("UPDATE targetas SET (fecha_salida, cliente, vendedor, estado, codigo, comentarios) VALUE(NOW(),?,?,?,?,?) WHERE id ="
                                                    +id+" AND tipo_targeta="+tipo);
          
            preparar_consulta.setString(2, cliente);
            preparar_consulta.setString(3, vendedor);
            preparar_consulta.setInt(4, estado);
            preparar_consulta.setString(5, comentarios);

        preparar_consulta.executeUpdate();
        
        
        
        
    }
    
    
        
}
