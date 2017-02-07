package org.ababup1192.book.after;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @PersistenceContext
    private EntityManager entityManager;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public void truncateBook() {
        entityManager.createNativeQuery("SET foreign_key_checks = 0").executeUpdate();
        bookRepository.truncate();
        categoryRepository.truncate();
        entityManager.createNativeQuery("SET foreign_key_checks = 1").executeUpdate();
    }

    @Override
    @Transactional
    public void dropBook() {
        bookRepository.drop();
        categoryRepository.drop();
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByCategoryName(String categoryName) {
        final String jpql = "SELECT DISTINCT b FROM Book b INNER JOIN FETCH b.category AS c " +
                "WHERE c.name = :categoryName";
        TypedQuery<Book> query = entityManager.createQuery(jpql, Book.class);
        query.setParameter("categoryName", categoryName);
        return query.getResultList();
    }

}
