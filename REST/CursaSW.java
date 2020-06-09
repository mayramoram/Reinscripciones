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
import mx.com.example.demo.models.Cursa;
import mx.com.example.demo.service.CursaService;


@RestController
@RequestMapping("/Cursa/v0")
public class CursaSW {
	
	@Autowired
	CursaService servicio;
	
	@GetMapping
	public ResponseEntity<List<Cursa>> consultar(){
		List<Cursa> respuesta = servicio.consultar();
		if (respuesta.isEmpty()) {
			return new ResponseEntity<>(respuesta,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Cursa>>(respuesta, HttpStatus.OK);
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Cursa> buscarPorId(@PathVariable int id)
	{
		Cursa cursa = null;
		try {
			cursa = servicio.buscarPorId(id);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Cursa>(cursa,HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<Cursa>(cursa,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cursa> crearCursa(@RequestBody Cursa cursa){
		Cursa respuesta= null;
		try {
			respuesta = servicio.crearCursa(cursa);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<Cursa>(respuesta,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Cursa>(respuesta,HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Cursa cursa) {
		
		try {
			 servicio.actualizar(cursa);
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
