package entidades;
public class Articulo {
	
	private int codArticulo;
	private String	descArticulo;
	private int codCategoria;
	private int stockTotalActual;
	
	public Articulo() {
		super();
	}
	public Articulo(int codArticulo, String descArticulo, int codCategoria, int stockTotalActual) {
		super();
		this.codArticulo = codArticulo;
		this.descArticulo = descArticulo;
		this.codCategoria = codCategoria;
		this.stockTotalActual = stockTotalActual;
	}
	public int getCodArticulo() {
		return codArticulo;
	}
	public void setCodArticulo(int codArticulo) {
		this.codArticulo = codArticulo;
	}
	public int getCodCategoria() {
		return codCategoria;
	}
	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}
	public String getDescArticulo() {
		return descArticulo;
	}
	public void setDescArticulo(String descArticulo) {
		this.descArticulo = descArticulo;
	}
	public int getStockTotalActual() {
		return stockTotalActual;
	}
	public void setStockTotalActual(int stockTotalActual) {
		this.stockTotalActual = stockTotalActual;
	}
}
