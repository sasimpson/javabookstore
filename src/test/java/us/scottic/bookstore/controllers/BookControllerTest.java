package us.scottic.bookstore.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

/*
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = standaloneSetup(new BookController()).build();
    }
*/

    @Test
    void getAllBooks(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(get("/books").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].title").value("Database Internals"));
    }
}