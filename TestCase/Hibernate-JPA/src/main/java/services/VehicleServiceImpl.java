package services;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Hibernate;

import com.test.Person;
import com.test.Student;
import com.test.Vehicle;

public class VehicleServiceImpl implements VehicleService {

	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insertVehicle() {
		System.out.println("This is from the hibernate bundle method insertVehicle...");
		try {

			Student st = new Student("1");
			st.setName("Shailendra");
			st.setEmail("xyz@abc.com");
			st.setUniversityID("U1");
			entityManager.merge(st);

			Vehicle vh = new Vehicle();
			vh.setId("VH1");
			vh.setPerson(st);
			entityManager.merge(vh);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getVehicleData() {
		System.out.println("This is from the hibernate bundle method getVehicleData...");
		try {
			List<Vehicle> list = entityManager.createQuery("FROM Vehicle", Vehicle.class).getResultList();

			Vehicle vh = list.get(0);

			Person pr = vh.getPerson();

			System.out.println("isInitialized= " + Hibernate.isInitialized(pr));

			Hibernate.initialize(pr);

			System.out.println("isInitialized= " + Hibernate.isInitialized(pr));

			System.out.println("Name= " + pr.getName());
			System.out.println("Email= " + pr.getEmail());

			Student outputST = (Student) pr;
			
			System.out.println("UniversityID= " + outputST.getUniversityID());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
