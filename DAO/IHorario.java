package mx.com.example.demo.DAO;

import java.util.List;

import mx.com.example.demo.models.Horario;


public interface IHorario {
	
	public List<Horario> consultar();
	public Horario buscarPorID(int id);
	public Horario crear (Horario horario);
	public void actualizar (Horario horario);
	public void eliminar (int id);

}
