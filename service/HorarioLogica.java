package mx.com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.example.demo.DAO.HorarioJDBC;
import mx.com.example.demo.models.Horario;

@Service
public class HorarioLogica implements HorarioService{

	@Autowired
	HorarioJDBC horario;
	
	@Override
	public List<Horario> consultar() {
		// TODO Auto-generated method stub
		return horario.consultar();
	}
	

	@Override
	public Horario buscarPorId(int id) {
		// TODO Auto-generated method stub
		return horario.buscarPorID(id);
	}

	@Override
	public Horario crearHorario(Horario horario1) {
		// TODO Auto-generated method stub
		return horario.crear(horario1);
	}

	@Override
	public void actualizar(Horario horario1) {
		// TODO Auto-generated method stub
		horario.actualizar(horario1);
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		horario.eliminar(id);
		
	}

}
