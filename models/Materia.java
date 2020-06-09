package mx.com.example.demo.models;

public class Materia {
	private int IdMateria;
	private String Nombre;
	private String Creditos;
	private int carrera_id;
	private int status;
	public Materia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Materia(int idMateria, String nombre, String creditos, int carrera_id, int status) {
		super();
		IdMateria = idMateria;
		Nombre = nombre;
		Creditos = creditos;
		this.carrera_id = carrera_id;
		this.status = status;
	}
	public int getIdMateria() {
		return IdMateria;
	}
	public void setIdMateria(int idMateria) {
		IdMateria = idMateria;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCreditos() {
		return Creditos;
	}
	public void setCreditos(String creditos) {
		Creditos = creditos;
	}
	public int getCarrera_id() {
		return carrera_id;
	}
	public void setCarrera_id(int carrera_id) {
		this.carrera_id = carrera_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
