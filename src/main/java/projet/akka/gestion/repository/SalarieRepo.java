package projet.akka.gestion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.akka.gestion.entity.Salarie;

public interface SalarieRepo extends JpaRepository<Salarie,Integer>{

	
	
	
	public Optional<Salarie> findByMail(String mail);
	
	
	
}
