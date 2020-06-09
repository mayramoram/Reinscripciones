package mx.com.example.demo.DAO;

import java.util.List;
import mx.com.example.demo.models.Materia;


public interface IMateria {
	
	public List<Materia> consultar();
	public Materia buscarPorID(int id);
	public Materia crear (Materia materia);
	public void actualizar (Materia materia);
	public void eliminar (int id);

}
