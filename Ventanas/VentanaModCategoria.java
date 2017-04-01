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
public class VentanaModCategoria extends javax.swing.JFrame implements ActionListener{
	private JComboBox comboModCat;
	private JLabel labelModCat;
	private JComboBox comboNuevoPadreModCat;
	private JButton botonVolverModCat;
	private JPanel panelModCat;
	private JButton botonModCat;
	private JLabel labelNuevaCatPadre;
	private JLabel labelNuevoNombreModCat;
	private JTextField textoNuevoNombreModCat;

	public VentanaModCategoria() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(643, 268);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/m_category.gif")).getImage());
			this.setTitle("Modificar categoría");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			{
				botonVolverModCat = new JButton();
				this.getContentPane().add(botonVolverModCat);
				botonVolverModCat.setText("Volver");
				botonVolverModCat.setBounds(268, 199, 99, 30);
				botonVolverModCat.addActionListener(this);
			}
			{
				panelModCat = new JPanel();
				this.getContentPane().add(panelModCat);
				panelModCat.setBounds(2, 1, 631, 186);
				panelModCat.setBackground(new java.awt.Color(204,230,230));
				panelModCat.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Opciones de modificación", TitledBorder.LEADING, TitledBorder.TOP));
				panelModCat.setLayout(null);
				{
					botonModCat = new JButton();
					panelModCat.add(botonModCat);
					botonModCat.setText("Modificar");
					botonModCat.setIcon(new ImageIcon(getClass()
						.getClassLoader()
						.getResource("Ventanas/m_category.GIF")));
					botonModCat.setBounds(497, 127, 110, 30);
					botonModCat.addActionListener(this);
				}
				{
					ComboBoxModel comboNuevoPadreModCatModel = new DefaultComboBoxModel(
						GestionBD.obtenerCategorias());
					comboNuevoPadreModCat = new JComboBox();
					panelModCat.add(comboNuevoPadreModCat);
					comboNuevoPadreModCat.setModel(comboNuevoPadreModCatModel);
					comboNuevoPadreModCat.setBounds(252, 133, 222, 23);
					comboNuevoPadreModCat.setEnabled(false);
				}
				{
					labelNuevaCatPadre = new JLabel();
					panelModCat.add(labelNuevaCatPadre);
					labelNuevaCatPadre.setText("Modifique la categoría padre");
					labelNuevaCatPadre.setBounds(18, 132, 203, 21);
				}
				{
					labelNuevoNombreModCat = new JLabel();
					panelModCat.add(labelNuevoNombreModCat);
					labelNuevoNombreModCat
						.setText("Modifique el nombre de la categoría");
					labelNuevoNombreModCat.setBounds(18, 86, 211, 23);
				}
				{
					textoNuevoNombreModCat = new JTextField();
					panelModCat.add(textoNuevoNombreModCat);
					textoNuevoNombreModCat.setBounds(251, 90, 224, 20);
					textoNuevoNombreModCat.setEnabled(false);
				}
				{
					labelModCat = new JLabel();
					panelModCat.add(labelModCat);
					labelModCat.setText("Seleccione una categoría");
					labelModCat.setBounds(16, 39, 193, 30);
				}
				{
					ComboBoxModel comboModCatModel = new DefaultComboBoxModel(
						GestionBD.obtenerCategorias());
					comboModCat = new JComboBox();
					panelModCat.add(comboModCat);
					comboModCat.setModel(comboModCatModel);
					comboModCat.setBounds(252, 44, 222, 21);
					comboModCat.addActionListener(this);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();
		if(o==comboModCat){
			textoNuevoNombreModCat.setText((String)comboModCat.getSelectedItem());
			textoNuevoNombreModCat.setEnabled(true);
			String nombrePadre = GestionBD.obtenerNombreCategoriaPadre(GestionBD.obtenerCodigoCategoria((String)comboModCat.getSelectedItem()));
			comboNuevoPadreModCat.setSelectedItem(nombrePadre);
			comboNuevoPadreModCat.setEnabled(true);
		}
		else if(o==botonModCat){
			if(textoNuevoNombreModCat.getText().equals("Todos")){
				JOptionPane.showMessageDialog(this,"La categoría Todos no puede ser modificada, ya que es la categoría por defecto","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				if(textoNuevoNombreModCat.isEnabled()&&!textoNuevoNombreModCat.getText().equals("")){
					int codCat= GestionBD.obtenerCodigoCategoria((String)comboModCat.getSelectedItem());
					int codPadre = GestionBD.obtenerCodigoCategoria((String)comboNuevoPadreModCat.getSelectedItem());
					GestionBD.modificarCategoria(codCat,textoNuevoNombreModCat.getText(),codPadre);
					JOptionPane.showMessageDialog(this,"La categoría  "+comboModCat.getSelectedItem()+"  ha sido modificada");
					comboModCat.setModel(new DefaultComboBoxModel(
							GestionBD.obtenerCategorias()));
					textoNuevoNombreModCat.setText("");
					textoNuevoNombreModCat.setEnabled(false);
					comboNuevoPadreModCat.setSelectedItem("Todos");
					comboNuevoPadreModCat.setEnabled(false);
				}
				else{
					JOptionPane.showMessageDialog(this,"No hay niguna categoría seleccionada","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
				
		}
		else if(o==botonVolverModCat){
			this.setAlwaysOnTop(false);
			this.setVisible(false);
		}
	}

}
