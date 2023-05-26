package Presentacion;

import Logica.BuscadorDTO;
import Logica.ConsultaApiPaisesDTO;
import Logica.ConsultaChatGptDTO;
import Logica.PaisesDTO;
import Persistencia.ArchivoDAO;

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
    private JLabel lblSubregion1;
    private JLabel lblSubregion2;
    private JButton generarGraficaButton;
    private JButton guardarBusquedaEnBaseButton;
    private JButton ButtonGenerarArchivo;


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
             lblSubregion1.setText(consultaApiPaisesDTO.getSubregion());
             lblimaganBandera1.setIcon(asociaciónImagenes.procesaImagen(consultaApiPaisesDTO.getFlag(), true));
             lblimagenEscudo1.setIcon(asociaciónImagenes.procesaImagen(consultaApiPaisesDTO.getShield(), false));
             lblnombrePais2.setText(consultaApiPaisesDTO.getName2());
             lblcapital2.setText(consultaApiPaisesDTO.getCapital2());
             lblgini2.setText(String.valueOf(consultaApiPaisesDTO.getGini2()));
             lblpoblacion2.setText(String.valueOf(consultaApiPaisesDTO.getPoblacion2()));
             lblarea2.setText(String.valueOf(consultaApiPaisesDTO.getArea2()));
             lblcontinente2.setText(consultaApiPaisesDTO.getContinente2());
             lblSubregion2.setText(consultaApiPaisesDTO.getSubregion2());
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
        generarGraficaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
                grafica graficar = new grafica(
                        paisTextField.getText(),
                        segundoPaísTextField.getText(),
                        lblgini1.getText(),
                        lblgini2.getText()
                );
                frame.setContentPane(graficar.getPanelGrafica1());
                frame.setTitle("Grafica");
                frame.setSize(600, 600);
                frame.setVisible(true);


            }
        });
        guardarBusquedaEnBaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ConsultaApiPaisesDTO consultaApiPaisesDTO = new ConsultaApiPaisesDTO();
                PaisesDTO paisesDTO = new PaisesDTO();
                boolean result = paisesDTO.crear(lblnombrePais1.getText(),
                        lblcapital1.getText(),
                        Double.parseDouble(lblgini1.getText()),
                        Double.parseDouble(lblpoblacion1.getText()),
                        Double.parseDouble(lblarea1.getText()),
                        lblcontinente1.getText(),
                        lblSubregion1.getText());

                boolean result2 = paisesDTO.crear(lblnombrePais2.getText(),
                        lblcapital2.getText(),
                        Double.parseDouble(lblgini2.getText()),
                        Double.parseDouble(lblpoblacion2.getText()),
                        Double.parseDouble(lblarea2.getText()),
                        lblcontinente2.getText(),
                        lblSubregion2.getText());

                if(result || result2 ) {
                    JOptionPane.showMessageDialog(panel1, " Se guardo con exito");
                }else{
                    JOptionPane.showMessageDialog(panel1, " Error");
                }
            }
        });
        consultarButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Excelente");
                String consulta = txtConsultaGpt2.getText();
                BuscadorDTO buscadorDTO = new BuscadorDTO();
                buscadorDTO.setBusquedaGPT(consulta);
                ConsultaChatGptDTO consultaChatGptDTO = new ConsultaChatGptDTO();
                String resultado = consultaChatGptDTO.getConsultaGpt(consulta);
                lblRespuestaGpt2.setText(resultado);

            }
        });
        ButtonGenerarArchivo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ArchivoDAO archivoDAO = new ArchivoDAO();
                archivoDAO.escribirArchivo(lblnombrePais1.getText(), lblcapital1.getText(),
                        Double.parseDouble(lblgini1.getText()),
                        Double.parseDouble(lblpoblacion1.getText()),
                        Double.parseDouble(lblarea1.getText()), lblcontinente1.getText(),lblSubregion1.getText());
                archivoDAO.escribirArchivo(lblnombrePais2.getText(), lblcapital2.getText(),
                        Double.parseDouble(lblgini2.getText()), Double.parseDouble(lblpoblacion2.getText()),
                        Double.parseDouble(lblarea2.getText()), lblcontinente2.getText(),lblSubregion2.getText());
            }
        });
    }
    public JPanel getPanel1() {
        return this.panel1;
    }

    public JLabel getLblgini1() {
        return lblgini1;
    }

    public JLabel getLblgini2() {
        return lblgini2;
    }
}
