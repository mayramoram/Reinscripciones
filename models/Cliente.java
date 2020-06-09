package mx.com.example.demo.models;

public class Cliente {
	private int id;
	private int NoControl;
	private String Nombre ;
	private String ApellidoP ;
	private String ApellidoM;
	private String Sexo ;
	private int IdCarrera ;
	private String Semestre ;
	private String email ;
	private String password ;
	private int status;
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cliente(int id, int noControl, String nombre, String apellidoP, String apellidoM, String sexo, int idCarrera,
			String semestre, String email, String password, int status) {
		super();
		this.id = id;
		this.NoControl = noControl;
		this.Nombre = nombre;
		this.ApellidoP = apellidoP;
		this.ApellidoM = apellidoM;
		this.Sexo = sexo;
		this.IdCarrera = idCarrera;
		this.Semestre = semestre;
		this.email = email;
		this.password = password;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNoControl() {
		return NoControl;
	}
	public void setNoControl(int noControl) {
		NoControl = noControl;
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
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public int getIdCarrera() {
		return IdCarrera;
	}
	public void setIdCarrera(int idCarrera) {
		IdCarrera = idCarrera;
	}
	public String getSemestre() {
		return Semestre;
	}
	public void setSemestre(String semestre) {
		Semestre = semestre;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	
}
