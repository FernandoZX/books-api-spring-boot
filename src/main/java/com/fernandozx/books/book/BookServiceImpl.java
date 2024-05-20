package com.fernandozx.books.book;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    public BookRepository bookRepository;

    @Override
    public List<Book> findBookAll() {
        return bookRepository.findAll(Sort.by(Sort.Direction.DESC, "publishDate"));
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }
}
