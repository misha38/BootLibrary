package cj.Sber.BootLibrary.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book_table")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "Title should be between 2 and 100 characters")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "There should be an author")
    @Size(min = 2, max = 100, message = "Author name should be between 2 and 100 characters")
    @Column(name = "author")
    private String author;

    @NotEmpty(message = "There should be an ISBN identifier")
    @Size(min = 2, max = 100, message = "ISBN code should be between 2 and 100 characters")
    @Column(name = "isbn")
    private String isbn;

    public Book() {
    }

    public Book(String name, String author, String isbn) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
