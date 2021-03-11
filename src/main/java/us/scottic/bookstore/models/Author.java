package us.scottic.bookstore.models;

import lombok.Data;

@Data
public class Author {
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;

    public Author() {}

    public Author(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
}
