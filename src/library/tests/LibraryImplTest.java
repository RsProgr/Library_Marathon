package library.tests;

import library.dao.Library;
import library.dao.LibraryImpl;
import library.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryImplTest {
    Library library;
    Book[] book;


    @BeforeEach
    void setUp() {
        library = new LibraryImpl(4);
        book = new Book[4];
        book[0] = new Book("Kazuo Ishiguro", 2021, 9780593318171L, "Klara and the Sun");
        book[1] = new Book("Andy Weir", 2021, 9780593135204L, "Project Hail Mary");
        book[2] = new Book("Taylor Jenkins Reid", 2021, 9781524798642L, "Malibu Rising");
        book[3] = new Book("Colleen Hoover", 2022, 9781542025607L, "Reminders of Him");


    }

    @Test
    void addBook() {
        assertFalse(library.addBook(null)); // Typically adding null should return false
        assertTrue(library.addBook(book[1]));
        assertFalse(library.addBook(book[1])); // Adding the same book again should fail
        Book book1 = new Book("autor5", 1254, 451269745612L, "ab");
        assertTrue(library.addBook(book1));
        assertEquals(2, library.quantity());

        Book book2 = new Book("autor6", 1365, 3465347583734L, "ey");
        assertTrue(library.addBook(book2));
        assertFalse(library.addBook(book[1]));
    }

    @Test
    void removeBook() {
    }

    @Test
    void findBook() {
    }

    @Test
    void quantity() {
    }

    @Test
    void printBook() {
    }

    @Test
    void updateBook() {
    }
}