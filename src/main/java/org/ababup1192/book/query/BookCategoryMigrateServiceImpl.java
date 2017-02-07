package org.ababup1192.book.query;

import org.ababup1192.book.after.*;
import org.ababup1192.book.before.BookCategory;
import org.ababup1192.book.before.BookCategoryRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookCategoryMigrateServiceImpl implements BookCategoryMigrateService {
    private final BookCategoryRepository bookCategoryRepository;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final BookService bookService;

    @Inject
    public BookCategoryMigrateServiceImpl(
            BookCategoryRepository bookCategoryRepository,
            BookRepository bookRepository,
            CategoryRepository categoryRepository,
            BookService bookService) {
        this.bookCategoryRepository = bookCategoryRepository;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.bookService = bookService;
    }

    @Transactional
    @Override
    public void migrate() {
        bookService.truncateBook();

        bookCategoryRepository.findAll().forEach((bc) -> {
            Category category = this.createCategory(bc.getCategoryName());
            bookRepository.save(new Book(bc.getName(), category));
        });
    }

    // return Category in DB if it already exists.
    private Category createCategory(String categoryName) {
        Category category = categoryRepository.findByName(categoryName);
        return category != null ? category : new Category(categoryName);
    }
}
