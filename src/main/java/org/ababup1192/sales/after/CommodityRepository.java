package org.ababup1192.sales.after;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommodityRepository extends PagingAndSortingRepository<Commodity, Integer> {
    // Delete code on production
    @Query(value = "TRUNCATE TABLE commodity;", nativeQuery = true)
    @Modifying
    @Transactional
    void truncate();

    // Delete code on production
    @Query(value = "DROP TABLE commodity;", nativeQuery = true)
    @Modifying
    @Transactional
    void drop();

    List<Commodity> findByNameAndUnitPrice(String name, Integer unitPrice);
}

