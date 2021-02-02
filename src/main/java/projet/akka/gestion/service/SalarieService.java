package projet.akka.gestion.service;


import java.util.List;
import java.util.Optional;

import javax.management.relation.Role;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import projet.akka.gestion.entity.*;

import projet.akka.gestion.repository.SalarieRepo;

@Service
public class SalarieService{
	
	@Autowired
	private SalarieRepo salarieRepo;

	public void createSalarie(String mail, String password, String nom, String prenom, projet.akka.gestion.entity.Service service, Role role, Salarie manager, List<Salarie> manage) {
		Salarie salarie = new Salarie();
		salarieRepo.save(salarie);
		
	}
	
	
	
	public Salarie save(Salarie s) {
		return salarieRepo.save(s);

	}

	public void delete(Salarie s) {
		salarieRepo.delete(s);
	}
	public void delete(Integer id) {
		salarieRepo.deleteById(id);
	}
	
	
	
	public Salarie findById(Integer id) {
		Optional<Salarie> opt = salarieRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Salarie();
	}

	
	
	public List<Salarie> findAll() {
		return salarieRepo.findAll();
	}
	
	
	public List<Salarie> findAllFilter(String mail) {
		return salarieRepo.findByMail(mail);
	}

}
