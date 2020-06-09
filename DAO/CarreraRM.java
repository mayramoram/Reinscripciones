package mx.com.example.demo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.example.demo.models.Carrera;
public class CarreraRM implements RowMapper<Carrera> {

	@Override
	public Carrera mapRow(ResultSet rs, int rowNum) throws SQLException {
		Carrera carrera = new Carrera();
		/*cliente.setId(rs.getInt("id"));*/
		carrera.setIdCarrera(rs.getInt("IdCarrera"));
		carrera.setNombre(rs.getString("nombre"));
		carrera.setClave(rs.getString("clave"));
		carrera.setCreditos(rs.getInt("creditos"));
		carrera.setStatus(rs.getInt("status"));
		return carrera;
	}

}
