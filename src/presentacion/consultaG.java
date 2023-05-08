package presentacion;

import Logica.Buscador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class consultaG {
    private JTextField paísTextField;
    public JPanel panel1;
    private JTextField segundoPaísTextField;
    private JButton buscarButton;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTextArea informaciónPaísTextArea;
    private JTextArea informaciónPaisTextArea;
    private JTextPane imagenBanderaTextPane;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JEditorPane imagenEscudoEditorPane;
    private JTextArea interaccionConChatGPTTextArea;
    private JTextPane imagenBanderaTextPane1;
    private JTextArea imagenEscudoTextArea;
    private JTextPane interacciónChatGPTTextPane;
public consultaG() {
    buscarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("que bueno");
            String pais = paísTextField.getText();
            Buscador buscador = new Buscador();
            buscador.setPaisBuscar(pais);
        }
    });
}
}
