package hospital_project_dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedItems {
	@Id
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MedItems [id=" + id + ", name=" + name + "]";
	}
	
	

}
