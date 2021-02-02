package projet.akka.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.akka.gestion.entity.Service;

public interface ServiceRepo extends JpaRepository<Service,Integer>{

	public List<Service> findByLibelle(String libelle);
}
