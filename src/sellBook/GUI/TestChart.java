package sellBook.GUI;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class TestChart extends JFrame {

    private JPanel main;

    public TestChart(String title) {
        super(title);

        // Create dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(120, "Books", "2019");
        dataset.setValue(160, "Books", "2020");
        dataset.setValue(200, "Books", "2021");

        // Create chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Books Sold", // Chart title
                "Year", // X-Axis Label
                "Number of Books", // Y-Axis Label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot orientation
                false, // Show legend
                true, // Use tooltips
                false // Generate URLs
        );

        // Create panel
        ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);
    }



}
