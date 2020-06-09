package mx.com.example.demo.service;

import java.util.List;
import mx.com.example.demo.models.Cursa;

public interface CursaService {
	public List<Cursa> consultar();
	public Cursa buscarPorId(int id);
	public Cursa crearCursa (Cursa cursa1);
	public void actualizar (Cursa cursa1);
	public void eliminar (int id);

}
