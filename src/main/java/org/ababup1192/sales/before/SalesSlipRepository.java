package org.ababup1192.sales.before;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SalesSlipRepository extends PagingAndSortingRepository<SalesSlip, Integer> {
    @Query(value = "TRUNCATE TABLE sales_slip", nativeQuery = true)
    @Modifying
    @Transactional
    void truncate();

    @Override
    List<SalesSlip> findAll();
}

