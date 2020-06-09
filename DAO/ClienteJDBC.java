package mx.com.example.demo.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import mx.com.example.demo.models.Cliente;



@Repository
public class ClienteJDBC implements ICliente {
	
	@Autowired
	JdbcTemplate jdbc;	
	String sql;

	@Override
	public List<Cliente> consultar() {
		sql = "SELECT * FROM reinscripciones.Alumnos where status = '1'";
		List<Cliente> cliente = jdbc.query(sql, new ClienteRM());
		return cliente;
	}

	@Override
	public Cliente buscarPorID(int id) {
		sql = "select * from alumnos where NoControl =?";
		
		return jdbc.queryForObject(sql, new ClienteRM(),id);
	}
	
	@Override
	public Cliente crear(Cliente cliente) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);
		List<String> columna = new ArrayList<>();
		columna.add("NoControl");
		columna.add("Nombre");
		columna.add("ApellidoP");
		columna.add("ApellidoM");
		columna.add("Sexo");
		columna.add("IdCarrera");
		columna.add("Semestre");
		columna.add("email");
		columna.add("password");
		columna.add("status");
		
		
		insert.setTableName("alumnos");
		insert.setColumnNames(columna);
		
		Map<String, Object> datos = new HashMap<>();
		datos.put("NoControl", cliente.getNoControl());
		datos.put("Nombre", cliente.getNombre());
		datos.put("ApellidoP", cliente.getApellidoP());
		datos.put("ApellidoM", cliente.getApellidoM());
		datos.put("Sexo", cliente.getSexo());
		datos.put("IdCarrera", cliente.getIdCarrera());
		datos.put("Semestre", cliente.getSemestre());
		datos.put("email", cliente.getEmail());
		datos.put("password", cliente.getPassword());
		datos.put("status", cliente.getStatus());
		
		insert.setGeneratedKeyName("id");
		
		/*insert.setGeneratedKeyName("noControl");*/
		Number id = insert.executeAndReturnKey(datos);
		
		cliente.setId(id.intValue());
		return cliente;
	}

	
	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		sql="UPDATE `reinscripciones`.`alumnos` SET `Nombre` = ?, `ApellidoP` = ?, `ApellidoM` = ?, `Sexo` = ?, `IdCarrera` = ?, `Semestre` = ?, `email` = ?, `password` = ?,`status` = ? WHERE (`NoControl` = ?);\r\n";
		jdbc.update(sql, cliente.getNombre(),cliente.getApellidoP(),cliente.getApellidoM(),cliente.getSexo(),cliente.getIdCarrera(),cliente.getSemestre(),cliente.getEmail(),cliente.getPassword(),cliente.getStatus(),cliente.getNoControl());
		System.out.println(jdbc);
	}

	@Override
	public void eliminar(int id) {
		sql = "UPDATE `reinscripciones`.`alumnos` SET `status` = '0' WHERE (`NoControl` = ?)";
		jdbc.update(sql,id);
		
	}

}
