package Presentacion;

import Logica.BuscadorDTO;
import Logica.ConsultaApiPaisesDTO;
import Logica.ConsultaChatGptDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class consultaG {
    public JTextField paisTextField;
    private JPanel panel1;
    public JTextField segundoPaísTextField;
    private JButton buscarButton;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JLabel lblcapital1;
    private JLabel lblgini1;
    private JLabel lblpoblacion1;
    private JLabel lblarea1;
    private JLabel lblcontinente1;
    private JLabel lblimaganBandera1;
    private JLabel lblimagenEscudo1;
    private JLabel lblnombrePais2;
    private JLabel lblcapital2;
    private JLabel lblgini2;
    private JLabel lblpoblacion2;
    private JLabel lblarea2;
    private JLabel lblimagenEscudo2;
    private JButton consultarButton;
    private JLabel lblResultadoGPT;
    private JTextField txtconsultaGpt;
    private JLabel lblcontinente2;
    private JLabel lblRespuestaGpt2;
    private JLabel lblimagenBandera2;
    private JTextField txtConsultaGpt2;
    private JButton consultarButton1;
    private JLabel lblnombrePais1;


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
             lblnombrePais1.setText(consultaApiPaisesDTO.getName());
             lblcapital1.setText(consultaApiPaisesDTO.getCapital());
             lblgini1.setText(String.valueOf(consultaApiPaisesDTO.getGini()));
             lblpoblacion1.setText(String.valueOf(consultaApiPaisesDTO.getPoblacion()));
             lblarea1.setText(String.valueOf(consultaApiPaisesDTO.getArea()));
             lblcontinente1.setText(consultaApiPaisesDTO.getContinente());
             lblimaganBandera1.setIcon(asociaciónImagenes.procesaImagen(consultaApiPaisesDTO.getFlag(), true));
             lblimagenEscudo1.setIcon(asociaciónImagenes.procesaImagen(consultaApiPaisesDTO.getShield(), false));
             lblnombrePais2.setText(consultaApiPaisesDTO.getName2());
             lblcapital2.setText(consultaApiPaisesDTO.getCapital2());
             lblgini2.setText(String.valueOf(consultaApiPaisesDTO.getGini2()));
             lblpoblacion2.setText(String.valueOf(consultaApiPaisesDTO.getPoblacion2()));
             lblarea2.setText(String.valueOf(consultaApiPaisesDTO.getArea2()));
             lblcontinente2.setText(consultaApiPaisesDTO.getContinente2());
             lblimagenBandera2.setIcon(asociaciónImagenes.procesaImagen(consultaApiPaisesDTO.getFlag2(), true));
             lblimagenEscudo2.setIcon(asociaciónImagenes.procesaImagen(consultaApiPaisesDTO.getShield2(), false));
                }catch (Exception es){
                System.out.println(es);
            }
        }
    });


        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Excelente");
                String consulta = txtconsultaGpt.getText();
                BuscadorDTO buscadorDTO = new BuscadorDTO();
                buscadorDTO.setBusquedaGPT(consulta);
                ConsultaChatGptDTO consultaChatGptDTO = new ConsultaChatGptDTO();
                String resultado = consultaChatGptDTO.getConsultaGpt(consulta);
                lblResultadoGPT.setText(resultado);
            }
        });
    }
    public JPanel getPanel1() {
        return this.panel1;
    }



}
