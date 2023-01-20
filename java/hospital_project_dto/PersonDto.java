package hospital_project_dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class PersonDto {
	

	@Id
	
	private int pid;
	private String pname;
	private long phone;
	private String address;
	@OneToMany
	private List<EncounterDto>encounter;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<EncounterDto> getEncounter() {
		return encounter;
	}
	public void setEncounter(List<EncounterDto> encounter) {
		this.encounter = encounter;
	}
	@Override
	public String toString() {
		return "PersonDto [pid=" + pid + ", pname=" + pname + ", phone=" + phone + ", address=" + address
				+ ", encounter=" + encounter + "]";
	}
	
}
