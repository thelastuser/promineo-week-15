package pet.store.controller.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor
public class PetStoreData {

	private Long petStoreId;
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private String petStoreZip;
	private String petStorePhone;
	private Set<PetStoreCustomer> customers = new HashSet<>();
	private Set<PetStoreEmployee> employees = new HashSet<>();
	
	public PetStoreData(PetStore petStore) {
		this.petStoreId = petStore.getPetStoreId();
		this.petStoreName = petStore.getPetStoreName();
		this.petStoreAddress = petStore.getPetStoreAddress();
		this.petStoreCity = petStore.getPetStoreCity();
		this.petStoreState = petStore.getPetStoreState();
		this.petStoreZip = petStore.getPetStoreZip();
		this.petStorePhone = petStore.getPetStorePhone();
		if (!Objects.isNull(petStore.getCustomers())) {
			for (Customer customer : petStore.getCustomers()) {
//				PetStoreCustomer psc = new PetStoreCustomer();
//				psc.setCustomerId(customer.getCustomerId());
//				psc.setCustomerFirstName(customer.getCustomerFirstName());
//				psc.setCustomerLastName(customer.getCustomerLastName());
//				psc.setCustomerEmail(customer.getCustomerEmail());
				customers.add(new PetStoreCustomer(customer));
			}
		}
		if (!Objects.isNull(petStore.getEmployees())) {
			for (Employee employee : petStore.getEmployees()) {
//				PetStoreEmployee pse = new PetStoreEmployee();
//				pse.setEmployeeId(employee.getEmployeeId());
//				pse.setEmployeeFirstName(employee.getEmployeeFirstName());
//				pse.setEmployeeLastName(employee.getEmployeeLastName());
//				pse.setEmployeeJobTitle(employee.getEmployeeJobTitle());
//				pse.setEmployeePhone(employee.getEmployeePhone());
				employees.add(new PetStoreEmployee(employee));
			}
		}

		
	}
	
}
