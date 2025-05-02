package com.sportfash.data.repo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sportfash.data.entities.Customer;

@DataJpaTest(
    properties = {
        "spring.profiles.active=unit-test"
    }
)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository testee;

    @Test
    void test_findById() {
        Optional<Customer> actual = testee.findById(1l);
    }
}
