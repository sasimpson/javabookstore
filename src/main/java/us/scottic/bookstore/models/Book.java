package us.scottic.bookstore.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany
    private List<Author> Authors;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

}
