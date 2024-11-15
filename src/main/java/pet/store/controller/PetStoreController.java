package pet.store.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreCustomer;
import pet.store.controller.model.PetStoreData;
import pet.store.controller.model.PetStoreEmployee;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {

@Autowired
private PetStoreService petStoreService;

@PostMapping
@ResponseStatus(code = HttpStatus.CREATED)
public PetStoreData insertPetStore(@RequestBody PetStoreData petStoreData) {
	log.info("Inserting PetStore record: {}", petStoreData);
	return petStoreService.savePetStore(petStoreData);
}

@PutMapping("/{petStoreId}")
public PetStoreData updatePetStore(@PathVariable Long petStoreId, @RequestBody PetStoreData petStoreData) {
	petStoreData.setPetStoreId(petStoreId);
	log.info("Updating PetStore {}", petStoreData);
	return petStoreService.savePetStore(petStoreData);
}

@PostMapping("/{petStoreId}/employee")
@ResponseStatus(code = HttpStatus.CREATED)
public PetStoreEmployee insertEmployee(@PathVariable Long petStoreId, @RequestBody PetStoreEmployee petStoreEmployee) {
	log.info("Inserting Employee data: {}", petStoreEmployee);
	return petStoreService.saveEmployee(petStoreId, petStoreEmployee);
}

@PostMapping("/{petStoreId}/customer")
@ResponseStatus(code = HttpStatus.CREATED)
public PetStoreCustomer insertCustomer(@PathVariable Long petStoreId, @RequestBody PetStoreCustomer petStoreCustomer) {
	log.info("Inserting Customer data: {}", petStoreCustomer);
	return petStoreService.saveCustomer(petStoreId, petStoreCustomer);
	
}

@GetMapping
@ResponseStatus(code = HttpStatus.OK)
public List<PetStoreData> listAllPetStores() {
	log.info("Returing a list of all Pet Stores");
	return petStoreService.retrieveAllPetStores();
}

@GetMapping("/{petStoreId}")
@ResponseStatus(code = HttpStatus.OK)
public PetStoreData findAPetStore(@PathVariable Long petStoreId) {
	log.info("Returning Pet store with ID = {}", petStoreId);
	return petStoreService.retrieveStoreById(petStoreId);
}

@DeleteMapping("/delete/{petStoreId}")
@ResponseStatus(code = HttpStatus.OK)
public Map<String, String> deletePetStoreById(@PathVariable Long petStoreId) {
	log.info("Attempting deletion of Pet store with ID = {}", petStoreId);
	return petStoreService.deletePetStoreById(petStoreId);
}

}
