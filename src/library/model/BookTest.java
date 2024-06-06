package library.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

class BookTest {
    Book[] book;

    @BeforeEach
    void setUp() {
        book = new Book[4];
        book[0] = new Book("George Orwell", 1949, 9780451524935L, "1984");
        book[1] = new Book("Harper Lee", 1960, 9780061120084L, "To Kill a Mockingbird");
        book[2] = new Book("J.R.R. Tolkien", 1954, 9780544003415L, "The Fellowship of the Ring");
        book[3] = new Book("F. Scott Fitzgerald", 1925, 9780743273565L, "The Great Gatsby");
    }

    @Test
    void testBookSort() {
        System.out.println("================Test Book sorting=============");
        printArray(book);
        Arrays.sort(book);

        System.out.println("===========After sorting by year");
        printArray(book);
    }

    @Test
    void testBookComparator() {
        Comparator<Book> bookComparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthor().compareTo(o2.getAuthor());
            }
        };
        System.out.println("=============Test Book sorting by comparator============");
        printArray(book);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("=============Test Book after sorting by comparator============");

        Arrays.sort(book, bookComparator);
        printArray(book);
    }

    private void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

        }
    }
}