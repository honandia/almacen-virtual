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
import javax.swing.SwingConstants;

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
public class VentanaCrearNuevaCategoria extends javax.swing.JFrame implements ActionListener{
	private JTextField textoCrearNuevaCategoria;
	private JLabel labelCreaNuevaCategoria;
	private JButton botonCrearNuevaCategoria;
	private JPanel panelCrearCategoria;
	private JButton botonVolverCrearCategoria;
	private JLabel labelCategoriaPadre;
	private JComboBox comboCategoriaPadre;
	
	public VentanaCrearNuevaCategoria() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(461, 234);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_category.gif")).getImage());
			this.setTitle("Crear nueva categoría");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			{
				botonVolverCrearCategoria = new JButton();
				this.getContentPane().add(botonVolverCrearCategoria);
				botonVolverCrearCategoria.setText("Volver");
				botonVolverCrearCategoria.setBounds(180, 164, 93, 30);
				botonVolverCrearCategoria.addActionListener(this);
			}
			{
				panelCrearCategoria = new JPanel();
				this.getContentPane().add(panelCrearCategoria);
				panelCrearCategoria.setBounds(1, 1, 449, 152);
				//panelCrearCategoria.setLayout(panelCrearCategoriaLayout);
				panelCrearCategoria.setBackground(new java.awt.Color(204,230,230));
				panelCrearCategoria.setLayout(null);
				panelCrearCategoria.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Crear categoría", TitledBorder.LEADING, TitledBorder.TOP));
				{
					ComboBoxModel comboCategoriaPadreModel = new DefaultComboBoxModel(
						GestionBD.obtenerCategorias());
					comboCategoriaPadre = new JComboBox();
					panelCrearCategoria.add(comboCategoriaPadre);
					comboCategoriaPadre.setModel(comboCategoriaPadreModel);
					comboCategoriaPadre.setBounds(22, 109, 286, 20);
				}
				{
					labelCategoriaPadre = new JLabel();
					panelCrearCategoria.add(labelCategoriaPadre);
					labelCategoriaPadre
						.setText("Seleccione la categoría padre de la nueva categoría");
					labelCategoriaPadre.setBounds(17, 80, 293, 16);
					labelCategoriaPadre.setHorizontalAlignment(SwingConstants.LEFT);
				}
				{
					textoCrearNuevaCategoria = new JTextField();
					panelCrearCategoria.add(textoCrearNuevaCategoria);
					textoCrearNuevaCategoria.setBounds(21, 43, 288, 20);
				}
				{
					labelCreaNuevaCategoria = new JLabel();
					panelCrearCategoria.add(labelCreaNuevaCategoria);
					labelCreaNuevaCategoria
						.setText("Introduzca el nombre de la nueva categoría");
					labelCreaNuevaCategoria.setBounds(18, 21, 244, 16);
					labelCreaNuevaCategoria
						.setHorizontalTextPosition(SwingConstants.CENTER);
					labelCreaNuevaCategoria.setHorizontalAlignment(SwingConstants.LEFT);
				}
				{
					botonCrearNuevaCategoria = new JButton();
					panelCrearCategoria.add(botonCrearNuevaCategoria);
					botonCrearNuevaCategoria.setIcon(new ImageIcon(getClass()
						.getClassLoader()
						.getResource("Ventanas/l_category.gif")));
					botonCrearNuevaCategoria.setText("Crear");
					botonCrearNuevaCategoria.setBounds(339, 99, 97, 30);
					botonCrearNuevaCategoria.addActionListener(this);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		Object o= e.getSource();
		if (o==botonCrearNuevaCategoria){
			if (textoCrearNuevaCategoria.getText().equals("")){
				JOptionPane.showMessageDialog(this,"No se puede crear una nueva categoría sin nombre","Error",2);
			}
			else{
			//comboCategoriaArtE.addItem(textoCrearNuevaCategoria.getText());
			GestionBD.insertarCategoria
			(textoCrearNuevaCategoria.getText(),GestionBD.obtenerCodigoCategoria((String)comboCategoriaPadre.getSelectedItem()));
			JOptionPane.showMessageDialog(this,"Se ha creado la nueva categoría "+textoCrearNuevaCategoria.getText());
			}	
		}
		if(o==botonVolverCrearCategoria){
			this.setVisible(false);
			
		}
		
	}

}
