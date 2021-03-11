package us.scottic.bookstore.models;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String title;
    private Author[] authors;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

}
