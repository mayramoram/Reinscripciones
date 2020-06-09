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
import mx.com.example.demo.models.Carrera;
import mx.com.example.demo.service.CarreraService;


@RestController
@RequestMapping("/Carrera/v0")
public class CarreraSW {
	
	@Autowired
	CarreraService servicio;
	
	@GetMapping
	public ResponseEntity<List<Carrera>> consultar(){
		List<Carrera> respuesta = servicio.consultar();
		if (respuesta.isEmpty()) {
			return new ResponseEntity<>(respuesta,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Carrera>>(respuesta, HttpStatus.OK);
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Carrera> buscarPorId(@PathVariable int id)
	{
		Carrera carrera = null;
		try {
			carrera = servicio.buscarPorId(id);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Carrera>(carrera,HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<Carrera>(carrera,HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Carrera> crearCarrera(@RequestBody Carrera carrera){
		Carrera respuesta= null;
		try {
			respuesta = servicio.crearCarrera(carrera);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<Carrera>(respuesta,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Carrera>(respuesta,HttpStatus.CREATED);
		
	}
	
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Carrera carrera) {
		
		try {
			 servicio.actualizar(carrera);
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
