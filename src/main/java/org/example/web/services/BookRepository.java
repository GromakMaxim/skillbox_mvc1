package org.example.web.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
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
        repo.add(book);
        logger.info("store new book: " + book);
    }

    @Override
    public boolean removeBookById(int bookIdToRemove) {
        Optional<Book> optional = retrieveAll().stream()
                .filter(book -> book.getId() == bookIdToRemove)
                .findFirst();

        if (optional.isPresent()) {
            repo.remove(optional.get());
            logger.info("removed: " + bookIdToRemove);
            return true;
        } else {
            logger.warn("no such id: " + bookIdToRemove);
        }
        return false;
    }
}
