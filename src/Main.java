import Presentacion.consultaG;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        consultaG gini = new consultaG();
        frame.setContentPane(gini.getPanel1());
        frame.pack();
        frame.setTitle("Consulta Gini");
        frame.setSize(800,800);
        frame.setVisible(true);
        System.out.println("hola mundo ");
    }
}