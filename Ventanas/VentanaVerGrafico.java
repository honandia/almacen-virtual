package Ventanas;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;

import org.jfree.data.*;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Series;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.xml.CategorySeriesHandler;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.*;
import org.jfree.chart.labels.CategorySeriesLabelGenerator;
import org.jfree.chart.plot.*;

import procesos.GestionBD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.sql.Connection;
import java.util.Vector;

import javax.swing.JButton;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public class VentanaVerGrafico extends javax.swing.JFrame implements ActionListener{
	private Image grafica;
	private JButton botonVolverVerGrafica;
	public VentanaVerGrafico() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setLayout(null);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/is_a4af.gif")).getImage());
			this.setTitle("Gráfica");
			this.setSize(705, 580);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			this.setLocationRelativeTo(null);
			this.setResizable(false);

			{	
				CategoryDataset dataset = createCategoryDataset(((Vector)VentanaVerEstadisticas.datosEstadistica));
		        JFreeChart chart = ChartFactory.createBarChart3D
		        ("Rendimiento de los operarios",
		        "Operarios","",dataset,PlotOrientation.HORIZONTAL,
		        true,
		        true,
		        false
		        );
				chart.setBackgroundPaint(new Color(204,230,230));
		        grafica = chart.createBufferedImage(700, 500);
		        paint(grafica.getGraphics()); 
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public void paint (Graphics g){
		super.paint(g);
		g.translate(getInsets().left,getInsets().top);
		g.drawImage(grafica,0,0,this);	
	}
	private CategoryDataset createCategoryDataset(Vector items){
		int size = items.size();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		{
			botonVolverVerGrafica = new JButton();
			this.getContentPane().add(botonVolverVerGrafica);
			botonVolverVerGrafica.setText("Volver");
			botonVolverVerGrafica.setBounds(300, 512, 97, 30);
			botonVolverVerGrafica.addActionListener(this);
		}
		for(int i=0;i<size;i++){
			Vector item = (Vector)items.get(i);
			String series1 = "Nº entradas+salidas";
			String series2 = "Nº articulos E+S";
			String series3 = "Tiempo Trabajado(Minutos)";
			int rowcount = item.size();
			for(int cuenta=0;cuenta<rowcount;cuenta++){
				dataset.addValue(Integer.parseInt(""+item.get(1)), series1,""+item.get(0));
				dataset.addValue(Integer.parseInt(""+item.get(2)), series2,""+item.get(0));
				dataset.addValue(Integer.parseInt(""+item.get(3)), series3,""+item.get(0));
			}
		}
		return dataset;
	}
	public void actionPerformed(ActionEvent e){
		Object o= e.getSource();
		if(o==botonVolverVerGrafica){
			this.setAlwaysOnTop(false);
			this.setVisible(false);
		}
	}

}
