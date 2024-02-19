package com.dden.carcatalog.repository;

import com.dden.carcatalog.domain.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * OwnerRepository
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */

@RepositoryRestResource
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Optional<Owner> findByFirstName(@Param("first_name") String firstName);
}
