package mx.com.example.demo.models;

public class Horario {
	private int idHorario;
	private int idCarrera;
	private String turno;
	private String semestre;
	private int idmateria1;
	private int idmateria2;
	private int idmateria3;
	private int idmateria4;
	private int idmateria5;
	private int status;
	
	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Horario(int idHorario, int idCarrera, String turno, String semestre, int idmateria1, int idmateria2,
			int idmateria3, int idmateria4, int idmateria5, int status) {
		super();
		this.idHorario = idHorario;
		this.idCarrera = idCarrera;
		this.turno = turno;
		this.semestre = semestre;
		this.idmateria1 = idmateria1;
		this.idmateria2 = idmateria2;
		this.idmateria3 = idmateria3;
		this.idmateria4 = idmateria4;
		this.idmateria5 = idmateria5;
		this.status = status;
	}
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	public int getIdCarrera() {
		return idCarrera;
	}
	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public int getIdmateria1() {
		return idmateria1;
	}
	public void setIdmateria1(int idmateria1) {
		this.idmateria1 = idmateria1;
	}
	public int getIdmateria2() {
		return idmateria2;
	}
	public void setIdmateria2(int idmateria2) {
		this.idmateria2 = idmateria2;
	}
	public int getIdmateria3() {
		return idmateria3;
	}
	public void setIdmateria3(int idmateria3) {
		this.idmateria3 = idmateria3;
	}
	public int getIdmateria4() {
		return idmateria4;
	}
	public void setIdmateria4(int idmateria4) {
		this.idmateria4 = idmateria4;
	}
	public int getIdmateria5() {
		return idmateria5;
	}
	public void setIdmateria5(int idmateria5) {
		this.idmateria5 = idmateria5;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
