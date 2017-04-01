package entidades;

public class Salida {
	
		private int codSalida;
		private String fechaSalida;
		private String horaSalida;
		private String estadoSalida;
		private String fechaFinSalida;
		private String horaFinSalida;
		private String tiempoSalida;
		private int codOperario;
		
		public Salida() {
			super();
		}
		public Salida(int codSalida, String fechaSalida, String horaSalida, String estadoSalida, String fechaFinSalida, String horaFinSalida, String tiempoSalida, int codOperario) {
			super();
			this.codSalida = codSalida;
			this.fechaSalida = fechaSalida;
			this.horaSalida = horaSalida;
			this.estadoSalida = estadoSalida;
			this.fechaFinSalida = fechaFinSalida;
			this.horaFinSalida = horaFinSalida;
			this.tiempoSalida = tiempoSalida;
			this.codOperario = codOperario;
		}
		public int getCodOperario() {
			return codOperario;
		}
		public void setCodOperario(int codOperario) {
			this.codOperario = codOperario;
		}
		public int getCodSalida() {
			return codSalida;
		}
		public void setCodSalida(int codSalida) {
			this.codSalida = codSalida;
		}
		public String getEstadoSalida() {
			return estadoSalida;
		}
		public void setEstadoSalida(String estadoSalida) {
			this.estadoSalida = estadoSalida;
		}
		public String getFechaFinSalida() {
			return fechaFinSalida;
		}
		public void setFechaFinSalida(String fechaFinSalida) {
			this.fechaFinSalida = fechaFinSalida;
		}
		public String getFechaSalida() {
			return fechaSalida;
		}
		public void setFechaSalida(String fechaSalida) {
			this.fechaSalida = fechaSalida;
		}
		public String getHoraFinSalida() {
			return horaFinSalida;
		}
		public void setHoraFinSalida(String horaFinSalida) {
			this.horaFinSalida = horaFinSalida;
		}
		public String getHoraSalida() {
			return horaSalida;
		}
		public void setHoraSalida(String horaSalida) {
			this.horaSalida = horaSalida;
		}
		public String getTiempoSalida() {
			return tiempoSalida;
		}
		public void setTiempoSalida(String tiempoSalida) {
			this.tiempoSalida = tiempoSalida;
		}
}
