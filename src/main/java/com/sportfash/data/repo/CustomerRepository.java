// File: com/sportfash/data/repo/CustomerRepository.java

package com.sportfash.data.repo;

import com.sportfash.data.entities.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Customer findByEmail(String email);

    Customer findByContactNo(String contactNo);

    Customer findByPaymentCardNo(String cardNo);

    @Query(value = "SELECT c FROM Customer c WHERE LOWER(CONCAT(c.firstName, ' ', c.lastName)) LIKE LOWER(concat('%', ?1,'%'))")
    List<Customer> keywordSearchByName(String keyword);

    @Query(value = "SELECT c FROM Customer c WHERE LOWER(CONCAT(c.address.addressLine1, ' ', c.address.addressLine2, ' ', c.address.city, ' ', c.address.country)) LIKE LOWER(concat('%', ?1,'%'))")
    List<Customer> keywordSearchByAddress(String keyword);
}
