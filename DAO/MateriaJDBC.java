package mx.com.example.demo.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import mx.com.example.demo.models.Materia;



@Repository
public class MateriaJDBC implements IMateria {
	
	@Autowired
	JdbcTemplate jdbc;	
	String sql;

	@Override
	public List<Materia> consultar() {
		sql = "SELECT * FROM reinscripciones.materias where status = '1'";
		List<Materia> materia = jdbc.query(sql, new MateriaRM());
		return materia;
	}

	@Override
	public Materia buscarPorID(int id) {
		sql = "select * from materias where IdMateria =?";
		
		return jdbc.queryForObject(sql, new MateriaRM(),id);
	}
	
	@Override
	public Materia crear(Materia materia) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);
		List<String> columna = new ArrayList<>();
		columna.add("IdMateria");
		columna.add("Nombre");
		columna.add("Creditos");
		columna.add("carrera_id");
		columna.add("status");
		
		insert.setTableName("materias");
		insert.setColumnNames(columna);
		
		Map<String, Object> datos = new HashMap<>();
		datos.put("IdMateria", materia.getIdMateria());
		datos.put("Nombre", materia.getNombre());
		datos.put("Creditos", materia.getCreditos());
		datos.put("carrera_id", materia.getCarrera_id());
		datos.put("status", materia.getStatus());
		
		insert.setGeneratedKeyName("id");
		
		/*insert.setGeneratedKeyName("noControl");*/
		Number id = insert.executeAndReturnKey(datos);
		
		materia.setIdMateria(id.intValue());
		return materia;
	}

	
	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		sql="UPDATE `reinscripciones`.`materias` SET `Nombre` = ?, `Creditos` = ?, `carrera_id` = ?, `status` = ? WHERE (`IdMateria` = ?);\r\n";
		jdbc.update(sql, materia.getNombre(),materia.getCreditos(),materia.getCarrera_id(),materia.getStatus(),materia.getIdMateria());
	}

	@Override
	public void eliminar(int id) {
		sql = "UPDATE `reinscripciones`.`materias` SET `status` = '0' WHERE (`IdMateria` = ?)";
		jdbc.update(sql,id);
		
	}

}
