package Ventanas;
import java.awt.BorderLayout;
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
public class VentanaVerEstadisticas extends javax.swing.JFrame implements ActionListener{
	private JScrollPane scrollEstadisticas;
	private JTable tablaEstadisticas;
	private JLabel labelEstadisticas;
	private JButton botonVolverEstadistica;
	private JLabel labelFechaFin;
	private JLabel labelFechaInicio;
	private JButton botonVerGrafica;
	private JButton botonObtenerEstadistica;
	private JComboBox comboDiaFechaFin;
	private JComboBox comboAnyoFechaFin;
	private JComboBox comboMesFechaFin;
	private JComboBox comboAnyoFechaInicial;
	private JComboBox comboMesFechaInicial;
	private JComboBox comboDiaFechaInicial;
	private Vector cabeceraEstadistica=new Vector();
	public static Vector datosEstadistica=new Vector();
	public static String fechaInicio,fechaFin; 

	public VentanaVerEstadisticas() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setLayout(null);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/stats_8.GIF")).getImage());
			this.setTitle("Estadísticas");
			this.setSize(794, 399);
			this.setLocationRelativeTo(null);
			this.getContentPane().setBackground(new java.awt.Color(204,230,230));
			this.setResizable(false);
			{
				scrollEstadisticas = new JScrollPane();
				this.getContentPane().add(scrollEstadisticas, BorderLayout.CENTER);
				scrollEstadisticas.setPreferredSize(new java.awt.Dimension(392, 224));
				scrollEstadisticas.setBounds(9, 38, 769, 201);
				{
					cargarVEstadisticas("00/00/00","00/00/00");
					tablaEstadisticas = new JTable(datosEstadistica,cabeceraEstadistica) {
						public boolean isCellEditable(
							int row,
							int column) {
							return false;
						}
					};
					scrollEstadisticas.setViewportView(tablaEstadisticas);
				}
			}
			{
				botonObtenerEstadistica = new JButton();
				this.getContentPane().add(botonObtenerEstadistica);
				botonObtenerEstadistica.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/stats_8.gif")));
				botonObtenerEstadistica.setText("Obtener estadística");
				botonObtenerEstadistica.setBounds(147, 326, 180, 30);
				botonObtenerEstadistica.addActionListener(this);
			}
			{
				botonVerGrafica = new JButton();
				this.getContentPane().add(botonVerGrafica);
				botonVerGrafica.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ventanas/is_a4af.gif")));
				botonVerGrafica.setText("Ver gráfica");
				botonVerGrafica.setBounds(335, 327, 185, 30);
				botonVerGrafica.addActionListener(this);
				botonVerGrafica.setEnabled(false);
			}
			{
				labelFechaInicio = new JLabel();
				this.getContentPane().add(labelFechaInicio);
				labelFechaInicio.setText("Fecha inicial DD/MM/AA");
				labelFechaInicio.setBounds(20, 250, 144, 20);
			}
			{
				labelFechaFin = new JLabel();
				this.getContentPane().add(labelFechaFin);
				labelFechaFin.setText("Fecha final DD/MM/AA");
				labelFechaFin.setBounds(219, 253, 155, 17);
			}
			{
				botonVolverEstadistica = new JButton();
				this.getContentPane().add(botonVolverEstadistica);
				botonVolverEstadistica.setText("Volver");
				botonVolverEstadistica.setBounds(529, 327, 98, 30);
				botonVolverEstadistica.addActionListener(this);
			}
			{
				labelEstadisticas = new JLabel();
				this.getContentPane().add(labelEstadisticas);
				labelEstadisticas.setText("Estadística: Rendimiento de los operarios");
				labelEstadisticas.setBounds(14, 7, 509, 25);
			}
			{
				ComboBoxModel comboDiaFechaInicialModel = new DefaultComboBoxModel(
					new String[] { "01", "02","03","04","05","06","07","08","09","10","11","12" 
							,"13", "14","15","16","17","18","19","20","21","22","23","24"
							,"25","26","27","28","29","30","31"});
				comboDiaFechaInicial = new JComboBox();
				this.getContentPane().add(comboDiaFechaInicial);
				comboDiaFechaInicial.setModel(comboDiaFechaInicialModel);
				comboDiaFechaInicial.setBounds(18, 277, 50, 18);
			}
			{
				ComboBoxModel comboMesFechaInicialModel = new DefaultComboBoxModel(
					new String[] { "01", "02","03","04","05","06","07","08","09","10","11","12" });
				comboMesFechaInicial = new JComboBox();
				this.getContentPane().add(comboMesFechaInicial);
				comboMesFechaInicial.setModel(comboMesFechaInicialModel);
				comboMesFechaInicial.setBounds(74, 277, 50, 18);
				comboMesFechaInicial.addActionListener(this);
			}
			{
				ComboBoxModel comboAnyoFechaInicialModel = new DefaultComboBoxModel(
					new String[] {"06","07", "08","09", "10","11"});
				comboAnyoFechaInicial = new JComboBox();
				this.getContentPane().add(comboAnyoFechaInicial);
				comboAnyoFechaInicial.setModel(comboAnyoFechaInicialModel);
				comboAnyoFechaInicial.setBounds(131, 277, 50, 18);
			}
			{
				ComboBoxModel comboDiaFechaFinModel = new DefaultComboBoxModel(
					new String[] { "01", "02","03","04","05","06","07","08","09","10","11","12" 
							,"13", "14","15","16","17","18","19","20","21","22","23","24"
							,"25","26","27","28","29","30","31" });
				comboDiaFechaFin = new JComboBox();
				this.getContentPane().add(comboDiaFechaFin);
				comboDiaFechaFin.setModel(comboDiaFechaFinModel);
				comboDiaFechaFin.setBounds(217, 279, 50, 18);
			}
			{
				ComboBoxModel comboMesFechaFinModel = new DefaultComboBoxModel(
					new String[] { "01", "02","03","04","05","06","07","08","09","10","11","12" });
				comboMesFechaFin = new JComboBox();
				this.getContentPane().add(comboMesFechaFin);
				comboMesFechaFin.setModel(comboMesFechaFinModel);
				comboMesFechaFin.setBounds(274, 279, 50, 18);
				comboMesFechaFin.addActionListener(this);
			}
			{
				ComboBoxModel comboAnyoFechaFinModel = new DefaultComboBoxModel(
					new String[] { "06","07", "08","09","10","11" });
				comboAnyoFechaFin = new JComboBox();
				this.getContentPane().add(comboAnyoFechaFin);
				comboAnyoFechaFin.setModel(comboAnyoFechaFinModel);
				comboAnyoFechaFin.setBounds(331, 279, 50, 18);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private Vector cargarDatosEstadistica(String fechaI,String fechaF){
		Vector timepoOperariosEntradas =GestionBD.obtenerTiempoMinutosOperariosEntradas(fechaI,fechaF);
		Vector tiempoOperariosSalidas = GestionBD.obtenerTiempoMinutosOperariosSalidas(fechaI,fechaF);
		Vector todo= new Vector();
		Vector Vresultado= new Vector();
		//*****************************************
		for(int i=0;i<timepoOperariosEntradas.size();i++){
			int codOp=Integer.parseInt(""+((Vector)(timepoOperariosEntradas.get(i))).get(0));
			if (todo.isEmpty()){
				Vector aux = new Vector();
				aux.add(0,""+codOp);
				aux.add(1,""+GestionBD.obtenerNumeroEntradasOperario(codOp,fechaI,fechaF));
				aux.add(2,"0");
				aux.add(3,"0");
				todo.add(aux);
			}
			else{	
				for(int j =0;j<todo.size();j++){
					boolean yaIntroducido=false;
					for(int k=0;k<todo.size();k++){
						if (codOp==Integer.parseInt(""+((Vector)todo.get(k)).get(0))){
							yaIntroducido=true;
						}
					}
					if (!yaIntroducido){
						Vector auxi = new Vector();
						auxi.add(0,""+codOp);
						auxi.add(1,""+GestionBD.obtenerNumeroEntradasOperario(codOp,fechaI,fechaF));
						auxi.add(2,"0");
						auxi.add(3,"0");
						todo.add(auxi);
				}
			}
		}
		}
        //*****************************************
		//timepoOperariosEntradas con los tiempo y los codigos de las entradas
		//todo con los operarios sin repetir y el numero de entradas
		for(int h=0;h<timepoOperariosEntradas.size();h++){
			int codOph = Integer.parseInt(""+((Vector)timepoOperariosEntradas.get(h)).get(0));
			int tiempoh = Integer.parseInt(""+((Vector)timepoOperariosEntradas.get(h)).get(1));
			int codEnth = Integer.parseInt(""+((Vector)timepoOperariosEntradas.get(h)).get(2));
			for(int tod=0;tod<todo.size();tod++){
				Vector lineaTodo=(Vector)todo.get(tod);
				int codOpTodo=Integer.parseInt(""+lineaTodo.get(0));
				if(codOpTodo==codOph){
					((Vector)todo.get(tod)).set(2,""+(GestionBD.obtenerNumeroArticulosEntrada(codEnth)+(Integer.parseInt(""+((Vector)todo.get(tod)).get(2)))));//numero total de articulos
					((Vector)todo.get(tod)).set(3,""+(tiempoh+Integer.parseInt(""+((Vector)todo.get(tod)).get(3))));//tiempoMinutos
				}
			}
		}
		//*************************************************for
		Vector todoSalida= new Vector();
		for(int i=0;i<tiempoOperariosSalidas.size();i++){
			int codOp=Integer.parseInt(""+((Vector)(tiempoOperariosSalidas.get(i))).get(0));
			if (todoSalida.isEmpty()){
				Vector aux = new Vector();
				aux.add(0,""+codOp);
				aux.add(1,""+GestionBD.obtenerNumeroSalidasOperario(codOp,fechaI,fechaF));
				aux.add(2,"0");
				aux.add(3,"0");
				todoSalida.add(aux);
			}
			else{	
				for(int j =0;j<todoSalida.size();j++){
					boolean yaIntroducido=false;
					for(int k=0;k<todoSalida.size();k++){
						if (codOp==Integer.parseInt(""+((Vector)todoSalida.get(k)).get(0))){
							yaIntroducido=true;
						}
					}
					if (!yaIntroducido){
						Vector auxi = new Vector();
						auxi.add(0,""+codOp);
						auxi.add(1,""+GestionBD.obtenerNumeroSalidasOperario(codOp,fechaI,fechaF));
						auxi.add(2,"0");
						auxi.add(3,"0");
						todoSalida.add(auxi);
				}
			}
		}
		}
        //*****************************************
		//timepoOperariosEntradas con los tiempo y los codigos de las entradas
		//todo con los operarios sin repetir y el numero de entradas
		for(int h=0;h<tiempoOperariosSalidas.size();h++){
			int codOph = Integer.parseInt(""+((Vector)tiempoOperariosSalidas.get(h)).get(0));
			int tiempoh = Integer.parseInt(""+((Vector)tiempoOperariosSalidas.get(h)).get(1));
			int codEnth = Integer.parseInt(""+((Vector)tiempoOperariosSalidas.get(h)).get(2));
			for(int tod=0;tod<todoSalida.size();tod++){
				Vector lineaTodo=(Vector)todoSalida.get(tod);
				int codOpTodo=Integer.parseInt(""+lineaTodo.get(0));
				if(codOpTodo==codOph){
					((Vector)todoSalida.get(tod)).set(2,""+(GestionBD.obtenerNumeroArticulosSalida(codEnth)+(Integer.parseInt(""+((Vector)todoSalida.get(tod)).get(2)))));//numero total de articulos
					((Vector)todoSalida.get(tod)).set(3,""+(tiempoh+Integer.parseInt(""+((Vector)todoSalida.get(tod)).get(3))));//tiempoMinutos
				}
			}
		}
		//ahora tengo el vector todo con la informacion estadistica de las entradas
		//y el vector todoSalida con la informacion estadistica de las salidas
		//tengo que juntarlos en un unico vector con toda la informacion
		//todo
		//todoSalida
		if(todo.isEmpty()){
			if(todoSalida.isEmpty()){
				Vresultado=new Vector();
			}
			else{
				for(int r=0;r<todoSalida.size();r++){
					String nombre=GestionBD.obtenerNombreOperario(Integer.parseInt(""+((Vector)todoSalida.get(r)).get(0)));
					((Vector)todoSalida.get(r)).set(0,nombre);
				}
				Vresultado= todoSalida;
			}		
		}
		if(todoSalida.isEmpty()){
			if(todo.isEmpty()){
				Vresultado=new Vector();
				
			}
			else{
				for(int r=0;r<todo.size();r++){
					String nombre=GestionBD.obtenerNombreOperario(Integer.parseInt(""+((Vector)todo.get(r)).get(0)));
					((Vector)todo.get(r)).set(0,nombre);
				}
				Vresultado= todo;
			}		
		}
		if(!todo.isEmpty() && !todoSalida.isEmpty()){
			
			boolean []existe = new boolean[todoSalida.size()];
			for(int e=0;e<todoSalida.size();e++){
				existe[e]=false;
			}
			for(int y=0;y<todo.size();y++){
				int codOp=Integer.parseInt(""+((Vector)todo.get(y)).get(0));
				int numES=Integer.parseInt(""+((Vector)todo.get(y)).get(1));
				int numArt=Integer.parseInt(""+((Vector)todo.get(y)).get(2));
				int minutos=Integer.parseInt(""+((Vector)todo.get(y)).get(3));
				for (int u=0;u<todoSalida.size();u++){
					if(Integer.parseInt(""+((Vector)todoSalida.get(u)).get(0))==codOp){
						((Vector)todo.get(y)).set(1,""+(numES+Integer.parseInt(""+((Vector)todoSalida.get(u)).get(1))));
						((Vector)todo.get(y)).set(2,""+(numArt+Integer.parseInt(""+((Vector)todoSalida.get(u)).get(2))));
						((Vector)todo.get(y)).set(3,""+(minutos+Integer.parseInt(""+((Vector)todoSalida.get(u)).get(3))));
						existe[u]=true;
					}
					
				}
			}
			for(int e=0;e<todoSalida.size();e++){
				if(!existe[e])
					todo.add(todoSalida.get(e));
			}
			
			for(int r=0;r<todo.size();r++){
				String nombre=GestionBD.obtenerNombreOperario(Integer.parseInt(""+((Vector)todo.get(r)).get(0)));
				((Vector)todo.get(r)).set(0,nombre);
			}
			Vresultado= todo;
		}
		return Vresultado;
	}
	private void cargarVEstadisticas(String fechaI,String fechaF) {
		cabeceraEstadistica= new Vector();
		cabeceraEstadistica.add("Nombre del operario");
		cabeceraEstadistica.add("Nº de entradas+salidas");
		cabeceraEstadistica.add("Nº de artículos entrados+salidos");
		cabeceraEstadistica.add("Minutos totales de trabajo");
		datosEstadistica=cargarDatosEstadistica(fechaI,fechaF);

	}
	public void actionPerformed (ActionEvent e){
		Object o = e.getSource();
		if (o==comboMesFechaInicial){
			String mesSeleccionado=(String)comboMesFechaInicial.getSelectedItem();
			if (mesSeleccionado.equals("02")){//febrero mes "especial"
				comboDiaFechaInicial.setModel(new DefaultComboBoxModel(
						new String[] { "01", "02","03","04","05","06","07","08","09","10","11","12" 
								,"13", "14","15","16","17","18","19","20","21","22","23","24"
								,"25","26","27","28"}));
		
				
			}
			else if(mesSeleccionado.equals("04") || 
			   mesSeleccionado.equals("06") ||
			   mesSeleccionado.equals("09") ||
			   mesSeleccionado.equals("11")){//meses de 30 dias
				
				comboDiaFechaInicial.setModel(new DefaultComboBoxModel(
						new String[] { "01", "02","03","04","05","06","07","08","09","10","11","12" 
								,"13", "14","15","16","17","18","19","20","21","22","23","24"
								,"25","26","27","28","29","30"}));
			}
			else{//meses de 31 dias
				comboDiaFechaInicial.setModel(new DefaultComboBoxModel(
						new String[] { "01", "02","03","04","05","06","07","08","09","10","11","12" 
								,"13", "14","15","16","17","18","19","20","21","22","23","24"
								,"25","26","27","28","29","30","31"}));
			}
		}
		else if (o==comboMesFechaFin){
			String mesSeleccionado=(String)comboMesFechaFin.getSelectedItem();
			if (mesSeleccionado.equals("02")){//febrero mes "especial"
				comboDiaFechaFin.setModel(new DefaultComboBoxModel(
						new String[] { "01", "02","03","04","05","06","07","08","09","10","11","12" 
								,"13", "14","15","16","17","18","19","20","21","22","23","24"
								,"25","26","27","28"}));
			}
			else if(mesSeleccionado.equals("04") || 
			   mesSeleccionado.equals("06") ||
			   mesSeleccionado.equals("09") ||
			   mesSeleccionado.equals("11")){//meses de 30 dias
				
				comboDiaFechaFin.setModel(new DefaultComboBoxModel(
						new String[] { "01", "02","03","04","05","06","07","08","09","10","11","12" 
								,"13", "14","15","16","17","18","19","20","21","22","23","24"
								,"25","26","27","28","29","30"}));
			}
			else{//meses de 31 dias
				comboDiaFechaFin.setModel(new DefaultComboBoxModel(
						new String[] { "01", "02","03","04","05","06","07","08","09","10","11","12" 
								,"13", "14","15","16","17","18","19","20","21","22","23","24"
								,"25","26","27","28","29","30","31"}));
			}
		}
		else if(o==botonObtenerEstadistica){
			fechaInicio=""+
			comboAnyoFechaInicial.getSelectedItem()+"/"+comboMesFechaInicial.getSelectedItem()+"/"+comboDiaFechaInicial.getSelectedItem();
			fechaFin=""+
				comboAnyoFechaFin.getSelectedItem()+"/"+comboMesFechaFin.getSelectedItem()+"/"+comboDiaFechaFin.getSelectedItem();
			int fI=Integer.parseInt(""+comboAnyoFechaInicial.getSelectedItem()+comboMesFechaInicial.getSelectedItem()+comboDiaFechaInicial.getSelectedItem());
			int fF=Integer.parseInt(""+comboAnyoFechaFin.getSelectedItem()+comboMesFechaFin.getSelectedItem()+comboDiaFechaFin.getSelectedItem());
			if(fF < fI){
				JOptionPane.showMessageDialog(this,"El intervalo de fechas introducido no es válido, la fecha final es anterior a la fecha inicial","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				Vector aux=new Vector();
				aux=cargarDatosEstadistica(fechaInicio,fechaFin);
				datosEstadistica.clear();
				for(int t=0;t<aux.size();t++){
					datosEstadistica.add(t,aux.get(t));
				}
				tablaEstadisticas.updateUI();
				if(datosEstadistica.isEmpty()){
					JOptionPane.showMessageDialog(this,"No se encontraron datos entre el "+comboDiaFechaInicial.getSelectedItem()+"/"+comboMesFechaInicial.getSelectedItem()+"/"+comboAnyoFechaInicial.getSelectedItem()+" y el "+comboDiaFechaFin.getSelectedItem()+"/"+comboMesFechaFin.getSelectedItem()+"/"+comboAnyoFechaFin.getSelectedItem());
					botonVerGrafica.setEnabled(false);
				}
				else{
					botonVerGrafica.setEnabled(true);
				}
			}
		}
		
		else if(o==botonVerGrafica){
			VentanaVerGrafico vGrafic = new VentanaVerGrafico();
			vGrafic.setVisible(true);
			vGrafic.setAlwaysOnTop(true);
		}
		else if(o==botonVolverEstadistica){
			this.setVisible(false);
		}
	}

}
