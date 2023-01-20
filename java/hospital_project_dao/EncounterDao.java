package hospital_project_dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hospital_dto.Branch;
import hospital_project_dto.EncounterDto;

import hospital_project_dto.PersonDto;

public class EncounterDao {
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
		
	}
	public void saveEncounter(int branchid,int personId, EncounterDto encounterdto)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		PersonDto personDto=entityManager.find(PersonDto.class, personId);
		Branch branch=entityManager.find(Branch.class, branchid);
		
		//List<EncounterDto> list = personDto.getEncounter();
		List<EncounterDto>list=new ArrayList<EncounterDto>();
		List<Branch>list2=new ArrayList<Branch>();
		
		
		if(personDto!=null) {
			list.add(encounterdto);
			list2.add(branch);
			personDto.setPid(personId);
			branch.setBranch_id(branchid);
		}
			entityTransaction.begin();
			personDto.setEncounter(list);
			encounterdto.setBranch(list2);
			
			
			entityManager.persist(encounterdto);
			entityManager.merge(personDto);
			entityManager.merge(branch);
		
			
		entityTransaction.commit();
		
		
	}
	public void updateEncounter(int e_id, EncounterDto encounterdto) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		EncounterDto newencounter = entityManager.find(EncounterDto.class, e_id);
		if (newencounter != null) {
			encounterdto.setEid(e_id);
			entityTransaction.begin();
			entityManager.merge(encounterdto);
			entityTransaction.commit();
			System.out.println("Encounter updated successfully");
		} else
			System.out.println("Not exists");
	}

}
