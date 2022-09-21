package cj.Sber.BootLibrary.controllers;

import cj.Sber.BootLibrary.model.Book;
import cj.Sber.BootLibrary.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/lib")
public class BookController {

    private final BooksService booksService;

    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, List<Book>>> getStats(@RequestParam(defaultValue = "") String letter) {
        return ResponseEntity.ok(booksService.getStats(letter));
    }

    @GetMapping("/books") // books?letter=A
    public ResponseEntity<List<Book>> getBooks(@RequestParam(defaultValue = "") String letter) {
        return ResponseEntity.ok(booksService.searchByTitle(letter));
    }

}