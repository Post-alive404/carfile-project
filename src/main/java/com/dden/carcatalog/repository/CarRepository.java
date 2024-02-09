package com.dden.carcatalog.repository;

import com.dden.carcatalog.domain.Car;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;


/**
 * CarRepository
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {  //PagingAndSortingRepository<Car, Long> {
    List<Car> findByBrand(@Param("brand") String brand);
    List<Car> findByColor(@Param("color") String color);
//    List<Car> findByModelYear(int modelYear);
//
//    List<Car> findByBrandAndModel(String brand, String model);
//    List<Car> findByBrandOrColor(String brand, String color);
//
//    List<Car> findByBrandOrderByModelYearAsc(String brand);
//
//    @Query("select c from Car c where c.brand = ?1")
//    List<Car> findByBrandQuery(String brand);
//
//    @Query("select c from Car c where c.brand like %?1")
//    List<Car> findByBrandEndsWith(String brand);

}
