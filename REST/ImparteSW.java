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
import mx.com.example.demo.models.Imparte;
import mx.com.example.demo.service.ImparteService;


@RestController
@RequestMapping("/Imparte/v0")
public class ImparteSW {
	
	@Autowired
	ImparteService servicio;
	
	@GetMapping
	public ResponseEntity<List<Imparte>> consultar(){
		List<Imparte> respuesta = servicio.consultar();
		if (respuesta.isEmpty()) {
			return new ResponseEntity<>(respuesta,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Imparte>>(respuesta, HttpStatus.OK);
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Imparte> buscarPorId(@PathVariable int id)
	{
		Imparte imparte = null;
		try {
			imparte = servicio.buscarPorId(id);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Imparte>(imparte,HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<Imparte>(imparte,HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Imparte> crearImparte(@RequestBody Imparte imparte){
		Imparte respuesta= null;
		try {
			respuesta = servicio.crearImparte(imparte);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<Imparte>(respuesta,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Imparte>(respuesta,HttpStatus.CREATED);
		
	}
	
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Imparte imparte) {
		
		try {
			 servicio.actualizar(imparte);
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
