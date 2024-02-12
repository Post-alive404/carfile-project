package com.dden.carcatalog.repository;

import com.dden.carcatalog.domain.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * AppUserRepository
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */

@RepositoryRestResource(exported = false)
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
