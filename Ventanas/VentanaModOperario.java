package Ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.NoSuchAlgorithmException;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entidades.Articulo;
import entidades.Operario;

import procesos.GestionBD;
import procesos.GestorCifrado;

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
public class VentanaModOperario extends javax.swing.JFrame implements ActionListener,MouseListener{
	private JButton botonModificarOp;
	private JTextField textoNuevoNombreModOp;
	private JTable tablaModOp;
	private JButton botonBuscarModOp;
	private JLabel labelTipoModOp;
	private JPasswordField textoRepNuevoPassOp;
	private JLabel labelRepNuevoPassOp;
	private JLabel labelNuevoPassOp;
	private JPasswordField textoModPasswordOp;
	private JLabel labelNombreUserModOp;
	private JTextField textoNombreUsuarioModOp;
	private JPanel panelModTipo;
	private JRadioButton radioBotonTipoGerente;
	private JRadioButton radioBotonTipoOperario;
	private ButtonGroup grupoBotonesTipoModOp;
	private JPanel panelOpcionesModOp;
	private JPanel panelOpcionesBuquedaModOp;
	private JLabel labelNombreModOp;
	private JTextField textoNombreModOp;
	private JComboBox comboTipoModOp;
	private JScrollPane scrollModOp;
	private JLabel labelNuevoNombreModOp;
	private JButton botonVolverModOp;
	private Vector datos,cabecera;
	public static int nFila=0;
	public static Vector vFila;
	public static Operario operarioSeleccionado;
	public static String TipoSeleccionado="";
	
	public VentanaModOperario() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(612, 528);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/modificaroperario.gif")).getImage());
			this.setTitle("Modificar operario");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			{
				
				botonVolverModOp = new JButton();
				this.getContentPane().add(botonVolverModOp);
				botonVolverModOp.setText("Volver");
				botonVolverModOp.setBounds(261, 465, 82, 30);
				botonVolverModOp.addActionListener(this);
			}
			{
				scrollModOp = new JScrollPane();
				this.getContentPane().add(scrollModOp);
				scrollModOp.setBounds(10, 98, 585, 176);
				{
					cargarVModOperarios();
					tablaModOp = new JTable(datos,cabecera){
							public boolean isCellEditable(
								int row,
								int column) {
								return false;
							}
						};
					scrollModOp.setViewportView(tablaModOp);
					tablaModOp.setColumnSelectionAllowed(false);
					tablaModOp.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
					tablaModOp.addMouseListener(this);
				}
			}
			{
				botonBuscarModOp = new JButton();
				this.getContentPane().add(botonBuscarModOp);
				botonBuscarModOp.setText("Buscar");
				botonBuscarModOp
					.setIcon(new ImageIcon(getClass().getClassLoader()
						.getResource("Ventanas/l_filesearch.gif")));
				botonBuscarModOp.setBounds(463, 35, 108, 30);
				botonBuscarModOp.addActionListener(this);
			}
			{
				ComboBoxModel comboCategoriaModArtModel = new DefaultComboBoxModel(
					new String[] { "no tener en cuenta", "operario", "gerente"  });
				comboTipoModOp = new JComboBox();
				this.getContentPane().add(comboTipoModOp);
				comboTipoModOp.setModel(comboCategoriaModArtModel);
				comboTipoModOp.setBounds(169, 56, 261, 20);
			}
			{
				textoNombreModOp = new JTextField();
				this.getContentPane().add(textoNombreModOp);
				textoNombreModOp.setBounds(169, 27, 261, 20);
			}
			{
				labelNombreModOp = new JLabel();
				this.getContentPane().add(labelNombreModOp);
				labelNombreModOp.setText("Nombre");
				labelNombreModOp.setBounds(82, 27, 73, 21);
			}
			{
				labelTipoModOp = new JLabel();
				this.getContentPane().add(labelTipoModOp);
				labelTipoModOp.setText("Tipo");
				labelTipoModOp.setBounds(82, 54, 73, 21);
			}
			{
				panelOpcionesBuquedaModOp = new JPanel();
				this.getContentPane().add(panelOpcionesBuquedaModOp);
				panelOpcionesBuquedaModOp.setBounds(7, 8, 589, 78);
				panelOpcionesBuquedaModOp.setBackground(new java.awt.Color(204,230,230));
				panelOpcionesBuquedaModOp.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Opciones de búsqueda", TitledBorder.LEADING, TitledBorder.TOP));
				panelOpcionesBuquedaModOp.setLayout(null);
			}
			{
				panelOpcionesModOp = new JPanel();
				this.getContentPane().add(panelOpcionesModOp);
				panelOpcionesModOp.setBounds(13, 283, 577, 172);
				panelOpcionesModOp.setLayout(null);
				panelOpcionesModOp.setBackground(new java.awt.Color(204,230,230));
				panelOpcionesModOp.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Opciones de modificación", TitledBorder.LEADING, TitledBorder.TOP));
				{
					labelNuevoNombreModOp = new JLabel();
					panelOpcionesModOp.add(labelNuevoNombreModOp);
					labelNuevoNombreModOp.setText("Modifique el nombre");
					labelNuevoNombreModOp.setBounds(21, 24, 122, 20);
				}
				{
					textoNuevoNombreModOp = new JTextField();
					panelOpcionesModOp.add(textoNuevoNombreModOp);
					textoNuevoNombreModOp.setEnabled(false);
					textoNuevoNombreModOp.setBounds(178, 25, 261, 21);
				}
				{
					botonModificarOp = new JButton();
					panelOpcionesModOp.add(botonModificarOp);
					botonModificarOp.setText("Modificar");
					botonModificarOp.setIcon(new ImageIcon(getClass()
						.getClassLoader().getResource(
							"Ventanas/modificaroperario.gif")));
					botonModificarOp.setBounds(454, 128, 108, 30);
					botonModificarOp.addActionListener(this);
				}
				{
					
					{
						panelModTipo = new JPanel();
						panelOpcionesModOp.add(panelModTipo);
						//panelModTipo.setLayout(panelModTipoLayout);
						panelModTipo.setBounds(452, 17, 110, 79);
						panelModTipo.setBorder(BorderFactory.createTitledBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), "Modifique el tipo", TitledBorder.LEADING, TitledBorder.TOP));
						panelModTipo.setBackground(new java.awt.Color(204,230,230));
						panelModTipo.setLayout(null);
						{
							radioBotonTipoOperario = new JRadioButton();
							radioBotonTipoOperario.setEnabled(false);
							panelModTipo.add(radioBotonTipoOperario);
							radioBotonTipoOperario.setText("operario");
							radioBotonTipoOperario.setBounds(9, 18, 73, 24);
							radioBotonTipoOperario.setBackground(new java.awt.Color(204,230,230));
							radioBotonTipoOperario.addMouseListener(this);
						}
						{
							radioBotonTipoGerente = new JRadioButton();
							radioBotonTipoGerente.setEnabled(false);
							panelModTipo.add(radioBotonTipoGerente);
							radioBotonTipoGerente.setText("gerente");
							radioBotonTipoGerente.setBounds(9, 48, 73, 24);
							radioBotonTipoGerente
								.setBackground(new java.awt.Color(204, 230, 230));
							radioBotonTipoGerente.addMouseListener(this);
						}
						grupoBotonesTipoModOp = new ButtonGroup();
						grupoBotonesTipoModOp.add(radioBotonTipoOperario);
						grupoBotonesTipoModOp.add(radioBotonTipoGerente);
					}
					{
						textoNombreUsuarioModOp = new JTextField();
						textoNombreUsuarioModOp.setEnabled(false);
						panelOpcionesModOp.add(textoNombreUsuarioModOp);
						textoNombreUsuarioModOp.setBounds(202, 64, 239, 21);
					}
					{
						labelNombreUserModOp = new JLabel();
						panelOpcionesModOp.add(labelNombreUserModOp);
						labelNombreUserModOp.setText("Modifique el nombre de usuario");
						labelNombreUserModOp.setBounds(15, 59, 183, 30);
					}
					{
						textoModPasswordOp = new JPasswordField();
						textoModPasswordOp.setEnabled(false);
						panelOpcionesModOp.add(textoModPasswordOp);
						textoModPasswordOp.setBounds(246, 100, 195, 21);
					}
					{
						labelNuevoPassOp = new JLabel();
						panelOpcionesModOp.add(labelNuevoPassOp);
						labelNuevoPassOp.setText("Introduzca un password nuevo");
						labelNuevoPassOp.setBounds(18, 100, 181, 20);
						labelNuevoPassOp.setEnabled(false);
					}
					{
						labelRepNuevoPassOp = new JLabel();
						panelOpcionesModOp.add(labelRepNuevoPassOp);
						labelRepNuevoPassOp.setText("Vuelva a introducir el nuevo password");
						labelRepNuevoPassOp.setBounds(17, 134, 228, 30);
						labelRepNuevoPassOp.setEnabled(false);
						
					}
					{
						textoRepNuevoPassOp = new JPasswordField();
						textoRepNuevoPassOp.setEnabled(false);
						panelOpcionesModOp.add(textoRepNuevoPassOp);
						textoRepNuevoPassOp.setBounds(246, 136, 195, 21);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void cargarVModOperarios() {
		cabecera= new Vector();
		cabecera.add("Código Operario");
		cabecera.add("Nómbre");
		cabecera.add("Tipo");
		datos = new Vector();
		datos=GestionBD.obtenerOperariosConLogin("","no tener en cuenta");;
	}
	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();
		if(o==botonBuscarModOp){
			textoNuevoNombreModOp.setEnabled(false);
			textoNuevoNombreModOp.setText("");
			textoNombreUsuarioModOp.setEnabled(false);
			textoNombreUsuarioModOp.setText("");
			labelNuevoPassOp.setEnabled(false);
			textoModPasswordOp.setEnabled(false);
			textoModPasswordOp.setText("");
			labelRepNuevoPassOp.setEnabled(false);
			textoRepNuevoPassOp.setEnabled(false);
			textoRepNuevoPassOp.setText("");
			Vector aux=new Vector();
			aux= GestionBD.obtenerOperariosConLogin(textoNombreModOp.getText(),""+comboTipoModOp.getSelectedItem());
			datos.clear();
			for(int t=0;t<aux.size();t++){
				datos.add(t,aux.get(t));
			}
			tablaModOp.updateUI();
			if (aux.isEmpty()){
				JOptionPane.showMessageDialog(this,"No se encontraron coincidencias");
			}
			
		}
		else if(o==botonModificarOp){
			if(!textoNuevoNombreModOp.isEnabled()){
				JOptionPane.showMessageDialog(this,"No hay ningun operario seleccionado","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				//activar cambia nombre y usuario.....
				if(textoModPasswordOp.isEnabled()){//hay q modificar el password
					if (textoModPasswordOp.getText().equals("")||
						textoRepNuevoPassOp.getText().equals("")){
							JOptionPane.showMessageDialog(this,"No puede haber campos vacios","Error",2);
						}
						else{
							if (!textoModPasswordOp.getText().equals(textoRepNuevoPassOp.getText())){
								JOptionPane.showMessageDialog(this,"Revise el password, los campos no coincide","Error",2);
							}
							else{
								if(textoNuevoNombreModOp.getText().equals("")||
								   textoNombreUsuarioModOp.getText().equals("")){
									JOptionPane.showMessageDialog(this,"No puede haber campos vacios","Error",2);
								}
								else{
									String pass="";
									if (TipoSeleccionado.equals("operario")){
										try {
											pass= GestorCifrado.getEncoded(textoModPasswordOp.getText());
										} catch (NoSuchAlgorithmException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
									else{
										try {
											pass= GestorCifrado.getEncoded(textoModPasswordOp.getText().concat("Admin"));
										} catch (NoSuchAlgorithmException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
									GestionBD.modificarOperario(operarioSeleccionado.getCodOperario(),textoNuevoNombreModOp.getText(),TipoSeleccionado);
									GestionBD.modificarUsuario(operarioSeleccionado.getCodUsuario(),textoNombreUsuarioModOp.getText(),pass);
									JOptionPane.showMessageDialog(this,"El operario ha sido modificado\n" +
											   "Nombre:  "+textoNuevoNombreModOp.getText()+"\n" +
											   "Tipo:  "+TipoSeleccionado+"\n" +
											   "Nombre de usuario:  "+textoNombreUsuarioModOp.getText()+"\n" +
											   "Password:  "+textoModPasswordOp.getText());
									textoNuevoNombreModOp.setEnabled(false);
									textoNuevoNombreModOp.setText("");
									textoNombreUsuarioModOp.setEnabled(false);
									textoNombreUsuarioModOp.setText("");
									labelNuevoPassOp.setEnabled(false);
									textoModPasswordOp.setEnabled(false);
									textoModPasswordOp.setText("");
									labelRepNuevoPassOp.setEnabled(false);
									textoRepNuevoPassOp.setEnabled(false);
									textoRepNuevoPassOp.setText("");
									
								}
							}
						}
				}
				else{//no hay q modificar el password
					if(textoNuevoNombreModOp.getText().equals("")||
							   textoNombreUsuarioModOp.getText().equals("")){
								JOptionPane.showMessageDialog(this,"No puede haber campos vacios","Error",2);
							}
					else{
						GestionBD.modificarOperario(operarioSeleccionado.getCodOperario(),textoNuevoNombreModOp.getText(),TipoSeleccionado);
						GestionBD.modificarUsuario(operarioSeleccionado.getCodUsuario(),textoNombreUsuarioModOp.getText());
						JOptionPane.showMessageDialog(this,"El operario ha sido modificado\n" +
								   "Nombre:  "+textoNuevoNombreModOp.getText()+"\n" +
								   "Nombre de usuario:  "+textoNombreUsuarioModOp.getText());
						textoNuevoNombreModOp.setEnabled(false);
						textoNuevoNombreModOp.setText("");
						textoNombreUsuarioModOp.setEnabled(false);
						textoNombreUsuarioModOp.setText("");
						labelNuevoPassOp.setEnabled(false);
						textoModPasswordOp.setEnabled(false);
						textoModPasswordOp.setText("");
						labelRepNuevoPassOp.setEnabled(false);
						textoRepNuevoPassOp.setEnabled(false);
						textoRepNuevoPassOp.setText("");
						
					}
				}
			}
		}
		else if(o==botonVolverModOp){
			this.setAlwaysOnTop(false);
			this.setVisible(false);
		}
	}

	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		Object o= me.getSource();
		if(o==tablaModOp){
		nFila=tablaModOp.getSelectedRow();
		vFila = new Vector();
		vFila=(Vector)datos.elementAt(nFila);
		operarioSeleccionado = new Operario();
		operarioSeleccionado.setCodOperario(Integer.parseInt(""+vFila.get(0)));
		operarioSeleccionado.setNombre(""+vFila.get(1));
		operarioSeleccionado.setTipo(""+vFila.get(2));
		operarioSeleccionado.setCodUsuario(Integer.parseInt(""+vFila.get(0)));
		textoNuevoNombreModOp.setEnabled(true);
		textoNuevoNombreModOp.setText(operarioSeleccionado.getNombre());
		textoNombreUsuarioModOp.setEnabled(true);
		textoNombreUsuarioModOp.setText(GestionBD.obtenerNombreUsuario(operarioSeleccionado.getCodUsuario()));
		radioBotonTipoOperario.setEnabled(true);
		radioBotonTipoGerente.setEnabled(true);
			if (operarioSeleccionado.getTipo().equals("operario")){
				radioBotonTipoOperario.setSelected(true);
				radioBotonTipoGerente.setSelected(false);
				TipoSeleccionado="operario";
			}
			else{
				radioBotonTipoGerente.setSelected(true);
				radioBotonTipoOperario.setSelected(false);
				TipoSeleccionado="gerente";
			}
		}
		else if(o==radioBotonTipoOperario){
			TipoSeleccionado="operario";
		}
		else if(o==radioBotonTipoGerente){
			TipoSeleccionado="gerente";
		}
		if(!operarioSeleccionado.getTipo().equals(TipoSeleccionado)){//Tipos no coinciden
			labelNuevoPassOp.setEnabled(true);
			textoModPasswordOp.setEnabled(true);
			labelRepNuevoPassOp.setEnabled(true);
			textoRepNuevoPassOp.setEnabled(true);
		}
		else{
			labelNuevoPassOp.setEnabled(false);
			textoModPasswordOp.setEnabled(false);
			labelRepNuevoPassOp.setEnabled(false);
			textoRepNuevoPassOp.setEnabled(false);
		}
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
