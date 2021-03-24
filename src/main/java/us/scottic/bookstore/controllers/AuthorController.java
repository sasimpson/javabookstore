package us.scottic.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import us.scottic.bookstore.models.Author;
import us.scottic.bookstore.repositories.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public @ResponseBody List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        Iterable<Author> results = authorRepository.findAll();
        for (Author author : results)
            authors.add(author);
        return authors;
    }

    @PostMapping
    public @ResponseBody Author addAuthor(@RequestBody Author author) {
        authorRepository.save(author);
        return author;
    }
}
