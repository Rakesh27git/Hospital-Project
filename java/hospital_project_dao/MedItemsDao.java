package hospital_project_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hospital_project_dto.MedItems;
import hospital_project_dto.MedOrdersDto;

public class MedItemsDao {
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
		
	}
	public void saveMedItems(int mid,MedItems medItems)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		MedOrdersDto medOrdersDto2=entityManager.find(MedOrdersDto.class, mid);
		List<MedItems>list=medOrdersDto2.getMedItems();
		list.add(medItems);
		if(medOrdersDto2!=null)
		{
			medOrdersDto2.setId(mid);
			entityTransaction.begin();
			entityManager.persist(medItems);
			entityManager.merge(medOrdersDto2);
			
		}
		entityTransaction.commit();
	}

}
