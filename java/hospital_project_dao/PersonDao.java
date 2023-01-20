package hospital_project_dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hospital_project_dto.EncounterDto;
import hospital_project_dto.PersonDto;

public class PersonDao {
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
		
	}
	public void savePerson(PersonDto person)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		
		entityManager.persist(person);
		
		entityTransaction.commit();
		
		
	}
	
//	public void updatePerson(int id,PersonDto personDto)
//	{
//		EntityManager entityManager=getEntityManager();
//		EntityTransaction entityTransaction=entityManager.getTransaction();
//		PersonDto personDto2=entityManager.find(PersonDto.class, id);
//		if(personDto2!=null)
//		{
//			
//		}
//		
//		
//	}
	public void findByPid(int id)
	{
		EntityManager entityManager=getEntityManager();
		PersonDto person=entityManager.find(PersonDto.class, id);
		System.out.println(person);
	}
	

}
