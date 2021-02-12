package projet.akka.gestion.restController;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import projet.akka.gestion.entity.Salarie;
import projet.akka.gestion.entity.Vue;
import projet.akka.gestion.entity.Vue.EmployeWithManager;
import projet.akka.gestion.exception.SalarieInvalidException;
import projet.akka.gestion.exception.SalarieNotFoundException;
import projet.akka.gestion.service.SalarieService;

@RestController
@RequestMapping("/api/salarie")
@CrossOrigin(origins="*")
public class SalarieRestController {

	@Autowired
	private SalarieService salarieService;

	@JsonView(EmployeWithManager.class)
	@GetMapping({ "", "/" })
	public List<Salarie> getAllSalarie() {
		return salarieService.findAll();
	}
	
	@JsonView(Vue.Common.class)
	@GetMapping({ "/lazy" })
	public List<Salarie> getAllSalarieLazy() {
		return salarieService.findAll();
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Salarie> addSalarie(@Valid @RequestBody Salarie p, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new SalarieInvalidException();
		}
		salarieService.createSalarie(p.getMail(), p.getPassword(), p.getNom(), p.getPrenom(), p.getService(), p.getRole(), p.getManager(), p.getManage());
		URI uri = uCB.path("/api/salarie/{id}").buildAndExpand(p.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Salarie>(p, headers, HttpStatus.CREATED);
	}

	@JsonView(EmployeWithManager.class)
	@GetMapping("/{id}")
	public Salarie findById(@PathVariable("id") Integer id) {
		Salarie p = salarieService.findById(id);
		if (p.getId() != null) {
			return p;
		}
		throw new SalarieNotFoundException();
	}

	@PutMapping("/{id}")
	@JsonView(EmployeWithManager.class)
	public Salarie update(@Valid @RequestBody Salarie p, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new SalarieInvalidException();
		}
		Salarie salarieEnBase = salarieService.findById(id);
		if (salarieEnBase.getId() == null) {
			throw new SalarieNotFoundException();
		}
		salarieEnBase.setNom(p.getNom());
		salarieEnBase.setMail(p.getMail());
		salarieEnBase.setService(p.getService());
		salarieEnBase.setRole(p.getRole());
		salarieService.save(salarieEnBase);
		return salarieEnBase;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Salarie salarieEnBase = salarieService.findById(id);
		if (salarieEnBase.getId() == null) {
			throw new SalarieNotFoundException();
		}
		salarieService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
