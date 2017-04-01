package entidades;

public class Categoria {

	private int codCategoria;
	private String nombreCategoria;
	private String categoriaPadre;
	
	public Categoria() {
		super();
	}
	public Categoria(int codCategoria, String nombreCategoria, String categoriaPadre) {
		super();
		this.codCategoria = codCategoria;
		this.nombreCategoria = nombreCategoria;
		this.categoriaPadre = categoriaPadre;
	}
	public String getCategoriaPadre() {
		return categoriaPadre;
	}
	public void setCategoriaPadre(String categoriaPadre) {
		this.categoriaPadre = categoriaPadre;
	}
	public int getCodigoCategoria() {
		return codCategoria;
	}
	public void setCodigoCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}	
}
