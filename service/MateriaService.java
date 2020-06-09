package mx.com.example.demo.service;

import java.util.List;
import mx.com.example.demo.models.Materia;

public interface MateriaService {
	
	public List<Materia> consultar();
	public Materia buscarPorId(int id);
	public Materia  crearMateria (Materia materia1);
	public void actualizar (Materia materia1);
	public void eliminar (int id);

}
