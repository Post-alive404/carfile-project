package com.dden.carcatalog;

import static org.assertj.core.api.Assertions.assertThat;
import com.dden.carcatalog.web.CarController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarCatalogApplicationTests {

	@Autowired
	private CarController carController;

	@Test
	@DisplayName("First test CarController")
	void contextLoads() {
		assertThat(carController).isNotNull();
	}

}



