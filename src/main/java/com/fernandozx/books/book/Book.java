package com.fernandozx.books.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fernandozx.books.author.Author;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="books")
public class Book {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLibros")
    @SequenceGenerator(name = "seqLibros", allocationSize = 1, sequenceName = "SEQ_LIBROS")
    @Builder.Default
    private Long id=0L;
    @NotNull @NotBlank
    @Size(min = 2, message = "El titulo debe tener por lo menos dos caracteres")
    private String title;
    @NotNull @NotBlank
    @Size(min = 2, message = "El genero del libro debe tener por menos dos caracteres")
    private String genre;
    @Basic
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime publishDate;
    private Integer pages;
    @ManyToOne
    @JoinColumn(name="authorsID", nullable=true)
    private Author author;
}
