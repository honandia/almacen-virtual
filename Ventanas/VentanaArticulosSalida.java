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
public class VentanaArticulosSalida extends javax.swing.JFrame implements ActionListener{
	public static JComboBox comboArticuloS;
	public static JComboBox comboCategoriaArtS;
	private JSpinner spinnerCantidadArticulosS;
	private JButton botonVolverVArtS;
	private JPanel panelAddArtS;
	private JLabel labelLocalizacionVArtS;
	private JComboBox comboLocalizacionesVArtS;
	private JLabel labelLocalizacionesVArtS;
	private JLabel labelCantidadVArtS;
	private JButton botonAnyadirVArtS;
	private JLabel labelArticuloVArtS;
	private JLabel labelCategoriaVArtS;

	public VentanaArticulosSalida() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(599, 253);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/t_downloading.gif")).getImage());
			this.setTitle("Añadir artículos a esta salida");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
				this.setResizable(false);			{
				botonVolverVArtS = new JButton();
				this.getContentPane().add(botonVolverVArtS);
				botonVolverVArtS.setText("Volver");
				botonVolverVArtS.setBounds(254, 185, 82, 30);
				botonVolverVArtS.addActionListener(this);
			}

			{
				panelAddArtS = new JPanel();
				this.getContentPane().add(panelAddArtS);
				panelAddArtS.setBounds(1, 3, 589, 174);
				panelAddArtS.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Añadir artículos", TitledBorder.LEADING, TitledBorder.TOP));
				panelAddArtS.setBackground(new java.awt.Color(204,230,230));
				panelAddArtS.setLayout(null);
				{
					labelArticuloVArtS = new JLabel();
					panelAddArtS.add(labelArticuloVArtS);
					labelArticuloVArtS
						.setText("Artículos disponibles en almacén");
					labelArticuloVArtS.setBounds(245, 25, 203, 16);
				}
				{
					labelCategoriaVArtS = new JLabel();
					panelAddArtS.add(labelCategoriaVArtS);
					labelCategoriaVArtS
						.setText("Categorías disponibles en almacén");
					labelCategoriaVArtS.setBounds(12, 25, 211, 16);
				}
				{

					ComboBoxModel comboCategoriaArtSModel = new DefaultComboBoxModel(
						GestionBD.obtenerCategoriasDisponibles());
					comboCategoriaArtS = new JComboBox();
					panelAddArtS.add(comboCategoriaArtS);
					comboCategoriaArtS.setModel(comboCategoriaArtSModel);
					comboCategoriaArtS.setBounds(13, 48, 210, 22);
					comboCategoriaArtS.addActionListener(this);

				}
				{
					GestionBD.actualizarTodosStockTotalArticulo();
					ComboBoxModel comboArticuloEModel = new DefaultComboBoxModel(
						GestionBD
							.obtenerArticulosConStock((String) comboCategoriaArtS
								.getSelectedItem()));

					comboArticuloS = new JComboBox();
					panelAddArtS.add(comboArticuloS);
					comboArticuloS.setModel(comboArticuloEModel);
					comboArticuloS.setBounds(243, 48, 212, 21);
					comboArticuloS.addActionListener(this);

				}
				{
					labelLocalizacionesVArtS = new JLabel();
					panelAddArtS.add(labelLocalizacionesVArtS);
					labelLocalizacionesVArtS.setText("Existen un total de "
						+ GestionBD
							.obtenerStockArticulo((String) comboArticuloS
								.getSelectedItem())
						+ " "
						+ (String) comboArticuloS.getSelectedItem()
						+ "  distribuidos en la siguientes localizaciones");
					labelLocalizacionesVArtS.setBounds(3, 78, 580, 22);
					labelLocalizacionesVArtS
						.setHorizontalTextPosition(SwingConstants.CENTER);
					labelLocalizacionesVArtS
						.setHorizontalAlignment(SwingConstants.CENTER);
				}
				{
					ComboBoxModel comboLocalizacionesVArtSModel = new DefaultComboBoxModel(
						GestionBD
							.obtenerLocalizacionesConArticulo((String) comboArticuloS
								.getSelectedItem()));
					comboLocalizacionesVArtS = new JComboBox();
					panelAddArtS.add(comboLocalizacionesVArtS);
					comboLocalizacionesVArtS
						.setModel(comboLocalizacionesVArtSModel);
					comboLocalizacionesVArtS.setBounds(14, 132, 207, 24);
					comboLocalizacionesVArtS.addActionListener(this);
				}	
					
					{
						labelLocalizacionVArtS = new JLabel();
						panelAddArtS.add(labelLocalizacionVArtS);
						labelLocalizacionVArtS.setText("Código localización");
						labelLocalizacionVArtS.setBounds(18, 109, 118, 18);
					}
					{
						labelCantidadVArtS = new JLabel();
						panelAddArtS.add(labelCantidadVArtS);
						labelCantidadVArtS.setText("Cantidad");
						labelCantidadVArtS.setBounds(320, 114, 60, 16);
					}
					{
						SpinnerNumberModel spinnerCantidadArticulosEModel = new SpinnerNumberModel(
							GestionBD.sumarStocksActualesLocalizacion(GestionBD
								.obtenerCodigoArticulo((String) comboArticuloS
									.getSelectedItem()), Integer
								.parseInt((String) comboLocalizacionesVArtS
									.getSelectedItem())),
							0,
							GestionBD.sumarStocksActualesLocalizacion(GestionBD
								.obtenerCodigoArticulo((String) comboArticuloS
									.getSelectedItem()), Integer
								.parseInt((String) comboLocalizacionesVArtS
									.getSelectedItem())),
							1);
						//System.out.println(GestionBD.sumarStocksActualesLocalizacion(GestionBD.obtenerCodigoArticulo((String)comboArticuloS.getSelectedItem()),Integer.parseInt((String)comboLocalizacionesVArtS.getSelectedItem())));
						spinnerCantidadArticulosS = new JSpinner();
						panelAddArtS.add(spinnerCantidadArticulosS);
						spinnerCantidadArticulosS
							.setModel(spinnerCantidadArticulosEModel);
						spinnerCantidadArticulosS.setBounds(319, 134, 60, 19);
					}
					
					{
						botonAnyadirVArtS = new JButton();
						panelAddArtS.add(botonAnyadirVArtS);
						botonAnyadirVArtS.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
								"Ventanas/t_downloading.gif")));

						botonAnyadirVArtS.setText("Añadir");
						botonAnyadirVArtS.setBounds(461, 129, 95, 30);
						botonAnyadirVArtS.addActionListener(this);
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public JSpinner getSpinnerCantidadArticulosS() {
		return spinnerCantidadArticulosS;
	}
	public void actionPerformed(ActionEvent e){
		Object o= e.getSource();
		if(o==comboCategoriaArtS){
			GestionBD.actualizarTodosStockTotalArticulo();
			comboArticuloS.setModel(new DefaultComboBoxModel(
					GestionBD.obtenerArticulosConStock((String)comboCategoriaArtS.getSelectedItem())));
			comboArticuloS.updateUI();
			int cantidad=GestionBD.obtenerStockArticulo((String)comboArticuloS.getSelectedItem());
			labelLocalizacionesVArtS.setText(
					"Existen un total de "+cantidad+" "+(String)comboArticuloS.getSelectedItem()+"  distribuidos en la siguientes localizaciones");
					comboLocalizacionesVArtS.setModel(new DefaultComboBoxModel(
							GestionBD.obtenerLocalizacionesConArticulo((String)comboArticuloS.getSelectedItem())));
					
			
			spinnerCantidadArticulosS.setModel(new SpinnerNumberModel(
					GestionBD.sumarStocksActualesLocalizacion(GestionBD.obtenerCodigoArticulo((String)comboArticuloS.getSelectedItem()),Integer.parseInt((String)comboLocalizacionesVArtS.getSelectedItem())),0,
					GestionBD.sumarStocksActualesLocalizacion(GestionBD.obtenerCodigoArticulo((String)comboArticuloS.getSelectedItem()),Integer.parseInt((String)comboLocalizacionesVArtS.getSelectedItem())),1));
			//spinnerCantidadArticulosS.updateUI();
					
			
		}
		else if(o==comboArticuloS){
			//int cantidad=GestionBD.obtenerStockArticulo((String)comboArticuloS.getSelectedItem());
			int cantidad=GestionBD.obtenerStockArticulo((String)comboArticuloS.getSelectedItem());
			labelLocalizacionesVArtS.setText(
			"Existen un total de "+cantidad+" "+(String)comboArticuloS.getSelectedItem()+"  distribuidos en la siguientes localizaciones");
			comboLocalizacionesVArtS.setModel(new DefaultComboBoxModel(
					GestionBD.obtenerLocalizacionesConArticulo((String)comboArticuloS.getSelectedItem())));
			
			spinnerCantidadArticulosS.setModel(new SpinnerNumberModel(
					GestionBD.sumarStocksActualesLocalizacion(GestionBD.obtenerCodigoArticulo((String)comboArticuloS.getSelectedItem()),Integer.parseInt((String)comboLocalizacionesVArtS.getSelectedItem())),0,
					GestionBD.sumarStocksActualesLocalizacion(GestionBD.obtenerCodigoArticulo((String)comboArticuloS.getSelectedItem()),Integer.parseInt((String)comboLocalizacionesVArtS.getSelectedItem())),1));
			//spinnerCantidadArticulosS.updateUI();
			//System.out.println(GestionBD.sumarStocksActualesLocalizacion(GestionBD.obtenerCodigoArticulo((String)comboArticuloS.getSelectedItem()),Integer.parseInt((String)comboLocalizacionesVArtS.getSelectedItem())));
			
		}
		else if(o==comboLocalizacionesVArtS){
			spinnerCantidadArticulosS.setModel(new SpinnerNumberModel(
					GestionBD.sumarStocksActualesLocalizacion(GestionBD.obtenerCodigoArticulo((String)comboArticuloS.getSelectedItem()),Integer.parseInt((String)comboLocalizacionesVArtS.getSelectedItem())),0,
					GestionBD.sumarStocksActualesLocalizacion(GestionBD.obtenerCodigoArticulo((String)comboArticuloS.getSelectedItem()),Integer.parseInt((String)comboLocalizacionesVArtS.getSelectedItem())),1));
			
		}
		else if (o==botonAnyadirVArtS){
			GestionBD.insertarLineaSalida(Integer.parseInt((String)panelEntradaSalida.vFila.get(0)),
					GestionBD.obtenerCodigoArticulo((String)comboArticuloS.getSelectedItem()),
					(((Integer)spinnerCantidadArticulosS.getValue()).intValue())*(-1),
					Integer.parseInt((String)comboLocalizacionesVArtS.getSelectedItem()),
					VentanaLogin.uLogin.getCodUsuario());
			JOptionPane.showMessageDialog(this,"Se han añadido "+((Integer)spinnerCantidadArticulosS.getValue()).intValue()+" "+(String)comboArticuloS.getSelectedItem()+" a la salida");
			
			if (!GestionBD.hayArticulosAlmacen()){
				labelLocalizacionesVArtS.setText(
						"El almacén esta vacio, no hay artículos disponibles");	
				comboLocalizacionesVArtS.setEnabled(false);
				spinnerCantidadArticulosS.setEnabled(false);
				comboCategoriaArtS.setEnabled(false);
				comboArticuloS.setEnabled(false);
				botonAnyadirVArtS.setEnabled(false);
			}
			else{
				
			comboCategoriaArtS.setModel(new DefaultComboBoxModel(
					GestionBD.obtenerCategoriasDisponibles()));
			comboArticuloS.setModel(new DefaultComboBoxModel(
					GestionBD.obtenerArticulosConStock((String)comboCategoriaArtS.getSelectedItem())));
			comboLocalizacionesVArtS.setModel(new DefaultComboBoxModel(
					GestionBD.obtenerLocalizacionesConArticulo((String)comboArticuloS.getSelectedItem())));
			spinnerCantidadArticulosS.setModel(new SpinnerNumberModel(
					GestionBD.sumarStocksActualesLocalizacion(GestionBD.obtenerCodigoArticulo((String)comboArticuloS.getSelectedItem()),Integer.parseInt((String)comboLocalizacionesVArtS.getSelectedItem())),0,
					GestionBD.sumarStocksActualesLocalizacion(GestionBD.obtenerCodigoArticulo((String)comboArticuloS.getSelectedItem()),Integer.parseInt((String)comboLocalizacionesVArtS.getSelectedItem())),1));
			int cantidad=GestionBD.obtenerStockArticulo((String)comboArticuloS.getSelectedItem());
			labelLocalizacionesVArtS.setText(
					"Existen un total de "+cantidad+" "+(String)comboArticuloS.getSelectedItem()+"  distribuidos en la siguientes localizaciones");	
			}		
				
					
					
		}
		else if(o==botonVolverVArtS){
			this.setVisible(false);
		}
	}

}
