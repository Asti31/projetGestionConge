package projet.akka.gestion.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOSalarie;
import projet.akka.gestion.entity.Salarie;


public class SalarieService implements IDAOSalarie{

	@Override
	public Salarie save(Salarie t) {
		
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{t=em.merge(t);}
		catch(Exception e) {System.out.println("Error save Salarie");}
		em.getTransaction().commit();
		em.close();
		return t;
		
	}

	@Override
	public void delete(Salarie t) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{em.remove(em.merge(t));}
		catch(Exception e) {System.out.println("Error delete Salarie");}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Salarie findById(Integer id) {
		Salarie emp=null;
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try{emp=em.find(Salarie.class,id);}
		catch(Exception e) {System.out.println("Error find Salarie");}
		
		em.close();
		return emp;
	}

	@Override
	public List<Salarie> findAll() {
		List<Salarie> employes = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from Salarie",Salarie.class);
			employes=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAll Salarie");}
		em.close();
		return employes;
	}
	
	@Override
	public List<Salarie> findAllFilter(String name) {
		List<Salarie> employes = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from Salarie e where e.login like :filter",Salarie.class);
			query.setParameter("filter", "%"+name+"%");
			employes=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAlFilter Salarie");}
		em.close();
		return employes;
	}

}
