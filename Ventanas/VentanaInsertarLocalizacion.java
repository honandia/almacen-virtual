package Ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

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
public class VentanaInsertarLocalizacion extends javax.swing.JFrame implements ActionListener{
	private JPanel panelInsertarLoc;
	private JButton botonNuevoArmario;
	private JButton botonVolverInsertarLoc;
	private JButton botonInsertarLoc;
	private JButton botonNuevaBalda;
	private JLabel labelBalda;
	private JLabel labelArmario;
	private JLabel labelPasillo;
	private JTextField textoNuevaBalda;
	private JTextField textoNuevoArmario;
	private JTextField textoNuevoPasillo;
	private JButton botonNuevoPasillo;
	private JComboBox comboBaldaILoc;
	private JComboBox comboArmarioILoc;
	private JComboBox comboPasilloILoc;

	public VentanaInsertarLocalizacion() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(400, 267);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_static.gif")).getImage());
			this.setTitle("Insertar localización");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			{
				panelInsertarLoc = new JPanel();
				this.getContentPane().add(panelInsertarLoc);
				panelInsertarLoc.setBounds(3, 2, 387, 181);
				panelInsertarLoc.setBackground(new java.awt.Color(204,230,230));
				panelInsertarLoc.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Insertar localización", TitledBorder.LEADING, TitledBorder.TOP));
				panelInsertarLoc.setLayout(null);
				{
					ComboBoxModel comboPasilloILocModel = new DefaultComboBoxModel(
						GestionBD.obtenerPasillos());
					comboPasilloILoc = new JComboBox();
					panelInsertarLoc.add(comboPasilloILoc);
					comboPasilloILoc.setModel(comboPasilloILocModel);
					comboPasilloILoc.setBounds(113, 36, 48, 20);
					comboPasilloILoc.addActionListener(this);
				}
				{
					ComboBoxModel comboArmarioILocModel = new DefaultComboBoxModel(
						GestionBD.obtenerArmariosPasillo(""+comboPasilloILoc.getSelectedItem()));
					comboArmarioILoc = new JComboBox();
					panelInsertarLoc.add(comboArmarioILoc);
					comboArmarioILoc.setModel(comboArmarioILocModel);
					comboArmarioILoc.setBounds(113, 68, 48, 20);
					comboArmarioILoc.addActionListener(this);
					
				}
				{
					ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(
						GestionBD.obtenerBaldasPasilloArmario(""+comboPasilloILoc.getSelectedItem(),""+comboArmarioILoc.getSelectedItem()));
					comboBaldaILoc = new JComboBox();
					panelInsertarLoc.add(comboBaldaILoc);
					comboBaldaILoc.setModel(jComboBox1Model);
					comboBaldaILoc.setBounds(113, 101, 48, 20);
					comboBaldaILoc.addActionListener(this);
				}
				{
					botonNuevoPasillo = new JButton();
					panelInsertarLoc.add(botonNuevoPasillo);
					botonNuevoPasillo.setText("Nuevo pasillo");
					botonNuevoPasillo.setBounds(169, 36, 117, 18);
					botonNuevoPasillo.addActionListener(this);
				}
				{
					textoNuevoPasillo = new JTextField();
					panelInsertarLoc.add(textoNuevoPasillo);
					textoNuevoPasillo.setBounds(294, 36, 49, 23);
				}
				{
					botonNuevoArmario = new JButton();
					panelInsertarLoc.add(botonNuevoArmario);
					botonNuevoArmario.setText("Nuevo armario");
					botonNuevoArmario.setBounds(169, 69, 117, 18);
					botonNuevoArmario.addActionListener(this);
				}
				{
					botonNuevaBalda = new JButton();
					panelInsertarLoc.add(botonNuevaBalda);
					botonNuevaBalda.setText("Nueva balda");
					botonNuevaBalda.setBounds(169, 103, 117, 18);
					botonNuevaBalda.addActionListener(this);
				}
				{
					textoNuevoArmario = new JTextField();
					panelInsertarLoc.add(textoNuevoArmario);
					textoNuevoArmario.setBounds(294, 69, 49, 23);
				}
				{
					textoNuevaBalda = new JTextField();
					panelInsertarLoc.add(textoNuevaBalda);
					textoNuevaBalda.setBounds(294, 102, 49, 23);
				}
				{
					labelPasillo = new JLabel();
					panelInsertarLoc.add(labelPasillo);
					labelPasillo.setText("Pasillo:");
					labelPasillo.setBounds(38, 35, 69, 20);
				}
				{
					labelArmario = new JLabel();
					panelInsertarLoc.add(labelArmario);
					labelArmario.setText("Armario:");
					labelArmario.setBounds(38, 68, 69, 20);
				}
				{
					labelBalda = new JLabel();
					panelInsertarLoc.add(labelBalda);
					labelBalda.setText("Balda:");
					labelBalda.setBounds(38, 101, 69, 20);
				}
				{
					botonInsertarLoc = new JButton();
					panelInsertarLoc.add(botonInsertarLoc);
					botonInsertarLoc.setText("Insertar localización");
					botonInsertarLoc.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_static.gif")));
					botonInsertarLoc.setBounds(202, 139, 175, 30);
					botonInsertarLoc.addActionListener(this);
				}
				
			}
			{
				botonVolverInsertarLoc = new JButton();
				this.getContentPane().add(botonVolverInsertarLoc);
				botonVolverInsertarLoc.setText("Volver");
				botonVolverInsertarLoc.setBounds(156, 195, 80, 30);
				botonVolverInsertarLoc.addActionListener(this);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();
		if(o==botonNuevoPasillo){
			if(textoNuevoPasillo.getText().equals("")){
				JOptionPane.showMessageDialog(this,"No se puede agregar un nuevo pasillo sin nombre","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				String[] vPasillos= new String[comboPasilloILoc.getModel().getSize()+1];
				
				for(int i=0;i<comboPasilloILoc.getModel().getSize();i++){
					vPasillos[i]=(""+comboPasilloILoc.getModel().getElementAt(i));
				}
				vPasillos[comboPasilloILoc.getModel().getSize()]=textoNuevoPasillo.getText();
				comboPasilloILoc.setModel(new DefaultComboBoxModel(vPasillos));
				JOptionPane.showMessageDialog(this,"Pasillo añadido");
				textoNuevoPasillo.setText("");
			}
				
		}
		else if (o==botonVolverInsertarLoc){
			this.setAlwaysOnTop(false);
			this.setVisible(false);
		}
		else if(o==botonNuevoArmario){
			if(textoNuevoArmario.getText().equals("")){
				JOptionPane.showMessageDialog(this,"No se puede agregar un nuevo armario sin nombre","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				String[] vArmarios= new String[comboArmarioILoc.getModel().getSize()+1];
				
				for(int i=0;i<comboArmarioILoc.getModel().getSize();i++){
					vArmarios[i]=(""+comboArmarioILoc.getModel().getElementAt(i));
				}
				vArmarios[comboArmarioILoc.getModel().getSize()]=textoNuevoArmario.getText();
				comboArmarioILoc.setModel(new DefaultComboBoxModel(vArmarios));
				JOptionPane.showMessageDialog(this,"Armario añadido");
				textoNuevoArmario.setText("");
			}
				
		}
		else if(o==botonNuevaBalda){
			if(textoNuevaBalda.getText().equals("")){
				JOptionPane.showMessageDialog(this,"No se puede agregar una nueva balda sin nombre","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				String[] vBaldas= new String[comboBaldaILoc.getModel().getSize()+1];
				
				for(int i=0;i<comboBaldaILoc.getModel().getSize();i++){
					vBaldas[i]=(""+comboBaldaILoc.getModel().getElementAt(i));
				}
				vBaldas[comboBaldaILoc.getModel().getSize()]=textoNuevaBalda.getText();
				comboBaldaILoc.setModel(new DefaultComboBoxModel(vBaldas));
				JOptionPane.showMessageDialog(this,"Balda añadida");
				textoNuevaBalda.setText("");
			}
				
		}
		else if(o==comboPasilloILoc){
			comboArmarioILoc.setModel(new DefaultComboBoxModel(
							GestionBD.obtenerArmariosPasillo(""+comboPasilloILoc.getSelectedItem())));
			comboBaldaILoc.setModel(new DefaultComboBoxModel(
					GestionBD.obtenerBaldasPasilloArmario(""+comboPasilloILoc.getSelectedItem(),""+comboArmarioILoc.getSelectedItem())));
		}
		else if(o==comboArmarioILoc){
			comboBaldaILoc.setModel(new DefaultComboBoxModel(
					GestionBD.obtenerBaldasPasilloArmario(""+comboPasilloILoc.getSelectedItem(),""+comboArmarioILoc.getSelectedItem())));
		}
		else if(o==botonInsertarLoc){
			if(GestionBD.existeLocalizacion(""+comboPasilloILoc.getSelectedItem(), ""+comboArmarioILoc.getSelectedItem(),""+comboBaldaILoc.getSelectedItem())){
				JOptionPane.showMessageDialog(this,"Error la localización indicada ya existia en la base de datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				GestionBD.insertarLocalizacion(""+comboPasilloILoc.getSelectedItem(), ""+comboArmarioILoc.getSelectedItem(),""+comboBaldaILoc.getSelectedItem());
				JOptionPane.showMessageDialog(this,"La nueva localizacion  "+comboPasilloILoc.getSelectedItem()+" "+comboArmarioILoc.getSelectedItem()+" "+comboBaldaILoc.getSelectedItem()+"  ha sido creada");
			}
		}
		
		
	}

}
