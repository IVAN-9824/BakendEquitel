package ms.equitel.bd.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ms.equitel.bd.modelo.Parte;
import ms.equitel.bd.service.ParteService;

@RestController
@RequestMapping ("/parte")
public class RestParte {

	@Autowired
	private ParteService parteService;

	@GetMapping("/get")
	private ResponseEntity<List<Parte>> getAllPartes(){
		return ResponseEntity.ok(parteService.findAll());
	}
	
	@PostMapping("/set")
	private ResponseEntity<Parte> saveParte(@RequestBody Parte parte) {
		try {
			Parte parteGuardada= parteService.save(parte);
			return ResponseEntity.created(new URI("/parte/set"+parteGuardada.getId())).body(parteGuardada);
			
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		
	}
}
