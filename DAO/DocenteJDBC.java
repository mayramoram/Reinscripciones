package mx.com.example.demo.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import mx.com.example.demo.models.Docente;



@Repository
public class DocenteJDBC implements IDocente {
	
	@Autowired
	JdbcTemplate jdbc;	
	String sql;

	@Override
	public List<Docente> consultar() {
		sql = "SELECT * FROM reinscripciones.profesor where status = '1'";
		List<Docente> docente = jdbc.query(sql, new DocenteRM());
		return docente;
	}

	@Override
	public Docente buscarPorID(int id) {
		sql = "select * from profesor where IdProfesor =?";
		
		return jdbc.queryForObject(sql, new DocenteRM(),id);
	}
	
	@Override
	public Docente crear(Docente docente) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);
		List<String> columna = new ArrayList<>();
		columna.add("IdProfesor");
		columna.add("Nombre");
		columna.add("ApellidoP");
		columna.add("ApellidoM");
		columna.add("email");
		columna.add("password");
		columna.add("Turno");
		columna.add("especialidad");
		columna.add("status");
		
		insert.setTableName("profesor");
		insert.setColumnNames(columna);
		
		Map<String, Object> datos = new HashMap<>();
		datos.put("IdProfesor", docente.getIdProfesor());
		datos.put("Nombre", docente.getNombre());
		datos.put("ApellidoP", docente.getApellidoP());
		datos.put("ApellidoM", docente.getApellidoM());
		datos.put("email", docente.getEmail());
		datos.put("password", docente.getPassword());
		datos.put("Turno", docente.getTurno());
		datos.put("especialidad", docente.getEspecialidad());
		datos.put("status", docente.getStatus());
		
		insert.setGeneratedKeyName("id");
		
		/*insert.setGeneratedKeyName("noControl");*/
		Number id = insert.executeAndReturnKey(datos);
		
		docente.setId(id.intValue());
		return docente;
	}

	
	@Override
	public void actualizar(Docente docente) {
		// TODO Auto-generated method stub
		sql="UPDATE `reinscripciones`.`profesor` SET `Nombre` = ?, `ApellidoP` = ?, `ApellidoM` = ?, `email` = ?, `password` = ?, `Turno` = ?, `especialidad` = ?, `status` = ? WHERE (`IdProfesor` = ?);\r\n";
		jdbc.update(sql, docente.getNombre(),docente.getApellidoP(),docente.getApellidoM(),docente.getEmail(),docente.getPassword(),docente.getTurno(),docente.getEspecialidad(),docente.getStatus(),docente.getIdProfesor());
	}

	@Override
	public void eliminar(int id) {
		sql = "UPDATE `reinscripciones`.`profesor` SET `status` = '0' WHERE (`IdProfesor` = ?)";
		jdbc.update(sql,id);
		
	}

}
