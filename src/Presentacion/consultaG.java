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
    private JComboBox comboBox2;
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
             NombrePais.setText(consultaApiPaisesDTO.getName());
             Capital.setText(consultaApiPaisesDTO.getCapital());
             gini.setText(String.valueOf(consultaApiPaisesDTO.getGini()));
             poblacion.setText(String.valueOf(consultaApiPaisesDTO.getPoblacion()));
             idioma.setText(consultaApiPaisesDTO.getIdioma());
             ImagenBandera.setIcon(asociaciónImagenes.procesaImagenBandera(consultaApiPaisesDTO.getFlag()));
             ImagenEscudo.setIcon(asociaciónImagenes.procesaImagenBandera(consultaApiPaisesDTO.getShield()));
             NombrePais2.setText(consultaApiPaisesDTO.getName2());
             Capital2.setText(consultaApiPaisesDTO.getCapital2());
             Gini2.setText(String.valueOf(consultaApiPaisesDTO.getGini2()));
             poblacion2.setText(String.valueOf(consultaApiPaisesDTO.getPoblacion2()));
             idioma2.setText(consultaApiPaisesDTO.getIdioma2());
             lblimagenBandera2.setIcon(asociaciónImagenes.procesaImagenBandera2(consultaApiPaisesDTO.getFlag2()));
             lblimagenEscudo2.setIcon(asociaciónImagenes.procesaImagenEscudo2(consultaApiPaisesDTO.getShield2()));
                }catch (Exception es){
                System.out.println(es);
            }
        }
    });
    BusquedaGPT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("que bueno");
                String BuscadorGPT = BusquedaGPT.getText();
                ConsultaChatGptDTO consultaChatGptDTO = new ConsultaChatGptDTO();
                try{
                    getConsultaGpt(BuscadorGPT);
                    String resultado = getConsultaGpt(BusquedaGPT.getText());
                    RespuestaGpt.setText(resultado);

                }catch (Exception es){
                    System.out.println(es);
                }

                BuscadorDTO buscador = new BuscadorDTO();
                buscador.setBusquedaGPT(BuscadorGPT);


                super.keyTyped(e);
            }
        });

    }
    public JPanel getPanel1() {
        return this.panel1;
    }



}
