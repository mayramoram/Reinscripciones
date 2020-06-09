package mx.com.example.demo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.example.demo.models.Horario;

public class HorarioRM implements RowMapper<Horario> {

	@Override
	public Horario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Horario horario = new Horario();
		horario.setIdHorario(rs.getInt("idHorario"));
		horario.setIdCarrera(rs.getInt("idCarrera"));
		horario.setTurno(rs.getString("turno"));
		horario.setSemestre(rs.getString("semestre"));
		horario.setIdmateria1(rs.getInt("idmateria1"));
		horario.setIdmateria2(rs.getInt("idmateria2"));
		horario.setIdmateria3(rs.getInt("idmateria3"));
		horario.setIdmateria4(rs.getInt("idmateria4"));
		horario.setIdmateria5(rs.getInt("idmateria5"));
		horario.setStatus(rs.getInt("status"));
		return horario;
	}

}
