package Presentacion;

import Logica.ConsultaApiPaisesDTO;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class AsociaciónImagenes {
    private ImageIcon icon;


    public ImageIcon procesaImagen(String urlImage, boolean bandera) throws MalformedURLException {

        {
            URL url = new URL(urlImage);
            ImageIcon imagen = new ImageIcon(url);
            int ancho = 200;
            int alto = 200;

            if(bandera){
                ancho = 200;
                alto = 100;
            }
            Image img = imagen.getImage().getScaledInstance( ancho, alto, Image.SCALE_SMOOTH);
            ImageIcon imagenEscalada = new ImageIcon( img );
            return imagenEscalada;

        }
    }
}

