package Logica;

import Persistencia.BuscadorDAO;
import Persistencia.Conexion;

public class Buscador {
public void setPaisBuscar( String pais, String pais2 ){
    System.out.println("ya recibi el pais " + pais);
    System.out.println("ya recibe el segundo país " + pais2);
}

public boolean procesarDatos() {
    BuscadorDAO buscadorDAO = new BuscadorDAO();

    return false;
}
public  void setBusquedaGPT(String BuscadorGPT){
    System.out.println("ya recibi busqueda" +  BuscadorGPT);
}
}
