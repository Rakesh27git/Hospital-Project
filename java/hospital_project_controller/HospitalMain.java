package hospital_project_controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hospital_dto.Address;
import hospital_dto.Branch;
import hospital_dto.Hospital;
import hospital_project_dao.AddressDao;
import hospital_project_dao.BranchDao;
import hospital_project_dao.EncounterDao;
import hospital_project_dao.HospitalDao;
import hospital_project_dao.MedItemsDao;
import hospital_project_dao.MedOrderDao;
import hospital_project_dao.PersonDao;
import hospital_project_dto.EncounterDto;
import hospital_project_dto.MedItems;
import hospital_project_dto.MedOrdersDto;
import hospital_project_dto.PersonDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Hospital hospital = new Hospital();
		HospitalDao hospitalDao = new HospitalDao();
		Branch branch = new Branch();
		BranchDao branchDao = new BranchDao();
		Address address = new Address();
		AddressDao addressDao = new AddressDao();
		boolean repeat = true;
		do {
			System.out.println("******************************WELCOME TO HOSPITAL**********************************");
			System.out.println("Please Enter your choice");
			System.out.println("1.Enter hospital Details");
			System.out.println("2.Enter person Details");
			int key = scanner.nextInt();
			switch (key) {
			case 1: {

				boolean flag = true;
				do {
					System.out.println(
							"Enter the choice\n1.Save \n2.Update  \n3.delete \n4.Details by Id\n5.All Details\n6.exit");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1: {

						System.out.println("Enter the choice to save \n 10.hospital \n 11.branch \n 12.address");
						int ch1 = scanner.nextInt();
						switch (ch1) {
						case 10: {
							System.out.println("Enter the Hospital id");
							int h_id = scanner.nextInt();
							System.out.println("Enter the hospital name");
							String h_name = scanner.next();
							System.out.println("Enter the hospital gst");
							String h_gst = scanner.next();
							System.out.println("Enter the hospital address");
							String h_address = scanner.next();
							System.out.println("Enter the hospital phone number");
							long h_phone = scanner.nextLong();
							hospital.setHospital_id(h_id);
							hospital.setHospital_name(h_name);
							hospital.setGst(h_gst);
							hospital.setHospital_address(h_address);
							hospital.setHospital_phone(h_phone);
							hospitalDao.saveHospital(hospital);
						}
							break;

						case 11: {
							System.out.println("Enter hospital id");
							int h_id = scanner.nextInt();
							System.out.println("Enter the Branch id");
							int b_id = scanner.nextInt();
							System.out.println("Enter the Branch name");
							String b_name = scanner.next();
							System.out.println("Enter the Branch head");
							String b_head = scanner.next();
							System.out.println("Enter the  Branch phone number");
							long b_phone = scanner.nextLong();
							branch.setBranch_id(b_id);
							branch.setBranch_name(b_name);
							branch.setBranch_phone(b_phone);
							branch.setHeadOfBranch(b_head);
							branchDao.saveBranch(branch, h_id);
						}
							break;

						case 12: {
							System.out.println("Enter branch id");
							int b_id = scanner.nextInt();
							System.out.println("Enter the Address id");
							int a_id = scanner.nextInt();
							System.out.println("Enter the area  name");
							String a_areaname = scanner.next();
							System.out.println("Enter the road number");
							int a_roadname = scanner.nextInt();
							System.out.println("Enter the pincode");
							int a_pincode = scanner.nextInt();
							address.setAddress_id(a_id);
							address.setArea_name(a_areaname);
							address.setPincode(a_pincode);
							address.setRoad_Num(a_roadname);
							addressDao.saveAddress(address, b_id);
						}
							break;
						default: {
							System.out.println("iinvalid choice");
						}
						}

					}
						break;
					case 2: {
						System.out.println("Enter the choice to update \n 1.hospital \n 2.branch \n 3.address");
						int ch1 = scanner.nextInt();

						switch (ch1) {
						case 1: {
							System.out.println("Enter the Hospital id");
							int h_id = scanner.nextInt();
							System.out.println("Enter the hospital address");
							String h_address = scanner.next();
							System.out.println("Enter the hospital phone number");
							long h_phone = scanner.nextLong();
							hospital.setHospital_address(h_address);
							hospital.setHospital_phone(h_phone);
							hospitalDao.updateHospital(hospital, h_id);
						}
							break;
						case 2: {
							System.out.println("Enter the Branch id");
							int b_id = scanner.nextInt();
							System.out.println("Enter the phone num to be updated");
							long b_phone = scanner.nextLong();
							System.out.println("Enter the head branch to be updated");
							String b_head = scanner.next();
							branch.setBranch_phone(b_phone);
							branch.setHeadOfBranch(b_head);
							branchDao.updateBranch(branch, b_id);

						}
							break;
						case 3: {
							System.out.println("enter the address id");
							int a_id = scanner.nextInt();
							System.out.println("enter the road number to be updated");
							int r_num = scanner.nextInt();
							System.out.println("enter the pincode to be updated");
							int pincode = scanner.nextInt();
							address.setPincode(pincode);
							address.setRoad_Num(r_num);
							addressDao.updateAddress(address, a_id);
						}
						default: {
							System.out.println("invalid choice");
						}
						}
					}
						break;
					case 3: {
						System.out.println("Enter the choice to be delete\n1 hospital\n2 branch\n3 address");
						int ch2 = scanner.nextInt();
						switch (ch2) {
						case 1: {
							System.out.println("enter the hospital id");
							int h_id = scanner.nextInt();
							System.out.println("enter the branch id");
							int b_id = scanner.nextInt();
							System.out.println("enter the address id");
							int a_id = scanner.nextInt();
							try {
								hospitalDao.deleteHospital(h_id, b_id, a_id);
							} catch (Exception e) {
								System.out.println("if you want to delete hospital first delete all branches  ");
							}
						}
							break;
						case 2: {
							System.out.println("Enter the branch id");
							int b_id = scanner.nextInt();
							System.out.println("enter address id");
							int a_id = scanner.nextInt();
							branchDao.deleteBranch(b_id, a_id);
						}
							break;
						case 3: {
							System.out.println("enter address id");
							int a_id = scanner.nextInt();
							addressDao.deleteAddress(a_id);
						}
							break;
						default: {
							System.out.println("invalid choice");
						}
						}
					}
						break;
					case 4: {
						System.out.println(
								"enter the choice top be display the details \n1 hospital\n2 branch \n3 address");
						int ch3 = scanner.nextInt();
						switch (ch3) {
						case 1: {
							System.out.println("enter hopsital id");
							int h_id = scanner.nextInt();
							hospitalDao.getHospital_Details_On_id(h_id);
						}
							break;
						case 2: {
							System.out.println("enter branch id");
							int b_id = scanner.nextInt();
							branchDao.getBranchOnId(b_id);

						}
							break;
						case 3: {
							System.out.println("enter address id");
							int a_id = scanner.nextInt();
							addressDao.getAddressDetailsOnId(a_id);
						}
							break;
						default: {
							System.out.println("invalid choice");
						}

						}
					}
						break;
					case 5: {
						System.out.println("enter the choice to display all details\n1 hospital \n2 branch\n3 address");
						int ch4 = scanner.nextInt();
						switch (ch4) {
						case 1: {
							hospitalDao.get_All_Hospital_Details();
						}
							break;
						case 2: {
							branchDao.getBranchAllDetails();
						}
							break;
						case 3: {
							addressDao.getAllAddress_Details();
						}
							break;
						default: {
							System.out.println("invalid choice");
						}
						}

					}
						break;
					case 6: {
						flag = false;
					}
						break;

					default:
						System.out.println("invalid choice");
					}
				} while (flag);
				System.out.println("Thank you....!!!");
			}
				break;

			case 2: {
				System.out.println("1.Save Person Details");
				System.out.println("2.Fetch Person Details");
				int a = scanner.nextInt();
				switch (a) {
				case 1: {

					boolean pole = true;
					do {
						PersonDto persondto = new PersonDto();
						PersonDao persondao = new PersonDao();

						System.out.println(
								"Enter your choice \n 1.Insert Person Details \n 2.Insert Encounter Details \n 3.Insert MedOrder Details \n 4.Insert MedItems List");

						int choice = scanner.nextInt();
						switch (choice) {
						case 1: {
							System.out.println("enter person id");
							int id = scanner.nextInt();
							persondto.setPid(id);
							System.out.println("Enter the person name");
							String name = scanner.next();
							persondto.setPname(name);
							System.out.println("Emter the person address");
							String add = scanner.next();
							persondto.setAddress(add);
							System.out.println("enter the person phone number");
							long phone = scanner.nextLong();
						    BranchDao dao=new BranchDao();
						    dao.getBranchAllDetails();
							persondto.setPhone(phone);
							persondao.savePerson(persondto);

						}
							break;

						case 2: {
							EncounterDto encounterDto1 = new EncounterDto();
							System.out.println("enter encounter id");
							int id = scanner.nextInt();
							encounterDto1.setEid(id);
							System.out.println("enter the encounter type");
							String type = scanner.next();
							encounterDto1.setEname(type);
							System.out.println("enter person  id");
							int personId = scanner.nextInt();
							System.out.println("enter branch id");
							int branchid = scanner.nextInt();

							EncounterDao encounterDao = new EncounterDao();
							encounterDao.saveEncounter(branchid, personId, encounterDto1);

						}break;
						case 3: {

							MedOrdersDto medOrderDto1 = new MedOrdersDto();
							System.out.println("enter the order id");
							int id = scanner.nextInt();
							medOrderDto1.setId(id);
							;
							System.out.println("enter the order details");
							String order = scanner.next();
							medOrderDto1.setName(order);
							;
							System.out.println("enter the encounter id");
							int eid = scanner.nextInt();

							MedOrderDao medOrderDao = new MedOrderDao();

							medOrderDao.saveMedOrder(eid, medOrderDto1);

						}
							break;

						case 4: {
							MedItems medItems = new MedItems();
							MedItemsDao medItemsDao = new MedItemsDao();
							System.out.println("enter the item id");
							int id = scanner.nextInt();
							medItems.setId(id);
							System.out.println("enter the item name");
							String name = scanner.next();
							medItems.setName(name);
							System.out.println("enter order id");
							int orderId = scanner.nextInt();

							medItemsDao.saveMedItems(orderId, medItems);
						}
							break;
						case 5: {
							System.out.println("********Thank You***********");
							pole = false;

						}
						}

					} while (pole);
				}

				case 2: {
					PersonDao personDao = new PersonDao();
					System.out.println("ENter person Id");
					int id = scanner.nextInt();
					personDao.findByPid(id);
				}
				}

			}

			}
		} while (repeat);
	}
}
