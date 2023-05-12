package Presentacion;

import Logica.Buscador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class consultaG {
    private JTextField paisTextField;
    private JPanel panel1;
    private JTextField segundoPaísTextField;
    private JButton buscarButton;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JTextPane textPane1;
    private JTextField textField2;
    private JTextPane textPane2;
    private JList list1;

    public consultaG() {
    buscarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("que bueno");
            String pais = paisTextField.getText();
            String pais2 = segundoPaísTextField.getText();
            Buscador buscador = new Buscador();
            buscador.setPaisBuscar(pais, pais2);
        }
    });
}
    public JPanel getPanel1() {
        return this.panel1;
    }
}
