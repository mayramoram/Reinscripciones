package mx.com.example.demo.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import mx.com.example.demo.models.Imparte;

@Repository
public class ImparteJDBC implements IImparte {
	
	@Autowired
	JdbcTemplate jdbc;	
	String sql;

	@Override
	public List<Imparte> consultar() {
		sql = "SELECT * FROM reinscripciones.imparte where status = '1'";
		List<Imparte> imparte = jdbc.query(sql, new ImparteRM());
		return imparte;
	}

	@Override
	public Imparte buscarPorID(int id) {
		sql = "select * from imparte where IdImparte =?";
		
		return jdbc.queryForObject(sql, new ImparteRM(),id);
	}
	
	@Override
	public Imparte crear(Imparte imparte) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);
		List<String> columna = new ArrayList<>();
		columna.add("IdImparte");
		columna.add("idprofesor");
		columna.add("nocontrol");
		columna.add("idimparteMaterias");
		columna.add("status");
		
		insert.setTableName("imparte");
		insert.setColumnNames(columna);
		
		Map<String, Object> datos = new HashMap<>();
		datos.put("IdImparte", imparte.getIdImparte());
		datos.put("idprofesor", imparte.getIdprofesor());
		datos.put("nocontrol", imparte.getNocontrol());
		datos.put("idimparteMaterias", imparte.getIdimparteMaterias());
		datos.put("status", imparte.getStatus());
		
		insert.setGeneratedKeyName("id");
		
		/*insert.setGeneratedKeyName("noControl");*/
		Number id = insert.executeAndReturnKey(datos);
		
		imparte.setIdImparte(id.intValue());
		return imparte;
	}

	
	@Override
	public void actualizar(Imparte imparte) {
		// TODO Auto-generated method stub
		sql="UPDATE `reinscripciones`.`imparte` SET `idprofesor` = ?, `nocontrol` = ?, `idimparteMaterias` = ?, `status` = ? WHERE (`IdImparte` = ?);\r\n";
		jdbc.update(sql, imparte.getIdprofesor(),imparte.getNocontrol(),imparte.getIdimparteMaterias(),imparte.getStatus(),imparte.getIdImparte());
	}

	@Override
	public void eliminar(int id) {
		sql = "UPDATE `reinscripciones`.`imparte` SET `status` = '0' WHERE (`IdImparte` = ?)";
		jdbc.update(sql,id);
		
	}

}
