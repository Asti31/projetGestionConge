package projet.akka.gestion.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import projet.akka.gestion.entity.Conge;
import projet.akka.gestion.entity.Role;
import projet.akka.gestion.entity.Salarie;
import projet.akka.gestion.entity.TypeConge;
import projet.akka.gestion.repository.SalarieRepo;
import projet.akka.gestion.repository.ServiceRepo;

@Service
public class InitUserInDataBase implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncorder;
	@Autowired
	private SalarieRepo salarieRepo;
	@Autowired
	private ServiceRepo serviceRepo;
	@Autowired
	private CongeService congeService;

	@Override
	public void run(String... args) throws Exception {
//		projet.akka.gestion.entity.Service service1 = new projet.akka.gestion.entity.Service("Compta");
//		service1 = serviceRepo.save(service1);
//		projet.akka.gestion.entity.Service service2 = new projet.akka.gestion.entity.Service("Secretaire");
//		service2 = serviceRepo.save(service2);
//		projet.akka.gestion.entity.Service service3 = new projet.akka.gestion.entity.Service("Developpeur");
//		service3 = serviceRepo.save(service3);
//		
//		Salarie manager = new Salarie("manager@mail", passwordEncorder.encode("pass"), "Abid", "Jordan", service1, Role.ROLE_MANAGER);
//		manager = salarieRepo.save(manager);
//		Salarie salarie1 = new Salarie("vanessa@mail", passwordEncorder.encode("pass"), "Desmartin", "Vanessa", service1,Role.ROLE_SALARIE);
//		Salarie salarie2 = new Salarie("Eli@mail", passwordEncorder.encode("pass"), "Dupont", "Elisabeth", service2,Role.ROLE_SALARIE);
//		Salarie salarie3 = new Salarie("kelly@mail", passwordEncorder.encode("pass"), "Daniel", "Kelly", service3,Role.ROLE_SALARIE);
//		List<Salarie> listManage = new ArrayList<Salarie>();
//		listManage.add(salarie1);
//		
//		salarie1 = salarieRepo.save(salarie1);
//		salarie2 = salarieRepo.save(salarie2);
//		salarie3 = salarieRepo.save(salarie3);
//		
//		salarie1.setManager(manager);
//		manager.setManage(listManage);
//		manager = salarieRepo.save(manager);
//		salarie1 = salarieRepo.save(salarie1);
//
//		Conge conge0 = new Conge(salarie1, TypeConge.CP, LocalDate.of(2022, 01, 18), LocalDate.of(2022, 01, 20), "Vacances aux caraibes");
//		Conge conge1 = new Conge(salarie1, TypeConge.CJ, LocalDate.of(2022, 02, 18), LocalDate.of(2022, 02, 20), "Vacances en Australie");
//		Conge conge2 = new Conge(salarie1, TypeConge.CSS, LocalDate.of(2022, 03, 18), LocalDate.of(2022, 03, 20), "Vacances en Egypte");
//		Conge conge3 = new Conge(salarie2, TypeConge.CP, LocalDate.of(2022, 01, 18), LocalDate.of(2022, 01, 20), "Vacances aux Etats-Unis");
//		Conge conge4 = new Conge(salarie2, TypeConge.CA, LocalDate.of(2022, 02, 18), LocalDate.of(2022, 02, 20), "Vacances en Finlande");
//		Conge conge5 = new Conge(salarie3, TypeConge.CP, LocalDate.of(2022, 01, 13), LocalDate.of(2022, 02, 15), "Vacances en Espagnes");
//		Conge conge6 = new Conge(salarie3, TypeConge.CP, LocalDate.of(2022, 02, 18), LocalDate.of(2022, 02, 20), "Vacances au Portugal");
//
//		congeService.save(conge0);
//		congeService.save(conge1);
//		congeService.save(conge2);
//		congeService.save(conge3);
//		congeService.save(conge4);
//		congeService.save(conge5);
//		congeService.save(conge6);
	}
}
