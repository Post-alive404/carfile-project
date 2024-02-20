package com.dden.carcatalog;

import com.dden.carcatalog.domain.AppUser;
import com.dden.carcatalog.repository.AppUserRepository;
import com.dden.carcatalog.repository.CarRepository;
import com.dden.carcatalog.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class CarCatalogApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CarCatalogApplication.class);

	private final CarRepository repository;
	private final OwnerRepository ownerRepository;
	private final AppUserRepository userRepository;

	public CarCatalogApplication(CarRepository repository, OwnerRepository ownerRepository, AppUserRepository userRepository) {
		this.repository = repository;
		this.ownerRepository = ownerRepository;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CarCatalogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {




//		userRepository.save(new AppUser("user","$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9" +
//				".f9q0e4bRadue", "USER" ));
//
//		userRepository.save(new AppUser("admin",
//				"$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9." +
//						"mP9vpMu0ssKi8GW", "ADMIN"));

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
