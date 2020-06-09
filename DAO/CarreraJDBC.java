package mx.com.example.demo.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import mx.com.example.demo.models.Carrera;



@Repository
public class CarreraJDBC implements ICarrera {
	
	@Autowired
	JdbcTemplate jdbc;	
	String sql;

	@Override
	public List<Carrera> consultar() {
		sql = "SELECT * FROM reinscripciones.carreras where status = '1'";
		List<Carrera> carrera = jdbc.query(sql, new CarreraRM());
		return carrera;
	}

	@Override
	public Carrera buscarPorID(int id) {
		sql = "select * from carreras where IdCarrera =?";
		return jdbc.queryForObject(sql, new CarreraRM(),id);
	}
	
	@Override
	public Carrera crear(Carrera carrera) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);
		List<String> columna = new ArrayList<>();
		columna.add("IdCarrera");
		columna.add("nombre");
		columna.add("clave");
		columna.add("creditos");
		columna.add("status");
		
		insert.setTableName("carreras");
		insert.setColumnNames(columna);
		
		Map<String, Object> datos = new HashMap<>();
		datos.put("IdCarrera", carrera.getIdCarrera());
		datos.put("nombre", carrera.getNombre());
		datos.put("clave", carrera.getClave());
		datos.put("creditos", carrera.getCreditos());
		datos.put("status", carrera.getStatus());
		
		insert.setGeneratedKeyName("id");
		
		/*insert.setGeneratedKeyName("noControl");*/
		Number id = insert.executeAndReturnKey(datos);
		
		carrera.setIdCarrera(id.intValue());
		return carrera;
	}

	
	@Override
	public void actualizar(Carrera carrera) {
		// TODO Auto-generated method stub
		sql="UPDATE `reinscripciones`.`carreras` SET `nombre` = ?, `clave` = ?, `creditos` = ?, `status` = ? WHERE (`IdCarrera` = ?);\r\n";
		jdbc.update(sql, carrera.getNombre(),carrera.getClave(),carrera.getCreditos(),carrera.getStatus(),carrera.getIdCarrera());
	}

	@Override
	public void eliminar(int id) {
		sql = "UPDATE `reinscripciones`.`carreras` SET `status` = '0' WHERE (`IdCarrera` = ?)";
		jdbc.update(sql,id);
		
	}

}
