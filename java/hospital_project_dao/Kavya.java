package hospital_project_dao;

package hibernate_project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_project.dto.Branch;
import hibernate_project.dto.Encounter;
import hibernate_project.dto.MedOrder;
import hibernate_project.dto.Person;

public class Kavya {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveEncounter(int p_id, int branch_id, Encounter encounter) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, p_id);
		Branch branch = entityManager.find(Branch.class, branch_id);
		List<Branch> list = new ArrayList<Branch>();
		list.add(branch);

		encounter.setBranches(list);
		encounter.setPerson(person);
		entityTransaction.begin();
		entityManager.persist(encounter);
		entityTransaction.commit();
		System.out.println("Encounter saved successfully");
	}

	public void updateEncounter(int e_id, Encounter encounter) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Encounter newencounter = entityManager.find(Encounter.class, e_id);
		if (newencounter != null) {
			encounter.setAdmission_no(e_id);
			entityTransaction.begin();
			entityManager.merge(encounter);
			entityTransaction.commit();
			System.out.println("Encounter updated successfully");
		} else
			System.out.println("Not exists");
	}

	public void deleteEncounter(int e_id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Encounter encounter = entityManager.find(Encounter.class, e_id);
		if (encounter != null) {
			entityTransaction.begin();
			entityManager.remove(encounter);
			entityTransaction.commit();
			System.out.println("Encounter deleted successfully");
		} else
			System.out.println("Not exists");

	}

	public void getEncounterById(int e_id) {
		EntityManager entityManager = getEntityManager();
		Encounter encounter = entityManager.find(Encounter.class, e_id);
		System.out.println(encounter);
	}

	public void getAllEncounter() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT e FROM Encounter e");
		List<Encounter> list = query.getResultList();
		System.out.println(list);
	}

}