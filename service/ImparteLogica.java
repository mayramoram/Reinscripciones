package mx.com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.example.demo.DAO.ImparteJDBC;
import mx.com.example.demo.models.Imparte;

@Service
public class ImparteLogica implements ImparteService{

	@Autowired
	ImparteJDBC imparte;
	
	@Override
	public List<Imparte> consultar() {
		// TODO Auto-generated method stub
		return imparte.consultar();
	}
	

	@Override
	public Imparte buscarPorId(int id) {
		// TODO Auto-generated method stub
		return imparte.buscarPorID(id);
	}

	@Override
	public Imparte crearImparte(Imparte imparte1) {
		// TODO Auto-generated method stub
		return imparte.crear(imparte1);
	}

	@Override
	public void actualizar(Imparte imparte1) {
		// TODO Auto-generated method stub
		imparte.actualizar(imparte1);
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		imparte.eliminar(id);
		
	}

}
