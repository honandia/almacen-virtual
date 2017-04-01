package entidades;

public class LineaSalida {
	
	private int codSalida;
	private int orden;
	private int codArticulo;
	private int numArticulo;
	private int localizacion;
	public LineaSalida() {
		super();
	}
	public LineaSalida(int codSalida, int orden, int codArticulo, int numArticulo, int localizacion) {
		super();
		this.codSalida = codSalida;
		this.orden = orden;
		this.codArticulo = codArticulo;
		this.numArticulo = numArticulo;
		this.localizacion = localizacion;
	}
	public int getCodArticulo() {
		return codArticulo;
	}
	public void setCodArticulo(int codArticulo) {
		this.codArticulo = codArticulo;
	}
	public int getCodSalida() {
		return codSalida;
	}
	public void setCodSalida(int codSalida) {
		this.codSalida = codSalida;
	}
	public int getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(int localizacion) {
		this.localizacion = localizacion;
	}
	public int getNumArticulo() {
		return numArticulo;
	}
	public void setNumArticulo(int numArticulo) {
		this.numArticulo = numArticulo;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
}
