package mx.com.example.demo.service;

import java.util.List;

import mx.com.example.demo.models.Imparte;

public interface ImparteService {
	
	public List<Imparte> consultar();
	public Imparte buscarPorId(int id);
	public Imparte  crearImparte (Imparte imparte1);
	public void actualizar (Imparte imparte1);
	public void eliminar (int id);

}
