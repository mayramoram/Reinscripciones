package Reinscripciones.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Reinscripciones.models.horarios;

@Repository
public class HorariosJDBC implements HorarioDAO {
	
	@Autowired
	
	String sql;
	JdbcTemplate jdbc;
	
	@Override
	public List<horarios> consultar() {
		sql = "SELECT * FROM horarios";
		return jdbc.query(sql, new HorarioRM());
		
	}
	
	
	public void Insertar(horarios horas) {
		sql = "insert into horarios values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbc.update(sql, horas.getIdHorario(),horas.getIdCarrera(),horas.getTurno(), horas.getSemestre(), horas.getIdmateria1(), horas.getIdmateria2(), horas.getIdmateria3(), horas.getIdmateria4(), horas.getIdmateria5());
	}
	
	public horarios Buscar(int idHorario) {
		sql = "select * from horarios where idHorario =?";
		return jdbc.queryForObject(sql, new HorarioRM(), idHorario);
	}
	
	@Override
	public void eliminar(int idHorario) {
		sql = "delete from horarios where idHorario = ?";
		jdbc.update(sql, idHorario);
	}
	
	@Override
	public void actualizar(horarios horario) {
		sql = "update horarios set idCarrera=?, turno =?, semestre=? where idHorario=?";
		jdbc.update(sql, horario.getIdHorario(),horario.getIdCarrera(),horario.getTurno(), horario.getSemestre(), horario.getIdmateria1(), horario.getIdmateria2(), horario.getIdmateria3(), horario.getIdmateria4(), horario.getIdmateria5());

	}

}
