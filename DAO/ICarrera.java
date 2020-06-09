package mx.com.example.demo.DAO;

import java.util.List;

import mx.com.example.demo.models.Carrera;


public interface ICarrera {
	
	public List<Carrera> consultar();
	public Carrera buscarPorID(int id);
	public Carrera crear (Carrera carrera);
	public void actualizar (Carrera carrera);
	public void eliminar (int id);

}
