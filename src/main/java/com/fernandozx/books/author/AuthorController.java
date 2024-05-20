package com.fernandozx.books.author;

import com.fernandozx.books.exceptions.ModelNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/autores")
    @ResponseBody
    public ResponseEntity<?> books(){
        List<Author> authors = new ArrayList<>();
        authors = authorService.findAuthorAll();
        return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
    }
    @PostMapping("/autores")
    public ResponseEntity<?> createAuthor(@Valid @RequestBody Author author) {

        authorService.createAuthor(author);
        return new ResponseEntity<Author>(HttpStatus.CREATED);
    }

    @GetMapping("/autores/{id}")
    @ResponseBody
    public ResponseEntity<?> getAuthor(@PathVariable("id") Long id) {
        System.out.println("print id" +id.getClass());
        Author author =authorService.getAuthor(id).orElseThrow(()-> new ModelNotFoundException("Autor no encontrado $id"));
        return ResponseEntity.ok(author);
    }

    @PutMapping("/autores/{id}")
    public Author updateAuthor(@PathVariable("id") Long id,@Valid @RequestBody Author author) {
        Author currentAuthor =authorService.getAuthor(id).orElseThrow(()-> new ModelNotFoundException("Autor no encontrado $id"));
        currentAuthor.setName(author.getName());
        currentAuthor.setLastName(author.getLastName());
        currentAuthor.setAge(author.getAge());
        return authorService.updateAuthor(currentAuthor);
    }

    @DeleteMapping("/autores/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") Long id) {

        authorService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }
}
