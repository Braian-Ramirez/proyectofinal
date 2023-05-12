package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class AsociaciónImagenes {
    private ImageIcon icon;

    public AsociaciónImagenes(){
        AsociaciónImagenes etiqueta = new AsociaciónImagenes();
        {
            URL url = null;
            try {
                url = new URL("https://upload.wikimedia.org/wikipedia/commons/f/f8/Flag_of_Colombia.png");
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
            ImageIcon imagen = new ImageIcon(url);
            int ancho = 200;
            int alto = 200;
            Image img = imagen.getImage().getScaledInstance( ancho, alto, Image.SCALE_SMOOTH);
            ImageIcon imagenEscalada = new ImageIcon( img );
        etiqueta.setIcon(imagenEscalada);
        }
    }


    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public ImageIcon getIcon() {
        return icon;
    }
}

