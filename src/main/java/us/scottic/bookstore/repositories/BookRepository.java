package us.scottic.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;
import us.scottic.bookstore.models.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
