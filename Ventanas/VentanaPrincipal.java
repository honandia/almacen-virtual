package Ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entidades.Entrada;

import procesos.Fecha;
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
public class VentanaPrincipal extends javax.swing.JFrame implements ActionListener{
	private JMenuBar menuPrincipal;
	private JMenuItem itEntradaSalida;
	private JMenuItem itArticulo;
	private JMenuItem itCategoria;
	private JMenuItem itCambiarPassword;
	private JMenuItem itCerrarSesion;
	private JMenuItem itSalir;
	public JMenu mEdicion;
	public JMenuItem itVerArticulos;
	public JMenuItem itVerCategorias;
	public JMenuItem itVerOperarios;
	public JMenuItem itVerLocalizaciones;
	public JMenuItem itVerEstadisticas;
	/*Edición de artículos (insertar, modificar artículos)
• Edición de categorías (insertar, modificar, eliminar categorías)
• Edición de operarios (insertar, modificar, eliminar usuarios)
• Edición de localizaciones (insertar, eliminar localizaciones de almacén)*/
	public JMenuItem itEdInsertarArticulo;
	public JMenuItem itEdModificarArticulo;
	public JMenuItem itEdInsertarCategoria;
	public JMenuItem itEdModificarCategoria;
	public JMenuItem itEdEliminarCategoria;
	public JMenuItem itEdInsertarOperario;
	public JMenuItem itEdModificarOperario;
	public JMenuItem itEdEliminarOperario;
	public JMenuItem itEdInsertarLocalizacion;
	public JMenuItem itEdEliminarLocalizacion;
	public JMenuItem itAyuContenido;
	public JMenuItem itAyuAcercade; 

	public VentanaPrincipal() {
		super();
		initGUI();
	}
	private void initGUI() {
		try {
			{
				this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/almacen.gif")).getImage());
				this.setTitle("Gestión del Almacén");
				this.setSize(800, 600);
				this.setLocationRelativeTo(null);
			}
			{
				JMenu mArchivo = new JMenu("Archivo");
				mEdicion = new JMenu("Edición");
				JMenu mVer = new JMenu("Ver");
				JMenu mAyuda = new JMenu("Ayuda");
				JMenu mNuevo = new JMenu("Nuevo");
				mNuevo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/filetype_other.GIF")));
				/*public JMenuItem itEdInsertarArticulo;
	public JMenuItem itEdModificarArticulo;
	public JMenuItem itEdInsertarCategoria;
	public JMenuItem itEdModificarCategoria;
	public JMenuItem itEdEliminarCategoria;
	public JMenuItem itEdInsertarOperario;
	public JMenuItem itEdModificarOperario;
	public JMenuItem itEdEliminarOperario;
	public JMenuItem itEdInsertarLocalizacion;
	public JMenuItem itEdEliminarLocalizacion;*/
				JMenu mEdArticulos = new JMenu("Artículos");
				itEdInsertarArticulo= new JMenuItem("Insertar artículo",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/file.GIF")));
				itEdModificarArticulo= new JMenuItem("Modificar artículo",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/modifArt.GIF")));
				itEdInsertarArticulo.addActionListener(this);
				itEdModificarArticulo.addActionListener(this);
				mEdArticulos.add(itEdInsertarArticulo);
				mEdArticulos.add(itEdModificarArticulo);
				JMenu mEdCategorias = new JMenu("Categorías");
				itEdInsertarCategoria= new JMenuItem("Insertar categoría",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_category.GIF")));
				itEdModificarCategoria= new JMenuItem("Modificar categoría",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/m_category.GIF")));
				itEdEliminarCategoria= new JMenuItem("Eliminar categoría",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/eliminarcategoira.GIF")));
				itEdInsertarCategoria.addActionListener(this);
				itEdModificarCategoria.addActionListener(this);
				itEdEliminarCategoria.addActionListener(this);
				mEdCategorias.add(itEdInsertarCategoria);
				mEdCategorias.add(itEdModificarCategoria);
				mEdCategorias.add(itEdEliminarCategoria);
				JMenu mEdOperarios = new JMenu("Operarios");
				itEdInsertarOperario= new JMenuItem("Insertar operario",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/stats_3.GIF")));
				itEdModificarOperario= new JMenuItem("Modificar operario",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/modificaroperario.GIF")));
				itEdEliminarOperario= new JMenuItem("Eliminar operario",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/eliminaroperario.GIF")));
				itEdInsertarOperario.addActionListener(this);
				itEdModificarOperario.addActionListener(this);
				itEdEliminarOperario.addActionListener(this);
				mEdOperarios.add(itEdInsertarOperario);
				mEdOperarios.add(itEdModificarOperario);
				mEdOperarios.add(itEdEliminarOperario);
				JMenu mEdLocalizaciones = new JMenu("Localizaciones");
				itEdInsertarLocalizacion= new JMenuItem("Insertar localización",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_static.GIF")));
				itEdEliminarLocalizacion= new JMenuItem("Eliminar localización",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/eliminarlocalizacion.GIF")));
				itEdInsertarLocalizacion.addActionListener(this);
				itEdEliminarLocalizacion.addActionListener(this);
				mEdLocalizaciones.add(itEdInsertarLocalizacion);
				mEdLocalizaciones.add(itEdEliminarLocalizacion);
				mEdicion.add(mEdArticulos);
				mEdicion.add(mEdCategorias);
				mEdicion.add(mEdOperarios);
				mEdicion.add(mEdLocalizaciones);
				itVerArticulos = new JMenuItem("Artículos",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/file.GIF")));
				itVerArticulos.addActionListener(this);
				itVerCategorias = new JMenuItem("Categorías",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_category.GIF")));
				itVerCategorias.addActionListener(this);
				itVerOperarios = new JMenuItem("Operarios",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/arrow_up_q.GIF")));
				itVerOperarios.addActionListener(this);
				itVerLocalizaciones = new JMenuItem("Localizaciones",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_static.GIF")));
				itVerLocalizaciones.addActionListener(this);
				itVerEstadisticas = new JMenuItem("Estadísticas",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/stats_8.GIF")));
				itVerEstadisticas.addActionListener(this);
				itAyuContenido = new JMenuItem("Contenido",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/contenido.GIF")));
				itAyuContenido.addActionListener(this);
				itAyuAcercade = new JMenuItem("Acerca de",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/almacen.GIF")));
				itAyuAcercade.addActionListener(this);
				mAyuda.add(itAyuContenido);
				mAyuda.add(itAyuAcercade);
				mVer.add(itVerArticulos);
				mVer.add(itVerCategorias);
				mVer.add(itVerOperarios);
				mVer.add(itVerLocalizaciones);
				mVer.add(itVerEstadisticas);
				mArchivo.add(mNuevo);
				itCambiarPassword = new JMenuItem("Cambiar password",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/hashing.GIF")));
				itCambiarPassword.addActionListener(this);
				mArchivo.add(itCambiarPassword);
				itCerrarSesion = new JMenuItem("Cerrar sesión",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_logout.GIF")));				
				itCerrarSesion.addActionListener(this);
				mArchivo.add(itCerrarSesion);
				itSalir = new JMenuItem("Salir",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_shutdown.GIF")));				
				itSalir.addActionListener(this);
				mArchivo.add(itSalir);
				itEntradaSalida = new JMenuItem("Entrada / Salida",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/arrow_updown.GIF")));				
				mNuevo.add(itEntradaSalida);
				itEntradaSalida.addActionListener(this);
				itArticulo = new JMenuItem("Artículo",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/articulo.GIF")));				
				mNuevo.add(itArticulo);
				itArticulo.addActionListener(this);
				itCategoria = new JMenuItem("Categoría",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/categoria.GIF")));				
				mNuevo.add(itCategoria);
				itCategoria.addActionListener(this);
				menuPrincipal = new JMenuBar();
				setJMenuBar(menuPrincipal);
				menuPrincipal.setPreferredSize(new java.awt.Dimension(792, 21));
				menuPrincipal.add(mArchivo);
				menuPrincipal.add(mEdicion);
				menuPrincipal.add(mVer);
				menuPrincipal.add(mAyuda);	
			}
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(800,600);
			this.getContentPane().setLayout(null);
			this.setResizable(false);
			this.getContentPane().setBackground(new java.awt.Color(181,183,253));
			{
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		Object o = (Object) e.getSource();		
		if (o == itEntradaSalida)
		{
			panelEntradaSalida pES = new panelEntradaSalida();
			this.setContentPane(pES);
		}
		else if(o==itEdModificarArticulo){
			VentanaModificarArticulo vModArt = new VentanaModificarArticulo();
			vModArt.setVisible(true);
			vModArt.setAlwaysOnTop(true);
		}
		else if(o==itEdModificarCategoria){
			VentanaModCategoria vModCat = new VentanaModCategoria();
			vModCat.setVisible(true);
			vModCat.setAlwaysOnTop(true);
		}
		else if (o==itEdEliminarCategoria){
			VentanaEliminarCat VElCat = new VentanaEliminarCat();
			VElCat.setVisible(true);
			VElCat.setAlwaysOnTop(true);
		}
		//VentanaInsetarOperario
		else if(o==itEdInsertarOperario){
			VentanaInsetarOperario vInsOp = new VentanaInsetarOperario();
			vInsOp.setVisible(true);
			vInsOp.setAlwaysOnTop(true);
		}
		//VentanaModOperario
		else if(o==itEdModificarOperario){
			VentanaModOperario vModOp = new VentanaModOperario();
			vModOp.setAlwaysOnTop(true);
			vModOp.setVisible(true);
		}
		//VentanaEliminarOperario
		else if(o==itEdEliminarOperario){
			VentanaEliminarOperario vDelOp = new VentanaEliminarOperario();
			vDelOp.setAlwaysOnTop(true);
			vDelOp.setVisible(true);
		}
		//VentanaInsertarLocalizacion
		else if(o==itEdInsertarLocalizacion){
			VentanaInsertarLocalizacion vILoc = new VentanaInsertarLocalizacion();
			vILoc.setAlwaysOnTop(true);
			vILoc.setVisible(true);
		}
		//VentalaEliminarLocalizacion
		else if(o==itEdEliminarLocalizacion){
			VentanaEliminarLocalizacion vElLoc = new VentanaEliminarLocalizacion();
			vElLoc.setAlwaysOnTop(true);
			vElLoc.setVisible(true);
		}
		//VentanaVerArticulos
		else if(o==itAyuAcercade){
			JOptionPane.showMessageDialog(this,"..::Almacen Virtual::.. \n\n ~Diseño y Programación: \n         ->Héctor Onandia Fernández \n\n Laboratorio de Informática II \n           ESIDE 2005-2006\n","Acerca de",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(o==itAyuContenido){
			try {
				Runtime.getRuntime().exec("WinHlp32.exe AYUDA.hlp");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		else if(o==itVerArticulos){
			VentanaVerArticulos vVArt = new VentanaVerArticulos();
			vVArt.setVisible(true);
		}
		//VentanaVerCategorias
		else if(o==itVerCategorias){
			VentanaVerCategorias vVCat = new VentanaVerCategorias();
			vVCat.setVisible(true);
		}
		//VentanaVerOperarios
		else if(o==itVerOperarios){
			VentanaVerOperarios vVOp = new VentanaVerOperarios();
			vVOp.setVisible(true);
		}
		else if(o==itVerLocalizaciones){
			VentanaVerLocalizaciones vVLocal =new VentanaVerLocalizaciones();
			vVLocal.setVisible(true);
		}
		else if (o==itVerEstadisticas){
			VentanaVerEstadisticas VVEstadisticas = new VentanaVerEstadisticas();
			VVEstadisticas.setVisible(true);
			VVEstadisticas.setAlwaysOnTop(true);
			
		}
		else if(o==itArticulo || o==itEdInsertarArticulo){
			VentanaCrearArticulo vCArt= new VentanaCrearArticulo();
			vCArt.setVisible(true);
			vCArt.setAlwaysOnTop(true);
			
		}
		else if(o==itCategoria || o==itEdInsertarCategoria){
			VentanaCrearNuevaCategoria vCNCat = new VentanaCrearNuevaCategoria();
			vCNCat.setVisible(true);
			vCNCat.setAlwaysOnTop(true);
		}
		
		else if (o==itCambiarPassword)
		{
			ventanaCambiarPassword vCPass = new ventanaCambiarPassword();
			vCPass.setVisible(true);
			vCPass.setAlwaysOnTop(true);
			
		}
	
		else if (o == itCerrarSesion)
		{
			VentanaLogin v= new VentanaLogin();
			v.setVisible(true);
			this.setVisible(false);
		}
		else if (o== itSalir)
		{System.exit(0);}
			
	}



	
}
