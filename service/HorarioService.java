package mx.com.example.demo.service;

import java.util.List;

import mx.com.example.demo.models.Horario;

public interface HorarioService {
	
	public List<Horario> consultar();
	public Horario buscarPorId(int id);
	public Horario crearHorario(Horario horario1);
	public void actualizar (Horario horario1);
	public void eliminar (int id);

}
