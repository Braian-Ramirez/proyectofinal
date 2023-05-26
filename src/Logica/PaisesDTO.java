package Logica;

import Persistencia.PaisesDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaisesDTO {
    private String pais;
    private String capital;
    private double gini;
    private double poblacion;
    private double area;
    private String continente;
    private String subregion;

    public boolean crear(String pais,
                         String capital,
                         double gini,
                         double poblacion,
                         double area,
                         String continente,
                         String subregion){

       this.pais = pais;
       this.capital = capital;
       this.gini = gini;
       this.poblacion = poblacion;
       this.area = area;
       this.continente = continente;
       this.subregion = subregion;



        PaisesDAO paisesDAO = new PaisesDAO();
        boolean result = paisesDAO.crear(this.pais,
                this.capital,
                this.gini,
                this.poblacion,
                this.area,
                this.continente,
                this.subregion );

        return result;
    }
}
