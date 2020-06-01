package Reinscripciones.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Reinscripciones.models.horarios;

public class HorarioRM implements RowMapper<horarios> {

	@Override
	public horarios mapRow(ResultSet rs, int rowNum) throws SQLException {

		horarios horario = new horarios();
		horario.setIdHorario(rs.getInt("idHorario"));
		horario.setIdCarrera(rs.getInt("idCarrera"));
		horario.setTurno(rs.getString("turno"));
		horario.setSemestre(rs.getInt("semestre"));
		horario.setIdmateria1(rs.getInt("idmateria1"));
		horario.setIdmateria2(rs.getInt("idmateria2"));
		horario.setIdmateria3(rs.getInt("idmateria3"));
		horario.setIdmateria4(rs.getInt("idmateria4"));
		horario.setIdmateria5(rs.getInt("idmateria5"));
		
		
		
		return horario;
	}

}
