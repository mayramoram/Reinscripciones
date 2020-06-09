package mx.com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.example.demo.DAO.ClienteJDBC;
import mx.com.example.demo.models.Cliente;




@Service
public class ClienteLogica implements ClienteService{

	@Autowired
	ClienteJDBC cliente;
	
	@Override
	public List<Cliente> consultar() {
		// TODO Auto-generated method stub
		return cliente.consultar();
	}
	

	@Override
	public Cliente buscarPorId(int id) {
		// TODO Auto-generated method stub
		return cliente.buscarPorID(id);
	}

	@Override
	public Cliente crearCliente(Cliente cliente1) {
		// TODO Auto-generated method stub
		return cliente.crear(cliente1);
	}

	@Override
	public void actualizar(Cliente cliente1) {
		// TODO Auto-generated method stub
		cliente.actualizar(cliente1);
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		cliente.eliminar(id);
		
	}

}
