package Ventanas;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.DefaultListSelectionModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SingleSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import entidades.Entrada;
import entidades.Salida;
import procesos.Fecha;
import procesos.GestionBD;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder,
 * which is free for non-commercial use. If Jigloo is being used commercially
 * (ie, by a corporation, company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo. Please visit
 * www.cloudgarden.com for details. Use of Jigloo implies acceptance of these
 * licensing terms. ************************************* A COMMERCIAL LICENSE
 * HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be
 * used legally for any corporate or commercial purpose.
 * *************************************
 */
public class panelEntradaSalida extends javax.swing.JPanel implements ActionListener,MouseListener {

	private JTable tablaSalidas;
	private JScrollPane scrollSalidas;
	private JLabel labelSalidas;
	private JScrollPane scrollTablaEntradas;
	private JLabel labelEntradas;
	private JButton botonNuevaEntrada;
	private JButton botonNuevaSalida;
	private JTabbedPane pestaEntradaSalida;
	public Vector datos,cabecera,datosSalidas,cabeceraSalidas;
	private JTable tablaEntradas;
	public static int nFila=0;
	public static Vector vFila;
	private JPopupMenu mOpcionEntradas ;
	private JMenuItem itPausar ;
	private JMenuItem itReanudar ;
	private JMenuItem itAnularPausada ;
    private JMenuItem itFinalizar;
    private JMenuItem itAddArticulos;
    private JMenuItem itInfoE;
    private JPopupMenu mOpcionSalidas ;
	private JMenuItem itPausarS ;
	private JMenuItem itReanudarS ;
	private JMenuItem itAnularSPausada ;
    private JMenuItem itFinalizarS;
    private JMenuItem itAddArticulosS;
    private JMenuItem itInfoS;

	public panelEntradaSalida() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			{
				//181,183,253
				this.setLayout(null);
				this.setPreferredSize(new java.awt.Dimension(793, 545));
				this.setBackground(new java.awt.Color(181,183,253));
			}
			{
				{
					{
						{
							pestaEntradaSalida = new JTabbedPane();
							this.add(pestaEntradaSalida);
							{
								JPanel panelEntrada = new JPanel();
								pestaEntradaSalida.addTab("Entrada",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/arrow_down.GIF")), panelEntrada);
								panelEntrada.setBackground(new java.awt.Color(
									204,
									230,
									230));
								panelEntrada.setLayout(null);
								panelEntrada.setPreferredSize(new java.awt.Dimension(787, 509));
								{
									botonNuevaEntrada = new JButton();
									panelEntrada.add(botonNuevaEntrada);
									botonNuevaEntrada.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/arrow_down.gif")));
									
									botonNuevaEntrada.setText("Nueva entrada");
									botonNuevaEntrada.setBounds(325, 467, 137, 33);
									botonNuevaEntrada.setSize(137, 33);
									botonNuevaEntrada.setToolTipText("Pulse aqui para iniciar una nueva entrada");
									botonNuevaEntrada.addActionListener(this);
								}
								{
									labelEntradas = new JLabel();
									panelEntrada.add(labelEntradas);
									labelEntradas.setText("GESTIÓN DE ENTRADAS AL ALMACEN");
									labelEntradas.setIcon(new ImageIcon(getClass()
											.getClassLoader().getResource(
											"Ventanas/entrada.JPG")));
									labelEntradas.setBounds(1, 3, 783, 36);
									labelEntradas.setHorizontalTextPosition(SwingConstants.RIGHT);
									labelEntradas.setHorizontalAlignment(SwingConstants.LEFT);
								}
								{
								    mOpcionEntradas = new JPopupMenu();
									mOpcionEntradas.addMouseListener(this);
									itPausar = new JMenuItem("Pausar",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_pause.GIF")));
									itPausar.addActionListener(this);
									itReanudar = new JMenuItem("Reanudar",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_resume.GIF")));
									itReanudar.addActionListener(this);
									itAnularPausada = new JMenuItem("Anular entrada pausada",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_cancel.GIF")));
									itAnularPausada.addActionListener(this);
									itFinalizar = new JMenuItem("Finalizar entrada",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_stop.GIF")));
									itFinalizar.addActionListener(this);
									itAddArticulos = new JMenuItem("Añadir artículos",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/t_downloading.GIF")));
									itAddArticulos.addActionListener(this);
									itInfoE = new JMenuItem("Información de la entrada",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_info.GIF")));
									itInfoE.addActionListener(this);
									mOpcionEntradas.add(itPausar);
									mOpcionEntradas.add(itReanudar);
									mOpcionEntradas.add(itAnularPausada);
									mOpcionEntradas.add(itFinalizar);
									mOpcionEntradas.add(itAddArticulos);
									mOpcionEntradas.add(itInfoE);
								}
								{
									{

										cargarVEntradas();
										tablaEntradas = new JTable(
											datos,
											cabecera) {
											public boolean isCellEditable(
												int row,
												int column) {
												return false;
											}
										};
										tablaEntradas.addMouseListener(this);
										tablaEntradas.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
										tablaEntradas.setColumnSelectionAllowed(false);
									
									}
									scrollTablaEntradas = new JScrollPane(tablaEntradas);
									panelEntrada.add(scrollTablaEntradas);
									scrollTablaEntradas.setBounds(9, 49, 771, 402);
								}
							}
							{
								JPanel panelSalida = new JPanel();
								pestaEntradaSalida.addTab("Salida",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/arrow_up.GIF")), panelSalida, null);
								{
									botonNuevaSalida = new JButton();
									panelSalida.add(botonNuevaSalida);
									botonNuevaSalida.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/arrow_up.gif")));
									
									botonNuevaSalida.setText("Nueva salida");
									botonNuevaSalida.setBounds(325, 467, 137, 33);
									botonNuevaSalida.setSize(137, 33);
									botonNuevaSalida.setToolTipText("Pulse aqui para iniciar una nueva salida");
									botonNuevaSalida.addActionListener(this);
								}
								{
									labelSalidas = new JLabel();
									panelSalida.add(labelSalidas);
									labelSalidas
										.setText("GESTIÓN DE SALIDAS DEL ALMACEN");
									labelSalidas
										.setIcon(new ImageIcon(getClass()
											.getClassLoader().getResource(
												"Ventanas/salida.JPG")));
									labelSalidas.setBounds(1, 3, 783, 36);
									labelSalidas.setHorizontalAlignment(SwingConstants.LEFT);
									labelSalidas
										.setHorizontalTextPosition(SwingConstants.RIGHT);
								}
								
								{
									
									{
										cargarVSalidas();
										tablaSalidas = new JTable(
												datosSalidas,
												cabeceraSalidas) {
												public boolean isCellEditable(
													int row,
													int column) {
													return false;
												}
											};
											tablaSalidas.addMouseListener(this);
											tablaSalidas.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
											tablaSalidas.setColumnSelectionAllowed(false);
									}
									scrollSalidas = new JScrollPane(tablaSalidas);
									panelSalida.add(scrollSalidas);
									scrollSalidas.setBounds(9, 49, 771, 402);
								}
								panelSalida.setBackground(new java.awt.Color(
									204,
									230,
									230));
								panelSalida.setLayout(null);
								panelSalida
									.setPreferredSize(new java.awt.Dimension(
										785,
										517));
							}
							{
								mOpcionSalidas = new JPopupMenu();
								mOpcionSalidas.addMouseListener(this);
								itPausarS = new JMenuItem("Pausar",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_pause.GIF")));
								itPausarS.addActionListener(this);
								itReanudarS = new JMenuItem("Reanudar",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_resume.GIF")));
								itReanudarS.addActionListener(this);
								itAnularSPausada = new JMenuItem("Anular salida pausada",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_cancel.GIF")));
								itAnularSPausada.addActionListener(this);
								itFinalizarS = new JMenuItem("Finalizar salida",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_stop.GIF")));
								itFinalizarS.addActionListener(this);
								itAddArticulosS = new JMenuItem("Añadir artículos",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/t_downloading.GIF")));
								itAddArticulosS.addActionListener(this);
								itInfoS = new JMenuItem("Información de la salida",new ImageIcon(getClass().getClassLoader().getResource("Ventanas/l_info.GIF")));
								itInfoS.addActionListener(this);
								mOpcionSalidas.add(itPausarS);
								mOpcionSalidas.add(itReanudarS);
								mOpcionSalidas.add(itAnularSPausada);
								mOpcionSalidas.add(itFinalizarS);
								mOpcionSalidas.add(itAddArticulosS);
								mOpcionSalidas.add(itInfoS);
							}
							pestaEntradaSalida.setBounds(1, 2, 792, 539);
							pestaEntradaSalida.setVisible(true);
							pestaEntradaSalida.setPreferredSize(new java.awt.Dimension(793, 535));
							pestaEntradaSalida.setBackground(new java.awt.Color(204,230,230));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void cargarVEntradas() {
		cabecera= new Vector();
		cabecera.add("Código entrada");
		cabecera.add("Fecha entrada");
		cabecera.add("Hora entrada");
		cabecera.add("Estado entrada");
		cabecera.add("Hora fin entrada");
		cabecera.add("Fecha fin entrada");
		cabecera.add("Tiempo");
		datos = new Vector();
		datos=GestionBD.obtenerEntradas();
	}
	private void cargarVSalidas() {
		cabeceraSalidas= new Vector();
		cabeceraSalidas.add("Código salida");
		cabeceraSalidas.add("Fecha salida");
		cabeceraSalidas.add("Hora salida");
		cabeceraSalidas.add("Estado salida");
		cabeceraSalidas.add("Hora fin salida");
		cabeceraSalidas.add("Fecha fin salida");
		cabeceraSalidas.add("Tiempo");
		datosSalidas = new Vector();
		datosSalidas=GestionBD.obtenerSalidas();
	}
	//********************************************************
	//********************************************************
	private String actualizarTiempo(){
		Fecha ahora = new Fecha();
		String horaActual = ahora.verHora();
		String fechaActual = ahora.obtenerFecha("D","M","A");
		String diaActual = ""+fechaActual.charAt(0)+fechaActual.charAt(1);
		String mesActual = ""+fechaActual.charAt(3)+fechaActual.charAt(4);
		String anyoActual = ""+fechaActual.charAt(6)+fechaActual.charAt(7);
		GregorianCalendar tiempoActual =new GregorianCalendar(2000+Integer.parseInt(anyoActual), Integer.parseInt(mesActual), Integer.parseInt(diaActual));
		long tiempoAc =tiempoActual.getTimeInMillis();
		int minutosActual = Integer.parseInt(new String (""+horaActual.charAt(3)+horaActual.charAt(4)));
		int horaAhora= Integer.parseInt(new String (""+horaActual.charAt(0)+horaActual.charAt(1)));
		int minutosTotalActual=horaAhora*60+minutosActual;
		String horaInicio="";
		String fechaInicio="";
		if(((String)vFila.get(4)).equals("...")){
			horaInicio=(String)vFila.get(2);
			fechaInicio=(String)vFila.get(1);
		}
		else{
			horaInicio=(String)vFila.get(5);
			fechaInicio=(String)vFila.get(4);
		}
		String diaInicio = ""+fechaInicio.charAt(0)+fechaInicio.charAt(1);
		String mesInicio = ""+fechaInicio.charAt(3)+fechaInicio.charAt(4);
		String anyoInicio = ""+fechaInicio.charAt(6)+fechaInicio.charAt(7);
		GregorianCalendar tiempoInicio =new GregorianCalendar(2000+Integer.parseInt(anyoInicio), Integer.parseInt(mesInicio), Integer.parseInt(diaInicio));
		long tiempoIn = tiempoInicio.getTimeInMillis();
		int minutosInicio=Integer.parseInt(new String (""+horaInicio.charAt(3)+horaInicio.charAt(4)));
		int horaIniciada= Integer.parseInt(new String (""+horaInicio.charAt(0)+horaInicio.charAt(1)));
		String calculo=""+0;
		
		if (fechaActual.equals(fechaInicio)){//si es el mismo dia
			int minutosTotalInicio=horaIniciada*60+minutosInicio;
			int calculoHoras =minutosTotalInicio-minutosTotalActual;
			if (calculoHoras < 0){
				calculoHoras = calculoHoras * -1;
			}
			String horas;
			if (((calculoHoras)/60)/10==0)
			{
				horas="0"+((calculoHoras)/60);
			}
			else{
				horas=""+((calculoHoras)/60);
			}	
			String minutos;
			if (((calculoHoras)%60)/10==0){
					minutos = "0"+(calculoHoras)%60;
			}
			else{
				minutos = ""+(calculoHoras)%60;
			}	
			calculo=""+horas+":"+minutos;
		}
		else{//cuando las fechas son distintas
			int minutosTotalInicio=horaIniciada*60+minutosInicio;	
			long tiempoTotalMins = 
				(((tiempoIn/1000)/60)+minutosTotalInicio) - (((tiempoAc/1000)/60)+minutosTotalActual);
			if (tiempoTotalMins < 0){
				tiempoTotalMins = tiempoTotalMins * -1;
			}
			long tiempoTotalHoras=(tiempoTotalMins/60) ;
			long tiempoMinutos = tiempoTotalMins%60;
			String horas;
			if ((tiempoTotalHoras/10)==0)
			{
				horas="0"+(tiempoTotalHoras);
			}
			else{
				horas=""+(tiempoTotalHoras);
			}	
			String minutos;
			if ((tiempoMinutos)/10==0){
					minutos = "0"+tiempoMinutos;
			}
			else{
				minutos = ""+tiempoMinutos;
			}	
			calculo=""+horas+":"+minutos;
		}
		return calculo;
	}
	//********************************************************
	//********************************************************
	private String sumarTiempos(String tiempoNuevo){
		String total="";
		int minutosNuevo=0;
		int horaNuevo=0;
		if(tiempoNuevo.length()>5){
			minutosNuevo = Integer.parseInt(new String (""+tiempoNuevo.charAt(4)+tiempoNuevo.charAt(5)));
			horaNuevo= Integer.parseInt(new String (""+tiempoNuevo.charAt(0)+tiempoNuevo.charAt(1)+tiempoNuevo.charAt(2)));
			
		}
		else{
			minutosNuevo = Integer.parseInt(new String (""+tiempoNuevo.charAt(3)+tiempoNuevo.charAt(4)));
			horaNuevo= Integer.parseInt(new String (""+tiempoNuevo.charAt(0)+tiempoNuevo.charAt(1)));
			
		}
		int totalMinutosNuevo=(horaNuevo*60)+minutosNuevo;
		//**********
		String tiempoAnterior = (String)vFila.get(6);
		int minutosAnterior=0;
		int horaAnterior=0;
		if(tiempoAnterior.length()>5){
			minutosAnterior = Integer.parseInt(new String (""+tiempoAnterior.charAt(4)+tiempoAnterior.charAt(5)));
			horaAnterior= Integer.parseInt(new String (""+tiempoAnterior.charAt(0)+tiempoAnterior.charAt(1)+tiempoAnterior.charAt(2)));
		}
		else{
			minutosAnterior = Integer.parseInt(new String (""+tiempoAnterior.charAt(3)+tiempoAnterior.charAt(4)));
			horaAnterior= Integer.parseInt(new String (""+tiempoAnterior.charAt(0)+tiempoAnterior.charAt(1)));
		}
		int totalMinutosAnterior=(horaAnterior*60)+minutosAnterior;
		
		int sumaTotalMinutos=totalMinutosNuevo+totalMinutosAnterior;
		int totalHoras = sumaTotalMinutos/60;
		int totalMinutos = sumaTotalMinutos%60;
		String horas="";
		String minutos="";
		if (totalHoras/10==0){
			horas="0"+totalHoras;
		}
		else{
			horas=""+totalHoras;
		}
		if (totalMinutos/10==0){
			minutos="0"+totalMinutos;
		}
		else{
			minutos=""+totalMinutos;
		}
		total = horas +":"+minutos;
		return total;
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = new Object();
		o=e.getSource();
		//Entradas
		if (o == botonNuevaEntrada){
			Entrada ent =new Entrada();
			Fecha fechaHora = new Fecha();
			//ent.setFechaEntrada(fechaHora.obtenerFecha("D","M","A"));
			ent.setFechaEntrada(fechaHora.obtenerFecha("A","M","D"));
			ent.setHoraEntrada(fechaHora.verHora());
			ent.setEstadoEntrada("Iniciada");
			ent.setCodOperario(VentanaLogin.uLogin.getCodUsuario());
			ent.setFechaFinEntrada("...");
			ent.setHoraFinEntrada("...");
			ent.setTiempoEntrada("00:00");
			GestionBD.insertarEntrada(ent);
			ent.setCodEntrada(Integer.parseInt(GestionBD.obtenerCodUltimaEntrada()));
			Vector entrada = new Vector();
			entrada.add(""+ent.getCodEntrada());
			//entrada.add(ent.getFechaEntrada());
			entrada.add(fechaHora.obtenerFecha("D","M","A"));
			entrada.add(ent.getHoraEntrada());
			entrada.add(ent.getEstadoEntrada());
			
			entrada.add(ent.getFechaFinEntrada());
			entrada.add(ent.getHoraFinEntrada());
			entrada.add(""+ent.getTiempoEntrada());
			entrada.add(""+ent.getCodOperario());
			datos.addElement(entrada);
			tablaEntradas.updateUI();
			JOptionPane.showMessageDialog(this,"Se ha introducido una nueva entrada el " +
					fechaHora.obtenerFecha("D","M","A")+ " a las "+ent.getHoraEntrada(),"Nueva Entrada",1);	
	}
		else if(o==itPausar){
			if(VentanaLogin.uLogin.getCodUsuario()==GestionBD.obtenerCodOperarioEntrada(Integer.parseInt((String)vFila.get(0)))){
				String tiempoNuevo =actualizarTiempo();
				String totalTiempo =sumarTiempos(tiempoNuevo);
				vFila.set(3,"Pausada");
				vFila.set(6,totalTiempo);
				datos.setElementAt(vFila,nFila);
				tablaEntradas.updateUI();
				Entrada entradaPausada = new Entrada();
				entradaPausada.setCodEntrada(Integer.parseInt((String)vFila.get(0)));
				entradaPausada.setEstadoEntrada("Pausada");
				entradaPausada.setFechaFinEntrada((String)vFila.get(4));
				entradaPausada.setHoraFinEntrada((String)vFila.get(5));
				entradaPausada.setTiempoEntrada(totalTiempo);
				GestionBD.modificarEstadoEntrada(entradaPausada);
			}
			else{
				JOptionPane.showMessageDialog(this,"Usted solo puede consultar la información de esta entrada, esta entrada pertenece a otro usuario","Error",2);
			}
			
	
		}
		else if(o==itReanudar){
			if(VentanaLogin.uLogin.getCodUsuario()==GestionBD.obtenerCodOperarioEntrada(Integer.parseInt((String)vFila.get(0)))){
				Fecha fechaHora = new Fecha();
				vFila.set(3,"Iniciada");
				vFila.set(4,fechaHora.obtenerFecha("D","M","A"));
				vFila.set(5,fechaHora.verHora());
				datos.setElementAt(vFila,nFila);
				tablaEntradas.updateUI();
				Entrada entradaReanudada = new Entrada();
				entradaReanudada.setCodEntrada(Integer.parseInt((String)vFila.get(0)));
				entradaReanudada.setEstadoEntrada("Iniciada");
				entradaReanudada.setFechaFinEntrada(fechaHora.obtenerFecha("D","M","A"));
				entradaReanudada.setHoraFinEntrada(fechaHora.verHora());
				entradaReanudada.setTiempoEntrada((String)vFila.get(6));
				GestionBD.modificarEstadoEntrada(entradaReanudada);
			}
			else{
				JOptionPane.showMessageDialog(this,"Usted solo puede consultar la información de esta entrada, esta entrada pertenece a otro usuario","Error",2);
			}
		}
		else if (o==itAnularPausada){
			if(VentanaLogin.uLogin.getCodUsuario()==GestionBD.obtenerCodOperarioEntrada(Integer.parseInt((String)vFila.get(0)))){
			int opcion = JOptionPane.showConfirmDialog(this,"¿Esta seguro de que quiere eliminar la entrada  "+(String)vFila.get(0)+"  y  todos los artículos que contiene?","Cofirmación",JOptionPane.YES_NO_OPTION);
			if (opcion==0){
				Vector StocksEntrada = new Vector();
				StocksEntrada= GestionBD.obtenerStocksActualesEntrada(Integer.parseInt((String)vFila.get(0)));
				GestionBD.eliminarStocksEntrada(Integer.parseInt((String)vFila.get(0)));
				GestionBD.actualizarTodosStockTotalArticulo();
				if(GestionBD.hayStockNegativo()){
					for(int k=0;k<StocksEntrada.size();k++){
						GestionBD.insertarStockActual(
								Integer.parseInt(""+((Vector)StocksEntrada.get(k)).get(0)),
								Integer.parseInt(""+((Vector)StocksEntrada.get(k)).get(1)),
								Integer.parseInt(""+((Vector)StocksEntrada.get(k)).get(2)),
								Integer.parseInt(""+((Vector)StocksEntrada.get(k)).get(3)));
					}
					GestionBD.actualizarTodosStockTotalArticulo();
					JOptionPane.showMessageDialog(this,"No se puede eliminar esta entrada, los artículos asociados a esta entrada estan también asociados a alguna salida","Error",JOptionPane.ERROR_MESSAGE);
				
				}
				else{
					GestionBD.eliminarLineasEntradas(Integer.parseInt((String)vFila.get(0)));
					GestionBD.eliminarEntradaPausada(Integer.parseInt((String)vFila.get(0)));
					datos.remove(nFila);
					tablaEntradas.updateUI();
					GestionBD.actualizarTodosStockTotalArticulo();
				//me falta hacer un metodo q revise los stocks negativos q esten sueltos
				//y poducen stock total negativos
				//GestionBD.eliminarStocksNegativosSueltos
				//->al eliminar una entrada y todos sus articulos, las salidas que
				//contienen los articulos de la entrada eliminada producen stocks negativos
					JOptionPane.showMessageDialog(this,"La entrada  "+(String)vFila.get(0)+"  ha sido eliminada");
				}
			}
			}
			else{
				JOptionPane.showMessageDialog(this,"Usted solo puede consultar la información de esta entrada, esta entrada pertenece a otro usuario","Error",2);
			}
			
		}
		else if(o==itFinalizar){
			if(VentanaLogin.uLogin.getCodUsuario()==GestionBD.obtenerCodOperarioEntrada(Integer.parseInt((String)vFila.get(0)))){
				Fecha ahora = new Fecha();
				String horaActual = ahora.verHora();
				String fechaActual = ahora.obtenerFecha("D","M","A");
				String totalTiempo =sumarTiempos(actualizarTiempo());
				vFila.set(3,"Finalizada");
				vFila.set(4,fechaActual);
				vFila.set(5,horaActual);
				vFila.set(6,totalTiempo);
				datos.setElementAt(vFila,nFila);
				tablaEntradas.updateUI();
				Entrada entradaFinalizada = new Entrada();
				entradaFinalizada.setCodEntrada(Integer.parseInt((String)vFila.get(0)));
				entradaFinalizada.setEstadoEntrada("Finalizada");
				entradaFinalizada.setFechaFinEntrada(fechaActual);
				entradaFinalizada.setHoraFinEntrada(horaActual);
				entradaFinalizada.setTiempoEntrada(totalTiempo);
				GestionBD.modificarEstadoEntrada(entradaFinalizada);
			}
			else{
				JOptionPane.showMessageDialog(this,"Usted solo puede consultar la información de esta entrada, esta entrada pertenece a otro usuario","Error",2);
			}
		}
		else if(o==itAddArticulos){
			if(VentanaLogin.uLogin.getCodUsuario()==GestionBD.obtenerCodOperarioEntrada(Integer.parseInt((String)vFila.get(0)))){
			VentanaArticulosEntrada vAE = new VentanaArticulosEntrada();
			vAE.setVisible(true);
			vAE.setAlwaysOnTop(true);
			}
			else{
				JOptionPane.showMessageDialog(this,"Usted solo puede consultar la información de esta entrada, esta entrada pertenece a otro usuario","Error",2);
			}
		}
		else if (o==itInfoE){
			VentanaInformacionEntrada vIE = new VentanaInformacionEntrada();
			vIE.setVisible(true);
			vIE.setAlwaysOnTop(true);
		}
		//Salidas
		else if(o==botonNuevaSalida){
			Salida sal =new Salida();
			Fecha fechaHora = new Fecha();
			//ent.setFechaEntrada(fechaHora.obtenerFecha("A","M","D"));
			sal.setFechaSalida(fechaHora.obtenerFecha("A","M","D"));
			sal.setHoraSalida(fechaHora.verHora());
			sal.setEstadoSalida("Iniciada");
			sal.setCodOperario(VentanaLogin.uLogin.getCodUsuario());
			sal.setFechaFinSalida("...");
			sal.setHoraFinSalida("...");
			sal.setTiempoSalida("00:00");
			GestionBD.insertarSalida(sal);
			sal.setCodSalida(Integer.parseInt(GestionBD.obtenerCodUltimaSalida()));
			Vector salida = new Vector();
			salida.add(""+sal.getCodSalida());
			salida.add(fechaHora.obtenerFecha("D","M","A"));
			salida.add(sal.getHoraSalida());
			salida.add(sal.getEstadoSalida());
			salida.add(sal.getFechaFinSalida());
			salida.add(sal.getHoraFinSalida());
			salida.add(""+sal.getTiempoSalida());
			salida.add(""+sal.getCodOperario());
			datosSalidas.addElement(salida);
			tablaSalidas.updateUI();
			JOptionPane.showMessageDialog(this,"Se ha introducido una nueva salida el " +
					fechaHora.obtenerFecha("D","M","A")+ " a las "+sal.getHoraSalida(),"Nueva Salida",1);
			
			
		}
		else if(o==itPausarS){
			if(VentanaLogin.uLogin.getCodUsuario()==GestionBD.obtenerCodOperarioSalida(Integer.parseInt((String)vFila.get(0)))){
				String totalTiempo =sumarTiempos(actualizarTiempo());
				vFila.set(3,"Pausada");
				vFila.set(6,totalTiempo);
				datosSalidas.setElementAt(vFila,nFila);
				tablaSalidas.updateUI();
				Salida salidaPausada = new Salida();
				salidaPausada.setCodSalida(Integer.parseInt((String)vFila.get(0)));
				salidaPausada.setEstadoSalida("Pausada");
				salidaPausada.setFechaFinSalida((String)vFila.get(4));
				salidaPausada.setHoraFinSalida((String)vFila.get(5));
				salidaPausada.setTiempoSalida(totalTiempo);
				GestionBD.modificarEstadoSalida(salidaPausada);
			}
			else{
				JOptionPane.showMessageDialog(this,"Usted solo puede consultar la información de esta salida, esta salida pertenece a otro usuario","Error",2);
			}
		}
		else if(o==itReanudarS){
			if(VentanaLogin.uLogin.getCodUsuario()==GestionBD.obtenerCodOperarioSalida(Integer.parseInt((String)vFila.get(0)))){
				Fecha fechaHora = new Fecha();
				vFila.set(3,"Iniciada");
				vFila.set(4,fechaHora.obtenerFecha("D","M","A"));
				vFila.set(5,fechaHora.verHora());
				datosSalidas.setElementAt(vFila,nFila);
				tablaSalidas.updateUI();
				Salida salidaReanudada = new Salida();
				salidaReanudada.setCodSalida(Integer.parseInt((String)vFila.get(0)));
				salidaReanudada.setEstadoSalida("Iniciada");
				salidaReanudada.setFechaFinSalida(fechaHora.obtenerFecha("D","M","A"));
				salidaReanudada.setHoraFinSalida(fechaHora.verHora());
				salidaReanudada.setTiempoSalida((String)vFila.get(6));
				GestionBD.modificarEstadoSalida(salidaReanudada);
			}
			else{
				JOptionPane.showMessageDialog(this,"Usted solo puede consultar la información de esta entrada, esta entrada pertenece a otro usuario","Error",2);
			}
		}
		//************************
		//***********************
		//VVVVVVVVVVVVVVVVVVVVVVVV
		else if (o==itAnularSPausada){
			if(VentanaLogin.uLogin.getCodUsuario()==GestionBD.obtenerCodOperarioSalida(Integer.parseInt((String)vFila.get(0)))){
			int opcion = JOptionPane.showConfirmDialog(this,"¿Esta seguro de que quiere eliminar la salida  "+(String)vFila.get(0)+"  y  todos los artículos que contiene?","Cofirmación",JOptionPane.YES_NO_OPTION);
			if (opcion==0){
				GestionBD.eliminarStocksSalida(Integer.parseInt((String)vFila.get(0)));
				GestionBD.eliminarLineasSalidas(Integer.parseInt((String)vFila.get(0)));
				GestionBD.eliminarSalidaPausada(Integer.parseInt((String)vFila.get(0)));
				datosSalidas.remove(nFila);
				tablaSalidas.updateUI();
				GestionBD.actualizarTodosStockTotalArticulo();
				JOptionPane.showMessageDialog(this,"La salida  "+(String)vFila.get(0)+"  ha sido eliminada");
			}
			}
			else{
				JOptionPane.showMessageDialog(this,"Usted solo puede consultar la información de esta salida, esta salida pertenece a otro usuario","Error",2);
			}
			
		}
		else if(o==itFinalizarS){
			if(VentanaLogin.uLogin.getCodUsuario()==GestionBD.obtenerCodOperarioSalida(Integer.parseInt((String)vFila.get(0)))){
				Fecha ahora = new Fecha();
				String horaActual = ahora.verHora();
				String fechaActual = ahora.obtenerFecha("D","M","A");
				String totalTiempo =sumarTiempos(actualizarTiempo());
				vFila.set(3,"Finalizada");
				vFila.set(4,fechaActual);
				vFila.set(5,horaActual);
				vFila.set(6,totalTiempo);
				datosSalidas.setElementAt(vFila,nFila);
				tablaSalidas.updateUI();
				Salida salidaFinalizada = new Salida();
				salidaFinalizada.setCodSalida(Integer.parseInt((String)vFila.get(0)));
				salidaFinalizada.setEstadoSalida("Finalizada");
				salidaFinalizada.setFechaFinSalida(fechaActual);
				salidaFinalizada.setHoraFinSalida(horaActual);
				salidaFinalizada.setTiempoSalida(totalTiempo);
				GestionBD.modificarEstadoSalida(salidaFinalizada);
			}
			else{
				JOptionPane.showMessageDialog(this,"Usted solo puede consultar la información de esta salida, esta salida pertenece a otro usuario","Error",2);
			}
		}
		else if(o==itAddArticulosS){
			if(VentanaLogin.uLogin.getCodUsuario()==GestionBD.obtenerCodOperarioSalida(Integer.parseInt((String)vFila.get(0)))){
				if (GestionBD.hayArticulosAlmacen()){
				VentanaArticulosSalida vAS = new VentanaArticulosSalida();
				vAS.setVisible(true);
				vAS.setAlwaysOnTop(true);
				}
				else{
					JOptionPane.showMessageDialog(this,"En este momento no hay ningun artículo en el almacén, es imposible agregar artículos a la salida","Error",2);
				}
			}
			else{
				JOptionPane.showMessageDialog(this,"Usted solo puede consultar la información de esta salida, esta salida pertenece a otro usuario","Error",2);
			}
		}
		else if (o==itInfoS){
			VentanaInformacionSalida vIS = new VentanaInformacionSalida();
			vIS.setVisible(true);
			vIS.setAlwaysOnTop(true);
		}
	}
public void mouseClicked(MouseEvent e) {
	
	if (pestaEntradaSalida.getSelectedIndex()==0){//Pestaña Entrada	
		if(e.getButton()==3){//Boton Derecho del raton
			int row = tablaEntradas.rowAtPoint(e.getPoint());
			tablaEntradas.changeSelection(row,-1,false,false);
		}
		nFila=tablaEntradas.getSelectedRow();
		vFila = new Vector();
		vFila=(Vector)datos.elementAt(nFila);
		Entrada entradaSeleccionada = new Entrada();
		entradaSeleccionada.setCodEntrada(Integer.parseInt((String)vFila.get(0)));
		entradaSeleccionada.setFechaEntrada((String)vFila.get(1));
		entradaSeleccionada.setHoraEntrada((String)vFila.get(2));
		entradaSeleccionada.setEstadoEntrada((String)vFila.get(3));
		entradaSeleccionada.setFechaFinEntrada((String)vFila.get(4));
		entradaSeleccionada.setHoraFinEntrada((String)vFila.get(5));
		entradaSeleccionada.setTiempoEntrada((String)vFila.get(6));
		if(e.getButton()==3){//Boton Derecho del raton
			if(entradaSeleccionada.getEstadoEntrada().equals("Iniciada")){
				itReanudar.setEnabled(false);
				itAnularPausada.setEnabled(false);
				itPausar.setEnabled(true);
				itFinalizar.setEnabled(true);
				itAddArticulos.setEnabled(true);
			}
			else if(entradaSeleccionada.getEstadoEntrada().equals("Pausada")){
				itReanudar.setEnabled(true);
				itAnularPausada.setEnabled(true);
				itPausar.setEnabled(false);
				itFinalizar.setEnabled(false);
				itAddArticulos.setEnabled(false);
			}
			else{
				itReanudar.setEnabled(false);
				itAnularPausada.setEnabled(false);
				itPausar.setEnabled(false);
				itFinalizar.setEnabled(false);
				itAddArticulos.setEnabled(false);
			}
			mOpcionEntradas.show(tablaEntradas, e.getX(), e.getY());
		}
		}
	else if(pestaEntradaSalida.getSelectedIndex()==1){//pestaña salida
		if(e.getButton()==3){//Boton Derecho del raton
			int row = tablaSalidas.rowAtPoint(e.getPoint());
			tablaSalidas.changeSelection(row,-1,false,false);
		}
		nFila=tablaSalidas.getSelectedRow();
		vFila = new Vector();
		vFila=(Vector)datosSalidas.elementAt(nFila);
		Salida salidaSeleccionada = new Salida();
		salidaSeleccionada.setCodSalida(Integer.parseInt((String)vFila.get(0)));
		salidaSeleccionada.setFechaSalida((String)vFila.get(1));
		salidaSeleccionada.setHoraSalida((String)vFila.get(2));
		salidaSeleccionada.setEstadoSalida((String)vFila.get(3));
		salidaSeleccionada.setFechaFinSalida((String)vFila.get(4));
		salidaSeleccionada.setHoraFinSalida((String)vFila.get(5));
		salidaSeleccionada.setTiempoSalida((String)vFila.get(6));
		
		if(e.getButton()==3){//Boton Derecho del raton
			if(salidaSeleccionada.getEstadoSalida().equals("Iniciada")){
				itReanudarS.setEnabled(false);
				itAnularSPausada.setEnabled(false);
				itPausarS.setEnabled(true);
				itFinalizarS.setEnabled(true);
				itAddArticulosS.setEnabled(true);
			}
			else if(salidaSeleccionada.getEstadoSalida().equals("Pausada")){
				itReanudarS.setEnabled(true);
				itAnularSPausada.setEnabled(true);
				itPausarS.setEnabled(false);
				itFinalizarS.setEnabled(false);
				itAddArticulosS.setEnabled(false);
			}
			else{
				itReanudarS.setEnabled(false);
				itAnularSPausada.setEnabled(false);
				itPausarS.setEnabled(false);
				itFinalizarS.setEnabled(false);
				itAddArticulosS.setEnabled(false);
			}
			mOpcionSalidas.show(tablaSalidas, e.getX(), e.getY());
		}
	}
		

		
		
	}//mouseclicked

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
