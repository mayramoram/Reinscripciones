package mx.com.example.demo.service;

import java.util.List;

import mx.com.example.demo.models.Carrera;

public interface CarreraService {
	
	public List<Carrera> consultar();
	public Carrera buscarPorId(int id);
	public Carrera  crearCarrera (Carrera carrera1);
	public void actualizar (Carrera carrera1);
	public void eliminar (int id);

}
