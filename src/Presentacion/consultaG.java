package Presentacion;

import Logica.BuscadorDTO;
import Logica.ConsultaApiPaisesDTO;
import Logica.ConsultaChatGptDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static Logica.ConsultaChatGptDTO.getConsultaGpt;

public class consultaG {
    public JTextField paisTextField;
    private JPanel panel1;
    public JTextField segundoPaísTextField;
    private JButton buscarButton;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JComboBox comboBox1;
    private JTextField BusquedaGPT;
    private JTextPane RespuestaGpt;
    private JTextField textField2;
    private JTextPane textPane2;
    private JLabel NombrePais;
    private JLabel Capital;
    private JLabel gini;
    private JLabel NombrePais2;
    private JLabel Capital2;
    private JLabel Gini2;
    private JLabel ImagenBandera;
    private JLabel poblacion;
    private JLabel idioma;
    private JLabel poblacion2;
    private JLabel moneda2;
    private JLabel idioma2;
    private JLabel ImagenEscudo;
    private JLabel lblimagenBandera2;
    private JLabel lblimagenEscudo2;
    private JLabel lblRespuestaGpt;
    private JButton button2;
    private JLabel NombrePais1;
    private JLabel Capital1;
    private JLabel Gine1;
    private JLabel Población1;
    private JLabel Divisa1;
    private JLabel Idioma1;
    private JLabel lblimagenBandera1;
    private JLabel lblMapa;
    private JPanel nombrepais;

    public consultaG() {
    buscarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("que bueno");
            String pais = paisTextField.getText();
            String pais2 = segundoPaísTextField.getText();
            BuscadorDTO buscador = new BuscadorDTO();
            buscador.setPaisBuscar(pais, pais2);

            ConsultaApiPaisesDTO consultaApiPaisesDTO = new ConsultaApiPaisesDTO();
            AsociaciónImagenes asociaciónImagenes = new AsociaciónImagenes();

            try{
            consultaApiPaisesDTO.getPaisInfo(pais, pais2);
             NombrePais1.setText(consultaApiPaisesDTO.getName());
             Capital1.setText(consultaApiPaisesDTO.getCapital());
             Gine1.setText(String.valueOf(consultaApiPaisesDTO.getGini()));
             Población1.setText(String.valueOf(consultaApiPaisesDTO.getPoblacion()));
             Idioma1.setText(consultaApiPaisesDTO.getIdioma());
             //ImagenBandera.setIcon(asociaciónImagenes.procesaImagen(consultaApiPaisesDTO.getFlag(), true));
             //ImagenEscudo.setIcon(asociaciónImagenes.procesaImagen(consultaApiPaisesDTO.getShield(), false));
             NombrePais2.setText(consultaApiPaisesDTO.getName2());
             Capital2.setText(consultaApiPaisesDTO.getCapital2());
             Gini2.setText(String.valueOf(consultaApiPaisesDTO.getGini2()));
             poblacion2.setText(String.valueOf(consultaApiPaisesDTO.getPoblacion2()));
             idioma2.setText(consultaApiPaisesDTO.getIdioma2());
             lblimagenBandera2.setIcon(asociaciónImagenes.procesaImagen(consultaApiPaisesDTO.getFlag2(), true));
             lblimagenEscudo2.setIcon(asociaciónImagenes.procesaImagen(consultaApiPaisesDTO.getShield2(), false));
                }catch (Exception es){
                System.out.println(es);
            }
        }
    });


    }
    public JPanel getPanel1() {
        return this.panel1;
    }



}
