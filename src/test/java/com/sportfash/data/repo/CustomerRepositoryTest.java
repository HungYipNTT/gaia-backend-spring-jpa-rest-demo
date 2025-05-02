package com.sportfash.data.repo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import com.sportfash.data.entities.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DataJpaTest(
    properties = {
        "spring.profiles.active=unit-test"
    }
)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CustomerRepositoryTest {

    static private PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:17.4");

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    private CustomerRepository testee;

    @Test
    void test_findById() {
        Optional<Customer> actual = testee.findById(1l);
    }

    @Test
    void test_create() {
        Customer entity = new Customer();
        entity = testee.save(entity);
        log.info("Id:{}",entity.getId());
        assertThat(testee.count(), equalTo(1l));
    }

    @Test
    void test_create2() {
        Customer entity = new Customer();
        entity = testee.save(entity);
        log.info("Id:{}",entity.getId());
        assertThat(testee.count(), equalTo(1l));
    }
}
