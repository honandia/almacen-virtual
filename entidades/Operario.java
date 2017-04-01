package entidades;

public class Operario {
	
	private int codOperario;
	private String nombre;
	private String tipo;
	private int  codUsuario;
	
	public Operario() {
		super();
	}
	public Operario(int codOperario, String nombre, String tipo, int codUsuario) {
		super();
		this.codOperario = codOperario;
		this.nombre = nombre;
		this.tipo = tipo;
		this.codUsuario = codUsuario;
	}
	public int getCodOperario() {
		return codOperario;
	}
	public void setCodOperario(int codOperario) {
		this.codOperario = codOperario;
	}
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
