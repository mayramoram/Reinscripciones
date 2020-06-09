package mx.com.example.demo.models;

public class Docente {
	private int id;
	private int IdProfesor;
	private String Nombre;
	private String ApellidoP;
	private String ApellidoM;
	private String email;
	private String password;
	private String Turno;
	private String especialidad;
	private int status;
	public Docente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Docente(int id, int idProfesor, String nombre, String apellidoP, String apellidoM, String email,
			String password, String turno, String especialidad, int status) {
		super();
		this.id = id;
		IdProfesor = idProfesor;
		Nombre = nombre;
		ApellidoP = apellidoP;
		ApellidoM = apellidoM;
		this.email = email;
		this.password = password;
		Turno = turno;
		this.especialidad = especialidad;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdProfesor() {
		return IdProfesor;
	}
	public void setIdProfesor(int idProfesor) {
		IdProfesor = idProfesor;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidoP() {
		return ApellidoP;
	}
	public void setApellidoP(String apellidoP) {
		ApellidoP = apellidoP;
	}
	public String getApellidoM() {
		return ApellidoM;
	}
	public void setApellidoM(String apellidoM) {
		ApellidoM = apellidoM;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTurno() {
		return Turno;
	}
	public void setTurno(String turno) {
		Turno = turno;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
