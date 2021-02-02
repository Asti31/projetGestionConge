package projet.akka.gestion.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import projet.akka.gestion.entity.Salarie;
import projet.akka.gestion.entity.UserDetailsWithSalarie;
import projet.akka.gestion.repository.SalarieRepo;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private SalarieRepo salarieRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Salarie> opt = salarieRepo.findByMail(username);
		if (opt.isPresent()) {
			return new UserDetailsWithSalarie(opt.get());
		}
		throw new UsernameNotFoundException("mail inconnu");
	}

	

}
