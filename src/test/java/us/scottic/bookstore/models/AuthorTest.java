package us.scottic.bookstore.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AuthorTest {

    @Test
    void getAndSetNames() {
        Author author = new Author();
        author.setFirstName("Test");
        Assertions.assertEquals("Test", author.getFirstName());

        author.setMiddleName("John");
        Assertions.assertEquals("John", author.getMiddleName());

        author.setLastName("Testing");
        Assertions.assertEquals("Testing", author.getLastName());
    }
}