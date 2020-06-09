package mx.com.example.demo.models;

public class Carrera {
	private int IdCarrera;
	private String nombre;
	private String clave;
	private int creditos;
	private int status;
	public Carrera() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Carrera(int idCarrera, String nombre, String clave, int creditos, int status) {
		super();
		IdCarrera = idCarrera;
		this.nombre = nombre;
		this.clave = clave;
		this.creditos = creditos;
		this.status = status;
	}
	public int getIdCarrera() {
		return IdCarrera;
	}
	public void setIdCarrera(int idCarrera) {
		IdCarrera = idCarrera;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
