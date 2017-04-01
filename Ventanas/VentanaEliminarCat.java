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
public class VentanaEliminarCat extends javax.swing.JFrame implements ActionListener{
	private JComboBox comboCategoriaEliminar;
	private JPanel panelEliminarCat;
	private JButton botonVolverEliminarCat;
	private JButton botonEliminarCat;

	public VentanaEliminarCat() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(448, 169);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/eliminarcategoira.gif")).getImage());
			this.setTitle("Eliminar categoría");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			{
				botonVolverEliminarCat = new JButton();
				this.getContentPane().add(botonVolverEliminarCat);
				botonVolverEliminarCat.setText("Volver");
				botonVolverEliminarCat.setBounds(176, 99, 89, 30);
				botonVolverEliminarCat.addActionListener(this);
			}
			{
				panelEliminarCat = new JPanel();
				this.getContentPane().add(panelEliminarCat);
				panelEliminarCat.setBounds(2, 3, 436, 81);
				panelEliminarCat.setBackground(new java.awt.Color(204,230,230));
				panelEliminarCat.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Seleccione la categoría que quiera eliminar", TitledBorder.LEADING, TitledBorder.TOP));
				panelEliminarCat.setLayout(null);
				{
					ComboBoxModel comboCategoriaEliminarModel = new DefaultComboBoxModel(
						GestionBD.obtenerCategorias());
					comboCategoriaEliminar = new JComboBox();
					panelEliminarCat.add(comboCategoriaEliminar);
					comboCategoriaEliminar
						.setModel(comboCategoriaEliminarModel);
					comboCategoriaEliminar.setBounds(19, 35, 234, 24);
				}
				{
					botonEliminarCat = new JButton();
					panelEliminarCat.add(botonEliminarCat);
					botonEliminarCat.setText("Eliminar categoría");
					botonEliminarCat.setIcon(new ImageIcon(getClass()
						.getClassLoader().getResource(
							"Ventanas/eliminarcategoira.gif")));
					botonEliminarCat.setBounds(267, 32, 157, 30);
					botonEliminarCat.addActionListener(this);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();
		if(o==botonEliminarCat){
			if (((String)comboCategoriaEliminar.getSelectedItem()).equals("Todos")){
				JOptionPane.showMessageDialog(this,"La categoría Todos no puede ser eliminada ya que es la categoría por defecto","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				int opcion =JOptionPane.showConfirmDialog(this,"¿Esta seguro de que quiere eliminar la categoría "+comboCategoriaEliminar.getSelectedItem()+"  ?","Cofirmación",JOptionPane.YES_NO_OPTION);
				if(opcion==0){
					GestionBD.actualizarCategoriasPadre(GestionBD.obtenerCodigoCategoria(((String)comboCategoriaEliminar.getSelectedItem())));
					GestionBD.actualizarCategoriaArticulos(GestionBD.obtenerCodigoCategoria(((String)comboCategoriaEliminar.getSelectedItem())));
					GestionBD.eliminarCategoria(GestionBD.obtenerCodigoCategoria(((String)comboCategoriaEliminar.getSelectedItem())));
					JOptionPane.showMessageDialog(this,"La categoría "+comboCategoriaEliminar.getSelectedItem()+"  ha sido eliminada");
					comboCategoriaEliminar.setModel(new DefaultComboBoxModel(
							GestionBD.obtenerCategorias()));
					
				
				}
				}
		}
		else if(o==botonVolverEliminarCat){
			this.setAlwaysOnTop(false);
			this.setVisible(false);
		}
	}
}
