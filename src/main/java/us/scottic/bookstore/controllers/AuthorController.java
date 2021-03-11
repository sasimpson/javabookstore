package us.scottic.bookstore.controllers;

import org.springframework.web.bind.annotation.*;
import us.scottic.bookstore.models.Author;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/authors")
public class AuthorController {

    @GetMapping
    public @ResponseBody List<Author> getAllUsers() {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("Obi", "Wan", "Kenobi"));
        return authors;
    }
}
