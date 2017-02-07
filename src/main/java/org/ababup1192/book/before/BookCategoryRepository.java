package org.ababup1192.book.before;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookCategoryRepository extends PagingAndSortingRepository<BookCategory, Integer> {
    @Query(value = "TRUNCATE TABLE book_category", nativeQuery = true)
    @Modifying
    @Transactional
    void truncateTable();

    @Override
    List<BookCategory> findAll();
}

