package mx.com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.example.demo.DAO.CarreraJDBC;
import mx.com.example.demo.models.Carrera;

@Service
public class CarreraLogica implements CarreraService{

	@Autowired
	CarreraJDBC carrera;
	
	@Override
	public List<Carrera> consultar() {
		// TODO Auto-generated method stub
		return carrera.consultar();
	}
	

	@Override
	public Carrera buscarPorId(int id) {
		// TODO Auto-generated method stub
		return carrera.buscarPorID(id);
	}

	@Override
	public Carrera crearCarrera(Carrera carrera1) {
		// TODO Auto-generated method stub
		return carrera.crear(carrera1);
	}

	@Override
	public void actualizar(Carrera carrera1) {
		// TODO Auto-generated method stub
		carrera.actualizar(carrera1);
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		carrera.eliminar(id);
		
	}

}