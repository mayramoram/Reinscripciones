package mx.com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.example.demo.DAO.MateriaJDBC;
import mx.com.example.demo.models.Materia;

@Service
public class MateriaLogica implements MateriaService{

	@Autowired
	MateriaJDBC materia;
	
	@Override
	public List<Materia> consultar() {
		// TODO Auto-generated method stub
		return materia.consultar();
	}
	

	@Override
	public Materia buscarPorId(int id) {
		// TODO Auto-generated method stub
		return materia.buscarPorID(id);
	}

	@Override
	public Materia crearMateria(Materia materia1) {
		// TODO Auto-generated method stub
		return materia.crear(materia1);
	}

	@Override
	public void actualizar(Materia materia1) {
		// TODO Auto-generated method stub
		materia.actualizar(materia1);
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		materia.eliminar(id);
		
	}

}
