package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection connection;

    public Conexion(){
        try{
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:proyectofinal.db");
        }catch(SQLException | ClassNotFoundException e ){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return null;
    }
}

