package library.dao;

import library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryArraysListImpl implements Library {
    private List<Book> list;
    private int capacity;

    public LibraryArraysListImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public boolean addBook(Book book) {
        if(book == null || this.findBook(book.getIsbn()) != null ){
            return false;
        }
        this.list.add(book);
        return true;
    }

    @Override
    public Book removeBook(long isbn) {
        Book book = findBook(isbn);
        this.list.remove(book);
        return book;
    }


    @Override
    public Book findBook(long isbn) {
        for (Book book : this.list) {
            if (book.getIsbn() == isbn) {
                return book;

            }
        }
        return null;
    }
        @Override
        public int quantity () {
            return this.list.size();
        }

        @Override
        public void printBook () {
            System.out.println(this.list);
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