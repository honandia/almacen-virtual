package procesos;
import java.sql.*; 
import java.util.Vector;

import Ventanas.panelEntradaSalida;

import entidades.Entrada;
import entidades.Salida;
import entidades.Usuario;


public class GestionBD {
	
	public static Connection con;
	public static void IniciarBD() 
		{
			try {
				    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			    } 
			    catch (ClassNotFoundException e)
			     {
			  	     System.out.println("Peta el Driver de la BD");
			     }
			try {
				String url = "jdbc:odbc:BD_Almacen";
				con = DriverManager.getConnection(url, "", "");
			    }
			     catch (SQLException se) 
			     {
				    System.out.println("SQLException " + se.getMessage());
				    se.printStackTrace(System.out);}
			     }
			     
	public static void CerrarBD() 
		{
	     	try {
			     	con.close();
			    } 
			    catch (SQLException e) 
			    {
			      	e.getMessage();
				   e.printStackTrace();
			      }
		}//fin metodo CerrarBD
		public static void actualizarPassword(int codUsuario,String passNuevo){
			
			String cadena =new String("UPDATE Usuarios SET Password = '"+passNuevo+
					"' WHERE Codigo_Usuario = "+codUsuario);
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el actualizar password:"+cadena);
				excep.getMessage();
			}
			
		}
		public static String obtenerPassword(int codUsuario){
			String pass="";
			ResultSet res;
			String cadena = "SELECT Password FROM Usuarios WHERE Codigo_Usuario = "+codUsuario;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				pass=res.getString("Password");
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return pass;
		}  
		public static Usuario obtenerUsuario(String nombre, String password) {
			Usuario u = null;
			ResultSet res;
			String cadena = "SELECT * FROM Usuarios WHERE Nombre LIKE '" + nombre + "'AND Password LIKE '" + password + "'";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				u = new Usuario();
				u.setCodUsuario(res.getInt("Codigo_Usuario"));
				u.setNombre(res.getString("Nombre"));
				u.setPassword(res.getString("Password"));
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return u;
		}
		
		public static Vector obtenerEntradas() {
			Vector vEntradas = new Vector();
			ResultSet res;
			String cadena = "SELECT * FROM Entradas";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				   Vector aux = new Vector();
				  String cod =res.getString("Codigo_Entrada");
				  String fecha=res.getString("Fecha_Entrada");
				 
				  String fechaFormateada= 
					  ""+fecha.charAt(6)+fecha.charAt(7)+"/"+fecha.charAt(3)+fecha.charAt(4)+"/"+fecha.charAt(0)+fecha.charAt(1);
				 
				  String hora=res.getString("Hora_Entrada");
				  String estado=res.getString("Estado_Entrada");
				  String fechafin=res.getString("Fecha_fin_entrada");
				  String horafin=res.getString("Hora_fin_Entrada");
				  String tiempo =res.getString("Tiempo_Entrada");
				  String codOp = res.getString("Codigo_Operario");
				  
				  aux.add(cod);
				  aux.add(fechaFormateada);
				  aux.add(hora);
				  aux.add(estado);
				  aux.add(fechafin);
				  aux.add(horafin);
				  aux.add(tiempo);
				  aux.add(codOp);
				  vEntradas.add(aux);
				
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return vEntradas;
		}
		//obtenerSalidas()
		public static Vector obtenerSalidas() {
			Vector vSalidas = new Vector();
			ResultSet res;
			String cadena = "SELECT * FROM Salidas";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				   Vector aux = new Vector();
				  String cod =res.getString("Codigo_Salida");
				  String fecha=res.getString("Fecha_salida");
				  String fechaFormateada= 
					  ""+fecha.charAt(6)+fecha.charAt(7)+"/"+fecha.charAt(3)+fecha.charAt(4)+"/"+fecha.charAt(0)+fecha.charAt(1);
				  String hora=res.getString("Hora_salida");
				  String estado=res.getString("Estado_salida");
				  String fechafin=res.getString("Fecha_fin_salida");
				  String horafin=res.getString("Hora_fin_salida");
				  String tiempo =res.getString("Tiempo_salida");
				  String codOp = res.getString("Codigo_Operario");
				  
				  aux.add(cod);
				  aux.add(fechaFormateada);
				  aux.add(hora);
				  aux.add(estado);
				  aux.add(fechafin);
				  aux.add(horafin);
				  aux.add(tiempo);
				  aux.add(codOp);
				  vSalidas.add(aux);
				
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return vSalidas;
		}
		
		public static void insertarEntrada(Entrada e){
			//
			String cadena =new String("INSERT INTO Entradas(Fecha_entrada,Hora_entrada,Estado_entrada,Fecha_fin_entrada,Hora_fin_entrada,Tiempo_entrada,Codigo_Operario) VALUES ('"
					+e.getFechaEntrada()+"','"+e.getHoraEntrada()+"','"+e.getEstadoEntrada()+"','"
					+ e.getFechaFinEntrada()+"','"+e.getHoraFinEntrada()+"','"+e.getTiempoEntrada()
					+"',"+e.getCodOperario()+")");
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el insertar entrada:"+cadena);
				excep.getMessage();
			}
		}
		//insetarSalida()
		public static void insertarSalida(Salida s){
			//
			String cadena =new String("INSERT INTO Salidas(Fecha_salida,Hora_salida,Estado_salida,Fecha_fin_salida,Hora_fin_salida,Tiempo_salida,Codigo_Operario) VALUES ('"
					+s.getFechaSalida()+"','"+s.getHoraSalida()+"','"+s.getEstadoSalida()+"','"
					+ s.getFechaFinSalida()+"','"+s.getHoraFinSalida()+"','"+s.getTiempoSalida()
					+"',"+s.getCodOperario()+")");
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el insertar salida:"+cadena);
				excep.getMessage();
			}
		}
		public static String obtenerCodUltimaEntrada () {
			String cadena =new String("SELECT MAX(Codigo_Entrada) AS MaxCod FROM Entradas");
			String codE="";
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				codE =res.getString("MaxCod");
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage());
				eXcp.printStackTrace(System.out);
			}
			return codE;
			
		}
		//obtenerCodUltimaSalida()
		public static String obtenerCodUltimaSalida() {
			String cadena =new String("SELECT MAX(Codigo_Salida) AS MaxCod FROM Salidas");
			String codS="";
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				codS =res.getString("MaxCod");
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage());
				eXcp.printStackTrace(System.out);
			}
			return codS;
			
		}
		
		public static void modificarEstadoEntrada(Entrada e) {
			Statement stmt = null;
			String cadena =
				"UPDATE Entradas SET Estado_entrada='"+ e.getEstadoEntrada()+
				"',Fecha_fin_entrada='" +e.getFechaFinEntrada()+
				"',Hora_fin_entrada='"+e.getHoraFinEntrada()+
				"' ,Tiempo_Entrada= '"+e.getTiempoEntrada()+
				"' WHERE Codigo_Entrada ="+ e.getCodEntrada();
			try {
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
				stmt.close();
			} catch (SQLException s) {
				s.printStackTrace();
				System.out.println(s.getMessage());
			}

		}
		//modificarEstadoSalida(salidaPausada)
		public static void modificarEstadoSalida(Salida sal) {
			Statement stmt = null;
			String cadena =
				"UPDATE Salidas SET Estado_salida='"+ sal.getEstadoSalida()+
				"',Fecha_fin_salida='" +sal.getFechaFinSalida()+
				"',Hora_fin_salida='"+sal.getHoraFinSalida()+
				"' ,Tiempo_salida = '"+sal.getTiempoSalida()+
				"' WHERE Codigo_Salida ="+ sal.getCodSalida();
			try {
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
				stmt.close();
			} catch (SQLException s) {
				s.printStackTrace();
				System.out.println(s.getMessage());
			}

		}
		public static Vector obtenerCategorias(){
			
			Vector aux= new Vector();
			ResultSet res;
			String cadena = "SELECT Nombre_Categoria FROM Categorias";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				  String nombre=res.getString("Nombre_Categoria");
				  aux.add(nombre);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return aux;
		}
		//obtenerCategoriasTree()
		public static Vector obtenerCategoriasTree(){
			
			Vector aux= new Vector();
			ResultSet res;
			String cadena = "SELECT Nombre_Categoria FROM Categorias " +
					"WHERE Categoria_padre = 3";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				  String nombre=res.getString("Nombre_Categoria");
				  aux.add(nombre);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return aux;
		}
		//obtenerSubCategorias(""+vCategorias.get(i));
		public static Vector obtenerSubCategorias(String categoria){
			int codigoCat=GestionBD.obtenerCodigoCategoria(categoria);
			Vector aux= new Vector();
			aux.add("Subcategorías");
			ResultSet res;
			String cadena = "SELECT Nombre_Categoria FROM Categorias " +
					"WHERE Categoria_padre = "+codigoCat;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){
				  String nombre=res.getString("Nombre_Categoria");
				  aux.add(nombre);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return aux;
		}
		//esCategoriaDiponible()
		public static boolean esCategoriaDiponible(int codCat){
			boolean existe= false;
			String cadena =new String("SELECT Codigo_Categoria FROM Articulos WHERE " +
					"Codigo_Categoria = "+codCat+" AND" +
					" Stock_total_actual > 0");
			
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				existe=true;
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return existe;
		}
		//obtenerCategoriasDisponibles()
		public static Vector obtenerCategoriasDisponibles(){
			
			Vector aux= new Vector();
			ResultSet res;
			String cadena = "SELECT Nombre_Categoria FROM Categorias";
			//esCategoriaDiponible(int codCat)
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				  String nombre=res.getString("Nombre_Categoria");
				  if(esCategoriaDiponible(GestionBD.obtenerCodigoCategoria(nombre))){
					  aux.add(nombre);
				  }
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return aux;
		}
		/*public static int obtenerDescArticulo(int codArt){
			ResultSet res;
			String cadena = "SELECT Descripcion_Categoria FROM Categorias WHERE Nombre_Categoria='"
				+nombreCat+"'";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				  codigo=res.getInt("Codigo_Categoria");
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return codigo;
		}*/
		public static int obtenerCodigoCategoria(String nombreCat){
			
			int codigo=0;
			ResultSet res;
			String cadena = "SELECT Codigo_Categoria FROM Categorias WHERE Nombre_Categoria='"
				+nombreCat+"'";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				  codigo=res.getInt("Codigo_Categoria");
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return codigo;
		}
		public static int obtenerCodigoArticulo(String nombreArt){
			
			int codigo=0;
			ResultSet res;
			String cadena = "SELECT Codigo_Articulo FROM Articulos WHERE Descripcion_Articulo='"
				+nombreArt+"'";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				  codigo=res.getInt("Codigo_Articulo");
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return codigo;
		} 
		//obtenerArticulos()
		public static Vector obtenerArticulos(){
			Vector articulos= new Vector();
			ResultSet res;
			String cadena=new String();
				cadena = "SELECT * FROM Articulos";
			
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				  Vector aux= new Vector();
				  String codArt=res.getString("Codigo_Articulo");
				  String nombre=res.getString("Descripcion_Articulo");
				  String categoria=GestionBD.obtenerNombreCategoria(Integer.parseInt(res.getString("Codigo_Categoria")));
				  String stock=res.getString("Stock_total_actual");
				  aux.add(codArt);
				  aux.add(nombre);
				  aux.add(categoria);
				  aux.add(stock);
				  articulos.add(aux);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return articulos;
		}
		public static Vector obtenerArticulosCategoria(String categoria){
			Vector articulos= new Vector();
			int codigoCat = GestionBD.obtenerCodigoCategoria(categoria);
			ResultSet res;
			String cadena=new String();
			if(codigoCat==3){
				cadena = "SELECT Descripcion_Articulo FROM Articulos";
			}
			else{
				cadena = "SELECT Descripcion_Articulo FROM Articulos WHERE Codigo_Categoria="+ codigoCat;
			}
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				  String nombre=res.getString("Descripcion_Articulo");
				  articulos.add(nombre);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return articulos;
		}
		//obtenerArticulosConStock((String)comboCategoriaArtS.getSelectedItem())
		public static Vector obtenerArticulosConStock(String categoria){
			Vector articulos= new Vector();
			int codigoCat = GestionBD.obtenerCodigoCategoria(categoria);
			ResultSet res;
			String cadena=new String();
			if(codigoCat==3){
				cadena = "SELECT Descripcion_Articulo FROM Articulos " +
						"WHERE Stock_total_actual > 0";
			}
			else{
				cadena = "SELECT Descripcion_Articulo FROM Articulos " +
						"WHERE Codigo_Categoria="+ codigoCat+
						" AND Stock_Total_actual > 0";
			}
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				  String nombre=res.getString("Descripcion_Articulo");
				  articulos.add(nombre);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return articulos;
		}
		//obtenerStockArticulo()
		public static int obtenerStockArticulo(String articulo){
			int stockArticulo=0;
			ResultSet res;
			String cadena=new String("SELECT Stock_total_actual FROM Articulos" +
					" WHERE Descripcion_Articulo = '"+articulo+"'");
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				  stockArticulo = res.getInt("Stock_total_actual");
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return stockArticulo;
		}
		//obtenerStocksActualesEntrada
		public static Vector obtenerStocksActualesEntrada(int codEnt){
			Vector vStockEntrada=new Vector();
			ResultSet res;
			String cadena=new String("SELECT * FROM StockArticulos " +
					" WHERE Codigo_Entrada = "+codEnt);
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
					Vector aux = new Vector();
					String codArt = res.getString("Codigo_Articulo");
					String codLoc = res.getString("Codigo_Localizacion");
					String stock = res.getString("Stock_actual");
					String codE = res.getString("Codigo_Entrada");
					String codSal = res.getString("Codigo_Salida");
					aux.add(codArt);
					aux.add(codLoc);
					aux.add(stock);
					aux.add(codE);
					aux.add(codSal);
					vStockEntrada.add(aux);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return vStockEntrada;
		}
		public static void insertarCategoria(String nombre, int padre){
			String cadena =new String("INSERT INTO Categorias(Nombre_Categoria,Categoria_padre) VALUES ('"+nombre+"',"+padre+")");
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el insertar categoria:"+cadena);
				excep.getMessage();
			}
		}
		public static Vector obtenerPasillos(){
			Vector pasillos= new Vector();
			ResultSet res;
			String cadena=new String();
			cadena = "SELECT Pasillo FROM Localizaciones GROUP BY Pasillo";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				  String pasillo=res.getString("Pasillo");
				  pasillos.add(pasillo);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return pasillos;
			
		}
		public static Vector obtenerArmariosPasillo(String pasillo){
			Vector armarios= new Vector();
			ResultSet res;
			String cadena=new String();
			cadena = "SELECT Armario FROM Localizaciones WHERE Pasillo='"+pasillo+"' GROUP BY Armario";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				  String armario=res.getString("Armario");
				  armarios.add(armario);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return armarios;	
		}
		public static Vector obtenerBaldasPasilloArmario(String pasillo, String armario){
			Vector baldas= new Vector();
			ResultSet res;
			String cadena=new String();
			cadena = "SELECT Balda FROM Localizaciones WHERE Pasillo='"+pasillo+"'AND Armario='"+armario+
					"'GROUP BY Balda";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				  String balda=res.getString("Balda");
				  baldas.add(balda);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return baldas;	
		}
		//obtenerBaldasPasilloArmarioParaTree
		public static Vector obtenerBaldasPasilloArmarioParaTree(String pasillo, String armario){
			Vector baldas= new Vector();
			baldas.add("Baldas");
			ResultSet res;
			String cadena=new String();
			cadena = "SELECT Balda FROM Localizaciones WHERE Pasillo='"+pasillo+"'AND Armario='"+armario+
					"'GROUP BY Balda";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				  String balda=res.getString("Balda");
				  baldas.add(balda);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return baldas;	
		}
		public static void insertarArticulo(String nombre, int codCat){
			String cadena =new String("INSERT INTO Articulos" +
					"(Descripcion_Articulo,Codigo_Categoria,Stock_total_actual) " +
					"VALUES ('"+nombre+"',"+codCat+",0)");
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el insertar articulo:"+cadena);
				excep.getMessage();
			}
		}
		//ORDEN
		public static int obtenerOrdenLineaEntrada (int codEnt) {//SELECT Max(Gastos) AS ElMax FROM Pedidos WHERE Pais  = 'España'; 
			String cadena =new String("SELECT MAX(Orden) AS MaxOrd FROM LineasEntradas WHERE " +
					"Codigo_Entrada = "+codEnt);
			int ord=0;
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				ord =res.getInt("MaxOrd");
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return (ord+1);
			
		}
		//obtenerOrdenLineaSalida(codSal)
		public static int obtenerOrdenLineaSalida (int codSal) {//SELECT Max(Gastos) AS ElMax FROM Pedidos WHERE Pais  = 'España'; 
			String cadena =new String("SELECT MAX(Orden) AS MaxOrd FROM LineasSalidas WHERE " +
					"Codigo_Salida = "+codSal);
			int ord=0;
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				ord =res.getInt("MaxOrd");
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return (ord+1);
			
		}
		public static int obtenerCodigoLocalizacion(String pasillo,String armario,String balda){
			
			int codigo=0;
			ResultSet res;
			String cadena = "SELECT Codigo_Localizacion FROM Localizaciones WHERE " +
					"Pasillo ='"+pasillo+"'AND "
					+"Armario ='"+armario+"' AND "
					+"Balda ='"+balda+"'";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				  codigo=res.getInt("Codigo_Localizacion");
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return codigo;
		}
		//GestionBD.obtenerLocalizacionesConArticulo()
		public static Vector obtenerLocalizacionesConArticulo(String articulo){
			Vector localizaciones= new Vector();
			int codArt =GestionBD.obtenerCodigoArticulo(articulo);
			ResultSet res;
			String cadena=new String();
			cadena = "SELECT Codigo_Localizacion FROM StockArticulos " +
					"WHERE Codigo_Articulo= "+codArt+
					" GROUP BY Codigo_Localizacion";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				  String codLoc=res.getString("Codigo_Localizacion");
				  localizaciones.add(codLoc);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return localizaciones;	
		}
		public static int sumarStocksActuales(int codArt){
			int suma=0;
			String cadena =new String("SELECT SUM(Stock_Actual) AS SumStock FROM StockArticulos WHERE " +
					"Codigo_Articulo = "+codArt);
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				suma =res.getInt("SumStock");
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return suma;
		}
		public static int sumarStocksActualesLocalizacion(int codArt,int codLoc){
			int suma=0;
			String cadena =new String("SELECT SUM(Stock_Actual) AS SumStock FROM StockArticulos WHERE " +
					"Codigo_Articulo = "+codArt+" AND " +
					"Codigo_Localizacion = "+codLoc);
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				suma =res.getInt("SumStock");
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return suma;
		}
		
		public static void actualizarStockTotalArticulo(int codArt){
			int sumaStocksActuales= sumarStocksActuales(codArt);
			String cadena =new String("UPDATE Articulos SET Stock_total_actual= "
					+sumaStocksActuales+" WHERE Codigo_Articulo = "+codArt);
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el actualizar stock total articulo entrada:"+cadena);
				excep.getMessage();
			}
			
		}
		public static void actualizarTodosStockTotalArticulo(){
			String cadena =new String("SELECT Codigo_Articulo FROM Articulos");
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
					int codArt = res.getInt("Codigo_Articulo");
					actualizarStockTotalArticulo(codArt);
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			
		}
		public static boolean existeStockActualEntrada(int codArt,int codLoc, int codEnt){
			boolean existe= false;
			String cadena =new String("SELECT Stock_actual FROM StockArticulos WHERE " +
					"Codigo_Articulo = "+codArt+" AND " +
					"Codigo_Localizacion = "+codLoc+" AND " +
					"Codigo_Entrada = "+codEnt);
			
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				existe=true;
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return existe;
		}
		//GestionBD.hayArticulosAlmacen()
		public static boolean hayArticulosAlmacen(){
			boolean hay= false;
			String cadena =new String("SELECT * FROM Articulos WHERE " +
					" Stock_Total_actual > 0");
			
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				hay=true;
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return hay;
		}
//		existeStockActualSalida(codArt,codLoc,codSal)
		public static boolean existeStockActualSalida(int codArt,int codLoc, int codSal){
			boolean existe= false;
			String cadena =new String("SELECT Stock_actual FROM StockArticulos WHERE " +
					"Codigo_Articulo = "+codArt+" AND " +
					"Codigo_Localizacion = "+codLoc+" AND " +
					"Codigo_Salida = "+codSal);
			
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				existe=true;
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return existe;
		}
		public static void insertarStockActual(int codArt,int codLoc,int numArt,int codEnt){
			String cadena =new String("INSERT INTO StockArticulos " +
					"(Codigo_Articulo, Codigo_Localizacion, Stock_Actual, Codigo_Entrada) VALUES ("+
					codArt+","+codLoc+","+numArt+","+codEnt+")");
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el insertar stock actual articulo entrada:"+cadena);
				excep.getMessage();
			}
		}
		public static void insertarStockActualSalida(int codArt,int codLoc,int numArt,int codSal){
			String cadena =new String("INSERT INTO StockArticulos " +
					"(Codigo_Articulo, Codigo_Localizacion, Stock_Actual, Codigo_Salida) VALUES ("+
					codArt+","+codLoc+","+numArt+","+codSal+")");
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el insertar stock actual articulo salida:"+cadena);
				excep.getMessage();
			}
		}
		public static void actualizarStockActualArticuloEntrada(int codArt,int codLoc,int numArt,int codEnt){
			String cadena =new String("UPDATE StockArticulos SET Stock_actual= Stock_actual + "
					+numArt+" WHERE Codigo_Articulo = "+codArt
					+" AND Codigo_Localizacion = "+codLoc+
					" AND Codigo_Entrada = " +codEnt);
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el actualizar stock actual articulo entrada:"+cadena);
				excep.getMessage();
			}
			
		}
		public static void actualizarStockActualArticuloSalida(int codArt,int codLoc,int numArt,int codSal){
			String cadena =new String("UPDATE StockArticulos SET Stock_actual= Stock_actual + "
					+numArt+" WHERE Codigo_Articulo = "+codArt
					+" AND Codigo_Localizacion = "+codLoc+
					" AND Codigo_Salida = " +codSal);
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el actualizar stock actual articulo salida:"+cadena);
				excep.getMessage();
			}
			
		}
		public static void insertarLineaEntrada(int codEnt, int codArt,int numArt,int codLoc,int codOp){
			int orden = GestionBD.obtenerOrdenLineaEntrada(codEnt);
			
			if (existeStockActualEntrada(codArt,codLoc,codEnt)){
				actualizarStockActualArticuloEntrada(codArt,codLoc,numArt,codEnt);
			}
			else{
				insertarStockActual(codArt,codLoc,numArt,codEnt);
			}
			
			actualizarStockTotalArticulo(codArt);
			String cadena =new String("INSERT INTO LineasEntradas VALUES ("
					+codEnt+","+orden+","+codArt+","+numArt+","+codLoc+","+codOp+")");
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el insertar Linea de Entrada:"+cadena);
				excep.getMessage();
			}
		}
		//public static void insertarLineaSalida(int codSal, int codArt,int numArt,int codLoc,int codOp)
		public static void insertarLineaSalida(int codSal, int codArt,int numArt,int codLoc,int codOp){
			int orden = GestionBD.obtenerOrdenLineaSalida(codSal);
			if (existeStockActualSalida(codArt,codLoc,codSal)){
				actualizarStockActualArticuloSalida(codArt,codLoc,numArt,codSal);
			}
			else{
				insertarStockActualSalida(codArt,codLoc,numArt,codSal);
			}
			
			actualizarStockTotalArticulo(codArt);
			String cadena =new String("INSERT INTO LineasSalidas VALUES ("
					+codSal+","+orden+","+codArt+","+numArt+","+codLoc+","+codOp+")");
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el insertar Linea de Salida:"+cadena);
				excep.getMessage();
			}
		}
		public static String obtenerTipo (int codOp) { 
			String cadena =new String("SELECT Tipo FROM Operarios WHERE " +
					"Codigo_Operario = "+codOp);
			String tipo="Operario no encontrado";
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				tipo =res.getString("Tipo");
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return tipo;
			
		}
		public static int obtenerCodOperarioEntrada (int codEnt) { 
			String cadena =new String("SELECT Codigo_Operario FROM Entradas WHERE " +
					"Codigo_Entrada = "+codEnt);
			int codOp=0;
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				codOp =res.getInt("Codigo_Operario");
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return codOp;
			
		}
		//obtenerCodOperarioSalida()
		public static int obtenerCodOperarioSalida (int codSal) { 
			String cadena =new String("SELECT Codigo_Operario FROM Salidas WHERE " +
					"Codigo_Salida = "+codSal);
			int codOp=0;
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				codOp =res.getInt("Codigo_Operario");
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return codOp;
			
		}
		public static String obtenerNombreOperario (int codOp) { 
			String cadena =new String("SELECT Nombre FROM Operarios WHERE " +
					"Codigo_Operario = "+codOp);
			String nombre="Operario no encontrado";
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				nombre =res.getString("Nombre");
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return nombre;
			
		}
		public static String obtenerNombreUsuario (int codUser) { 
			String cadena =new String("SELECT Nombre FROM Usuarios WHERE " +
					"Codigo_Usuario = "+codUser);
			String nombre="Operario no encontrado";
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				nombre =res.getString("Nombre");
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return nombre;
			
		}
		//obtenerDescArticulo
		public static String obtenerDescArticulo (int codArt) { 
			String cadena =new String("SELECT Descripcion_Articulo FROM Articulos" +
					" WHERE Codigo_Articulo = "+codArt);
			String nombre="Descripcion no encontrada";
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				nombre =res.getString("Descripcion_Articulo");
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return nombre;
			
		}
		//obtenerDescCategoria
		public static String obtenerNombreCategoria (int codCat) { 
			String cadena =new String("SELECT Nombre_Categoria FROM Categorias" +
					" WHERE Codigo_Categoria = "+codCat);
			String nombre="Descripcion no encontrada";
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				nombre =res.getString("Nombre_Categoria");
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return nombre;
			
		}
		public static Vector obtenerInfoLineasEntradas(int codEnt){
			Vector vInfo= new Vector();
			ResultSet res;
			String cadena=new String();
			cadena = "SELECT Orden, Codigo_Articulo, Numero_Articulos FROM LineasEntradas " +
					"WHERE Codigo_Entrada="+codEnt;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
					Vector aux = new Vector();
					String orden =res.getString("Orden");
					int cod_art=res.getInt("Codigo_Articulo");
					String num=res.getString("Numero_Articulos"); 
					
					aux.add(orden);
					aux.add(obtenerDescArticulo(cod_art));
					aux.add(num);
					
					vInfo.add(aux);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return vInfo;	
		}
		public static Vector obtenerInfoLineasSalidas(int codSal){
			Vector vInfo= new Vector();
			ResultSet res;
			String cadena=new String();
			cadena = "SELECT Orden, Codigo_Articulo, Numero_Articulos FROM LineasSalidas " +
					"WHERE Codigo_Salida="+codSal;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
					Vector aux = new Vector();
					String orden =res.getString("Orden");
					int cod_art=res.getInt("Codigo_Articulo");
					int num=res.getInt("Numero_Articulos"); 
					
					aux.add(orden);
					aux.add(obtenerDescArticulo(cod_art));
					aux.add(""+(num*-1));
					
					vInfo.add(aux);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return vInfo;	
		}
		public static void eliminarStocksEntrada(int codEnt){
			String cadena =new String("DELETE FROM StockArticulos WHERE " +
					"Codigo_Entrada = "+codEnt);
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el eliminar stocks entrada :"+cadena);
				excep.getMessage();
			}
			
		}
		//eliminarStocksSalida
		public static void eliminarStocksSalida(int codSal){
			String cadena =new String("DELETE FROM StockArticulos WHERE " +
					"Codigo_Salida = "+codSal);
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el eliminar stocks salida :"+cadena);
				excep.getMessage();
			}
			
		}
		public static void eliminarLineasEntradas(int codEnt){
			String cadena =new String("DELETE FROM LineasEntradas WHERE " +
					"Codigo_Entrada = "+codEnt);
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el eliminar lineas entradas :"+cadena);
				excep.getMessage();
			}
			
			
		}
		public static void eliminarLineasSalidas(int codSal){
			String cadena =new String("DELETE FROM LineasSalidas WHERE " +
					"Codigo_Salida = "+codSal);
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el eliminar lineas salidas :"+cadena);
				excep.getMessage();
			}
			
			
		}
		public static void eliminarEntradaPausada(int codEnt){
			String cadena =new String("DELETE FROM Entradas WHERE " +
					"Codigo_Entrada = "+codEnt);
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el eliminar entrada pausada:"+cadena);
				excep.getMessage();
			}
			
		}
		public static void eliminarSalidaPausada(int codSal){
			String cadena =new String("DELETE FROM Salidas WHERE " +
					"Codigo_Salida = "+codSal);
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el eliminar salida pausada:"+cadena);
				excep.getMessage();
			}
			
		}
		//funciones para crear la tabla de estadisticas
		//*********************************************
		//*********************************************
		public static Vector obtenerTiempoMinutosOperariosEntradas(String FechaInicio, String FechaFin){
			Vector VOperariosTiempo=new Vector();
			ResultSet res ;
			int horas = 0; 
			int minutos=0;
			String cadena=new String();
			cadena = "SELECT Codigo_Operario,Tiempo_entrada,Codigo_Entrada FROM Entradas" +
					" WHERE  Fecha_entrada BETWEEN '"+FechaInicio+"' AND '"+FechaFin+"'";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
					String codigo =res.getString("Codigo_Operario");
					String tiempo =res.getString("Tiempo_entrada");
					String codEnt =res.getString("Codigo_Entrada");
					if(tiempo.length()>5){
						horas = Integer.parseInt(new String (""+tiempo.charAt(0)+tiempo.charAt(1)+tiempo.charAt(2))); 
						minutos = Integer.parseInt(new String (""+tiempo.charAt(4)+tiempo.charAt(5)));
					}
					else{
						horas = Integer.parseInt(new String (""+tiempo.charAt(0)+tiempo.charAt(1))); 
						minutos = Integer.parseInt(new String (""+tiempo.charAt(3)+tiempo.charAt(4)));
					}
					
					int minutosTotal = (horas*60)+minutos;
					Vector aux = new Vector();
					aux.add(codigo);
					aux.add(""+minutosTotal);
					aux.add(codEnt);
					VOperariosTiempo.add(aux);
					
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return VOperariosTiempo;	
		} 
		public static Vector obtenerTiempoMinutosOperariosSalidas(String FechaInicio, String FechaFin){
			Vector VOperariosTiempo=new Vector();
			ResultSet res ;
			int horas = 0; 
			int minutos=0;
			String cadena=new String();
			cadena = "SELECT Codigo_Operario,Tiempo_salida,Codigo_Salida FROM Salidas" +
					" WHERE  Fecha_salida BETWEEN '"+FechaInicio+"' AND '"+FechaFin+"'";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
					String codigo =res.getString("Codigo_Operario");
					String tiempo =res.getString("Tiempo_salida");
					String codSal =res.getString("Codigo_Salida");
					if(tiempo.length()>5){
						horas = Integer.parseInt(new String (""+tiempo.charAt(0)+tiempo.charAt(1)+tiempo.charAt(2))); 
						minutos = Integer.parseInt(new String (""+tiempo.charAt(4)+tiempo.charAt(5)));
					}
					else{
						horas = Integer.parseInt(new String (""+tiempo.charAt(0)+tiempo.charAt(1))); 
						minutos = Integer.parseInt(new String (""+tiempo.charAt(3)+tiempo.charAt(4)));
					}
					int minutosTotal = (horas*60)+minutos;
					Vector aux = new Vector();
					aux.add(codigo);
					aux.add(""+minutosTotal);
					aux.add(codSal);
					VOperariosTiempo.add(aux);
					
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return VOperariosTiempo;	
		} 
		public static int obtenerNumeroEntradasOperario(int codOp,String FechaInicio, String FechaFin){
			int numeroEnt=0;
			ResultSet res ;
			String cadena=new String();
			cadena = "SELECT * FROM Entradas" +
					" WHERE  Fecha_entrada BETWEEN '"+FechaInicio+"' AND '"+FechaFin+"' " +
					" AND Codigo_Operario = "+codOp;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
					numeroEnt=numeroEnt+1;
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return numeroEnt;	
		} 
		public static int obtenerNumeroSalidasOperario(int codOp,String FechaInicio, String FechaFin){
			int numeroSal=0;
			ResultSet res ;
			String cadena=new String();
			cadena = "SELECT * FROM Salidas" +
					" WHERE  Fecha_salida BETWEEN '"+FechaInicio+"' AND '"+FechaFin+"' " +
					" AND Codigo_Operario = "+codOp;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
					numeroSal=numeroSal+1;
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return numeroSal;	
		} 
		public static int obtenerNumeroArticulosEntrada(int codEnt){
			int numeroArticulos=0;
			ResultSet res ;
			String cadena=new String();
			cadena = "SELECT SUM (Numero_Articulos) AS SumArt FROM LineasEntradas" +
					" WHERE Codigo_Entrada= "+codEnt;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
					numeroArticulos=res.getInt("SumArt");
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return numeroArticulos;	
		} 
		public static int obtenerNumeroArticulosSalida(int codSal){
			int numeroArticulos=0;
			ResultSet res ;
			String cadena=new String();
			cadena = "SELECT SUM (Numero_Articulos) AS SumArt FROM LineasSalidas" +
					" WHERE Codigo_Salida= "+codSal;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
					numeroArticulos=res.getInt("SumArt");
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return (numeroArticulos*-1);	
		} 
		
		public static Vector obtenerOperarios(){
			Vector vOperarios= new Vector();
			ResultSet res;
			String cadena=new String();
			cadena = "SELECT * FROM Operarios ";
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
					Vector aux = new Vector();
					String codOp =res.getString("Codigo_Operario");
					String nombre =res.getString("Nombre");
					String tipo =res.getString("Tipo");
					aux.add(codOp);
					aux.add(nombre);
					aux.add(tipo);
					vOperarios.add(aux);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return vOperarios;	
		}
		//GestionBD.existeLoginOperario(codOp)
		public static boolean existeLoginOperario(int codOp){
			boolean existe= false;
			String cadena =new String("SELECT * FROM Usuarios " +
									  " WHERE Codigo_Usuario = "+codOp);
			
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				existe=true;
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return existe;
		}
		//GestionBD.obtenerOperariosConLogin()
		public static Vector obtenerOperariosConLogin(String nomb, String tip){
			Vector vOperarios= new Vector();
			ResultSet res;
			String cadena=new String();
			if(tip.equals("no tener en cuenta")){
				cadena = "SELECT * FROM Operarios " +
			 			" WHERE Nombre LIKE '%"+nomb+"%'";
			}
			else{
				cadena = "SELECT * FROM Operarios " +
					 	" WHERE Nombre LIKE '%"+nomb+"%'" +
					 	" AND Tipo LIKE '"+tip+"'";
			}
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
					Vector aux = new Vector();
					String codOp =res.getString("Codigo_Operario");
					String nombre =res.getString("Nombre");
					String tipo =res.getString("Tipo");
					if(GestionBD.existeLoginOperario(Integer.parseInt(codOp))){
						aux.add(codOp);
						aux.add(nombre);
						aux.add(tipo);
						vOperarios.add(aux);
					}
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return vOperarios;	
		}
		//GestionBD.buscarOperarios(nombre,tipo);
		public static Vector buscarOperarios(String palabra,String tip){
			Vector vOperarios= new Vector();
			ResultSet res;
			String cadena=new String();
			if(tip.equals("no tener en cuenta")){
				cadena = "SELECT * FROM Operarios WHERE " +
				"Nombre LIKE '%"+palabra+"%'";
			}
			else{
				cadena = "SELECT * FROM Operarios WHERE " +
						"Nombre LIKE '%"+palabra+"%'"+
						" AND Tipo LIKE '"+tip+"'";
			}
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
					Vector aux = new Vector();
					String codOp =res.getString("Codigo_Operario");
					String nombre =res.getString("Nombre");
					String tipo =res.getString("Tipo");
					aux.add(codOp);
					aux.add(nombre);
					aux.add(tipo);
					vOperarios.add(aux);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return vOperarios;	
		}
		//buscarArticulos(textoNombreVerArticulos.getText(),""+comboCategoriaVerArticulos.getSelectedItem());
		public static Vector buscarArticulos(String nombre,String cat){
			Vector vOperarios= new Vector();
			ResultSet res;
			String cadena=new String();
			if(cat.equals("Todos")){
				cadena = "SELECT * FROM Articulos WHERE " +
				"Descripcion_Articulo LIKE '%"+nombre+"%'";
			}
			else{
				cadena = "SELECT * FROM Articulos WHERE " +
				"Descripcion_Articulo LIKE '%"+nombre+"%'"+
				" AND Codigo_Categoria ="+GestionBD.obtenerCodigoCategoria(cat);
			}
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
					Vector aux = new Vector();
					String codArt =res.getString("Codigo_Articulo");
					String desc =res.getString("Descripcion_Articulo");
					String categ =GestionBD.obtenerNombreCategoria(Integer.parseInt(res.getString("Codigo_Categoria")));
					String stock =res.getString("Stock_total_actual");
					aux.add(codArt);
					aux.add(desc);
					aux.add(categ);
					aux.add(stock);
					vOperarios.add(aux);
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error SQL en la búsqueda" + e.getMessage());
				e.printStackTrace(System.out);
			}
			return vOperarios;	
		}
		public static boolean hayStockNegativo(){
			boolean negativo= false;
			String cadena =new String("SELECT * FROM Articulos" +
					" WHERE Stock_total_actual < 0");
			
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				negativo=true;
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return negativo;
		}
		public static void modificarArticulo(int codArt,String nombArtNuevo, String nombCatArtNuevo){
			int codCat = GestionBD.obtenerCodigoCategoria(nombCatArtNuevo);
			String cadena ="UPDATE  Articulos  SET Descripcion_Articulo ='"+nombArtNuevo+
						   "' ,Codigo_Categoria = "+codCat +
						   " WHERE Codigo_Articulo ="+codArt;
				try {
					Statement stmt = con.createStatement();
					stmt = con.createStatement();
					stmt.executeUpdate(cadena);
					stmt.close();
				}catch (SQLException s) {
					s.printStackTrace();
					System.out.println(s.getMessage());
				}
			}
		//obtenerNombreCategoriaPadre(int codcat);
		public static String obtenerNombreCategoriaPadre (int codCat) { 
			String cadena =new String("SELECT Categoria_padre FROM Categorias" +
					" WHERE Codigo_Categoria = "+codCat);
			String nombre= "Descripcion no encontrada";
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				int codPadre =res.getInt("Categoria_padre");
				nombre = GestionBD.obtenerNombreCategoria(codPadre);
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return nombre;
			
		}
		//GestionBD.modificarCategoria(int codCat, String NombreNuevo, int codPadre);
		public static void modificarCategoria(int codCat, String NombreNuevo, int codPadre){
			String cadena ="UPDATE  Categorias  SET Nombre_Categoria='"+NombreNuevo+
						   "' ,Categoria_padre = "+codPadre +
						   " WHERE Codigo_Categoria ="+codCat;
				try {
					Statement stmt = con.createStatement();
					stmt = con.createStatement();
					stmt.executeUpdate(cadena);
					stmt.close();
				}catch (SQLException s) {
					s.printStackTrace();
					System.out.println(s.getMessage());
				}
		}
		//GestionBD.eliminarCategoria(int codCat)
		public static void eliminarCategoria(int codCat){
			String cadena =new String("DELETE FROM Categorias WHERE " +
					"Codigo_Categoria = "+codCat);
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el eliminar categoria:"+cadena);
				excep.getMessage();
			}
			
		}
		//GestionBD.actualizarCategoriaArticulos(int codCat);
		public static void actualizarCategoriaArticulos(int codCat){
			String cadena ="UPDATE  Articulos  SET Codigo_Categoria= 3 " +
						   " WHERE Codigo_Categoria = "+codCat;
				try {
					Statement stmt = con.createStatement();
					stmt = con.createStatement();
					stmt.executeUpdate(cadena);
					stmt.close();
				}catch (SQLException s) {
					s.printStackTrace();
					System.out.println(s.getMessage());
				}
		}
		//GestionBD.actualizarCategoriasPadre(int codCat);
		public static void actualizarCategoriasPadre(int codCat){
			String cadena ="UPDATE  Categorias  SET Categoria_padre= 3 " +
						   " WHERE Categoria_padre = "+codCat;
				try {
					Statement stmt = con.createStatement();
					stmt = con.createStatement();
					stmt.executeUpdate(cadena);
					stmt.close();
				}catch (SQLException s) {
					s.printStackTrace();
					System.out.println(s.getMessage());
				}
		}
		//insertarOperario(nombre,tipo)
		public static void insertarOperario(String nombre,String tipo){
			//
			int codUsuario= GestionBD.obtenerCodUltimoUsuario();
			String cadena =new String("INSERT INTO Operarios(Nombre, Tipo, Codigo_Usuario) " +
					" VALUES ('"+nombre+"','"+tipo+"','"+codUsuario+"')");
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el insertar operario:"+cadena);
				excep.getMessage();
			}
		}
		//insertarUsuario(nombreUsuario,passwordMD5)
		public static void insertarUsuario(String nombreUsuario,String password){
			//
			String cadena =new String("INSERT INTO Usuarios(Nombre, Password) " +
					" VALUES ('"+nombreUsuario+"','"+password+"')");
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el insertar usuario:"+cadena);
				excep.getMessage();
			}
		}
		//obtenerCodUltimoUsuario()
		public static int obtenerCodUltimoUsuario() {
			String cadena =new String("SELECT MAX(Codigo_Usuario) AS MaxCod FROM Usuarios");
			int codUltU=0;
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
					codUltU =res.getInt("MaxCod");
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage());
				eXcp.printStackTrace(System.out);
			}
			return codUltU;
			
		}
		//GestionBD.modificarOperario(codOp,nombre);							
		public static void modificarOperario(int codOp,String nombre,String tipo){
			String cadena ="UPDATE  Operarios  SET Nombre='"+nombre+
						   "',Tipo ='"+tipo+
						   "' WHERE Codigo_Operario ="+codOp;
				try {
					Statement stmt = con.createStatement();
					stmt = con.createStatement();
					stmt.executeUpdate(cadena);
					stmt.close();
				}catch (SQLException s) {
					s.printStackTrace();
					System.out.println(s.getMessage());
				}
		}
		//GestionBD.modificarUsuario(codUser,login);
		public static void modificarUsuario(int codUser,String login){
			String cadena ="UPDATE  Usuarios  SET Nombre='"+login+
						   "' WHERE Codigo_Usuario ="+codUser;
				try {
					Statement stmt = con.createStatement();
					stmt = con.createStatement();
					stmt.executeUpdate(cadena);
					stmt.close();
				}catch (SQLException s) {
					s.printStackTrace();
					System.out.println(s.getMessage());
				}
		}
		//GestionBD.modificarUsuario(codUser,login,password);
		public static void modificarUsuario(int codUser,String login,String password){
			String cadena ="UPDATE  Usuarios  SET Nombre='"+login+
						   "',Password ='"+password+
						   "' WHERE Codigo_Usuario ="+codUser;
				try {
					Statement stmt = con.createStatement();
					stmt = con.createStatement();
					stmt.executeUpdate(cadena);
					stmt.close();
				}catch (SQLException s) {
					s.printStackTrace();
					System.out.println(s.getMessage());
				}
		}
		//eliminarUsuario(operarioSeleccionado.getCodUsuario());
		public static void eliminarUsuario(int codUser){
			String cadena =new String("DELETE FROM Usuarios WHERE " +
					"Codigo_Usuario = "+codUser);
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el eliminar operario:"+cadena);
				excep.getMessage();
			}
			
		}
		//GestionBD.existeLocalizacion(String pasillo, String armario,String balda);
		public static boolean existeLocalizacion(String pasillo, String armario,String balda){
			boolean existe= false;
			String cadena =new String("SELECT * FROM Localizaciones " +
									  " WHERE Pasillo = '"+pasillo+
									  "' AND Armario = '"+armario+
									  "' AND Balda= '"+balda+"'");
			
			ResultSet res;
			try {
				Statement stmt = con.createStatement();
				res = stmt.executeQuery(cadena);
				while(res.next()){			
				existe=true;
				}
				res.close();
				stmt.close();
			} catch (SQLException eXcp) {
				System.out.println("Error SQL en la búsqueda" + eXcp.getMessage()+cadena);
				eXcp.printStackTrace(System.out);
			}
			return existe;
		}
		//GestionBD.insertarLocalizacion(String pasillo, String armario, String balda);
		public static void insertarLocalizacion(String pasillo, String armario, String balda){
			//
			String cadena =new String("INSERT INTO Localizaciones(Pasillo, Armario, Balda) " +
					" VALUES ('"+pasillo+"','"+armario+"','"+balda+"')");
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el insertar localizacion:"+cadena);
				excep.getMessage();
			}
		}
		//GestionBD.eliminarLocalizacion(String pasillo, String armario, String balda);
		public static void eliminarLocalizacion(String pasillo, String armario, String balda){
			String cadena =new String("DELETE FROM Localizaciones WHERE " +
					"Pasillo = '"+pasillo+"' " +
					"AND Armario = '"+armario+"' " +
					"AND Balda ='"+balda+"'");
			try {
				Statement stmt = con.createStatement();
				stmt = con.createStatement();
				stmt.executeUpdate(cadena);
			} catch (SQLException excep) {
				System.out.println("Problemas con el eliminar localizacion:"+cadena);
				excep.getMessage();
			}
			
		}
}
