package entidades;
public class Usuario {
	
	private  int codUsuario;
	private String nombre;
	private String password;
	
	public Usuario() {
		super();
	}
	public Usuario(int codUsuario, String nombre, String password) {
		super();
		this.codUsuario = codUsuario;
		this.nombre = nombre;
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

}
