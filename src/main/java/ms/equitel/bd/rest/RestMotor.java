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

import ms.equitel.bd.modelo.Motor;
import ms.equitel.bd.service.MotorService;

@RestController
@RequestMapping("/motor/")
public class RestMotor {

	@Autowired
	private MotorService motorService;

	@GetMapping("get/")
	private ResponseEntity<List<Motor>> getAllMotor() {
		return ResponseEntity.ok(motorService.findAll());
	}

	@PostMapping("set/")
	private ResponseEntity<Motor> saveParte(@RequestBody Motor motor) {
		try {
			Motor motorGuardada = motorService.save(motor);
			return ResponseEntity.created(new URI("/motor/set/" + motorGuardada.getRef())).body(motorGuardada);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}
}
