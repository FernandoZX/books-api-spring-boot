package com.fernandozx.books.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> findBookAll();
    public Book createBook(Book book);
    public Book updateBook(Book book);
    public void deleteBook(Long id);
    public Optional<Book> getBook(Long id);
}
