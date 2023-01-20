package hospital_project_dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import hospital_dto.Branch;

@Entity
public class EncounterDto {
	@Id

	private int eid;
	private String ename;
	@OneToMany
	private List<MedOrdersDto> medOrder;
	@OneToMany 
	private List<Branch>branch;

	public List<Branch> getBranch() {
		return branch;
	}

	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public List<MedOrdersDto> getMedOrder() {
		return medOrder;
	}
	public void setMedOrder(List<MedOrdersDto> medOrder) {
		this.medOrder = medOrder;
	}

	@Override
	public String toString() {
		return "EncounterDto [eid=" + eid + ", ename=" + ename + ", medOrder=" + medOrder + ", branch=" + branch
				+ ", getBranch()=" + getBranch() + ", getEid()=" + getEid() + ", getEname()=" + getEname()
				+ ", getMedOrder()=" + getMedOrder() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	

}
