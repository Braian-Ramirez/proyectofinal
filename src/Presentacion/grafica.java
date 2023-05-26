package Presentacion;

import Logica.ConsultaApiPaisesDTO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class grafica {
    private JButton buttonGenerarGrafica;
    private JPanel PanelGrafica1;
    private JPanel PanelGrafica;


    public grafica(String pais1, String pais2, String gini1, String gini2) {
    buttonGenerarGrafica.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ConsultaApiPaisesDTO consultaApiPaisesDTO = new ConsultaApiPaisesDTO();
            double valor1 = Double.parseDouble(gini1);
            double valor2 = Double.parseDouble(gini2);



            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.addValue(valor1, pais1, "País");
            dataset.addValue(valor2, pais2, "País");

            JFreeChart chart = ChartFactory.createBarChart3D(
                    "Gráfico de Barras Gini",
                    "Paises",
                    "Indice de Desigualdad Gini",
                    dataset
            );
            ChartPanel chartPanel = new ChartPanel(chart);
            PanelGrafica.removeAll();
            PanelGrafica.setLayout( new BorderLayout());
            PanelGrafica.add( chartPanel, BorderLayout.CENTER);
            PanelGrafica.revalidate();
            PanelGrafica.repaint();

        }
    });
}
public JPanel getPanelGrafica1(){ return this.PanelGrafica1;}
}
