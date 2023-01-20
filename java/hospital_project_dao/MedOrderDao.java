package hospital_project_dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hospital_project_dto.EncounterDto;

import hospital_project_dto.MedOrdersDto;

public class MedOrderDao {
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
		
	}
	public void saveMedOrder(int eid,MedOrdersDto medOrder)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		EncounterDto encounterDto=entityManager.find(EncounterDto.class, eid);
		List<MedOrdersDto>list=encounterDto.getMedOrder();
		if(encounterDto!=null)
		{
	        
			if(list!=null)
			{
			   list.add(medOrder);

				entityTransaction.begin();
				entityManager.persist(medOrder);
				entityManager.merge(encounterDto);
				entityTransaction.commit();
				
			}
			else
			{
			  List<MedOrdersDto> list1 = new ArrayList<MedOrdersDto>();
			  list1.add(medOrder);
			  encounterDto.setMedOrder(list1);

				entityTransaction.begin();
				entityManager.persist(medOrder);
				entityManager.merge(encounterDto);
				entityTransaction.commit();
				
			}
		
		}
		
		
	}

}
