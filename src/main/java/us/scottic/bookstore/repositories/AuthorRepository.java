package us.scottic.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;
import us.scottic.bookstore.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
