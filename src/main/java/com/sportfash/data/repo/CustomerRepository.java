package com.sportfash.data.repo;

import com.sportfash.data.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>, PagingAndSortingRepository<Customer, Long> {

    @Query(value = "SELECT * FROM new_sale_platform.customer WHERE email = ?1", nativeQuery = true)
    Customer findByEmail(String email);

    @Query(value = "SELECT * FROM new_sale_platform.customer WHERE contact_no = ?1", nativeQuery = true)
    Customer findByContactNo(String contactNo);

    @Query(value = "SELECT * FROM new_sale_platform.customer WHERE payment_card_no = ?1", nativeQuery = true)
    Customer findByCardNo(String cardNo);

    @Query(value = "SELECT * FROM new_sale_platform.customer WHERE CONCAT(first_name, ' ', last_name) LIKE %?1%", nativeQuery = true)
    Iterable<Customer> searchByFullNameKeyword(String keyword);

    @Query(value = "SELECT * FROM new_sale_platform.customer WHERE CONCAT(address_line1, ' ', city, ' ', country) LIKE %?1%", nativeQuery = true)
    Iterable<Customer> searchByAddressKeyword(String keyword);
}
