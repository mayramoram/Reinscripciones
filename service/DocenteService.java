package mx.com.example.demo.service;

import java.util.List;

import mx.com.example.demo.models.Docente;

public interface DocenteService {
	
	public List<Docente> consultar();
	public Docente buscarPorId(int id);
	public Docente  crearDocente (Docente docente1);
	public void actualizar (Docente docente1);
	public void eliminar (int id);

}
