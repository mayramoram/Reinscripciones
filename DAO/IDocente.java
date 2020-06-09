package mx.com.example.demo.DAO;

import java.util.List;
import mx.com.example.demo.models.Docente;


public interface IDocente {
	
	public List<Docente> consultar();
	public Docente buscarPorID(int id);
	public Docente crear (Docente docente);
	public void actualizar (Docente docente);
	public void eliminar (int id);

}
