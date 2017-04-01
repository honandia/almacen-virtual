package entidades;

public class Localizacion {
	
	private int codLocalizacion;
	private String pasillo;
	private String armario;
	private String balda;
	
	public Localizacion() {
		super();
	}
	public Localizacion(int codLocalizacion, String pasillo, String armario, String balda) {
		super();
		this.codLocalizacion = codLocalizacion;
		this.pasillo = pasillo;
		this.armario = armario;
		this.balda = balda;
	}
	public String getArmario() {
		return armario;
	}
	public void setArmario(String armario) {
		this.armario = armario;
	}
	public String getBalda() {
		return balda;
	}
	public void setBalda(String balda) {
		this.balda = balda;
	}
	public int getCodLocalizacion() {
		return codLocalizacion;
	}
	public void setCodLocalizacion(int codLocalizacion) {
		this.codLocalizacion = codLocalizacion;
	}
	public String getPasillo() {
		return pasillo;
	}
	public void setPasillo(String pasillo) {
		this.pasillo = pasillo;
	}
}
