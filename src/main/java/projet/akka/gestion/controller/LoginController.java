package projet.akka.gestion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/accueil")
	public String accueil() {
		
		return "accueil";
	}
	
	@GetMapping("")
	public String salarie() {
		
		return "salarie/salarie";
	}

	@GetMapping("/home")
	public String home() {
		
		return "/home";
	}
	
}
