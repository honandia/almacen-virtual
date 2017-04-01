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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
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
public class VentanaArticulosEntrada extends javax.swing.JFrame implements ActionListener{
	private JLabel labelArticuloE;
	private JComboBox comboBalda;
	private JPanel panelAddArtE;
	private JLabel labelBaldaArtE;
	private JLabel labelArmarioArtE;
	private JLabel labelPasilloArtE;
	private JComboBox comboArmario;
	private JComboBox comboPasillo;
	private JButton botonVolverAnyadirArtE;
	private JSpinner spinnerCantidadArticulosE;
	private JButton botonCrearArticulo;
	private JButton botonCrearCategoria;
	private JButton botonAnyadirArticuloEntrada;
	private JLabel labelCantArtE;
	private JLabel labelCategoriaArtE;
	public JComboBox comboArticuloE;
	public JComboBox comboCategoriaArtE;
	

	public VentanaArticulosEntrada() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(472, 316);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/t_downloading.gif")).getImage());
			this.setTitle("Añadir artículos a esta entrada");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			{
				botonVolverAnyadirArtE = new JButton();
				this.getContentPane().add(botonVolverAnyadirArtE);
				botonVolverAnyadirArtE.setText("Volver");
				botonVolverAnyadirArtE.setBounds(194, 249, 80, 28);
				botonVolverAnyadirArtE.addActionListener(this);
			}
			{
				panelAddArtE = new JPanel();
				this.getContentPane().add(panelAddArtE);
				panelAddArtE.setBounds(1, 1, 462, 239);
				panelAddArtE.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Añadir artículos", TitledBorder.LEADING, TitledBorder.TOP));
				panelAddArtE.setBackground(new java.awt.Color(204,230,230));
				panelAddArtE.setLayout(null);
				{
					labelBaldaArtE = new JLabel();
					panelAddArtE.add(labelBaldaArtE);
					labelBaldaArtE.setText("Balda");
					labelBaldaArtE.setBounds(274, 172, 60, 18);
				}
				{
					labelArmarioArtE = new JLabel();
					panelAddArtE.add(labelArmarioArtE);
					labelArmarioArtE.setText("Armario");
					labelArmarioArtE.setBounds(188, 172, 60, 18);
				}
				{
					labelPasilloArtE = new JLabel();
					panelAddArtE.add(labelPasilloArtE);
					labelPasilloArtE.setText("Pasillo");
					labelPasilloArtE.setBounds(103, 172, 53, 18);
				}
				{
					ComboBoxModel comboPasilloModel = new DefaultComboBoxModel(
						GestionBD.obtenerPasillos());
					comboPasillo = new JComboBox();
					panelAddArtE.add(comboPasillo);
					comboPasillo.setModel(comboPasilloModel);
					comboPasillo.setBounds(102, 194, 60, 20);
					comboPasillo.setToolTipText("Elija un pasillo");
					comboPasillo.addActionListener(this);
				}
				{
					ComboBoxModel comboArmarioModel = new DefaultComboBoxModel(
						GestionBD.obtenerArmariosPasillo((String) comboPasillo
							.getSelectedItem()));
					comboArmario = new JComboBox();
					panelAddArtE.add(comboArmario);
					comboArmario.setModel(comboArmarioModel);
					comboArmario.setBounds(187, 194, 60, 20);
					comboArmario.setToolTipText("Elija un armario");
					comboArmario.addActionListener(this);
				}
				{
					ComboBoxModel comboBaldaModel = new DefaultComboBoxModel(
						GestionBD.obtenerBaldasPasilloArmario(
							(String) comboPasillo.getSelectedItem(),
							(String) comboArmario.getSelectedItem()));
					comboBalda = new JComboBox();
					panelAddArtE.add(comboBalda);
					comboBalda.setModel(comboBaldaModel);
					comboBalda.setBounds(272, 194, 60, 20);
					comboBalda.setToolTipText("Elija una balda");
				}
				
				{
					SpinnerNumberModel spinnerCantidadArticulosEModel = new SpinnerNumberModel(
						1,
						1,
						9999,
						1);
					this.setResizable(false);
					spinnerCantidadArticulosE = new JSpinner();
					panelAddArtE.add(spinnerCantidadArticulosE);
					spinnerCantidadArticulosE
						.setModel(spinnerCantidadArticulosEModel);
					spinnerCantidadArticulosE.setBounds(17, 194, 60, 20);
					spinnerCantidadArticulosE.setToolTipText("Seleccione la catidad de artículos");
				}
				{
					labelCantArtE = new JLabel();
					panelAddArtE.add(labelCantArtE);
					labelCantArtE.setText("Cantidad");
					labelCantArtE.setBounds(17, 172, 57, 18);
				}
				{
					labelArticuloE = new JLabel();
					panelAddArtE.add(labelArticuloE);
					labelArticuloE.setText("Artículo");
					labelArticuloE.setBounds(22, 90, 60, 16);
				}
				{
					labelCategoriaArtE = new JLabel();
					panelAddArtE.add(labelCategoriaArtE);
					labelCategoriaArtE.setText("Categoría");
					labelCategoriaArtE.setBounds(22, 27, 60, 17);
				}
				
				{

					ComboBoxModel comboCategoriaArtEModel = new DefaultComboBoxModel(
						GestionBD.obtenerCategorias());
					comboCategoriaArtE = new JComboBox();
					panelAddArtE.add(comboCategoriaArtE);
					comboCategoriaArtE.setModel(comboCategoriaArtEModel);
					comboCategoriaArtE.setBounds(19, 55, 305, 22);
					comboCategoriaArtE.setToolTipText("Seleccione la categoría del artículo que desee añadir a la entrada");
					comboCategoriaArtE.addActionListener(this);

				}
				{
					ComboBoxModel comboArticuloEModel = new DefaultComboBoxModel(
						GestionBD
							.obtenerArticulosCategoria((String) comboCategoriaArtE
								.getSelectedItem()));

					comboArticuloE = new JComboBox();
					panelAddArtE.add(comboArticuloE);
					comboArticuloE.setModel(comboArticuloEModel);
					comboArticuloE.setBounds(19, 117, 305, 22);
					comboArticuloE.setToolTipText("Seleccione el artículo que desee añadir a la entrada");
					comboArticuloE.addActionListener(this);

				}
				{
					botonAnyadirArticuloEntrada = new JButton();
					botonAnyadirArticuloEntrada.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
								"Ventanas/t_downloading.gif")));
					panelAddArtE.add(botonAnyadirArticuloEntrada);	
					botonAnyadirArticuloEntrada.setText("Añadir");
					botonAnyadirArticuloEntrada.setBounds(346, 186, 105, 30);
					botonAnyadirArticuloEntrada.setToolTipText("Pulsando aqui los artículos serán añadidos a la entrada");
					botonAnyadirArticuloEntrada.addActionListener(this);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JSpinner getSpinnerCantidadArticulosE() {
		return spinnerCantidadArticulosE;
	}
	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();
		if (o==comboCategoriaArtE){
			//comboCategoriaArtE.setModel(new DefaultComboBoxModel(
			//		GestionBD.obtenerCategorias()));
			comboArticuloE.setModel(new DefaultComboBoxModel(
					GestionBD.obtenerArticulosCategoria((String)comboCategoriaArtE.getSelectedItem())));
			comboArticuloE.updateUI();
		}
		//else if(o==comboArticuloE){
		//	comboArticuloE.setModel(new DefaultComboBoxModel(
		//			GestionBD.obtenerArticulos()));
		//}
		else if(o==comboPasillo){
			comboArmario.setModel(new DefaultComboBoxModel(
					GestionBD.obtenerArmariosPasillo((String)comboPasillo.getSelectedItem())));
			comboArmario.updateUI();
			comboBalda.setModel(new DefaultComboBoxModel(
					GestionBD.obtenerBaldasPasilloArmario((String)comboPasillo.getSelectedItem()
							,(String)comboArmario.getSelectedItem())));
			comboBalda.updateUI();
			
		}
		else if(o==comboArmario){
			comboBalda.setModel(new DefaultComboBoxModel(
					GestionBD.obtenerBaldasPasilloArmario((String)comboPasillo.getSelectedItem()
							,(String)comboArmario.getSelectedItem())));
			comboBalda.updateUI();
		}
		else if(o==botonCrearCategoria){
			VentanaCrearNuevaCategoria vCNC = new VentanaCrearNuevaCategoria();
			vCNC.setVisible(true);
			vCNC.setAlwaysOnTop(true);
			this.setAlwaysOnTop(false);
			
		}
		else if (o==botonCrearArticulo){
			VentanaCrearArticulo vCA= new VentanaCrearArticulo();
			vCA.setVisible(true);
			vCA.setAlwaysOnTop(true);
			this.setAlwaysOnTop(false);
		}
		else if (o==botonVolverAnyadirArtE){
			this.setVisible(false);
		}
		else if(o==botonAnyadirArticuloEntrada){
			
			GestionBD.insertarLineaEntrada(Integer.parseInt((String)panelEntradaSalida.vFila.get(0)),
					GestionBD.obtenerCodigoArticulo((String)comboArticuloE.getSelectedItem()),
					((Integer)spinnerCantidadArticulosE.getValue()).intValue(),
					GestionBD.obtenerCodigoLocalizacion((String)comboPasillo.getSelectedItem(),(String)comboArmario.getSelectedItem(),(String)comboBalda.getSelectedItem()),
					VentanaLogin.uLogin.getCodUsuario());
			JOptionPane.showMessageDialog(this,"Se han añadido "+((Integer)spinnerCantidadArticulosE.getValue()).intValue()+" "+(String)comboArticuloE.getSelectedItem()+" a la entrada");
			
		}
	}

}
