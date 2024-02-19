package com.dden.carcatalog.repository;

import com.dden.carcatalog.domain.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * OwnerRepositoryTest
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */

@DataJpaTest
class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    void saveOwner(){
        ownerRepository.save(new Owner("Lucy", "Smitch"));

        assertThat(ownerRepository.findByFirstName("Lucy").isPresent()).isTrue();
    }

    @Test
    void deletesOwners(){
        ownerRepository.save(new Owner("Lisa", "Simpson"));
        ownerRepository.deleteAll();
        assertThat(ownerRepository.count()).isEqualTo(0);
    }

}