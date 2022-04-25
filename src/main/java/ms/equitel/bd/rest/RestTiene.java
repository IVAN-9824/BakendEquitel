package ms.equitel.bd.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ms.equitel.bd.modelo.Parte;
import ms.equitel.bd.modelo.Tiene;
import ms.equitel.bd.service.TieneService;

@RestController
@RequestMapping ("/tiene/")
public class RestTiene {

	@Autowired
	private TieneService tieneService;
	
	@PostMapping("set/")
	private ResponseEntity<Tiene> saveParte(@RequestBody Tiene tiene) {
		try {
			Tiene tieneGuardada= tieneService.save(tiene);
			return ResponseEntity.created(new URI("/parte/set/"+tieneGuardada.getId())).body(tieneGuardada);
			
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		
	}
	@GetMapping("get/{id}/")
	private ResponseEntity<List<Tiene>> getAllTieneByMotor (@PathVariable("id") String id){
		return ResponseEntity.ok(tieneService.findAllByMotor(id));
	} 
}
