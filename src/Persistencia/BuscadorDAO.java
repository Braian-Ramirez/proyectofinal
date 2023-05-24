package Persistencia;

import java.sql.*;

public class BuscadorDAO {
   private Connection connection;
    public BuscadorDAO() {
        Conexion conexion = new Conexion();
        this.connection = conexion.getConnection();
        this.crearTabla();
    }
    private  void crearTabla(){
        try{
            Statement statement = this.connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS consulta_paises( id INTEGER PRIMARY KEY, pais TEXT, capital TEXT, gini DOUBLE, poblacion DOUBLE, area DOUBLE, continente TEXT, subregion TEXT)");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public boolean crear(String pais, String capital, double gini, double poblacion, double area, String continente, String subregion){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(" INSERT INTO consulta_paises( pais, capital, gini, poblacion, area, continente, subregion) VALUES (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, pais);
            preparedStatement.setString(2, capital);
            preparedStatement.setDouble(3, gini);
            preparedStatement.setDouble(4, poblacion);
            preparedStatement.setDouble(5,area);
            preparedStatement.setString(6,continente);
            preparedStatement.setString(7,subregion);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
        }
    public void readAll(){
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM consulta_paises ");

            while ( resultSet.next()){
                System.out.println(resultSet.getString("pais") + " " + resultSet.getString("capital") + " " + resultSet.getInt("gini") + " " + resultSet.getString("moneda"));
                }
        }catch ( SQLException e){
            e.printStackTrace();
        }
    }
    public void readOne(){
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT pais FROM consulta_paises");

            while (( resultSet.next())){
                System.out.println(resultSet.getString("pais") + " " + resultSet.getString("capital") + " " + resultSet.getInt("gini") + " " + resultSet.getString("moneda"));
            }
        }catch( SQLException e){
            e.printStackTrace();
        }
    }
    public void delete( String pais ){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(" DELETE FROM consulta_paises WHERE pais =? ");
            preparedStatement.setString(1, pais);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
