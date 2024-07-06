package library.dao;

import library.model.Book;

import java.util.HashSet;
import java.util.Set;

public class LibraryHashSetImpl implements Library {
    private Set<Book> set;
    private int capacity;


    public LibraryHashSetImpl(int capacity) {
        set = new HashSet<>();
        this.capacity = capacity;
    }

    @Override
    public boolean addBook(Book book) {
        if (book == null) {
            return false;
        }
        return  this.set.add(book);
    }

    @Override
    public Book removeBook(long isbn) {
        Book book = findBook(isbn);
        this.set.remove(book);
        return book;
    }


    @Override
    public Book findBook(long isbn) {
        for (Book book : this.set) {
            if (book.getIsbn() == isbn) {
                return book;

            }
        }
        return null;
    }

    @Override
    public int quantity() {
        return this.set.size();
    }

    @Override
    public void printBook() {
        System.out.println(this.set);
    }

    @Override
    public Book updateBook(long isbn, String author) {
        Book book = findBook(isbn);
        if (book != null) {
            book.setAuthor(author);
            return book;
        }
        return null;
    }
}