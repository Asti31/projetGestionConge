package projet.akka.gestion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	@GetMapping("/accueil")
	public String accueil() {
		
		return "accueil";
	}


	@GetMapping("/home")
	public String home() {
		
		return "/home";
	}
	
}
