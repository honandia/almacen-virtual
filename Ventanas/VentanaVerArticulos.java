package Ventanas;
import java.awt.Canvas;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import procesos.GestionBD;

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
public class VentanaVerArticulos extends javax.swing.JFrame implements ActionListener{
	private Canvas canvasFotoVerArticulos;
	private JTextField textoNombreVerArticulos;
	private JTable tablaVerArticulos;
	private JButton botonVolverVerArticulo;
	private JButton botonBuscarVerArticulo;
	private JScrollPane scrollVerArticulos;
	private JLabel labelFotoArticulo;
	private JLabel labelArticuloVerArticulo;
	private JLabel labelCategoriaVerArticulos;
	private JComboBox comboCategoriaVerArticulos;
	private Vector datos,cabecera;
	public VentanaVerArticulos() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(795, 390);
			this.setLayout(null);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/file.gif")).getImage());
			this.setTitle("Ver artículos");
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			{
				ComboBoxModel comboCategoriaVerArticulosModel = new DefaultComboBoxModel(
					GestionBD.obtenerCategorias());
				comboCategoriaVerArticulos = new JComboBox();
				this.getContentPane().add(comboCategoriaVerArticulos);
				comboCategoriaVerArticulos
					.setModel(comboCategoriaVerArticulosModel);
				comboCategoriaVerArticulos.setBounds(185, 46, 240, 22);
			}
			{
				labelCategoriaVerArticulos = new JLabel();
				this.getContentPane().add(labelCategoriaVerArticulos);
				labelCategoriaVerArticulos.setText("Categoría");
				labelCategoriaVerArticulos.setBounds(23, 50, 60, 18);
			}
			{
				labelArticuloVerArticulo = new JLabel();
				this.getContentPane().add(labelArticuloVerArticulo);
				labelArticuloVerArticulo.setText("Descripción artículo");
				labelArticuloVerArticulo.setBounds(21, 14, 147, 15);
			}
			{
				scrollVerArticulos = new JScrollPane();
				this.getContentPane().add(scrollVerArticulos);
				scrollVerArticulos.setBounds(7, 97, 772, 214);
				{
					GestionBD.actualizarTodosStockTotalArticulo();
					cargarVVerArticulos();
					tablaVerArticulos =new JTable(datos,cabecera){
							public boolean isCellEditable(
								int row,
								int column) {
								return false;
							}
						};
					scrollVerArticulos.setViewportView(tablaVerArticulos);
				}
			}
			{
				textoNombreVerArticulos = new JTextField();
				this.getContentPane().add(textoNombreVerArticulos);
				textoNombreVerArticulos.setBounds(185, 12, 240, 22);
			}
			{
				botonBuscarVerArticulo = new JButton();
				this.getContentPane().add(botonBuscarVerArticulo);
				botonBuscarVerArticulo.setText("Buscar");
				botonBuscarVerArticulo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_filesearch.gif")));
				botonBuscarVerArticulo.setBounds(440, 25, 122, 30);
				botonBuscarVerArticulo.addActionListener(this);
			}
			{
				botonVolverVerArticulo = new JButton();
				this.getContentPane().add(botonVolverVerArticulo);
				botonVolverVerArticulo.setText("Volver");
				botonVolverVerArticulo.setBounds(349, 321, 88, 30);
				botonVolverVerArticulo.addActionListener(this);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void cargarVVerArticulos() {
		cabecera= new Vector();
		cabecera.add("Código Articulo");
		cabecera.add("Descripción");
		cabecera.add("Categoría");
		cabecera.add("Stock");
		datos = new Vector();
		datos=GestionBD.obtenerArticulos();
	}
	public void actionPerformed(ActionEvent e){
		Object o= e.getSource();
		if(o==botonBuscarVerArticulo){
			GestionBD.actualizarTodosStockTotalArticulo();
			Vector aux=new Vector();
			aux= GestionBD.buscarArticulos(textoNombreVerArticulos.getText(),""+comboCategoriaVerArticulos.getSelectedItem());
			datos.clear();
			for(int t=0;t<aux.size();t++){
				datos.add(t,aux.get(t));
			}
			tablaVerArticulos.updateUI();
			if (aux.isEmpty()){
				JOptionPane.showMessageDialog(this,"No se encontraron coincidencias");
			}
		}
		else if(o==botonVolverVerArticulo){
			this.setVisible(false);
		}
	}
}
