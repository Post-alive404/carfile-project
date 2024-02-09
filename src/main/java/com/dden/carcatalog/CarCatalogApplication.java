package com.dden.carcatalog;

import com.dden.carcatalog.domain.Car;
import com.dden.carcatalog.domain.Owner;
import com.dden.carcatalog.repository.CarRepository;
import com.dden.carcatalog.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CarCatalogApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CarCatalogApplication.class);

	private final CarRepository repository;
	private final OwnerRepository ownerRepository;

	public CarCatalogApplication(CarRepository repository, OwnerRepository ownerRepository) {
		this.repository = repository;
		this.ownerRepository = ownerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CarCatalogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Owner owner1 = new Owner("Den", "Robbin");
//		Owner owner2 = new Owner("Ihor", "Franklin");
//		ownerRepository.saveAll(Arrays.asList(owner1,owner2));
//
//		repository.save(new Car("Ford", "Mustang", "Red",
//				"ADF-1121", 2023, 59000, owner1));
//		repository.save(new Car("Nissan", "Leaf", "White",
//				"SSJ-3002", 2020, 29000, owner2));
//		repository.save(new Car("Toyota", "Prius", "Silver",
//				"KKO-0212", 2022, 39000, owner2));
//
//		for (Car car : repository.findAll()){
//			logger.info("brand: {}, model: {}", car.getBrand(), car.getModel());
//		}
	}
}
