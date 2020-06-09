package mx.com.example.demo.models;

public class Imparte {
	private int IdImparte;
	private int idprofesor;
	private int nocontrol;
	private int idimparteMaterias;
	private int status;
	public Imparte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Imparte(int idImparte, int idprofesor, int nocontrol, int idimparteMaterias, int status) {
		super();
		IdImparte = idImparte;
		this.idprofesor = idprofesor;
		this.nocontrol = nocontrol;
		this.idimparteMaterias = idimparteMaterias;
		this.status = status;
	}
	public int getIdImparte() {
		return IdImparte;
	}
	public void setIdImparte(int idImparte) {
		IdImparte = idImparte;
	}
	public int getIdprofesor() {
		return idprofesor;
	}
	public void setIdprofesor(int idprofesor) {
		this.idprofesor = idprofesor;
	}
	public int getNocontrol() {
		return nocontrol;
	}
	public void setNocontrol(int nocontrol) {
		this.nocontrol = nocontrol;
	}
	public int getIdimparteMaterias() {
		return idimparteMaterias;
	}
	public void setIdimparteMaterias(int idimparteMaterias) {
		this.idimparteMaterias = idimparteMaterias;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
