package entidades;

public class StockArticulo {
	
	private int codArticulo;
	private int codLocalizacion;
	private int stockActual;
	
	public StockArticulo() {
		super();
	}
	public StockArticulo(int codArticulo, int codLocalizacion, int stockActual) {
		super();
		this.codArticulo = codArticulo;
		this.codLocalizacion = codLocalizacion;
		this.stockActual = stockActual;
	}
	public int getCodArticulo() {
		return codArticulo;
	}
	public void setCodArticulo(int codArticulo) {
		this.codArticulo = codArticulo;
	}
	public int getCodLocalizacion() {
		return codLocalizacion;
	}
	public void setCodLocalizacion(int codLocalizacion) {
		this.codLocalizacion = codLocalizacion;
	}
	public int getStockActual() {
		return stockActual;
	}
	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}
}
