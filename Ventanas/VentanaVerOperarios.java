package Ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

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
public class VentanaVerOperarios extends javax.swing.JFrame implements ActionListener{
	private JScrollPane scrollVerOperarios;
	private JTable tablaVerOperarios;
	private JComboBox comboTipoBuscarOperario;
	private JLabel labelNombreOperario;
	private JLabel labelTipoOperario;
	private JTextField textoNombreBuscarOperario;
	private JButton botonBuscarVerOperarios;
	private JButton botonVolverVerOperarios;
	private Vector datos,cabecera;

	public VentanaVerOperarios() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setLayout(null);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/arrow_up_q.gif")).getImage());
			setTitle("Ver operarios");
			this.setSize(656, 440);
			setLocationRelativeTo(null);
			getContentPane().setBackground(new java.awt.Color(204,230,230));
			{
				scrollVerOperarios = new JScrollPane();
				this.getContentPane().add(scrollVerOperarios);
				scrollVerOperarios.setBounds(16, 75, 623, 270);
				{
					cargarVVerOperarios();
					tablaVerOperarios = new JTable(datos,cabecera){
							public boolean isCellEditable(
								int row,
								int column) {
								return false;
							}
						};
					scrollVerOperarios.setViewportView(tablaVerOperarios);
					
				}
			}
			{
				botonVolverVerOperarios = new JButton();
				this.getContentPane().add(botonVolverVerOperarios);
				botonVolverVerOperarios.setText("Volver");
				botonVolverVerOperarios.setBounds(272, 370, 104, 30);
				botonVolverVerOperarios.addActionListener(this);
			}
			{
				botonBuscarVerOperarios = new JButton();
				this.getContentPane().add(botonBuscarVerOperarios);
				botonBuscarVerOperarios.setText("Buscar");
				botonBuscarVerOperarios.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_filesearch.gif")));
				botonBuscarVerOperarios.setBounds(269, 25, 109, 30);
				botonBuscarVerOperarios.addActionListener(this);
			}
			{
				textoNombreBuscarOperario = new JTextField();
				this.getContentPane().add(textoNombreBuscarOperario);
				textoNombreBuscarOperario.setBounds(81, 13, 176, 22);
				textoNombreBuscarOperario.setToolTipText("Introduzca la palabra que desea buscar, si deja este campo en blanco no se tendra en cuenta para la busqueda");
			}
			{
				ComboBoxModel comboTipoBuscarOperarioModel = new DefaultComboBoxModel(
					new String[] { "no tener en cuenta", "gerente","operario" });
				comboTipoBuscarOperario = new JComboBox();
				this.getContentPane().add(comboTipoBuscarOperario);
				comboTipoBuscarOperario.setModel(comboTipoBuscarOperarioModel);
				comboTipoBuscarOperario.setBounds(81, 41, 176, 22);
			}
			{
				labelNombreOperario = new JLabel();
				this.getContentPane().add(labelNombreOperario);
				labelNombreOperario.setText("Nombre");
				labelNombreOperario.setBounds(21, 14, 57, 19);
			}
			{
				labelTipoOperario = new JLabel();
				this.getContentPane().add(labelTipoOperario);
				labelTipoOperario.setText("Tipo");
				labelTipoOperario.setBounds(19, 45, 54, 21);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void cargarVVerOperarios() {
		cabecera= new Vector();
		cabecera.add("Código Operario");
		cabecera.add("Nómbre");
		cabecera.add("Tipo");
		datos = new Vector();
		datos=GestionBD.obtenerOperarios();
	}
	public void actionPerformed(ActionEvent e){
		Object o= e.getSource();
		if(o==botonBuscarVerOperarios){
			Vector aux=new Vector();
			aux= GestionBD.buscarOperarios(textoNombreBuscarOperario.getText(),""+comboTipoBuscarOperario.getSelectedItem());
			datos.clear();
			for(int t=0;t<aux.size();t++){
				datos.add(t,aux.get(t));
			}
			tablaVerOperarios.updateUI();
			if (aux.isEmpty()){
				JOptionPane.showMessageDialog(this,"No se encontraron coincidencias");
			}
			
		}
		else if(o==botonVolverVerOperarios){
			this.setVisible(false);
		}
	}

}
