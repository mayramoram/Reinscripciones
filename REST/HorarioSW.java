package mx.com.example.demo.REST;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.com.example.demo.models.Horario;
import mx.com.example.demo.service.HorarioService;


@RestController
@RequestMapping("/Horario/v0")
public class HorarioSW {
	
	@Autowired
	HorarioService servicio;
	
	@GetMapping
	public ResponseEntity<List<Horario>> consultar(){
		List<Horario> respuesta = servicio.consultar();
		if (respuesta.isEmpty()) {
			return new ResponseEntity<>(respuesta,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Horario>>(respuesta, HttpStatus.OK);
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Horario> buscarPorId(@PathVariable int id)
	{
		Horario horario = null;
		try {
			horario = servicio.buscarPorId(id);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Horario>(horario,HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<Horario>(horario,HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Horario> crearCliente(@RequestBody Horario horario){
		Horario respuesta= null;
		try {
			respuesta = servicio.crearHorario(horario);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<Horario>(respuesta,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Horario>(respuesta,HttpStatus.CREATED);
		
	}
	
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Horario horario) {
		
		try {
			 servicio.actualizar(horario);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable int id)
	{
		try
		{
			servicio.eliminar(id);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
