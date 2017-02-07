package org.ababup1192.book.after;

import java.util.List;

public interface BookService {
    void truncateBook();
    void dropBook();

    List<Book> findAll();
    List<Book> findByCategoryName(String categoryName);
}
