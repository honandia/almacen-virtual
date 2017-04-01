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
public class VentanaInformacionSalida extends javax.swing.JFrame implements ActionListener{
	private JLabel labelInformacionSalida;
	private JLabel labelTablaInfoSalida;
	private JButton botonVolverInfoSalida;
	private JTable tablaInfoSalida;
	private JScrollPane scrollInfoSalida;
	private Vector datos,cabecera;
	
	public VentanaInformacionSalida() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(691, 297);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_info.gif")).getImage());
			this.setTitle("Información de la salida");
			this.setLocationRelativeTo(null);
			this.getContentPane().setLayout(null);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			this.setResizable(false);
			{
				labelInformacionSalida = new JLabel();
				this.getContentPane().add(labelInformacionSalida);
				int codSalida = Integer.parseInt((String)panelEntradaSalida.vFila.get(0));
				String tipoOperario = GestionBD.obtenerTipo(GestionBD.obtenerCodOperarioSalida(codSalida));
				String nombreOperario=GestionBD.obtenerNombreOperario(GestionBD.obtenerCodOperarioSalida(codSalida));
				String mensage ="La salida con código "+codSalida+"  fue creada por el "+tipoOperario+" "+nombreOperario+
				" el "+(String)panelEntradaSalida.vFila.get(1)+" a las "+(String)panelEntradaSalida.vFila.get(2);
				labelInformacionSalida.setText(mensage);
				labelInformacionSalida.setBounds(12, 11, 657, 20);
				labelInformacionSalida.setHorizontalAlignment(SwingConstants.LEFT);
				labelInformacionSalida.setHorizontalTextPosition(SwingConstants.RIGHT);
			}
			{
				scrollInfoSalida = new JScrollPane();
				this.getContentPane().add(scrollInfoSalida);
				scrollInfoSalida.setBounds(11, 81, 664, 127);
				{
					cargarVInfoSalidas();
					tablaInfoSalida = new JTable(datos,cabecera) {
							public boolean isCellEditable(
								int row,
								int column) {
								return false;
							}
						};
					scrollInfoSalida.setViewportView(tablaInfoSalida);
				}
			}
			{
				botonVolverInfoSalida = new JButton();
				this.getContentPane().add(botonVolverInfoSalida);
				botonVolverInfoSalida.setText("Volver");
				botonVolverInfoSalida.setBounds(290, 227, 103, 30);
				botonVolverInfoSalida.addActionListener(this);
			}
			{
				labelTablaInfoSalida = new JLabel();
				this.getContentPane().add(labelTablaInfoSalida);
				labelTablaInfoSalida.setText("Se han añadido los siguientes artículos");
				labelTablaInfoSalida.setBounds(10, 53, 245, 20);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void cargarVInfoSalidas() {
		cabecera= new Vector();
		cabecera.add("Orden de inserción");
		cabecera.add("Descripción artículo");
		cabecera.add("Número artículos");
		datos = new Vector();
		datos=GestionBD.obtenerInfoLineasSalidas(Integer.parseInt((String)panelEntradaSalida.vFila.get(0)));
	}
	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();
		if(o==botonVolverInfoSalida){
			this.setVisible(false);
		}
	}

}
