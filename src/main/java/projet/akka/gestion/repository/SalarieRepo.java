package projet.akka.gestion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.akka.gestion.entity.Conge;
import projet.akka.gestion.entity.Salarie;

public interface SalarieRepo extends JpaRepository<Salarie,Integer>{

	
	public Optional<Salarie> findByMail(String mail);
	
	
	@Query ("Select c from Conge c left join c.salarie s where s.id= :id")
	public List<Conge> findCongeBySalarie(@Param("id")Integer id);



}
