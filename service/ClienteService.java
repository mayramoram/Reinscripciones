package mx.com.example.demo.service;

import java.util.List;

import mx.com.example.demo.models.Cliente;

public interface ClienteService {
	
	public List<Cliente> consultar();
	public Cliente buscarPorId(int id);
	public Cliente  crearCliente (Cliente cliente1);
	public void actualizar (Cliente cliente1);
	public void eliminar (int id);

}
