package projet.akka.gestion.service;


import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;


import projet.akka.gestion.entity.Service;
import projet.akka.gestion.repository.ServiceRepo;



@org.springframework.stereotype.Service
public class ServiceService {
@Autowired
private ServiceRepo serviceRepo;



public void createService(String libelle) {
	Service service = new Service(libelle);
	serviceRepo.save(service);
	
}



	public Service save(Service t) {
		
		return serviceRepo.save(t);
		
	}


	public void delete(Service t) {
		serviceRepo.delete(t);
	}

	
	
	public Service findById(Integer id) {
		Optional<Service> opt = serviceRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return new Service();
	}

	
	
	public List<Service> findAll() {
		return serviceRepo.findAll();
		
	}
	
	
	public List<Service> findAllFilter(String libelle) {
		return serviceRepo.findByLibelle(libelle);
	}

}
