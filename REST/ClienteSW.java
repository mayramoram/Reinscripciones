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

import mx.com.example.demo.models.Cliente;
import mx.com.example.demo.service.ClienteService;


@RestController
@RequestMapping("/consumers/v0")
public class ClienteSW {
	
	@Autowired
	ClienteService servicio;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> consultar(){
		List<Cliente> respuesta = servicio.consultar();
		if (respuesta.isEmpty()) {
			return new ResponseEntity<>(respuesta,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Cliente>>(respuesta, HttpStatus.OK);
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable int id)
	{
		Cliente cliente = null;
		try {
			cliente = servicio.buscarPorId(id);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Cliente>(cliente,HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
		Cliente respuesta= null;
		try {
			respuesta = servicio.crearCliente(cliente);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("array response: "+ respuesta);
			return new ResponseEntity<Cliente>(respuesta,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Cliente>(respuesta,HttpStatus.CREATED);
		
	}
	
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Cliente cliente) {
		
		try {
			 servicio.actualizar(cliente);
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
