package projet.akka.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import projet.akka.gestion.entity.Role;
import projet.akka.gestion.entity.Salarie;
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

	@Override
	public void run(String... args) throws Exception {
		projet.akka.gestion.entity.Service s = new projet.akka.gestion.entity.Service("Comptable");
		Salarie u = new Salarie("toto@toto.fr", passwordEncorder.encode("toto"), "Daniel", "Kelly", s, Role.ROLE_ADMIN);

		serviceRepo.save(s);
		salarieRepo.save(u);
	}
}
