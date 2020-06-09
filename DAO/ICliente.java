package mx.com.example.demo.DAO;

import java.util.List;

import mx.com.example.demo.models.Cliente;


public interface ICliente {
	
	public List<Cliente> consultar();
	public Cliente buscarPorID(int id);
	public Cliente crear (Cliente cliente);
	public void actualizar (Cliente cliente);
	public void eliminar (int id);

}
