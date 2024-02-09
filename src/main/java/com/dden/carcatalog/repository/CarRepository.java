package com.dden.carcatalog.repository;

import com.dden.carcatalog.domain.Car;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;


/**
 * CarRepository
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */

public interface CarRepository extends CrudRepository<Car, Long> {  //PagingAndSortingRepository<Car, Long> {
    List<Car> findByBrand(String brand);
    List<Car> findByColor(String color);
    List<Car> findByModelYear(int modelYear);

    List<Car> findByBrandAndModel(String brand, String model);
    List<Car> findByBrandOrColor(String brand, String color);

    List<Car> findByBrandOrderByModelYearAsc(String brand);

    @Query("select c from Car c where c.brand = ?1")
    List<Car> findByBrandQuery(String brand);

    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndsWith(String brand);

}
