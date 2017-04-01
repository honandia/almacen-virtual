package Ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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
public class VentanaCrearArticulo extends javax.swing.JFrame implements ActionListener{
	private JLabel labelCrearArticulo;
	private JPanel panelCrearArticulo;
	private JButton botonVolverCrearNuevoArticulo;
	private JButton botonCrearNuevoArticulo;
	private JComboBox comboCategoriaCrearAticulo;
	private JLabel labelSeleccionarCategoriaNA;
	private JTextField textoCrearArticulo;
	
	public VentanaCrearArticulo() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(472, 211);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/file.gif")).getImage());
			this.setTitle("Crear nuevo artículo");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			{
				botonVolverCrearNuevoArticulo = new JButton();
				this.getContentPane().add(botonVolverCrearNuevoArticulo);
				botonVolverCrearNuevoArticulo.setText("Volver");
				botonVolverCrearNuevoArticulo.setBounds(188, 144, 88, 30);
				botonVolverCrearNuevoArticulo.addActionListener(this);
			}
			{
				panelCrearArticulo = new JPanel();
				this.getContentPane().add(panelCrearArticulo);
				panelCrearArticulo.setBounds(3, 3, 456, 135);
				panelCrearArticulo.setLayout(null);
				panelCrearArticulo.setBackground(new java.awt.Color(204,230,230));
				panelCrearArticulo.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Crear artículo", TitledBorder.LEADING, TitledBorder.TOP));
				{
					ComboBoxModel comboCategoriaCrearAticuloModel = new DefaultComboBoxModel(
						GestionBD.obtenerCategorias());
					comboCategoriaCrearAticulo = new JComboBox();
					panelCrearArticulo.add(comboCategoriaCrearAticulo);
					comboCategoriaCrearAticulo
						.setModel(comboCategoriaCrearAticuloModel);
					comboCategoriaCrearAticulo.setBounds(29, 104, 268, 21);
				}
				{
					labelSeleccionarCategoriaNA = new JLabel();
					panelCrearArticulo.add(labelSeleccionarCategoriaNA);
					labelSeleccionarCategoriaNA
						.setText("Seleccione una categoría para el nuevo artículo");
					labelSeleccionarCategoriaNA.setBounds(17, 76, 278, 19);
				}
				{
					textoCrearArticulo = new JTextField();
					panelCrearArticulo.add(textoCrearArticulo);
					textoCrearArticulo.setBounds(29, 48, 268, 22);
				}
				{
					labelCrearArticulo = new JLabel();
					panelCrearArticulo.add(labelCrearArticulo);
					labelCrearArticulo
						.setText("Introduzca el nombre del nuevo artículo");
					labelCrearArticulo.setBounds(17, 21, 278, 19);
				}
				{
					botonCrearNuevoArticulo = new JButton();
					panelCrearArticulo.add(botonCrearNuevoArticulo);
					botonCrearNuevoArticulo.setIcon(new ImageIcon(getClass()
						.getClassLoader().getResource("Ventanas/file.gif")));
					botonCrearNuevoArticulo.setText("Crear artículo");
					botonCrearNuevoArticulo.setBounds(310, 94, 136, 30);
					botonCrearNuevoArticulo.addActionListener(this);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();
		if (o==botonCrearNuevoArticulo){
			if(textoCrearArticulo.getText().equals("")){
				JOptionPane.showMessageDialog(this,"No se puede crear un nuevo artículo sin nombre","Error",2);
			}
			else{
			GestionBD.insertarArticulo(textoCrearArticulo.getText()
			,GestionBD.obtenerCodigoCategoria((String)comboCategoriaCrearAticulo.getSelectedItem()));
			//VentanaArticulosEntrada.comboArticuloE.addItem(textoCrearArticulo.getText());
			JOptionPane.showMessageDialog(this,"Se ha creado el nuevo artículo "+textoCrearArticulo.getText());
			}
		}
		else if (o==botonVolverCrearNuevoArticulo){
			this.setVisible(false);
		}
	}

}
