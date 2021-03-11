package us.scottic.bookstore.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookTest {
    @Test
    void getAndSetTitle() {
        Book book = new Book();
        book.setTitle("test title");
        Assertions.assertEquals("test title", book.getTitle());
    }

}