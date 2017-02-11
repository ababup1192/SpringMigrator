package org.ababup1192.sales.after;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface OrderFormRepository extends PagingAndSortingRepository<OrderForm, Integer> {
    // Delete code on production
    @Query(value = "TRUNCATE TABLE order_form;", nativeQuery = true)
    @Modifying
    @Transactional
    void truncate();

    // Delete code on production
    @Query(value = "DROP TABLE order_form;", nativeQuery = true)
    @Modifying
    @Transactional
    void drop();
}

