package org.example.web.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements ProjectRepository<Book> {
    private final Logger logger = Logger.getLogger(this.getClass());
    private final List<Book> repo = new ArrayList<>();

    @Override
    public List<Book> retrieveAll() {

        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        book.setId(book.hashCode());
    }
}
