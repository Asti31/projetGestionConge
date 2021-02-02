package projet.akka.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.akka.gestion.entity.Salarie;

public interface SalarieRepo extends JpaRepository<Salarie,Integer>{

	
	
	
	public List<Salarie> findByMail(String mail);
	
	
	
}
