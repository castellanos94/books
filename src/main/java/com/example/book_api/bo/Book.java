package com.example.book_api.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Max(255)
    private String title;
    @NotBlank
    @Max(255)
    private String author;
    @NotBlank
    @Max(13)
    @Column(unique=true)
    private String isbn;


}
