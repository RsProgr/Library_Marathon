package library.dao;

import library.model.Book;

public class LibraryImpl implements Library {
    Book[] books;
    int size;

    public LibraryImpl(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    @Override
    public boolean addBook(Book book) {
        if (size + 1 >= this.books.length || book == null) {
            return false;
        }
        Book found = findBook(book.getIsbn());
        if (found != null) {
            return false;

        }

        this.books[size] = book;
        size++;
        return true;

    }

    @Override
    public Book removeBook(long isbn) {
        int index = -1;
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i].getIsbn() == isbn) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return null;
        }
        Book value = this.books[index];
        for (int i = index + 1; i < this.size; i++) {
            this.books[i - 1] = this.books[i];
        }
        this.size -= 1;
        return value;
    }

    @Override
    public Book findBook(long isbn) {
        for (int i = 0; i < this.size; i++) {
            if (this.books[i].getIsbn() == isbn) {
                return this.books[i];
            }
        }
        return null;
    }


    @Override
    public int quantity() {
        return this.size;
    }

    @Override
    public Book updateBook(long isbn, String author) {
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == isbn) {
                books[i].setAuthor(author);
                return books[i];
            }
        }
        return null;
    }


    @Override
    public void printBook() {
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }
}