package mx.com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.example.demo.DAO.CursaJDBC;
import mx.com.example.demo.models.Cursa;

@Service
public class CursaLogica implements CursaService{

	@Autowired
	CursaJDBC cursa;
	
	@Override
	public List<Cursa> consultar() {
		// TODO Auto-generated method stub
		return cursa.consultar();
	}
	

	@Override
	public Cursa buscarPorId(int id) {
		// TODO Auto-generated method stub
		return cursa.buscarPorID(id);
	}

	@Override
	public Cursa crearCursa(Cursa cursa1) {
		// TODO Auto-generated method stub
		return cursa.crear(cursa1);
	}

	@Override
	public void actualizar(Cursa cursa1) {
		// TODO Auto-generated method stub
		cursa.actualizar(cursa1);
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		cursa.eliminar(id);
		
	}

}
