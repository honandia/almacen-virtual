package entidades;

public class Entrada {
	
	private int codEntrada;
	private String fechaEntrada;
	private String horaEntrada;
	private String estadoEntrada;
	private String fechaFinEntrada;
	private String horaFinEntrada;
	private String tiempoEntrada;
	private int codOperario;
	
	public Entrada() {
		super();
	}
	public Entrada(int codEntrada, String fechaEntrada, String horaEntrada, String estadoEntrada, String fechaFinEntrada, String horaFinEntrada, String tiempoEntrada, int codOperario) {
		super();
		this.codEntrada = codEntrada;
		this.fechaEntrada = fechaEntrada;
		this.horaEntrada = horaEntrada;
		this.estadoEntrada = estadoEntrada;
		this.fechaFinEntrada = fechaFinEntrada;
		this.horaFinEntrada = horaFinEntrada;
		this.tiempoEntrada = tiempoEntrada;
		this.codOperario = codOperario;
	}
	public int getCodEntrada() {
		return codEntrada;
	}
	public void setCodEntrada(int codEntrada) {
		this.codEntrada = codEntrada;
	}
	public int getCodOperario() {
		return codOperario;
	}
	public void setCodOperario(int codOperario) {
		this.codOperario = codOperario;
	}
	public String getEstadoEntrada() {
		return estadoEntrada;
	}
	public void setEstadoEntrada(String estadoEntrada) {
		this.estadoEntrada = estadoEntrada;
	}
	public String getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public String getFechaFinEntrada() {
		return fechaFinEntrada;
	}
	public void setFechaFinEntrada(String fechaFinEntrada) {
		this.fechaFinEntrada = fechaFinEntrada;
	}
	public String getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public String getHoraFinEntrada() {
		return horaFinEntrada;
	}
	public void setHoraFinEntrada(String horaFinEntrada) {
		this.horaFinEntrada = horaFinEntrada;
	}
	public String getTiempoEntrada() {
		return tiempoEntrada;
	}
	public void setTiempoEntrada(String tiempoEntrada) {
		this.tiempoEntrada = tiempoEntrada;
	}

}
