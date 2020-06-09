package mx.com.example.demo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.com.example.demo.models.Cursa;

public class CursaRM implements RowMapper<Cursa> {

	@Override
	public Cursa mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cursa cursa = new Cursa();
		cursa.setIdCursa(rs.getInt("IdCursa"));
		cursa.setNocontrol(rs.getInt("nocontrol"));
		cursa.setIdCursaMaterias(rs.getInt("idCursaMaterias"));
		cursa.setStatus(rs.getInt("status"));
		return cursa;
	}

}
