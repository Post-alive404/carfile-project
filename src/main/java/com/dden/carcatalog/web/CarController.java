package com.dden.carcatalog.web;

import com.dden.carcatalog.domain.Car;
import com.dden.carcatalog.repository.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CarController
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */

@RestController
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public Iterable<Car> getCars(){
        return carRepository.findAll();
    }
}
