package com.sportfash.data.repo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;

import com.sportfash.data.entities.Address;
import com.sportfash.data.entities.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DataJpaTest(
    properties = {
        "spring.profiles.active=unit-test"
    }
)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional
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
    @Sql({"/reset-table-sequence.sql","/create-single-customer.sql"})
    void test_findById() {
        Optional<Customer> optional = testee.findById(1l);

        assertThat(optional.isPresent(),equalTo(true));
        assertThat(testee.count(), equalTo(1l));

        Customer actual = optional.get();

        assertThat(actual.getId(), equalTo(1l));
    }

    @Test
    @Sql("/reset-table-sequence.sql")
    void test_create() {
        Customer entity = new Customer();
        entity.setTitle("Mr");
        entity.setFirstName("John");
        entity.setLastName("Doe");
        entity.setEmail("john.doe@gmail.com");
        entity.setCreatedBy("userA");
        
        Customer actual = testee.save(entity);

        assertThat(actual.getId(),equalTo(1l));
        assertThat(actual.getCreatedBy(), equalTo("userA"));
        assertThat(actual.getCreateDate(), notNullValue());
        assertThat(actual.getVer(),equalTo(0l));
    }

    @Test
    @Sql({"/reset-table-sequence.sql","/create-single-customer.sql"})
    void test_update() {
        Optional<Customer> optional = testee.findById(1l);

        Customer retrieved = optional.get();

        retrieved.setContactNo("0123456-34567");
        retrieved.setDateOfBirth(LocalDate.of(1900,1,1));

        Address address = new Address();
        address.setAddressLine1("54, Queue Road");
        address.setPostCode("AAB 12R");
        address.setCity("London");
        address.setCountry("UK");
        retrieved.setAddress(address);
        retrieved.setLastUpdBy("userB");
        retrieved.setVer(retrieved.getVer()+1);
        //retrieved.setLastUpdDate(LocalDateTime.now());
        //retrieved.incrVersion();

        Customer actual = testee.save(retrieved);

        log.info("count:{}",testee.count());

        assertThat(actual.getId(),equalTo(1l));
        assertThat(actual.getLastUpdBy(), equalTo("userB"));
        assertThat(actual.getLastUpdDate(), notNullValue());
        assertThat(actual.getVer(),equalTo(2l));
    }

    @Test
    @Sql({"/reset-table-sequence.sql","/create-single-customer.sql"})
    void test_delete() {
        testee.deleteById(1l);
        assertThat(testee.count(), equalTo(0l));
    }

}
