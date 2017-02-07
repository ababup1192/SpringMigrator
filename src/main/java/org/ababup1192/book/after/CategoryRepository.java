package org.ababup1192.book.after;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
    // Delete code on production
    @Query(value = "TRUNCATE TABLE category", nativeQuery = true)
    @Modifying
    @Transactional
    void truncate();

    // Delete code on production
    @Query(value = "DROP TABLE category", nativeQuery = true)
    @Modifying
    @Transactional
    void drop();

    Category findByName(String name);
}
