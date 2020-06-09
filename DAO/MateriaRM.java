package mx.com.example.demo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import mx.com.example.demo.models.Materia;

public class MateriaRM implements RowMapper<Materia> {

	@Override
	public Materia mapRow(ResultSet rs, int rowNum) throws SQLException {
		Materia materia = new Materia();
		materia.setIdMateria(rs.getInt("IdMateria"));
		materia.setNombre(rs.getString("Nombre"));
		materia.setCreditos(rs.getString("Creditos"));
		materia.setCarrera_id(rs.getInt("carrera_id"));
		materia.setStatus(rs.getInt("status"));
		return materia;
	}

}
