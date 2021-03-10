package us.scottic.bookstore.controllers;

import org.springframework.web.bind.annotation.*;
import us.scottic.bookstore.models.Author;
import us.scottic.bookstore.repositories.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @PostMapping(path = "/new")
    public Author addAuthor(@RequestBody Author author) {
        System.out.println(author.toString());
        return authorRepository.save(author);
    }


    @GetMapping
    public @ResponseBody List<Author> getAllUsers() {
        List<Author> authors = new ArrayList<>();
        authorRepository.findAll().forEach(authors::add);
//        authors.add(new Author("Obiwan", "Kenobi"));

        return authors;
    }
}
