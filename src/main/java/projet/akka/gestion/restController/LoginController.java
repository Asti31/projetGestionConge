package projet.akka.gestion.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.akka.gestion.entity.Salarie;
import projet.akka.gestion.entity.UserDetailsWithSalarie;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins="*")
public class LoginController {
	
	@GetMapping("")
	public ResponseEntity<Salarie> login(Authentication auth) {
		Salarie salarie = ((UserDetailsWithSalarie)auth.getPrincipal()).getSalarie();
		return new ResponseEntity<Salarie>(salarie,HttpStatus.OK);
	}
}
