package projet.akka.gestion.service;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import projet.akka.gestion.entity.Conge;
import projet.akka.gestion.entity.Salarie;
import projet.akka.gestion.entity.TypeConge;
import projet.akka.gestion.repository.CongeRepo;

@Service
public class CongeService {
	
	@Autowired
	private CongeRepo congeRepo;
	

	//public void creationPersonne(Personne p) {
	//if (p.getPrenom() != null && !p.getPrenom().isEmpty() && p.getNom() != null && !p.getNom().isEmpty()) {
	//personneRepo.save(p);
//} else {
		//System.out.println("la personne n'a pas toute les infos obligatoires");
	//}
//}
	
	
public void createConge(Salarie salarie, TypeConge typeConge, LocalDate dateDebut, LocalDate dateFin, String motif) {
	Conge conge = new Conge(salarie, typeConge, dateDebut, dateFin, motif);
	congeRepo.save(conge);
	
}
	
	public Conge save(Conge c) {
		return congeRepo.save(c);
		
	}

	public void delete(Conge c) {
		congeRepo.delete(c);
	}
	
	
	public void delete(Integer id) {
		congeRepo.deleteById(id);
	}

	public Conge findById(Integer id) {
		Optional<Conge> opt = congeRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Conge();
	}

	
	public List<Conge> findAll() {
		return congeRepo.findAll();
	}
	
	public List<Conge> findAllFilterByDate(LocalDate dateDebut, LocalDate dateFin) {
		
		return congeRepo.findAllFilterByDate(dateDebut, dateFin);
		
	}
		
	
	public List<Conge> findCongeByService(Integer id) {
		
		return congeRepo.findCongeByService(id);
	}
	
	
	public List<Conge> findAllFilterByServiceDate(Integer id, LocalDate dateDebut, LocalDate dateFin) {
		
		return congeRepo.findAllFilterByServiceDate(id,dateDebut, dateFin);
	}
	
	
	public List<Conge> demandeAttente() {
		return congeRepo.findByEtat("ATTENTE");
	}
	
	public List<Conge> demandeAttente(Salarie salarie) {
		return congeRepo.findByEtatAndSalarie("ATTENTE", salarie);
	}

	
	public List<Conge> demandeSalarie(Salarie s) {
		return congeRepo.findBySalarie(s);
	}
}
