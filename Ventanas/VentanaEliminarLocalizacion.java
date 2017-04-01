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
public class VentanaEliminarLocalizacion extends javax.swing.JFrame implements ActionListener{
	private JPanel panelEliminarLoc;
	private JButton botonVolverEliminarLoc;
	private JButton botonEliminarLoc;
	private JLabel labelBalda;
	private JLabel labelArmario;
	private JLabel labelPasillo;
	private JComboBox comboPasilloILoc;
	private JComboBox comboArmarioILoc;
	private JComboBox comboBaldaILoc;

	public VentanaEliminarLocalizacion() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(400, 223);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/eliminarlocalizacion.gif")).getImage());
			this.setTitle("Eliminar localización");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			{
				panelEliminarLoc = new JPanel();
				this.getContentPane().add(panelEliminarLoc);
				panelEliminarLoc.setBounds(12, 14, 373, 128);
				panelEliminarLoc.setBackground(new java.awt.Color(204,230,230));
				panelEliminarLoc.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Seleccione una localización", TitledBorder.LEADING, TitledBorder.TOP));
				panelEliminarLoc.setLayout(null);
				{
					ComboBoxModel comboPasilloILocModel = new DefaultComboBoxModel(
							GestionBD.obtenerPasillos());
					comboPasilloILoc = new JComboBox();
					panelEliminarLoc.add(comboPasilloILoc);
					comboPasilloILoc.setModel(comboPasilloILocModel);
					comboPasilloILoc.setBounds(109, 25, 48, 20);
					comboPasilloILoc.addActionListener(this);
				}
				{
					ComboBoxModel comboArmarioILocModel = new DefaultComboBoxModel(
							GestionBD.obtenerArmariosPasillo(""+comboPasilloILoc.getSelectedItem()));
						comboArmarioILoc = new JComboBox();
					panelEliminarLoc.add(comboArmarioILoc);
					comboArmarioILoc.setModel(comboArmarioILocModel);
					comboArmarioILoc.setBounds(109, 57, 48, 20);
					comboArmarioILoc.addActionListener(this);
				}
				
				{
					ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(
							GestionBD.obtenerBaldasPasilloArmario(""+comboPasilloILoc.getSelectedItem(),""+comboArmarioILoc.getSelectedItem()));
					comboBaldaILoc = new JComboBox();
					panelEliminarLoc.add(comboBaldaILoc);
					comboBaldaILoc.setModel(jComboBox1Model);
					comboBaldaILoc.setBounds(109, 90, 48, 20);
					comboBaldaILoc.addActionListener(this);
				}
				
				{
					labelPasillo = new JLabel();
					panelEliminarLoc.add(labelPasillo);
					labelPasillo.setText("Pasillo:");
					labelPasillo.setBounds(34, 24, 69, 20);
				}
				{
					labelArmario = new JLabel();
					panelEliminarLoc.add(labelArmario);
					labelArmario.setText("Armario:");
					labelArmario.setBounds(34, 57, 69, 20);
				}
				{
					labelBalda = new JLabel();
					panelEliminarLoc.add(labelBalda);
					labelBalda.setText("Balda:");
					labelBalda.setBounds(34, 90, 69, 20);
				}
				{
					botonEliminarLoc = new JButton();
					panelEliminarLoc.add(botonEliminarLoc);
					botonEliminarLoc.setText("Eliminar localización");
					botonEliminarLoc.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/eliminarlocalizacion.gif")));
					botonEliminarLoc.setBounds(182, 81, 175, 30);
					botonEliminarLoc.addActionListener(this);
				}
			}
			{
				botonVolverEliminarLoc = new JButton();
				this.getContentPane().add(botonVolverEliminarLoc);
				botonVolverEliminarLoc.setText("Volver");
				botonVolverEliminarLoc.setBounds(154, 152, 85, 30);
				botonVolverEliminarLoc.addActionListener(this);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();
		if(o==comboPasilloILoc){
			comboArmarioILoc.setModel(new DefaultComboBoxModel(
							GestionBD.obtenerArmariosPasillo(""+comboPasilloILoc.getSelectedItem())));
			comboBaldaILoc.setModel(new DefaultComboBoxModel(
					GestionBD.obtenerBaldasPasilloArmario(""+comboPasilloILoc.getSelectedItem(),""+comboArmarioILoc.getSelectedItem())));
		}
		else if(o==comboArmarioILoc){
			comboBaldaILoc.setModel(new DefaultComboBoxModel(
					GestionBD.obtenerBaldasPasilloArmario(""+comboPasilloILoc.getSelectedItem(),""+comboArmarioILoc.getSelectedItem())));
		}
		else if(o==botonEliminarLoc){
			int opcion =JOptionPane.showConfirmDialog(this,"¿Esta seguro de que quiere eliminar la localización:  "+comboPasilloILoc.getSelectedItem()+" "+comboArmarioILoc.getSelectedItem()+" "+comboBaldaILoc.getSelectedItem()+"  ?","Cofirmación",JOptionPane.YES_NO_OPTION);
			if(opcion==0){
				GestionBD.eliminarLocalizacion(""+comboPasilloILoc.getSelectedItem(), ""+comboArmarioILoc.getSelectedItem(),""+comboBaldaILoc.getSelectedItem());
				JOptionPane.showMessageDialog(this,"La localización  "+comboPasilloILoc.getSelectedItem()+" "+comboArmarioILoc.getSelectedItem()+" "+comboBaldaILoc.getSelectedItem()+"  ha sido eliminada");
			
				comboPasilloILoc.setModel(new DefaultComboBoxModel(
						GestionBD.obtenerPasillos()));
				comboArmarioILoc.setModel(new DefaultComboBoxModel(
						GestionBD.obtenerArmariosPasillo(""+comboPasilloILoc.getSelectedItem())));
				comboBaldaILoc.setModel(new DefaultComboBoxModel(
						GestionBD.obtenerBaldasPasilloArmario(""+comboPasilloILoc.getSelectedItem(),""+comboArmarioILoc.getSelectedItem())));
			}
		}
		else if (o==botonVolverEliminarLoc){
			this.setAlwaysOnTop(false);
			this.setVisible(false);
		}
	}
}
