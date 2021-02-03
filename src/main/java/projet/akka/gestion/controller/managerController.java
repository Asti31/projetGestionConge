package projet.akka.gestion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import projet.akka.gestion.entity.Conge;
import projet.akka.gestion.entity.Salarie;
import projet.akka.gestion.entity.UserDetailsWithSalarie;
import projet.akka.gestion.service.CongeService;
import projet.akka.gestion.service.SalarieService;


@Controller
@RequestMapping("/manager")
public class managerController {
	@Autowired
	private CongeService congeService;

	
	
	@GetMapping({ "", "/" })
	public ModelAndView list(Authentication auth) {
		Salarie manager = ((UserDetailsWithSalarie)auth.getPrincipal()).getSalarie();
		List<Conge> listConges= new ArrayList<Conge>();
		for (Salarie salarie : manager.getManage()) {
			listConges.addAll(congeService.demandeAttente(salarie));
		}
		ModelAndView modelAndView = new ModelAndView("manager/manager", "conges", listConges);
		
		return modelAndView;
	} 

//	@GetMapping("/delete")
//	public ModelAndView delete(@RequestParam(name = "id") Integer id) {
//		congeService.delete(id);
//		return new ModelAndView("redirect:/salarie");
//	}
//
//	@GetMapping("/edit")
//	public ModelAndView edit(@RequestParam(name = "id") Integer id) {
//		return goForm(congeService.findById(id));
//	}
//
//	@GetMapping("/add")
//	public ModelAndView add() {
//		
//		return goForm(new Conge());
//	}
//
	private ModelAndView goForm(Conge conge) {
		ModelAndView modelAndView = new ModelAndView("salarie/salarie");
		modelAndView.addObject("conge", conge);

		return modelAndView;
	}

	@PostMapping("/save")
	public ModelAndView save(@ModelAttribute("conge") Conge conge) {
		Conge congeIB = congeService.findById(conge.getId());
		congeIB.setMotif(conge.getMotif());
		congeIB.setEtat(conge.getEtat());
		congeService.save(congeIB);
		return new ModelAndView("redirect:/manager");
	}
}
