package library.dao;

import library.model.Book;

public interface Library {
    boolean addBook(Book book);
    Book removeBook(long isbn);
    Book findBook(long isbn);
    int quantity();
    void printBook();
    Book updateBook(long isbn, String author);


}
