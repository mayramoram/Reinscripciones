package mx.com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.example.demo.DAO.DocenteJDBC;
import mx.com.example.demo.models.Docente;

@Service
public class DocenteLogica implements DocenteService{

	@Autowired
	DocenteJDBC docente;
	
	@Override
	public List<Docente> consultar() {
		// TODO Auto-generated method stub
		return docente.consultar();
	}
	

	@Override
	public Docente buscarPorId(int id) {
		// TODO Auto-generated method stub
		return docente.buscarPorID(id);
	}

	@Override
	public Docente crearDocente(Docente docente1) {
		// TODO Auto-generated method stub
		return docente.crear(docente1);
	}

	@Override
	public void actualizar(Docente docente1) {
		// TODO Auto-generated method stub
		docente.actualizar(docente1);
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		docente.eliminar(id);
		
	}

}
