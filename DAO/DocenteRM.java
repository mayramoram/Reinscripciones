package mx.com.example.demo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.example.demo.models.Docente;

public class DocenteRM implements RowMapper<Docente> {

	@Override
	public Docente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Docente docente = new Docente();
		/*cliente.setId(rs.getInt("id"));*/
		docente.setIdProfesor(rs.getInt("IdProfesor"));
		docente.setNombre(rs.getString("Nombre"));
		docente.setApellidoP(rs.getString("ApellidoP"));
		docente.setApellidoM(rs.getString("ApellidoM"));
		docente.setEmail(rs.getString("email"));
		docente.setTurno(rs.getString("Turno"));
		docente.setPassword(rs.getString("Password"));
		docente.setEspecialidad(rs.getString("especialidad"));
		docente.setStatus(rs.getInt("status"));
		return docente;
	}

}
