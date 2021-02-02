package projet.akka.gestion.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.akka.gestion.entity.Conge;
import projet.akka.gestion.entity.Salarie;

public interface CongeRepo extends JpaRepository<Conge,Integer>{


	@Query("Select c from Conge c left join c.salarie s left join s.service b where s.id=c.salarie and b.id=:id")
	public List<Conge> findCongeByService(@Param("id")Integer id);


	@Query("Select e from Conge e where e.dateDebut >= :dateDebut and e.dateFin <= :dateFin")
	public List<Conge> findAllFilterByDate(@Param("dateDebut")LocalDate dateDebut, @Param("dateFin")LocalDate dateFin);
	
	
	@Query("Select c from Conge c left join c.salarie s left join s.service b where s.id=c.salarie and b.id=:id and c.dateDebut >= :dateDebut and c.dateFin <= :dateFin")
	List<Conge> findAllFilterByServiceDate(Integer id, LocalDate dateDebut, LocalDate dateFin);
	
	
	List<Conge> findByEtat(String etat);
	
	
	List<Conge> findBySalarie(Salarie id);
}
