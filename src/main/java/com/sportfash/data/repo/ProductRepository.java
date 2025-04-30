// File: com/sportfash/data/repo/ProductRepository.java

package com.sportfash.data.repo;

import com.sportfash.data.entities.product.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    //@Override
    //@NativeQuery(value = "SELECT pc.relname as clazz_, p.* FROM pg_class pc, new_sale_platform.product p where pc.oid = p.tableoid")
    //Page<Product> findAll(Pageable pageable);

    //@Override
    //@NativeQuery(value = "SELECT p.* FROM new_sale_platform.product p")
    //List<Product> findAll(Sort sort);

    List<Product> findByBrand(String brand);

    List<Product> findByCategory(String category);

    @Query(value = "SELECT p FROM Product p WHERE LOWER(p.productName) LIKE LOWER(concat('%', ?1,'%'))")
    List<Product> keywordSearchByProductName(String keyword);

    @Query(value = "SELECT p FROM Product p WHERE LOWER(p.shortDescription) LIKE LOWER(concat('%', ?1,'%'))")
    List<Product> keywordSearchByProductDescription(String keyword);
}
