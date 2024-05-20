package com.fernandozx.books.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    public AuthorRepository authorRepository;

    @Override
    public List<Author> findAuthorAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.saveAndFlush(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Optional<Author> getAuthor(Long id) {
        return authorRepository.findById(id);
    }
}
