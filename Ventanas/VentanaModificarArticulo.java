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

import entidades.Articulo;
import entidades.Entrada;

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
public class VentanaModificarArticulo extends javax.swing.JFrame implements ActionListener,MouseListener{
	private JLabel labelModificarArticulo;
	private JButton botonBuscarModArt;
	private JButton botonModificarArt;
	private JLabel labelNuevaCatModArt;
	private JLabel labelNuevaDescModArt;
	private JComboBox comboNuevaCategoriaModArt;
	private JTextField textoNuevoNombreArt;
	private JPanel panelModOp;
	private JPanel panelBuscarArticuloModArt;
	private JButton botonVolverModArt;
	private JTable tablaModArt;
	private JScrollPane scrollModArt;
	private JLabel labelCategoriaModArt;
	private JComboBox comboCategoriaModArt;
	private JTextField textoDescArtModArt;
	private Vector datos,cabecera;
	public static int nFila=0;
	public static Vector vFila;
	public static Articulo articuloSeleccionado;

	public VentanaModificarArticulo() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(612, 445);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/modifArt.GIF")).getImage());
			this.setTitle("Modificar artículo");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			{
				labelModificarArticulo = new JLabel();
				this.getContentPane().add(labelModificarArticulo);
				labelModificarArticulo.setText("Descripción del artículo");
				labelModificarArticulo.setBounds(11, 24, 143, 30);
			}
			{
				labelCategoriaModArt = new JLabel();
				this.getContentPane().add(labelCategoriaModArt);
				labelCategoriaModArt.setText("Categoría");
				labelCategoriaModArt.setBounds(12, 52, 73, 30);
			}
			{
				scrollModArt = new JScrollPane();
				this.getContentPane().add(scrollModArt);
				scrollModArt.setBounds(10, 98, 585, 176);
				{
					datos=new Vector();
					cabecera= new Vector();
					cabecera.add("Código Articulo");
					cabecera.add("Descripción");
					cabecera.add("Categoría");
					tablaModArt = new JTable(datos,cabecera){
							public boolean isCellEditable(
								int row,
								int column) {
								return false;
							}
						};
					tablaModArt.setColumnSelectionAllowed(false);
					tablaModArt.addMouseListener(this);
					tablaModArt.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
					scrollModArt.setViewportView(tablaModArt);
					
				}
			}
			{
				botonVolverModArt = new JButton();
				this.getContentPane().add(botonVolverModArt);
				botonVolverModArt.setText("Volver");
				botonVolverModArt.setBounds(261, 378, 82, 30);
				botonVolverModArt.addActionListener(this);
			}
			{
				panelBuscarArticuloModArt = new JPanel();
				this.getContentPane().add(panelBuscarArticuloModArt);
				panelBuscarArticuloModArt.setBounds(2, 3, 599, 91);
				panelBuscarArticuloModArt.setBackground(new java.awt.Color(204,230,230));
				panelBuscarArticuloModArt.setLayout(null);
				panelBuscarArticuloModArt.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Opciones de búsqueda", TitledBorder.LEADING, TitledBorder.TOP));
				{
					botonBuscarModArt = new JButton();
					panelBuscarArticuloModArt.add(botonBuscarModArt);
					botonBuscarModArt.setText("Buscar");
					botonBuscarModArt.setIcon(new ImageIcon(getClass()
						.getClassLoader().getResource(
							"Ventanas/l_filesearch.gif")));
					botonBuscarModArt.setBounds(480, 52, 108, 30);
					botonBuscarModArt.addActionListener(this);
				}
				{
					ComboBoxModel comboCategoriaModArtModel = new DefaultComboBoxModel(
						GestionBD.obtenerCategorias());
					comboCategoriaModArt = new JComboBox();
					panelBuscarArticuloModArt.add(comboCategoriaModArt);
					comboCategoriaModArt.setModel(comboCategoriaModArtModel);
					comboCategoriaModArt.setBounds(156, 56, 261, 20);
				}
				{
					textoDescArtModArt = new JTextField();
					panelBuscarArticuloModArt.add(textoDescArtModArt);
					textoDescArtModArt.setBounds(156, 27, 261, 20);
				}
			}
			{
				panelModOp = new JPanel();
				this.getContentPane().add(panelModOp);
				panelModOp.setBounds(1, 278, 601, 91);
				panelModOp.setBackground(new java.awt.Color(204,230,230));
				panelModOp.setLayout(null);
				panelModOp.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Opciones de modificación", TitledBorder.LEADING, TitledBorder.TOP));
				{
					botonModificarArt = new JButton();
					panelModOp.add(botonModificarArt);
					botonModificarArt.setText("Modificar");
					botonModificarArt.setBounds(480, 47, 108, 30);
					botonModificarArt
						.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Ventanas/modifArt.gif")));
					botonModificarArt.addActionListener(this);
				}
				{
					ComboBoxModel comboNuevaCategoriaModArtModel = new DefaultComboBoxModel(
						GestionBD.obtenerCategorias());
					comboNuevaCategoriaModArt = new JComboBox();
					panelModOp.add(comboNuevaCategoriaModArt);
					comboNuevaCategoriaModArt
						.setModel(comboNuevaCategoriaModArtModel);
					comboNuevaCategoriaModArt.setBounds(193, 57, 261, 20);
					comboNuevaCategoriaModArt.setEnabled(false);
				}
				{
					textoNuevoNombreArt = new JTextField();
					panelModOp.add(textoNuevoNombreArt);
					textoNuevoNombreArt.setBounds(193, 26, 261, 20);
					textoNuevoNombreArt.setEnabled(false);
				}
				{
					labelNuevaCatModArt = new JLabel();
					panelModOp.add(labelNuevaCatModArt);
					labelNuevaCatModArt.setText("Modifique la categoría");
					labelNuevaCatModArt.setBounds(35, 56, 151, 20);
				}
				{
					labelNuevaDescModArt = new JLabel();
					panelModOp.add(labelNuevaDescModArt);
					labelNuevaDescModArt.setText("Modifique la descripción");
					labelNuevaDescModArt.setBounds(35, 26, 151, 19);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();
		if (o==botonBuscarModArt){
			Vector aux=new Vector();
			aux= GestionBD.buscarArticulos(textoDescArtModArt.getText(),""+comboCategoriaModArt.getSelectedItem());
			datos.clear();
			for(int t=0;t<aux.size();t++){
				datos.add(t,aux.get(t));
			}
			tablaModArt.updateUI();
			if (aux.isEmpty()){
				JOptionPane.showMessageDialog(this,"No se encontraron coincidencias");
			}
			textoNuevoNombreArt.setText("");
			textoNuevoNombreArt.setEnabled(false);
			comboNuevaCategoriaModArt.setSelectedItem("Todos");
			comboNuevaCategoriaModArt.setEnabled(false);
		}
		else if(o==botonModificarArt){
			if(datos.isEmpty()){
				JOptionPane.showMessageDialog(this,"No hay nigún artículo seleccionado","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				if(textoNuevoNombreArt.isEnabled()&&!textoNuevoNombreArt.getText().equals("")){
					int opcion = JOptionPane.showConfirmDialog(this,"¿Esta seguro de que quiere modificar el artículo  "+(String)vFila.get(1)+"?","Cofirmación",JOptionPane.YES_NO_OPTION);
					if(opcion==0){
						GestionBD.modificarArticulo(articuloSeleccionado.getCodArticulo(),textoNuevoNombreArt.getText(),""+comboNuevaCategoriaModArt.getSelectedItem());
						Vector aux=new Vector();
						aux= GestionBD.buscarArticulos(textoNuevoNombreArt.getText(),""+comboNuevaCategoriaModArt.getSelectedItem());
						datos.clear();
						for(int t=0;t<aux.size();t++){
							datos.add(t,aux.get(t));
						}
						tablaModArt.updateUI();
						JOptionPane.showMessageDialog(this,"El artículo  "+articuloSeleccionado.getDescArticulo()+"  ha sido modificado");
						
					}
				}
				else{
					JOptionPane.showMessageDialog(this,"No hay nigún artículo seleccionado","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if(o==botonVolverModArt){
			this.setAlwaysOnTop(false);
			this.setVisible(false);
		}
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		nFila=tablaModArt.getSelectedRow();
		vFila = new Vector();
		vFila=(Vector)datos.elementAt(nFila);
		articuloSeleccionado = new Articulo();
		articuloSeleccionado.setCodArticulo(Integer.parseInt((String)vFila.get(0)));
		articuloSeleccionado.setDescArticulo((String)vFila.get(1));
		articuloSeleccionado.setCodCategoria(GestionBD.obtenerCodigoCategoria((String)vFila.get(2)));
		articuloSeleccionado.setStockTotalActual(Integer.parseInt((String)vFila.get(3)));
		textoNuevoNombreArt.setEnabled(true);
		textoNuevoNombreArt.setText(articuloSeleccionado.getDescArticulo());
		comboNuevaCategoriaModArt.setEnabled(true);
		comboNuevaCategoriaModArt.setSelectedItem(GestionBD.obtenerNombreCategoria(articuloSeleccionado.getCodCategoria()));
		
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
