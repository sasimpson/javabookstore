package us.scottic.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import us.scottic.bookstore.models.Book;
import us.scottic.bookstore.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        Iterable<Book> results = bookRepository.findAll();
        for (Book book : results)
            books.add(book);
        return books;

    }

    @PostMapping
    public @ResponseBody Book addBook(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }
}
