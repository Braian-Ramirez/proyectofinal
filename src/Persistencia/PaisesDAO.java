package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PaisesDAO {
    private Connection connection;
    public PaisesDAO() {
        Conexion conexion = new Conexion();
        this.connection = conexion.getConnection();
        this.crearTabla();
    }
    private  void crearTabla(){
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS paises" +
                    "( id INTEGER PRIMARY KEY, pais TEXT, capital TEXT, gini DOUBLE," +
                    " poblacion DOUBLE, area DOUBLE, continente TEXT, subregion TEXT)");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public boolean crear(String pais, String capital, double gini, double poblacion, double area, String continente,
                         String subregion){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    (" INSERT INTO paises( pais, capital, gini, poblacion, area, continente, subregion) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, pais);
            preparedStatement.setString(2, capital);
            preparedStatement.setDouble(3, gini);
            preparedStatement.setDouble(4, poblacion);
            preparedStatement.setDouble(5,area);
            preparedStatement.setString(6,continente);
            preparedStatement.setString(7,subregion);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
