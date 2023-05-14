package Presentacion;

import Logica.ConsultaApiPaisesDTO;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class AsociaciónImagenes {
    private ImageIcon icon;
    ConsultaApiPaisesDTO consultaApiPaisesDTO = new ConsultaApiPaisesDTO();


    public AsociaciónImagenes(){

        {
            URL url = null;
            try {
                url = new URL(consultaApiPaisesDTO.getFlag());
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
            ImageIcon imagen = new ImageIcon(url);
            int ancho = 200;
            int alto = 200;
            Image img = imagen.getImage().getScaledInstance( ancho, alto, Image.SCALE_SMOOTH);
            ImageIcon imagenEscalada = new ImageIcon( img );
           // setIcon(imagenEscalada);

        }
    }



}

