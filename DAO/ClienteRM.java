package mx.com.example.demo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.example.demo.models.Cliente;

public class ClienteRM implements RowMapper<Cliente> {

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente cliente = new Cliente();
		/*cliente.setId(rs.getInt("id"));*/
		cliente.setNoControl(rs.getInt("NoControl"));
		cliente.setNombre(rs.getString("Nombre"));
		cliente.setApellidoP(rs.getString("ApellidoP"));
		cliente.setApellidoM(rs.getString("ApellidoM"));
		cliente.setSexo(rs.getString("Sexo"));
		cliente.setIdCarrera(rs.getInt("IdCarrera"));
		cliente.setSemestre(rs.getString("Semestre"));
		cliente.setEmail(rs.getString("email"));
		cliente.setPassword(rs.getString("password"));
		cliente.setStatus(rs.getInt("status"));
		
		
		return cliente;
	}

}
