package mx.com.example.demo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.example.demo.models.Imparte;

public class ImparteRM implements RowMapper<Imparte> {

	@Override
	public Imparte mapRow(ResultSet rs, int rowNum) throws SQLException {
		Imparte imparte = new Imparte();
		imparte.setIdImparte(rs.getInt("IdImparte"));
		imparte.setIdprofesor(rs.getInt("idprofesor"));
		imparte.setNocontrol(rs.getInt("nocontrol"));
		imparte.setIdimparteMaterias(rs.getInt("idimparteMaterias"));
		imparte.setStatus(rs.getInt("status"));
		return imparte;
	}

}
