package hospital_project_dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MedOrdersDto {
	
	@Id
	private int id;
	private String name;
	@OneToMany
	private List<MedItems>medItems;
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
	public List<MedItems> getMedItems() {
		return medItems;
	}
	public void setMedItems(List<MedItems> medItems) {
		this.medItems = medItems;
	}
	@Override
	public String toString() {
		return "MedOrdersDto [id=" + id + ", name=" + name + ", medItems=" + medItems + "]";
	}
	
}
	
	
