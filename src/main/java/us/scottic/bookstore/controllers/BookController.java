package us.scottic.bookstore.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.scottic.bookstore.models.Book;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @GetMapping
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Database Internals"));
        return books;
    }
}
