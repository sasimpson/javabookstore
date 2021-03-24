package us.scottic.bookstore.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import us.scottic.bookstore.models.Book;
import us.scottic.bookstore.repositories.BookRepository;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookControllerTest {
    @InjectMocks
    BookController bookController;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testGetAllBooks() {
        //given
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(bookRepository.findAll()).thenReturn(Collections.singletonList(
                new Book("Database Internals")));

        //when
        List<Book> result = bookController.getAllBooks();

        //then
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void testAddBook() {
        //given
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Book book1 = new Book("Database Internals");
        Book book2 = new Book("Database Internals");
        book2.setId(1);

        when(bookRepository.save(book1)).thenReturn(book2);

        //when
        Book result = bookController.addBook(book1);

        //then
        assertThat(result.getTitle()).isEqualTo("Database Internals");
    }
}