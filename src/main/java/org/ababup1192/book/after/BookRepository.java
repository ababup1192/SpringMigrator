package org.ababup1192.book.after;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
    // Delete code on production
    @Query(value = "TRUNCATE TABLE book;", nativeQuery = true)
    @Modifying
    @Transactional
    void truncate();

    // Delete code on production
    @Query(value = "DROP TABLE book;", nativeQuery = true)
    @Modifying
    @Transactional
    void drop();

    @Override
    List<Book> findAll();
}

