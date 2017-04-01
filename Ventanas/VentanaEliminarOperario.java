package Ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import procesos.GestionBD;

import entidades.Operario;

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
public class VentanaEliminarOperario extends javax.swing.JFrame implements ActionListener, MouseListener{
	private JPanel panelOpcionesBusquedaDelOp;
	private JLabel labelNombreDelOp;
	private JScrollPane scrollDelOp;
	private JPanel panelEliminarOp;
	private JButton botonVolverEliminarOp;
	private JButton botonEliminarOp;
	private JLabel labelNombreOpSeleccionado;
	private JLabel labelOpSeleccionado;
	private JTable tablaDelOp;
	private JButton botonBuscarDelOp;
	private JLabel labelTipoDelOp;
	private JComboBox comboTipoDelOp;
	private JTextField comboNombreDelOp;
	private Vector datos,cabecera;
	public static int nFila=0;
	public static Vector vFila;
	public static Operario operarioSeleccionado;
	
	public VentanaEliminarOperario() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(494, 354);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/eliminaroperario.gif")).getImage());
			this.setTitle("Eliminar operario");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			{
				panelOpcionesBusquedaDelOp = new JPanel();
				this.getContentPane().add(panelOpcionesBusquedaDelOp);
				//panelOpcionesBusquedaDelOp.setLayout(panelOpcionesBusquedaDelOpLayout);
				panelOpcionesBusquedaDelOp.setBounds(4, 2, 477, 88);
				panelOpcionesBusquedaDelOp.setBackground(new java.awt.Color(204,230,230));
				panelOpcionesBusquedaDelOp.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Opciones de búsqueda", TitledBorder.LEADING, TitledBorder.TOP));
				panelOpcionesBusquedaDelOp.setLayout(null);
				{
					comboNombreDelOp = new JTextField();
					panelOpcionesBusquedaDelOp.add(comboNombreDelOp);
					comboNombreDelOp.setBounds(101, 22, 187, 22);
				}
				{
					ComboBoxModel comboTipoDelOpModel = new DefaultComboBoxModel(
						new String[] { "no tener en cuenta", "operario", "gerente" });
					comboTipoDelOp = new JComboBox();
					panelOpcionesBusquedaDelOp.add(comboTipoDelOp);
					comboTipoDelOp.setModel(comboTipoDelOpModel);
					comboTipoDelOp.setBounds(100, 53, 187, 22);
				}
				{
					labelNombreDelOp = new JLabel();
					panelOpcionesBusquedaDelOp.add(labelNombreDelOp);
					labelNombreDelOp.setText("Nombre");
					labelNombreDelOp.setBounds(23, 22, 60, 18);
				}
				{
					labelTipoDelOp = new JLabel();
					panelOpcionesBusquedaDelOp.add(labelTipoDelOp);
					labelTipoDelOp.setText("Tipo");
					labelTipoDelOp.setBounds(23, 55, 60, 17);
				}
				{
					botonBuscarDelOp = new JButton();
					panelOpcionesBusquedaDelOp.add(botonBuscarDelOp);
					botonBuscarDelOp.setText("Buscar");
					botonBuscarDelOp.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_filesearch.gif")));
					botonBuscarDelOp.setBounds(353, 43, 104, 30);
					botonBuscarDelOp.addActionListener(this);
				}
			}
			{
				scrollDelOp = new JScrollPane();
				this.getContentPane().add(scrollDelOp);
				scrollDelOp.setBounds(6, 95, 474, 114);
				{
					cargarVDelOperarios();
					tablaDelOp = new JTable(datos,cabecera){
							public boolean isCellEditable(
								int row,
								int column) {
								return false;
							}
						};
					scrollDelOp.setViewportView(tablaDelOp);
					tablaDelOp.setColumnSelectionAllowed(false);
					tablaDelOp.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
					tablaDelOp.addMouseListener(this);
				}
			}
			{
				botonVolverEliminarOp = new JButton();
				this.getContentPane().add(botonVolverEliminarOp);
				botonVolverEliminarOp.setText("Volver");
				botonVolverEliminarOp.setBounds(200, 287, 86, 30);
				botonVolverEliminarOp.addActionListener(this);
			}
			{
				panelEliminarOp = new JPanel();
				this.getContentPane().add(panelEliminarOp);
				//panelEliminarOp.setLayout(panelEliminarOpLayout);
				panelEliminarOp.setBounds(3, 221, 477, 61);
				panelEliminarOp.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Eliminar operario", TitledBorder.LEADING, TitledBorder.TOP));
				panelEliminarOp.setBackground(new java.awt.Color(204,230,230));
				panelEliminarOp.setLayout(null);
				{
					labelOpSeleccionado = new JLabel();
					panelEliminarOp.add(labelOpSeleccionado);
					labelOpSeleccionado.setText("Seleccionado: ");
					labelOpSeleccionado.setBounds(8, 25, 83, 16);
				}
				{
					labelNombreOpSeleccionado = new JLabel();
					panelEliminarOp.add(labelNombreOpSeleccionado);
					labelNombreOpSeleccionado.setText("ninguno");
					labelNombreOpSeleccionado.setBounds(94, 25, 222, 16);
					labelNombreOpSeleccionado.setForeground(new java.awt.Color(255,0,0));
				}
				{
					botonEliminarOp = new JButton();
					panelEliminarOp.add(botonEliminarOp);
					botonEliminarOp.setText("Eliminar operario");
					botonEliminarOp.setIcon(new ImageIcon(getClass()
						.getClassLoader().getResource(
							"Ventanas/eliminaroperario.gif")));
					botonEliminarOp.setBounds(318, 20, 151, 26);
					botonEliminarOp.addActionListener(this);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void cargarVDelOperarios() {
		cabecera= new Vector();
		cabecera.add("Código Operario");
		cabecera.add("Nómbre");
		cabecera.add("Tipo");
		datos = new Vector();
		datos=GestionBD.obtenerOperariosConLogin("","no tener en cuenta");
	}
	public void actionPerformed(ActionEvent e){
		Object o= e.getSource();
		if(o==botonBuscarDelOp){
			labelNombreOpSeleccionado.setText("ninguno");
			labelNombreOpSeleccionado.setForeground(new java.awt.Color(255,0,0));
			Vector aux=new Vector();
			aux= GestionBD.obtenerOperariosConLogin(comboNombreDelOp.getText(),(String)comboTipoDelOp.getSelectedItem());
			datos.clear();
			for(int t=0;t<aux.size();t++){
				datos.add(t,aux.get(t));
			}
			tablaDelOp.updateUI();
			if (aux.isEmpty()){
				JOptionPane.showMessageDialog(this,"No se encontraron coincidencias");
			}
		}
		else if (o==botonVolverEliminarOp){
			this.setAlwaysOnTop(false);
			this.setVisible(false);
		}
		else if (o==botonEliminarOp){
			if(labelNombreOpSeleccionado.getText().equals("ninguno")){
				JOptionPane.showMessageDialog(this,"No hay ningun operario seleccionado","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				int opcion =JOptionPane.showConfirmDialog(this,"¿Esta seguro de que quiere eliminar el "+operarioSeleccionado.getTipo()+" "+operarioSeleccionado.getNombre()+"  ?","Cofirmación",JOptionPane.YES_NO_OPTION);
				if(opcion==0){
					GestionBD.eliminarUsuario(operarioSeleccionado.getCodUsuario());
					Vector aux=new Vector();
					aux= GestionBD.obtenerOperariosConLogin("","no tener en cuenta");
					datos.clear();
					for(int t=0;t<aux.size();t++){
						datos.add(t,aux.get(t));
					}
					JOptionPane.showMessageDialog(this,"El  "+operarioSeleccionado.getTipo()+" "+operarioSeleccionado.getNombre()+"  ha sido eliminado");
					tablaDelOp.updateUI();
					labelNombreOpSeleccionado.setText("ninguno");
					labelNombreOpSeleccionado.setForeground(new java.awt.Color(255,0,0));
				}
				
			}
				
		}
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		nFila=tablaDelOp.getSelectedRow();
		vFila = new Vector();
		vFila=(Vector)datos.elementAt(nFila);
		operarioSeleccionado = new Operario();
		operarioSeleccionado.setCodOperario(Integer.parseInt(""+vFila.get(0)));
		operarioSeleccionado.setNombre(""+vFila.get(1));
		operarioSeleccionado.setTipo(""+vFila.get(2));
		operarioSeleccionado.setCodUsuario(Integer.parseInt(""+vFila.get(0)));
		labelNombreOpSeleccionado.setText(operarioSeleccionado.getNombre());
		labelNombreOpSeleccionado.setForeground(new java.awt.Color(0,0,255));
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
