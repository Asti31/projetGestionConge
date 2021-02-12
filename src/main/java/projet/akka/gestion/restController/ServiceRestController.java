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

import projet.akka.gestion.entity.Service;
import projet.akka.gestion.entity.Vue;
import projet.akka.gestion.entity.Vue.EmployeWithManager;
import projet.akka.gestion.exception.ServiceInvalidException;
import projet.akka.gestion.exception.ServiceNotFoundException;
import projet.akka.gestion.service.ServiceService;

@RestController
@RequestMapping("/api/service")
@CrossOrigin(origins="*")
public class ServiceRestController {

	@Autowired
	private ServiceService serviceService;

	@JsonView(Vue.Common.class)
	@GetMapping({ "", "/" })
	public List<Service> getAllService() {
		return serviceService.findAll();
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Service> addService(@Valid @RequestBody Service p, BindingResult br,
			UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			throw new ServiceInvalidException();
		}
		serviceService.createService(p.getLibelle());
		URI uri = uCB.path("/api/service/{id}").buildAndExpand(p.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Service>(p, headers, HttpStatus.CREATED);
	}

	@JsonView(Vue.Common.class)
	@GetMapping("/{id}")
	public Service findById(@PathVariable("id") Integer id) {
		Service p = serviceService.findById(id);
		if (p.getId() != null) {
			return p;
		}
		throw new ServiceNotFoundException();
	}

	@PutMapping("/{id}")
	public Service update(@Valid @RequestBody Service p, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new ServiceInvalidException();
		}
		Service serviceEnBase = serviceService.findById(id);
		if (serviceEnBase.getId() == null) {
			throw new ServiceNotFoundException();
		}
		serviceEnBase.setLibelle(p.getLibelle());
		serviceService.save(serviceEnBase);
		return serviceEnBase;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Service serviceEnBase = serviceService.findById(id);
		if (serviceEnBase.getId() == null) {
			throw new ServiceNotFoundException();
		}
		serviceService.delete(serviceEnBase);;
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
