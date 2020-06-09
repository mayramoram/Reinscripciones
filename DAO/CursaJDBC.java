package mx.com.example.demo.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import mx.com.example.demo.models.Cursa;



@Repository
public class CursaJDBC implements ICursa {
	
	@Autowired
	JdbcTemplate jdbc;	
	String sql;

	@Override
	public List<Cursa> consultar() {
		sql = "SELECT * FROM reinscripciones.cursa where status = '1'";
		List<Cursa> cursa = jdbc.query(sql, new CursaRM());
		return cursa;
	}

	@Override
	public Cursa buscarPorID(int id) {
		sql = "select * from cursa where IdCursa =?";
		
		return jdbc.queryForObject(sql, new CursaRM(),id);
	}
	
	@Override
	public Cursa crear(Cursa cursa) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);
		List<String> columna = new ArrayList<>();
		columna.add("IdCursa");
		columna.add("nocontrol");
		columna.add("idCursaMaterias");
		columna.add("status");
		
		insert.setTableName("cursa");
		insert.setColumnNames(columna);
		
		Map<String, Object> datos = new HashMap<>();
		datos.put("IdCursa", cursa.getIdCursa());
		datos.put("nocontrol", cursa.getNocontrol());
		datos.put("idCursaMaterias", cursa.getIdCursaMaterias());
		datos.put("status", cursa.getStatus());
		
		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(datos);
		
		cursa.setIdCursa(id.intValue());
		return cursa;
	}

	
	@Override
	public void actualizar(Cursa cursa) {
		// TODO Auto-generated method stub
		sql="UPDATE `reinscripciones`.`cursa` SET `nocontrol` = ?, `idCursaMaterias` = ?, `status` = ? WHERE (`IdCursa` = ?);\r\n";
		jdbc.update(sql, cursa.getNocontrol(),cursa.getIdCursaMaterias(),cursa.getStatus(),cursa.getIdCursa());
	}

	@Override
	public void eliminar(int id) {
		sql = "UPDATE `reinscripciones`.`cursa` SET `status` = '0' WHERE (`IdCursa` = ?)";
		jdbc.update(sql,id);
		
	}

}
