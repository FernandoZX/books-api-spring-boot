package com.fernandozx.books.book;

import com.fernandozx.books.exceptions.ModelNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/libros")
    @ResponseBody
    public ResponseEntity<?> books(){
        List<Book> books = new ArrayList<>();
        books = bookService.findBookAll();
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
    @PostMapping("/libros")
    public ResponseEntity<?> createBook(@Valid @RequestBody Book book) {

        bookService.createBook(book);
        return new ResponseEntity<Book>(HttpStatus.CREATED);
    }

    @GetMapping("/libros/{id}")
    @ResponseBody
    public ResponseEntity<?> getBook(@PathVariable("id") Long id) {
        System.out.println("print id" +id.getClass());
        Book book =bookService.getBook(id).orElseThrow(()-> new ModelNotFoundException("Libro no encontrado $id"));
        return ResponseEntity.ok(book);
    }

    @PutMapping("/libros/{id}")
    public Book updateBook(@PathVariable("id") Long id,@Valid @RequestBody Book book) {
        Book currentBook =bookService.getBook(id).orElseThrow(()-> new ModelNotFoundException("Libro no encontrado $id"));
        currentBook.setTitle(book.getTitle());
        currentBook.setGenre(book.getGenre());
        currentBook.setPages(book.getPages());
        currentBook.setPublishDate(book.getPublishDate());
        return bookService.updateBook(currentBook);
    }

    @DeleteMapping("/libros/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {

        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
