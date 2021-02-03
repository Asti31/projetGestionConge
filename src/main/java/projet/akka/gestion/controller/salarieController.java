package projet.akka.gestion.controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import projet.akka.gestion.entity.Conge;
import projet.akka.gestion.entity.Salarie;
import projet.akka.gestion.entity.TypeConge;
import projet.akka.gestion.entity.UserDetailsWithSalarie;
import projet.akka.gestion.service.CongeService;
import projet.akka.gestion.service.SalarieService;

@Controller
@RequestMapping("/salarie")
public class salarieController {

	@Autowired
	private SalarieService salarieService;
	@Autowired
	private CongeService congeService;


	@GetMapping({ "", "/" })
	public ModelAndView list(Authentication auth) {
		ModelAndView modelAndView = new ModelAndView("salarie/salarie", "conges", salarieService.findCongeBySalarie(((UserDetailsWithSalarie)auth.getPrincipal()).getId()));
		Salarie salarie = ((UserDetailsWithSalarie)auth.getPrincipal()).getSalarie();
		modelAndView.addObject("salarie", salarie);
		Conge conge = new Conge();
		conge.setSalarie(salarie);
		modelAndView.addObject("conge", conge);
		modelAndView.addObject("typesConge", TypeConge.values());
		
		return modelAndView;
	} 

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id") Integer id) {
		congeService.delete(id);
		return new ModelAndView("redirect:/salarie");
	}

	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id") Integer id) {
		return goForm(congeService.findById(id));
	}

	@GetMapping("/add")
	public ModelAndView add() {
		
		return goForm(new Conge());
	}

	private ModelAndView goForm(Conge conge) {
		ModelAndView modelAndView = new ModelAndView("salarie/salarie");
		modelAndView.addObject("conge", conge);

		return modelAndView;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute("conge") Conge conge, BindingResult br) {
		if (br.hasErrors()) {
			return goForm(conge);
		}
		conge.setNbJour(conge.calculeNbJour());
		congeService.save(conge);
		return new ModelAndView("redirect:/salarie");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
