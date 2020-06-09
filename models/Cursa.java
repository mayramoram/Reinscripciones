package mx.com.example.demo.models;

public class Cursa {
	private int IdCursa;
	private int nocontrol;
	private int idCursaMaterias;
	private int status;
	public Cursa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cursa(int idCursa, int nocontrol, int idCursaMaterias, int status) {
		super();
		IdCursa = idCursa;
		this.nocontrol = nocontrol;
		this.idCursaMaterias = idCursaMaterias;
		this.status = status;
	}
	public int getIdCursa() {
		return IdCursa;
	}
	public void setIdCursa(int idCursa) {
		IdCursa = idCursa;
	}
	public int getNocontrol() {
		return nocontrol;
	}
	public void setNocontrol(int nocontrol) {
		this.nocontrol = nocontrol;
	}
	public int getIdCursaMaterias() {
		return idCursaMaterias;
	}
	public void setIdCursaMaterias(int idCursaMaterias) {
		this.idCursaMaterias = idCursaMaterias;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
