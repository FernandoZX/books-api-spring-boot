package com.fernandozx.books.author;


import com.fernandozx.books.book.Book;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="authors")
public class Author {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAutores")
    @SequenceGenerator(name = "seqAutores", allocationSize = 1, sequenceName = "SEQ_AUTORES")
    @Builder.Default
    private Long id=0L;
    @NotNull
    @NotBlank
    @Size(min = 2, message = "El Nombre debe tener por lo menos dos caracteres")
    private String name;
    @NotNull @NotBlank
    @Size(min = 2, message = "El Apellido debe tener por lo menos dos caracteres")
    private String lastName;
    private Integer age;
    @OneToMany(targetEntity = com.fernandozx.books.book.Book.class,
            cascade = CascadeType.ALL)
    private List<Book> books;
}
