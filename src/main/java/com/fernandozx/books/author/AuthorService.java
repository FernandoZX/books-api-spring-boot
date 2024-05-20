package com.fernandozx.books.author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    public List<Author> findAuthorAll();
    public Author createAuthor(Author author);
    public Author updateAuthor(Author author);
    public void deleteAuthor(Long id);
    public Optional<Author> getAuthor(Long id);
}
