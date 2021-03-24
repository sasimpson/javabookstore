package us.scottic.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import us.scottic.bookstore.models.Author;
import us.scottic.bookstore.repositories.AuthorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping(path = "/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public @ResponseBody List<Author> getAllAuthors() {

        List<Author> authors = new ArrayList<>();
        Iterable<Author> results = authorRepository.findAll();
        if (results != null) {
            results.forEach(new Consumer<Author>() {
                @Override
                public void accept(Author author) {
                    authors.add(author);
                }
            });
            return authors;
        }
        return authors;
    }

    @PostMapping
    public @ResponseBody Author addAuthor(@RequestBody Author author) {
        authorRepository.save(author);
        return author;
    }
}
