package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    Book book1 = new Book(1, "Harry Potter and the philosopher's tone", 1000, "Rowling J.", 332, 2001);
    Book book2 = new Book(2, "Harry Potter and secret room", 1500, "Rowling J.", 374, 2002);

    @Test
    public void shouldCheckItemDeletion() {
        repository.save(book1);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1};

        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldGenerateNotFoundException() {
        repository.save(book2);
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(3);
        });
    }
}


