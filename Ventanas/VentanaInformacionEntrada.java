package Ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

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
public class VentanaInformacionEntrada extends javax.swing.JFrame implements ActionListener{
	private JLabel labelInformacionEntrada;
	private JLabel labelTablaInfoEntrada;
	private JButton botonVolverInfoEntrada;
	private JTable tablaInfoEntrada;
	private JScrollPane scrollInfoEntrada;
	private Vector datos,cabecera;
	
	public VentanaInformacionEntrada() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(691, 297);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_info.gif")).getImage());
			this.setTitle("Información de la entrada");
			this.setLocationRelativeTo(null);
			this.getContentPane().setLayout(null);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			this.setResizable(false);
			{
				labelInformacionEntrada = new JLabel();
				this.getContentPane().add(labelInformacionEntrada);
				int codEntrada = Integer.parseInt((String)panelEntradaSalida.vFila.get(0));
				String tipoOperario = GestionBD.obtenerTipo(GestionBD.obtenerCodOperarioEntrada(codEntrada));
				String nombreOperario=GestionBD.obtenerNombreOperario(GestionBD.obtenerCodOperarioEntrada(codEntrada));
				String mensage ="La entrada con código "+codEntrada+"  fue creada por el "+tipoOperario+" "+nombreOperario+
				" el "+(String)panelEntradaSalida.vFila.get(1)+" a las "+(String)panelEntradaSalida.vFila.get(2);
				labelInformacionEntrada.setText(mensage);
				labelInformacionEntrada.setBounds(12, 11, 657, 20);
				labelInformacionEntrada.setHorizontalAlignment(SwingConstants.LEFT);
				labelInformacionEntrada.setHorizontalTextPosition(SwingConstants.RIGHT);
			}
			{
				scrollInfoEntrada = new JScrollPane();
				this.getContentPane().add(scrollInfoEntrada);
				scrollInfoEntrada.setBounds(11, 81, 664, 127);
				{
					cargarVInfoEntradas();
					tablaInfoEntrada = new JTable(datos,cabecera) {
							public boolean isCellEditable(
								int row,
								int column) {
								return false;
							}
						};
					scrollInfoEntrada.setViewportView(tablaInfoEntrada);
				}
			}
			{
				botonVolverInfoEntrada = new JButton();
				this.getContentPane().add(botonVolverInfoEntrada);
				botonVolverInfoEntrada.setText("Volver");
				botonVolverInfoEntrada.setBounds(290, 227, 103, 30);
				botonVolverInfoEntrada.addActionListener(this);
			}
			{
				labelTablaInfoEntrada = new JLabel();
				this.getContentPane().add(labelTablaInfoEntrada);
				labelTablaInfoEntrada.setText("Se han añadido los siguientes artículos");
				labelTablaInfoEntrada.setBounds(10, 53, 245, 20);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void cargarVInfoEntradas() {
		cabecera= new Vector();
		cabecera.add("Orden de inserción");
		cabecera.add("Descripción artículo");
		cabecera.add("Número artículos");
		datos = new Vector();
		datos=GestionBD.obtenerInfoLineasEntradas(Integer.parseInt((String)panelEntradaSalida.vFila.get(0)));
	}
	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();
		if(o==botonVolverInfoEntrada){
			this.setVisible(false);
		}
	}

}
