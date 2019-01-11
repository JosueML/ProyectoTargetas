/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marquetti
 */
public class ConexionBD {
    private static Connection conexion;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static final String url = "jdbc:mysql://localhost:3306/bd_targetas";

    public ConexionBD() {
        conexion = null;
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, pass);
            if(conexion != null)
                System.out.println("Conexion establecida");
        } catch (ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar " + e);
        }
    }
    public Connection getConnection(){
        return conexion;
    }
    
}
