// File: com/sportfash/data/repo/OrderRepository.java

package com.sportfash.data.repo;

import com.sportfash.data.entities.Order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.sportfash.data.entities.Customer;
import com.sportfash.data.entities.product.Product;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>, PagingAndSortingRepository<Order, Long> {
    List<Order> findByCustomer(Customer customer);

    @Query(value = "SELECT o FROM Order o WHERE EXISTS (SELECT i FROM OrderItem i WHERE i.order = o AND i.product = ?1)")
    List<Order> findByProduct(Product product);

    List<Order> findByPaymentReference(String paymentReference);

    @Query(value = "SELECT o FROM Order o WHERE LOWER(o.shippingAddress) LIKE LOWER(concat('%', ?1,'%'))")
    List<Order> keywordSearchByShippingAddress(String keyword);
}
