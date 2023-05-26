package Persistencia;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ArchivoDAO {
     public void escribirArchivo(String pais, String capital, double gini, double poblacion,
                                 double area, String continente, String subregion){
         File archivo = new File("archivos_paises/" + pais);
         try{
             FileWriter escritor = new FileWriter(archivo);
             escritor.write(pais);
             escritor.write(capital);
             escritor.write(String.valueOf(gini));
             escritor.write(String.valueOf(poblacion));
             escritor.write(String.valueOf(area));
             escritor.write(continente);
             escritor.write(subregion);
             escritor.close();
             JOptionPane.showMessageDialog(null,"Archivo creado correctamente");

         }catch (IOException e){
             JOptionPane.showMessageDialog(null, "Error al guardar el archivo",
                     "Error", JOptionPane.ERROR_MESSAGE);
         }

     }
}
