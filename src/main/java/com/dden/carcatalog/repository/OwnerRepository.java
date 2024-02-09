package com.dden.carcatalog.repository;

import com.dden.carcatalog.domain.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * OwnerRepository
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
