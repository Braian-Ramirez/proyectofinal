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


    public grafica() {
    buttonGenerarGrafica.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ConsultaApiPaisesDTO consultaApiPaisesDTO = new ConsultaApiPaisesDTO();
            double valor1 = consultaApiPaisesDTO.getGini();
            double valor2 = consultaApiPaisesDTO.getGini2();

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.addValue(valor1, consultaApiPaisesDTO.getName(), "País");
            dataset.addValue(valor2, consultaApiPaisesDTO.getName2(), "País");

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
