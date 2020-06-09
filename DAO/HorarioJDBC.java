package mx.com.example.demo.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import mx.com.example.demo.models.Horario;



@Repository
public class HorarioJDBC implements IHorario {
	
	@Autowired
	JdbcTemplate jdbc;	
	String sql;

	@Override
	public List<Horario> consultar() {
		sql = "SELECT * FROM reinscripciones.horarios where status = '1'";
		List<Horario> horario = jdbc.query(sql, new HorarioRM());
		return horario;
	}

	@Override
	public Horario buscarPorID(int id) {
		sql = "select * from horarios where idHorario =?";
		
		return jdbc.queryForObject(sql, new HorarioRM(),id);
	}
	
	@Override
	public Horario crear(Horario horario) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);
		List<String> columna = new ArrayList<>();
		columna.add("idHorario");
		columna.add("idCarrera");
		columna.add("turno");
		columna.add("semestre");
		columna.add("idmateria1");
		columna.add("idmateria2");
		columna.add("idmateria3");
		columna.add("idmateria4");
		columna.add("idmateria5");
		columna.add("status");
		
		insert.setTableName("horarios");
		insert.setColumnNames(columna);
		
		Map<String, Object> datos = new HashMap<>();
		datos.put("idHorario", horario.getIdHorario());
		datos.put("idCarrera", horario.getIdCarrera());
		datos.put("turno", horario.getTurno());
		datos.put("semestre", horario.getSemestre());
		datos.put("idmateria1", horario.getIdmateria1());
		datos.put("idmateria2", horario.getIdmateria2());
		datos.put("idmateria3", horario.getIdmateria3());
		datos.put("idmateria4", horario.getIdmateria4());
		datos.put("idmateria5", horario.getIdmateria5());
		datos.put("status", horario.getStatus());
		
		insert.setGeneratedKeyName("id");
		Number id = insert.executeAndReturnKey(datos);
		
		horario.setIdHorario(id.intValue());
		return horario;
	}

	
	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub
		sql="UPDATE `reinscripciones`.`horarios` SET `idCarrera` = ?, `turno` = ?, `semestre` = ?, `idmateria1` = ?, `idmateria2` = ?, `idmateria3` = ?, `idmateria4` = ?, `idmateria5` = ?, `status` = ? WHERE (`idHorario` = ?);\r\n";
		jdbc.update(sql, horario.getIdCarrera(),horario.getTurno(),horario.getSemestre(),horario.getIdmateria1(),horario.getIdmateria2(),horario.getIdmateria3(),horario.getIdmateria4(),horario.getIdmateria5(),horario.getStatus(),horario.getIdHorario());
	}

	@Override
	public void eliminar(int id) {
		sql = "UPDATE `reinscripciones`.`horarios` SET `status` = '0' WHERE (`idHorario` = ?)";
		jdbc.update(sql,id);
		
	}

}
