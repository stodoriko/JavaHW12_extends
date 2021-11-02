package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "О дивный новый мир", 399, "Олдос Хаксли");
    Product book2 = new Book(2, "Пират", 499, "Вальтер Скотт");
    Product book3 = new Book(3, "Clear Code", 599, "Robert Martin");
    Product smartphone = new Smartphone(4, "Pixel", 19000, "Google");

    @BeforeEach
    public void SetUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone);
    }

    @Test
    public void shouldFindAuthor() {
        Product[] expected = { book1 };
        Product[] actual = manager.searchBy("Олдос Хаксли");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookName() {
        Product[] expected = { book2 };
        Product[] actual = manager.searchBy("Пират");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Олдос Хаскли");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindNull() {
        Product[] expected = {};
        Product[] actual = manager.searchBy(null);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneName() {
        Product[] expected = { smartphone };
        Product[] actual = manager.searchBy("Pixel");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneProducer() {
        Product[] expected = { smartphone };
        Product[] actual = manager.searchBy("Google");
        assertArrayEquals(expected, actual);
    }

}