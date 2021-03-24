package us.scottic.bookstore.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import us.scottic.bookstore.models.Author;
import us.scottic.bookstore.repositories.AuthorRepository;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class AuthorControllerTest {
    @InjectMocks
    AuthorController authorController;

    @Mock
    AuthorRepository authorRepository;

    @Test
    public void testGetAllAuthors() {
        //given
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(authorRepository.findAll()).thenReturn(Collections.singletonList(
                new Author("Obi", "Wan", "Kenobi")));

        //when
        List<Author> result = authorController.getAllAuthors();

        //then
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void testAddAuthor() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        //given
        Author author1 = new Author("Obi", "Wan", "Kenobi");
        Author author2 = new Author("Obi", "Wan", "Kenobi");
        author2.setId(1);

        when(authorRepository.save(author1))
                .thenReturn(author2);

        //when
        Author result = authorController.addAuthor(author1);

        //then
        assertThat(result.getLastName()).isEqualTo("Kenobi");
    }
}