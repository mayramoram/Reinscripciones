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
import mx.com.example.demo.models.Materia;
import mx.com.example.demo.service.MateriaService;


@RestController
@RequestMapping("/Materia/v0")
public class MateriaSW {
	
	@Autowired
	MateriaService servicio;
	
	@GetMapping
	public ResponseEntity<List<Materia>> consultar(){
		List<Materia> respuesta = servicio.consultar();
		if (respuesta.isEmpty()) {
			return new ResponseEntity<>(respuesta,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Materia>>(respuesta, HttpStatus.OK);
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Materia> buscarPorId(@PathVariable int id)
	{
		Materia materia = null;
		try {
			materia = servicio.buscarPorId(id);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Materia>(materia,HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<Materia>(materia,HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Materia> crearCliente(@RequestBody Materia materia){
		Materia respuesta= null;
		try {
			respuesta = servicio.crearMateria(materia);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<Materia>(respuesta,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Materia>(respuesta,HttpStatus.CREATED);
		
	}
	
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Materia materia) {
		
		try {
			 servicio.actualizar(materia);
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
