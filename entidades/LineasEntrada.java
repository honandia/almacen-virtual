package entidades;

public class LineasEntrada {
	
	private int codEntrada;
	private int orden;
	private int codArticulo;
	private int numArticulos;
	private int codLocalizacion;
	
	public LineasEntrada() {
		super();
	}
	public LineasEntrada(int codEntrada, int orden, int codArticulo, int numArticulos, int codLocalizacion) {
		super();
		this.codEntrada = codEntrada;
		this.orden = orden;
		this.codArticulo = codArticulo;
		this.numArticulos = numArticulos;
		this.codLocalizacion = codLocalizacion;
	}
	public int getCodArticulo() {
		return codArticulo;
	}
	public void setCodArticulo(int codArticulo) {
		this.codArticulo = codArticulo;
	}
	public int getCodEntrada() {
		return codEntrada;
	}
	public void setCodEntrada(int codEntrada) {
		this.codEntrada = codEntrada;
	}
	public int getCodLocalizacion() {
		return codLocalizacion;
	}
	public void setCodLocalizacion(int codLocalizacion) {
		this.codLocalizacion = codLocalizacion;
	}
	public int getNumArticulos() {
		return numArticulos;
	}
	public void setNumArticulos(int numArticulos) {
		this.numArticulos = numArticulos;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
}
