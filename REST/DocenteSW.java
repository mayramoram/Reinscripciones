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
import mx.com.example.demo.models.Docente;
import mx.com.example.demo.service.DocenteService;


@RestController
@RequestMapping("/Docente/v0")
public class DocenteSW {
	
	@Autowired
	DocenteService servicio;
	
	@GetMapping
	public ResponseEntity<List<Docente>> consultar(){
		List<Docente> respuesta = servicio.consultar();
		if (respuesta.isEmpty()) {
			return new ResponseEntity<>(respuesta,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Docente>>(respuesta, HttpStatus.OK);
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Docente> buscarPorId(@PathVariable int id)
	{
		Docente docente = null;
		try {
			docente = servicio.buscarPorId(id);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Docente>(docente,HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<Docente>(docente,HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Docente> crearCliente(@RequestBody Docente docente){
		Docente respuesta= null;
		try {
			respuesta = servicio.crearDocente(docente);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<Docente>(respuesta,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Docente>(respuesta,HttpStatus.CREATED);
		
	}
	
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Docente docente) {
		
		try {
			 servicio.actualizar(docente);
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
