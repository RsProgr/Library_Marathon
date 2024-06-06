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
        book[0] = new Book("autor3", 1964, 451254789L, "title1");
        book[1] = new Book("autor1", 1962, 451254787L, "title2");
        book[2] = new Book("autor2", 1954, 451254786L, "title3");
        book[3] = new Book("autor4", 1967, 451254785L, "title4");
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
        System.out.println("=========================================================");
        printArray(book);
        System.out.println("=============Test Book sorting by comparator============");

        Arrays.sort(book, bookComparator);
        printArray(book);
    }

    private void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

        }
    }
}