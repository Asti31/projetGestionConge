package projet.akka.gestion.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOService;


public class ServiceService implements IDAOService{

	@Override
	public Service save(Service t) {
		
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{t=em.merge(t);}
		catch(Exception e) {System.out.println("Error save Service");}
		em.getTransaction().commit();
		em.close();
		return t;
		
	}

	@Override
	public void delete(Service t) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{em.remove(em.merge(t));}
		catch(Exception e) {System.out.println("Error delete Service");}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Service findById(Integer id) {
		Service emp=null;
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try{emp=em.find(Service.class,id);}
		catch(Exception e) {System.out.println("Error find Service");}
		
		em.close();
		return emp;
	}

	@Override
	public List<Service> findAll() {
		List<Service> employes = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from Service",Service.class);
			employes=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAll Service");}
		em.close();
		return employes;
	}
	
	@Override
	public List<Service> findAllFilter(String name) {
		List<Service> employes = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from Service e where e.login like :filter",Service.class);
			query.setParameter("filter", "%"+name+"%");
			employes=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAlFilter Service");}
		em.close();
		return employes;
	}

}
